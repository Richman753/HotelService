package by.test.mappers;

import by.test.dto.AddressDto;
import by.test.dto.ArrivalTimeDto;
import by.test.models.Address;
import by.test.models.ArrivalTime;
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
