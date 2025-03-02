package com.progressoft.clustereddatawarehouse.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "deals")
@Builder
public class Deal {

    @Id
    private String id;

    @Column(nullable = false)
    private String fromCurrencyISOCode;

    @Column(nullable = false)
    private String toCurrencyISOCode;

    @CreationTimestamp
    private LocalDateTime dealTimestamp;

    @Column(nullable = false)
    private Double dealAmount;

}