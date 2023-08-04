package com.nutridish.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recipes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Name is required")
    private String name;

    @Column(name = "description")
    @NotBlank(message = "Description is required")
    private String description;

    @Column(name = "created_by")
    @NotBlank(message = "Created by is required")
    private String createdBy;

    @Column(name = "total_time_minutes")
    @NotBlank(message = "Total time is required")
    private int totalTime;

    @Column(name = "servings")
    @NotBlank(message = "Servings is required")
    private int servings;

    @Column(name = "image_url")
    @NotBlank(message = "Image is required")
    private String image;
}
