package uz.pdp.wearhouse.payload;

import lombok.Data;

@Data
public class ProductDto {
    String name;
    boolean active;
    Integer categoryId;
    Integer photoId;
    Integer measurmentId;
}
