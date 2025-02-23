package by.test.hotels.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleHotelResponseDto {
    private int id;
    private String name;
    private String description;
    private String address;
    private String phone;
}
