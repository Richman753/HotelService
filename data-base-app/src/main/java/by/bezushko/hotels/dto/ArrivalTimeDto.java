package by.bezushko.hotels.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArrivalTimeDto {
    @Schema(description = "Время заселения")
    private String checkIn;
    @Schema(description = "Время выселения")
    private String checkOut;
}
