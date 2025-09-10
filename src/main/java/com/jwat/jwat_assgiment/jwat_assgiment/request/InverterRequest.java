package com.jwat.jwat_assgiment.jwat_assgiment.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InverterRequest {

    private String inverterCode;

    private String inverterName;

    private String slaveAddress;

    private String startAddress;

    private int numberOfPoles;

    private LocalDateTime updatedAt;

    private Boolean isFlag;
}
