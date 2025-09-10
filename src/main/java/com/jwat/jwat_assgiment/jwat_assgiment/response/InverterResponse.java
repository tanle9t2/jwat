package com.jwat.jwat_assgiment.jwat_assgiment.response;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InverterResponse {

    private String id;


    private String inverterCode;

    private String inverterName;

    private String slaveAddress;

    private String startAddress;

    private int numberOfPoles;

    private LocalDateTime updatedAt;

    private Boolean isFlag;
}
