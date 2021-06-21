package uz.pdp.wearhouse.payload;

import lombok.Data;

@Data
public class OutputDto {

    Integer wearhouseId;
    Integer currencyId;
    String factureNumber;

    Integer clientId;

}
