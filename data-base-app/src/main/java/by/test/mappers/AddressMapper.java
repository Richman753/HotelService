package by.test.mappers;

import by.test.dto.AddressDto;
import by.test.dto.HotelResponseDto;
import by.test.models.Address;
import by.test.models.Hotel;
import org.springframework.stereotype.Service;

@Service
public class AddressMapper {
    public AddressDto toDto(Address address)
    {
        return new AddressDto(
                address.getHouseNumber(),
                address.getStreet(),
                address.getCity(),
                address.getCountry(),
                address.getPostCode()
        );
    }

    public Address toEntity(AddressDto addressDto)
    {
        return new Address(
                0,
                addressDto.getHouseNumber(),
                addressDto.getStreet(),
                addressDto.getCity(),
                addressDto.getCountry(),
                addressDto.getPostCode()
        );
    }
}
