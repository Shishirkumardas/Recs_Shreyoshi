package org.example.recs_shreyoshi.dto;


import lombok.Data;
import org.example.recs_shreyoshi.enums.Brand;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductCreateDTO {
    private String name;
    private String description;
    private double price;
    private int stock;
    private String category;       // main category
    private String subCategory;    // sub category
    private Brand brand;
//    private MultipartFile image;   // ← file upload
    private List<MultipartFile> images = new ArrayList<>();
}
