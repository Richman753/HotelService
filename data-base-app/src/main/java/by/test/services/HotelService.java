package by.test.services;

import by.test.dto.HistogramResponseDto;
import by.test.models.Hotel;
import by.test.repositories.HotelRepo;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HotelService {
    private final HotelRepo hotelRepo;

    public HotelService(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    public List<Hotel> getHotels()
    {
        return hotelRepo.findAll();
    }

    public List<Hotel> getFilteredHotels(String name, String brand, String city, String country, String amenities)
    {
        return hotelRepo.getFilteredHotels(name.toLowerCase(), brand.toLowerCase(), city.toLowerCase(), country.toLowerCase(), amenities.toLowerCase());
    }

    public Hotel getHotelById(int id)
    {
        return hotelRepo.findById(id).orElse(null);
    }

    public Hotel addHotel(Hotel hotel)
    {
        return hotelRepo.save(hotel);
    }

    public Hotel addAmenities(int id, List<String> amenities)
    {
        Hotel hotel = getHotelById(id);
        hotel.setAmenities(amenities);
        return hotelRepo.save(hotel);
    }

    public Map<String, Integer> getHistogram(String parameter)
    {
        Map<String, Integer> result = new HashMap<>();
        switch (parameter) {
            case "brand":
                hotelRepo.getBrandHistogram().forEach(element -> result.put(element.get(0), Integer.valueOf(element.get(1))));
                break;
            case "city":
                hotelRepo.getCityHistogram().forEach(element -> result.put(element.get(0), Integer.valueOf(element.get(1))));
                break;
            case "country":
                hotelRepo.getCountryHistogram().forEach(element -> result.put(element.get(0), Integer.valueOf(element.get(1))));
                break;
            case "amenities":
                hotelRepo.getAmenitiesHistogram().forEach(element -> result.put(element.get(0), Integer.valueOf(element.get(1))));
                break;
            default:
                break;
        }
        return result;
    }
}
