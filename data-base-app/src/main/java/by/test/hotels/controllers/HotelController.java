package by.test.hotels.controllers;

import by.test.hotels.dto.HotelResponseDto;
import by.test.hotels.dto.SimpleHotelResponseDto;
import by.test.hotels.mappers.HotelMapper;
import by.test.hotels.services.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("property-view")
public class HotelController {

    private final HotelService hotelService;
    private final HotelMapper hotelMapper;

    public HotelController(HotelService hotelService, HotelMapper hotelMapper) {
        this.hotelService = hotelService;
        this.hotelMapper = hotelMapper;
    }

    @GetMapping("/hotels/{id}")
    public HotelResponseDto showHotels(
            @PathVariable int id
    )
    {
        return hotelMapper.toResponseDto(hotelService.getHotelById(id));
    }

    @GetMapping("/hotels")
    public List<SimpleHotelResponseDto> showHotels()
    {
        return hotelService.getHotels().stream().map(hotelMapper::toSimpleResponseDto).toList();
    }

    @PostMapping("/hotels")
    public SimpleHotelResponseDto addHotel(
            @RequestBody HotelResponseDto hotelResponseDto
    )
    {
        return hotelMapper.toSimpleResponseDto(hotelService.addHotel(hotelMapper.responseDtoToEntity(hotelResponseDto)));
    }

    @PostMapping("/hotels/{id}/amenities")
    public HotelResponseDto addAmenities(
            @PathVariable int id,
            @RequestBody List<String> amenities
    )
    {
        return hotelMapper.toResponseDto(hotelService.addAmenities(id, amenities));
    }

    @GetMapping("/histogram/{param}")
    public Map<String, Integer> showHistogram(
            @PathVariable String param
    )
    {
        return hotelService.getHistogram(param);
    }

    @GetMapping("/search")
    public List<SimpleHotelResponseDto> showHotels(
            @RequestParam(name = "name", defaultValue = "", required = false) String name,
            @RequestParam(name = "brand", defaultValue = "", required = false) String brand,
            @RequestParam(name = "city", defaultValue = "", required = false) String city,
            @RequestParam(name = "country", defaultValue = "", required = false) String country,
            @RequestParam(name = "amenities", defaultValue = "", required = false) String amenities
    )
    {
        return hotelService.getFilteredHotels(name, brand, city, country, amenities).stream().map(hotelMapper::toSimpleResponseDto).toList();
    }
}
