package by.bezushko.hotels.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Объект гистограммы")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistogramResponseDto {
    @Schema(description = "Элемент группировки")
    private String parameter;
    @Schema(description = "Количество отелей")
    private Long count;
}
