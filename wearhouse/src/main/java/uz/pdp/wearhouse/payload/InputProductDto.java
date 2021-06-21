package uz.pdp.wearhouse.payload;

import lombok.Data;

import java.sql.Date;

@Data
public class InputProductDto {
    Integer productId;
    Double ammount;
    Double price;
    Integer inputId;
    Date expireDate;
}
