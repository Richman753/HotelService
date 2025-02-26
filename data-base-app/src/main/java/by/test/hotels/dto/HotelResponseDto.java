package by.test.hotels.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Schema(description = "Объект отеля")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelResponseDto {
    @Schema(description = "ИД отеля")
    private int id;
    @Schema(description = "Название отеля")
    private String name;
    @Schema(description = "Описание отеля")
    private String description;
    @Schema(description = "Бренд отеля")
    private String brand;
    @Schema(description = "Адрес отеля")
    private AddressDto address;
    @Schema(description = "Контактные данные отеля")
    private ContactsDto contacts;
    @Schema(description = "Время заселения/выселения")
    private ArrivalTimeDto arrivalTime;
    @Schema(description = "Список удобств")
    private List<String> amenities;

}
