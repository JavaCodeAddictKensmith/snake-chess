package com.kensmith.repository;

import com.kensmith.entity.Product;
import com.kensmith.enums.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface  ProductRepository extends JpaRepository<Product,Long> {


    List<Product> findByCategory(ProductCategory category);

    List<Product> findProductsByManufacturerManufacturersName(String manufacturersName);

    List<Product> findProductByManufacturerLocation(String location);

    @Query("SELECT product FROM Product product WHERE LOWER(product.productName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(product.description) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Product> searchProductByKeyword(@Param("keyword") String keyword);

    Optional<Product> findByProductName(String productName);

    @Query("SELECT product FROM Product product " + "WHERE " + "(LOWER(product.manufacturer.location) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(product.productName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(product.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(product.manufacturer.manufacturersName) LIKE LOWER(CONCAT('%', :keyword, '%'))) " +
            "AND (:price IS NULL OR product.price = :price)")
    List<Product> searchProduct(@Param("keyword") String keyword, @Param("price") Double price);
}