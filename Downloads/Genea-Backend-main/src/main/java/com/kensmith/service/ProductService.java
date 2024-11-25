package com.kensmith.service;

import com.kensmith.dto.request.CreateProductRequest;
import com.kensmith.dto.request.ManufacturerRequest;
import com.kensmith.dto.response.ProductSearchResponse;
import com.kensmith.entity.Manufacturer;
import com.kensmith.entity.Product;
import com.kensmith.enums.ProductCategory;

import java.util.List;


public interface ProductService {
    String addProduct(CreateProductRequest productRequest);


    String createManufacturer(ManufacturerRequest manufacturerRequest);

    List<Product> getAllProducts();

    List<Manufacturer> getAllManufacturers();

    Product getProductById(Long id);

    Manufacturer getManufacturerById(Long id);

    String deleteProduct(Long id);

    Product getProductByName(String name);

    Manufacturer getManufacturerByName(String name);

    List<Product> getProductsByCategory(ProductCategory category);

    List<Product> getProductByManufacturersName(String name);





    List<ProductSearchResponse> getProductByManufacturerLocation(String location);

    List<ProductSearchResponse> getProductsByKeyword(String keyword);


    List<ProductSearchResponse> searchProduct(String keyword, Double price);



}
