package uz.pdp.wearhouse.payload;

import lombok.Data;

@Data
public class OutputProductDto {
    Integer productId;
    Double ammount;
    Double price;
    Integer outputId;
}
