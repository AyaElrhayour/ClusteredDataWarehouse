package com.progressoft.clustereddatawarehouse.services.impl;

import com.progressoft.clustereddatawarehouse.dto.DealDto;
import com.progressoft.clustereddatawarehouse.entities.Deal;
import com.progressoft.clustereddatawarehouse.exceptions.DuplicatedIdException;
import com.progressoft.clustereddatawarehouse.mappers.DealMapper;
import com.progressoft.clustereddatawarehouse.repositories.DealRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DealServiceImplTest {

    @InjectMocks
    private DealServiceImpl dealService;

    @Mock
    private DealMapper dealMapper;

    @Mock
    private DealRepository dealRepository;

    private DealDto dealDto;

    private Deal deal;

    @BeforeEach
    public void setUp() {
        deal = Deal.builder()
                .id("testId")
                .fromCurrencyISOCode("fromISOCodetest")
                .toCurrencyISOCode("toISOCodetest")
                .dealTimestamp(LocalDateTime.now())
                .dealAmount(12345.67)
                .build();
        dealDto = DealDto.builder()
                .id("testIdDto")
                .fromCurrencyISOCode("fromISOCodetestDto")
                .toCurrencyISOCode("toISOCodetestDto")
                .dealTimestamp(LocalDateTime.now())
                .dealAmount(12345.89)
                .build();
    }

    @Test
    public void givenDuplicatedDealIdThenThrowException() {
        given(dealRepository.existsById(dealDto.getId())).willReturn(true);
        assertThatExceptionOfType(DuplicatedIdException.class)
                .isThrownBy(() -> dealService.saveDeal(dealDto))
                .withMessageContaining("Duplicated dealId");
    }

    @Test
    public void givenValidDealDtoThenReturnDealDto() {
        given(dealRepository.existsById(dealDto.getId())).willReturn(false);
        given(dealRepository.save(deal)).willReturn(deal);
        given(dealMapper.toDeal(dealDto)).willReturn(deal);
        given(dealMapper.toDealDto(deal)).willReturn(dealDto);
        DealDto savedDealDto = dealService.saveDeal(dealDto);
        assertThat(savedDealDto).isEqualTo(dealDto);
        verify(dealRepository).save(deal);
        verify(dealRepository).existsById(dealDto.getId());
    }
}