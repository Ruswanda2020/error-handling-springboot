package com.onedev.payload;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductRequest {

    @NotBlank(message = "Product name is required")
    @Size(min = 3, max = 50, message = "Product name must be between 3 and 50 characters")
    private String name;

    @Min(value = 0, message = "Price cannot be negative")
    private double price;
}
