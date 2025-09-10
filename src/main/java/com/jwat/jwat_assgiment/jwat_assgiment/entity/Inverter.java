package com.jwat.jwat_assgiment.jwat_assgiment.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "inverter",schema = "jwat")
public class Inverter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "inverter_code")
    private String inverterCode;
    @Column(name = "inverter_name")
    private String inverterName;
    @Column(name = "slave_address")
    private String slaveAddress;
    @Column(name = "start_address")
    private String startAddress;
    @Column(name = "number_of_poles")
    private int numberOfPoles;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();
    @Column(name = "is_flag")
    private Boolean isFlag;
}
