package by.test.hotels.repositories;

import by.test.hotels.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Integer> {
    @Query(value = "select brand, count(brand) from Hotel " +
            "group by brand", nativeQuery = true)
    List<List<String>> getBrandHistogram();

    @Query(value = "select city, count(city) from Hotel " +
            "left join Address on address.id=hotel.address_id " +
            "group by city", nativeQuery = true)
    List<List<String>> getCityHistogram();

    @Query(value = "select country, count(country) from Hotel " +
            "left join Address on address.id=hotel.address_id " +
            "group by country", nativeQuery = true)
    List<List<String>> getCountryHistogram();

    @Query(value = "select hotel_amenities.amenities, count(hotel_amenities.amenities) from Hotel " +
            "join hotel_amenities on hotel.id=hotel_amenities.hotel_id " +
            "group by hotel_amenities.amenities", nativeQuery = true)
    List<List<String>> getAmenitiesHistogram();

    @Query(value = "select distinct h1_0.id,h1_0.address_id,a1_0.city,a1_0.country,a1_0.houseNumber,a1_0.postCode,a1_0.street,h1_0.arrivalTime_id,at1_0.checkIn,at1_0.checkOut,h1_0.brand,h1_0.contacts_id,c1_0.email,c1_0.phone,h1_0.description,h1_0.name from Hotel h1_0 " +
            "left join Address a1_0 on a1_0.id=h1_0.address_id " +
            "left join ArrivalTime at1_0 on at1_0.id=h1_0.arrivalTime_id " +
            "left join Contacts c1_0 on c1_0.id=h1_0.contacts_id " +
            "left join hotel_amenities ha1_0 on h1_0.id=ha1_0.hotel_id " +
            "where LOWER(a1_0.city) like %:city " +
            "and LOWER(h1_0.name) like %:name " +
            "and LOWER(h1_0.brand) like %:brand " +
            "and LOWER(a1_0.country) like %:country " +
            "and LOWER(ifnull(ha1_0.amenities, '')) like %:amenities", nativeQuery = true)
    List<Hotel> getFilteredHotels(@Param("name") String name,
                                  @Param("brand") String brand,
                                  @Param("city") String city,
                                  @Param("country") String country,
                                  @Param("amenities") String amenities);
}
