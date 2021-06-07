package com.mercadolivre.desafioSpring.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostToCreateRequest {
    private Integer userId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    @NotNull(message = "O post deve ter um produto")
    private ProductToCreateRequest detail;
    @NotNull(message = "O post deve ter uma categoria")
    private Integer category;
    @NotNull(message = "O post deve informar o preco do produto")
    private Double price;
    private Boolean hasPromo = false;
    private Double discount = 0.0;
}
