package com.progressoft.clustereddatawarehouse.services.impl;

import com.progressoft.clustereddatawarehouse.dto.DealDto;
import com.progressoft.clustereddatawarehouse.exceptions.DuplicatedIdException;
import com.progressoft.clustereddatawarehouse.mappers.DealMapper;
import com.progressoft.clustereddatawarehouse.repositories.DealRepository;
import com.progressoft.clustereddatawarehouse.services.DealService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DealServiceImpl implements DealService {

    private final DealRepository dealRepository;
    private final DealMapper dealMapper;

    @Override
    public DealDto saveDeal(DealDto dealDto) {
        if (dealRepository.existsById(dealDto.getId())) {
            throw new DuplicatedIdException("Duplicated dealId: " + dealDto.getId());
        }
        return dealMapper.toDealDto(dealRepository.save(dealMapper.toDeal(dealDto)));
    }
}
