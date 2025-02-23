package by.test.hotels.mappers;

import by.test.hotels.dto.HotelResponseDto;
import by.test.hotels.dto.SimpleHotelResponseDto;
import by.test.hotels.models.Hotel;
import org.springframework.stereotype.Service;

@Service
public class HotelMapper {

    private final AddressMapper addressMapper;
    private final ContactsMapper contactsMapper;
    private final ArrivalTimeMapper arrivalTimeMapper;

    public HotelMapper(AddressMapper addressMapper, ContactsMapper contactsMapper, ArrivalTimeMapper arrivalTimeMapper) {
        this.addressMapper = addressMapper;
        this.contactsMapper = contactsMapper;
        this.arrivalTimeMapper = arrivalTimeMapper;
    }

    public SimpleHotelResponseDto toSimpleResponseDto(Hotel hotel)
    {
        return new SimpleHotelResponseDto(
                hotel.getId(),
                hotel.getName(),
                hotel.getDescription(),
                hotel.getAddress().getHouseNumber() +
                        " " +
                        hotel.getAddress().getStreet() +
                        ", " +
                        hotel.getAddress().getCity() +
                        ", " +
                        hotel.getAddress().getPostCode() +
                        ", " +
                        hotel.getAddress().getHouseNumber(),
                hotel.getContacts().getPhone()
        );
    }

    public HotelResponseDto toResponseDto(Hotel hotel)
    {
        return new HotelResponseDto(
                hotel.getId(),
                hotel.getName(),
                hotel.getDescription(),
                hotel.getBrand(),
                addressMapper.toDto(hotel.getAddress()),
                contactsMapper.toDto(hotel.getContacts()),
                arrivalTimeMapper.toDto(hotel.getArrivalTime()),
                hotel.getAmenities()
        );
    }

    public Hotel responseDtoToEntity(HotelResponseDto hotelResponseDto)
    {
        return new Hotel(
                hotelResponseDto.getId(),
                hotelResponseDto.getName(),
                hotelResponseDto.getDescription(),
                hotelResponseDto.getBrand(),
                addressMapper.toEntity(hotelResponseDto.getAddress()),
                contactsMapper.toEntity(hotelResponseDto.getContacts()),
                arrivalTimeMapper.toEntity(hotelResponseDto.getArrivalTime()),
                hotelResponseDto.getAmenities()
        );
    }
}
