package org.example.recs_shreyoshi.repositories;

import org.example.recs_shreyoshi.enums.Brand;
import org.example.recs_shreyoshi.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByBrand(Brand brand);

    List<Product> findByCategory(String category);

    List<Product> findByCategoryAndSubCategory(String category, String subCategory);

//    List<Product> findByDeletedFalse();
}
