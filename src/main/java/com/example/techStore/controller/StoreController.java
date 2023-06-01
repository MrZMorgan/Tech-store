package com.example.techStore.controller;

import com.example.techStore.dto.GoodsResponse;
import com.example.techStore.dto.ProductRequest;
import com.example.techStore.dto.Product;
import com.example.techStore.enums.ProductType;
import com.example.techStore.sevice.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/store/goods/")
public class StoreController {

    private final ProductsService productsService;

    @PostMapping
    public GoodsResponse addProduct(@RequestBody final ProductRequest addGoodsResponse) {
        return GoodsResponse.builder().id(productsService.addProducts(addGoodsResponse)).build();
    }

    @GetMapping("/productType/{productType}/")
    public List<Product> getProducts(@PathVariable(value = "productType") final String productType) {
        return productsService.findProducts(ProductType.valueOf(productType));
    }

    @GetMapping("/productType/{productType}/id/{id}")
    public Product getProduct(
        @PathVariable(value = "productType") final String productType,
        @PathVariable(value = "id") final int id
    ) {
        return productsService.findProducts(ProductType.valueOf(productType), id);
    }

    @PutMapping
    public GoodsResponse updateProduct(@RequestBody final ProductRequest addGoodsResponse) {
        return GoodsResponse.builder().id(productsService.updateProduct(addGoodsResponse)).build();
    }
}
