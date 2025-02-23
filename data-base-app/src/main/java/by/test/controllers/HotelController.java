package by.test.controllers;

import by.test.dto.HistogramResponseDto;
import by.test.dto.HotelResponseDto;
import by.test.dto.SimpleHotelResponseDto;
import by.test.mappers.HotelMapper;
import by.test.models.Hotel;
import by.test.services.HotelService;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.util.ElementKindVisitor7;
import java.util.HashMap;
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
