package by.test.hotels.controllers;

import by.test.hotels.dto.HotelResponseDto;
import by.test.hotels.dto.SimpleHotelResponseDto;
import by.test.hotels.mappers.HotelMapper;
import by.test.hotels.services.HotelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Tag(
        name = "Hotel Controller",
        description = "Контроллер для управления отелями"
)
@RestController
@RequestMapping("property-view")
public class HotelController {

    private final HotelService hotelService;
    private final HotelMapper hotelMapper;

    public HotelController(HotelService hotelService, HotelMapper hotelMapper) {
        this.hotelService = hotelService;
        this.hotelMapper = hotelMapper;
    }

    @Operation(
            summary = "Вывод информации об отеле",
            description = "Выводит полную информацию об отеле"
    )
    @GetMapping("/hotels/{id}")
    public HotelResponseDto showHotels(
            @PathVariable @Parameter(description = "ИД отеля") int id
    )
    {
        return hotelMapper.toResponseDto(hotelService.getHotelById(id));
    }

    @Operation(
            summary = "Вывод списка отелей",
            description = "Выводит краткую информацию об отелях"
    )
    @GetMapping("/hotels")
    public List<SimpleHotelResponseDto> showHotels()
    {
        return hotelService.getHotels().stream().map(hotelMapper::toSimpleResponseDto).toList();
    }

    @Operation(
            summary = "Добавление отеля",
            description = "Добавляет отель в БД"
    )
    @PostMapping("/hotels")
    public SimpleHotelResponseDto addHotel(
            @RequestBody @Parameter(description = "Объект отеля") HotelResponseDto hotelResponseDto
    )
    {
        return hotelMapper.toSimpleResponseDto(hotelService.addHotel(hotelMapper.responseDtoToEntity(hotelResponseDto)));
    }

    @Operation(
            summary = "Добавление списка удобств",
            description = "Добавляет список удобств к отелю с выбранным ИД"
    )
    @PostMapping("/hotels/{id}/amenities")
    public HotelResponseDto addAmenities(
            @PathVariable @Parameter(description = "ИД отеля") int id,
            @RequestBody @Parameter(description = "Список удобств") List<String> amenities
    )
    {
        return hotelMapper.toResponseDto(hotelService.addAmenities(id, amenities));
    }

    @Operation(
            summary = "Вывод гистограммы",
            description = "Выводит количество отелей сгруппированных по каждому значению указанного параметра"
    )
    @GetMapping("/histogram/{param}")
    public Map<String, Integer> showHistogram(
            @PathVariable @Parameter(description = "Параметр, по которому выводим данные") String param
    )
    {
        return hotelService.getHistogram(param);
    }

    @Operation(
            summary = "Поиск отелей",
            description = "Выводит отели, соответствующие введенным параметрам"
    )
    @GetMapping("/search")
    public List<SimpleHotelResponseDto> showHotels(
            @RequestParam(name = "name", defaultValue = "", required = false) @Parameter(description = "Название отеля") String name,
            @RequestParam(name = "brand", defaultValue = "", required = false) @Parameter(description = "Бренд отеля") String brand,
            @RequestParam(name = "city", defaultValue = "", required = false) @Parameter(description = "Город отеля") String city,
            @RequestParam(name = "country", defaultValue = "", required = false) @Parameter(description = "Страна отеля") String country,
            @RequestParam(name = "amenities", defaultValue = "", required = false) @Parameter(description = "Присутствующее удобство") String amenities
    )
    {
        return hotelService.getFilteredHotels(name, brand, city, country, amenities).stream().map(hotelMapper::toSimpleResponseDto).toList();
    }
}
