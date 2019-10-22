package hibernate.lesson4.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "HOTEL")
public class Hotel {
    private long id;
    private String name;
    private String country;
    private String city;
    private String street;
    private List <Room> rooms;

    public Hotel() {
    }

    public Hotel(long id) {
        this.id = id;
    }

    public Hotel(long id, String name, String country, String city, String street) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public Hotel(long id, String name, String country, String city, String street, List<Room> rooms) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
        this.rooms = rooms;
    }

    public Hotel(String name, String country, String city, String street, List<Room> rooms) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
        this.rooms = rooms;
    }

    public Hotel(String name, String country, String city, String street) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    @Id
    @SequenceGenerator(name = "HL_SEQ", sequenceName = "HOTEL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HL_SEQ")
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "NAME_HOTEL")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "COUNTRY")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "STREET")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel", fetch = FetchType.LAZY)
    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
