package com.progressoft.clustereddatawarehouse.controllers;

import com.progressoft.clustereddatawarehouse.dto.DealDto;
import com.progressoft.clustereddatawarehouse.services.DealService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/deals", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@Slf4j
public class DealController {

    private final DealService dealService;

    @PostMapping
    public ResponseEntity<DealDto> saveDeal(@Valid @RequestBody DealDto dealDto) {
        DealDto result = dealService.saveDeal(dealDto);
        log.info("Saved deal: {}", result);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
