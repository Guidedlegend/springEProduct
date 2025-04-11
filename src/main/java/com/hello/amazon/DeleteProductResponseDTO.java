package com.hello.amazon;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteProductResponseDTO {
    private String message;
    private EProduct deletedProduct;

}
