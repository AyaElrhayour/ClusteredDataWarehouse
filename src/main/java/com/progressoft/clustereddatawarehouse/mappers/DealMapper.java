package com.progressoft.clustereddatawarehouse.mappers;

import com.progressoft.clustereddatawarehouse.dto.DealDto;
import com.progressoft.clustereddatawarehouse.entities.Deal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DealMapper {
    Deal toDeal(DealDto dealDto);
    DealDto toDealDto(Deal deal);
}
