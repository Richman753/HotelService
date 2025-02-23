package by.test.hotels.mappers;

import by.test.hotels.dto.ArrivalTimeDto;
import by.test.hotels.models.ArrivalTime;
import org.springframework.stereotype.Service;

@Service
public class ArrivalTimeMapper {
    public ArrivalTimeDto toDto(ArrivalTime arrivalTime)
    {
        return new ArrivalTimeDto(
                arrivalTime.getCheckIn(),
                arrivalTime.getCheckOut()
        );
    }

    public ArrivalTime toEntity(ArrivalTimeDto arrivalTimeDto)
    {
        return new ArrivalTime(
                0,
                arrivalTimeDto.getCheckIn(),
                arrivalTimeDto.getCheckOut()
        );
    }
}
