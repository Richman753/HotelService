package by.bezushko.hotels.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactsDto {
    @Schema(description = "Контактный номер")
    private String phone;
    @Schema(description = "Контактный адрес почты")
    private String email;
}
