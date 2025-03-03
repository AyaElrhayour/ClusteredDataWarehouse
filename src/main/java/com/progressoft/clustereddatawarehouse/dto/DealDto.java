package com.progressoft.clustereddatawarehouse.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DealDto {

    @NotNull(message = "Id must not be null")
    @NotEmpty(message = "Id must not be empty")
    @Size(max = 255, min = 3, message = "Id should be between 3 and 255 characters")
    private String id;

    @NotNull(message = "From Currency ISO Code must not be null")
    @NotEmpty(message = "From Currency ISO Code must not be empty")
    @Size(max = 3, min = 3, message = "From Currency ISO Code should be 3 characters. Example: `EUR`")
    private String fromCurrencyISOCode;

    @NotNull(message = "To Currency ISO Code must not be null")
    @NotEmpty(message = "To Currency ISO Code must not be empty")
    @Size(max = 3, min = 3, message = "To Currency ISO Code should be 3 characters. Example: `GBP`")
    private String toCurrencyISOCode;

    private LocalDateTime dealTimestamp;

    @NotNull(message = "Deal Amount must not be null")
    @Positive(message = "Deal Amount must be a positive number")
    private Double dealAmount;
}
