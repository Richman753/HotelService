package by.bezushko.hotels.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    @Schema(description = "Номер дома")
    private int houseNumber;
    @Schema(description = "Название улицы")
    private String street;
    @Schema(description = "Название города")
    private String city;
    @Schema(description = "Название страны")
    private String country;
    @Schema(description = "Почтовый индекс")
    private String postCode;
}
