package uz.pdp.wearhouse.payload;

import lombok.Data;

@Data
public class CategoryDto {
    String name;
    boolean active;
    Integer parentCategoryId;
}
