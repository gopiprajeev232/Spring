package com.spring.classes;
import com.spring.customvalidation.BikeCode;

import javax.validation.constraints.*;
import lombok.Data;

public @Data class Customer {
    @NotNull(message="is required")
    @Size(min=1, message = "is required")
    private String name;

//    @Range(min = 1, max = 99)
    @NotNull(message = "is required")
    @Min(value=1, message="Must be greater than or equal to 1")
    @Max(value=100, message="Must be less than or equal to 100")
    private Integer age;

    @Pattern(regexp="^[0-9]{6}$", message = "only 6 digits allowed")
    private String zipCode;

    @BikeCode
    private String bikeCode;

}
