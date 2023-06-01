package com.example.techStore.sevice;

import com.example.techStore.dto.ProductRequest;
import com.example.techStore.dto.ComputerDTO;
import com.example.techStore.dto.HardDiscDeviceDTO;
import com.example.techStore.dto.LaptopDTO;
import com.example.techStore.dto.MonitorDTO;
import com.example.techStore.dto.Product;
import com.example.techStore.entity.Computer;
import com.example.techStore.entity.HardDiskDevice;
import com.example.techStore.entity.Laptop;
import com.example.techStore.entity.Monitor;
import com.example.techStore.enums.ProductType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductsService {
    private final ComputerService computerService;
    private final HardDiskDeviceService diskDeviceService;
    private final MonitorService monitorService;
    private final LaptopService laptopService;

    public int addProducts(final ProductRequest addGoodsRequest) {
        switch (addGoodsRequest.getType()) {
            case COMPUTER:
                return computerService.save(Computer.of((ComputerDTO) addGoodsRequest.getProduct())).getId();
            case LAPTOP:
                return laptopService.save(Laptop.of((LaptopDTO) addGoodsRequest.getProduct())).getId();
            case HARD_DISK_DEVICE:
                return diskDeviceService.save(HardDiskDevice.of((HardDiscDeviceDTO) addGoodsRequest.getProduct())).getId();
            case MONITOR :
                return monitorService.save(Monitor.of((MonitorDTO) addGoodsRequest.getProduct())).getId();
            default : throw new IllegalStateException("product type not implemented yet");
        }
    }

    public List<Product> findProducts(final ProductType type) {

        switch (type) {
            case COMPUTER:
                return computerService.findAll().stream().map(ComputerDTO::of).collect(Collectors.toList());
            case LAPTOP:
                return laptopService.findAll().stream().map(LaptopDTO::of).collect(Collectors.toList());
            case HARD_DISK_DEVICE:
                return diskDeviceService.findAll().stream().map(HardDiscDeviceDTO::of).collect(Collectors.toList());
            case MONITOR :
                return monitorService.findAll().stream().map(MonitorDTO::of).collect(Collectors.toList());
            default : throw new IllegalStateException("product type not implemented yet");
        }
    }

    public Product findProducts(final ProductType type, final int id) {
        switch (type) {
            case COMPUTER:         return ComputerDTO.of(computerService.getById(id));
            case LAPTOP:           return LaptopDTO.of(laptopService.getById(id));
            case HARD_DISK_DEVICE: return HardDiscDeviceDTO.of(diskDeviceService.getById(id));
            case MONITOR :         return  MonitorDTO.of(monitorService.getById(id));
            default : throw new IllegalStateException("product type not implemented yet");
        }
    }

    public int updateProduct(final ProductRequest addGoodsRequest) {
        switch (addGoodsRequest.getType()) {
            case COMPUTER:
                return computerService.update((ComputerDTO) addGoodsRequest.getProduct()).getId();
            case LAPTOP:
                return laptopService.update((LaptopDTO) addGoodsRequest.getProduct()).getId();
            case HARD_DISK_DEVICE:
                return diskDeviceService.update((HardDiscDeviceDTO) addGoodsRequest.getProduct()).getId();
            case MONITOR :
                return  monitorService.update((MonitorDTO) addGoodsRequest.getProduct()).getId();
            default : throw new IllegalStateException("product type not implemented yet");
        }
    }
}
