package uz.pdp.wearhouse.payload;

import lombok.Data;

@Data
public class UserDto {
    Integer id;
    String firstName;
    String lastName;
    String phoneNumber;
    boolean active;
    Integer[] wearhouseId;
}
