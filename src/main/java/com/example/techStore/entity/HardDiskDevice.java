package com.example.techStore.entity;

import com.example.techStore.dto.HardDiscDeviceDTO;
import com.example.techStore.enums.HardDiskDeviceCapacity;
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
@Table(name = "hdd")
public class HardDiskDevice {

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

    @Column(name = "capacity")
    @Enumerated(EnumType.STRING)
    private HardDiskDeviceCapacity capacity;

    public static HardDiskDevice of(final HardDiscDeviceDTO discDeviceDTO) {
        return HardDiskDevice.builder()
            .serialNumber(discDeviceDTO.getSerialNumber())
            .price(discDeviceDTO.getPrice())
            .quantity(discDeviceDTO.getQuantity())
            .capacity(discDeviceDTO.getCapacity())
            .build();
    }
}
