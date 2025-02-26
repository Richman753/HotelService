package by.bezushko.hotels.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "brand")
    private String brand;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "contacts_id")
    private Contacts contacts;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "arrivalTime_id")
    private ArrivalTime arrivalTime;

    @ElementCollection
    private List<String> amenities;
}
