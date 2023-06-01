package com.example.techStore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Product {

    protected int id;
    protected String serialNumber;
    protected long price;
    protected long quantity;
}
