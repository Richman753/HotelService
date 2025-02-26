package by.test.hotels.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Упрощенный объект отеля")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleHotelResponseDto {
    @Schema(description = "ИД отеля")
    private int id;
    @Schema(description = "Название отеля")
    private String name;
    @Schema(description = "Описание отеля")
    private String description;
    @Schema(description = "Адрес отеля")
    private String address;
    @Schema(description = "Контактный номер отеля")
    private String phone;
}
