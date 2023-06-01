package com.example.techStore.entity;

import com.example.techStore.dto.ComputerDTO;
import com.example.techStore.enums.ComputerFormFactor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "computer")
public class Computer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "price")
    private long price;

    @Column(name = "quantity")
    private long quantity;

    @Column(name = "form_factor")
    @Enumerated(EnumType.STRING)
    private ComputerFormFactor formFactor;

    public static Computer of(final ComputerDTO computerDTO) {
        return Computer.builder()
            .serialNumber(computerDTO.getSerialNumber())
            .price(computerDTO.getPrice())
            .quantity(computerDTO.getQuantity())
            .formFactor(computerDTO.getFormFactor())
            .build();
    }
}
