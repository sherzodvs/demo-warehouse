package uz.pdp.wearhouse.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private String message;
    private boolean result;
    private Object object;

    public ApiResponse(String message, boolean result) {
        this.message = message;
        this.result = result;
    }
}
