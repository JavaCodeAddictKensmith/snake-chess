package com.kensmith.dto.response;

import com.kensmith.entity.Product;
import com.kensmith.enums.ProductCategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSearchResponse {
    private Long id;

    private String productName;

    private String description;

    private Double price;
    private ProductCategory category;
    private String image;
    private String manufacturersName;

    private String location;


    public ProductSearchResponse(Product  product) {
        this.id = product.getId();
        this.productName = product.getProductName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.category = product.getCategory();
        this.image = product.getImageUrl();
        this.manufacturersName = product.getManufacturer().getManufacturersName();
        this.location = product.getManufacturer().getLocation();
    }
}
