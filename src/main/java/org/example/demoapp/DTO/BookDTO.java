package org.example.demoapp.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data


public class BookDTO {

    private Integer id;

    @NotBlank(message = "Tittle is Required !")
    private String title;

    @NotBlank(message = "Author is Required !")
    private String author;

    @Positive(message = "Price should be Positive")
    private double price;

    @NotBlank(message = "ISBN is Required !")
    private String isbn;
}