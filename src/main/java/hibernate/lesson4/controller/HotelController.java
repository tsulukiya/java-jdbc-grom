package hibernate.lesson4.controller;


import hibernate.lesson4.model.Hotel;
import hibernate.lesson4.services.HotelService;

public class HotelController {
    HotelService hotelService = new HotelService();


    public Hotel save(Hotel hotel) {
        return hotelService.save(hotel);
    }

    public Hotel update(Hotel hotel) {
        return hotelService.update(hotel);
    }

    public Hotel delete(long id) {
        return hotelService.delete(id);
    }

    public Hotel findById(long id) {
        return hotelService.findById(id);
    }

    public Hotel findByName(String name) {
        return hotelService.findByName(name);
    }

    public Hotel findByCity(String city) {
        return hotelService.findByCity(city);
    }

}
