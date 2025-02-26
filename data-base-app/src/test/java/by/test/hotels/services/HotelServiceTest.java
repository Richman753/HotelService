package by.test.hotels.services;

import by.test.hotels.models.Address;
import by.test.hotels.models.ArrivalTime;
import by.test.hotels.models.Contacts;
import by.test.hotels.models.Hotel;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.ObjectOptimisticLockingFailureException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HotelServiceTest {

    @Autowired
    private HotelService hotelService;

    @Test
    @Order(1)
    void addHotel_then_returnHotel() {
        Hotel expected = new Hotel(
                null,
                "name",
                "desc",
                "brand",
                new Address(
                        null,
                        33,
                        "street",
                        "city",
                        "country",
                        "pc"
                ),
                new Contacts(
                        null,
                        "333",
                        "mail"
                ),
                new ArrivalTime(
                        null,
                        "11",
                        "12"
                ),
                new ArrayList<>()
        );
        Hotel actual = hotelService.addHotel(expected);
        expected.setId(1);
        expected.getAddress().setId(1);
        expected.getContacts().setId(1);
        expected.getArrivalTime().setId(1);
        Assertions.assertEquals(expected, actual);
        expected.setId(null);
        expected.getAddress().setId(null);
        expected.getContacts().setId(null);
        expected.getArrivalTime().setId(null);
        expected.setAddress(
                new Address(
                        null,
                        33,
                        "street",
                        "Minsk",
                        "Belarus",
                        "pc"
                )
        );
        hotelService.addHotel(expected);
    }

    @Test
    @Order(2)
    void addAmenities_then_returnHotel() {
        Hotel expected = new Hotel(
                1,
                "name",
                "desc",
                "brand",
                new Address(
                        1,
                        33,
                        "street",
                        "city",
                        "country",
                        "pc"
                ),
                new Contacts(
                        1,
                        "333",
                        "mail"
                ),
                new ArrivalTime(
                        1,
                        "11",
                        "12"
                ),
                List.of(
                        "Free wi-fi",
                        "Large rooms"
                )
        );
        Hotel actual = hotelService.addAmenities(1, List.of("Free wi-fi", "Large rooms"));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(3)
    @Transactional
    void getHotels_then_returnHotels() {
        List<Hotel> expected = List.of(new Hotel(
                1,
                "name",
                "desc",
                "brand",
                new Address(
                        1,
                        33,
                        "street",
                        "city",
                        "country",
                        "pc"
                ),
                new Contacts(
                        1,
                        "333",
                        "mail"
                ),
                new ArrivalTime(
                        1,
                        "11",
                        "12"
                ),
                List.of(
                        "Free wi-fi",
                        "Large rooms"
                )),
                new Hotel(
                        2,
                        "name",
                        "desc",
                        "brand",
                        new Address(
                                2,
                                33,
                                "street",
                                "Minsk",
                                "Belarus",
                                "pc"
                        ),
                        new Contacts(
                                2,
                                "333",
                                "mail"
                        ),
                        new ArrivalTime(
                                2,
                                "11",
                                "12"
                        ),
                        new ArrayList<>()
                ));
        List<Hotel> actual = hotelService.getHotels();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(4)
    @Transactional
    void getHotelById_then_returnHotel() {
        Hotel expected = new Hotel(
                1,
                "name",
                "desc",
                "brand",
                new Address(
                        1,
                        33,
                        "street",
                        "city",
                        "country",
                        "pc"
                ),
                new Contacts(
                        1,
                        "333",
                        "mail"
                ),
                new ArrivalTime(
                        1,
                        "11",
                        "12"
                ),
                List.of(
                        "Free wi-fi",
                        "Large rooms"
                )
        );
        Hotel actual = hotelService.getHotelById(1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(5)
    @Transactional
    void getFilteredHotels_then_returnHotels() {
        List<Hotel> expected = List.of(new Hotel(
                2,
                "name",
                "desc",
                "brand",
                new Address(
                        2,
                        33,
                        "street",
                        "Minsk",
                        "Belarus",
                        "pc"
                ),
                new Contacts(
                        2,
                        "333",
                        "mail"
                ),
                new ArrivalTime(
                        2,
                        "11",
                        "12"
                ),
                new ArrayList<>()
        ));
        List<Hotel> actual = hotelService.getFilteredHotels("","","Minsk","","");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(6)
    void getHistogram_then_returnHistogram() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("Free wi-fi", 1);
        expected.put("Large rooms", 1);
        Map<String, Integer> actual = hotelService.getHistogram("amenities");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(7)
    void addHotel_then_throwExceptions() {
        Hotel expected = new Hotel(
                -1,
                "name",
                "desc",
                "brand",
                new Address(
                        1,
                        33,
                        "street",
                        "city",
                        "country",
                        "pc"
                ),
                new Contacts(
                        1,
                        "333",
                        "mail"
                ),
                new ArrivalTime(
                        1,
                        "11",
                        "12"
                ),
                new ArrayList<>()
        );
        Assertions.assertThrows(ObjectOptimisticLockingFailureException.class, () -> hotelService.addHotel(expected));
        expected.setId(null);
        expected.setAddress(null);
        expected.getContacts().setId(null);
        expected.getArrivalTime().setId(null);
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> hotelService.addHotel(expected));
    }

    @Test
    @Order(8)
    void addAmenities_then_throwExceptions() {
        Hotel expected = new Hotel(
                1,
                "name",
                "desc",
                "brand",
                new Address(
                        1,
                        33,
                        "street",
                        "city",
                        "country",
                        "pc"
                ),
                new Contacts(
                        1,
                        "333",
                        "mail"
                ),
                new ArrivalTime(
                        1,
                        "11",
                        "12"
                ),
                null
        );
        Assertions.assertThrows(NullPointerException.class, () -> hotelService.addAmenities(33, null));
    }

    @Test
    @Order(9)
    @Transactional
    void getHotelById_then_returnNull() {
        Hotel actual = hotelService.getHotelById(-1);
        Assertions.assertNull(actual);
    }
}