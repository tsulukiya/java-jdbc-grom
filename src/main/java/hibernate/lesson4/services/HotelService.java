package hibernate.lesson4.services;


import hibernate.lesson4.model.Hotel;
import hibernate.lesson4.repository.HotelRepository;

public class HotelService {
    HotelRepository hotelRepository = new HotelRepository();


    public Hotel save (Hotel hotel) {
        return (Hotel) hotelRepository.save(hotel);
    }

    public Hotel update(Hotel hotel) {
        return (Hotel) hotelRepository.update(hotel);
    }

    public Hotel delete(long id) {
        return hotelRepository.delete(id);
    }

    public Hotel findById(long id) {
        return hotelRepository.findById(id);
    }

    public Hotel findByName(String name) {
        return hotelRepository.findHotelByName(name);
    }

    public Hotel findByCity(String city) {
        return hotelRepository.findHotelByCity(city);
    }
}
