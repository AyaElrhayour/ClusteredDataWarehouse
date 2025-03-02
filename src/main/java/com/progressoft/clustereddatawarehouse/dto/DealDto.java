package com.progressoft.clustereddatawarehouse.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DealDto {

    @NotNull(message = "Id must not be null")
    @NotEmpty(message = "Id must not be empty")
    private String id;

    @NotNull(message = "From Currency ISO Code must not be null")
    @NotEmpty(message = "From Currency ISO Code must not be empty")
    private String fromCurrencyISOCode;

    @NotNull(message = "To Currency ISO Code must not be null")
    @NotEmpty(message = "To Currency ISO Code must not be empty")
    private String toCurrencyISOCode;

    private LocalDateTime dealTimestamp;

    @NotNull(message = "Deal Amount must not be null")
    @Positive(message = "Deal Amount must be a positive number")
    private Double dealAmount;
}
