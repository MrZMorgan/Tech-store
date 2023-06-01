package com.example.techStore.entity;

import com.example.techStore.dto.LaptopDTO;
import com.example.techStore.enums.LaptopScreenSize;
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
@Table(name = "laptop")
public class Laptop {

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

    @Column(name = "screen_size")
    @Enumerated(EnumType.STRING)
    private LaptopScreenSize screenSize;

    public static Laptop of(final LaptopDTO laptopDTO) {
        return Laptop.builder()
            .serialNumber(laptopDTO.getSerialNumber())
            .price(laptopDTO.getPrice())
            .quantity(laptopDTO.getQuantity())
            .screenSize(laptopDTO.getScreenSize())
            .build();
    }
}
