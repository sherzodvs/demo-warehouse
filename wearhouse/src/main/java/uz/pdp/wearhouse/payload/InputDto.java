package uz.pdp.wearhouse.payload;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class InputDto {
    Timestamp date;
    Integer wearhouseId;
    Integer currencyId;
    String factureNumber;

    Integer supplierId;

}
