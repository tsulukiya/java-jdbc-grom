package hibernate.lesson4.Demo;


import hibernate.lesson4.controller.HotelController;
import hibernate.lesson4.model.Hotel;

public class DemoHotel {
    public static void main(String[] args) {
        HotelController hotelController = new HotelController();
        //hotelController.save(new Hotel("PARK INN", "Ukraine", "Kiev", "Street"));

        //hotelController.update(new Hotel(129,"PARK INN", "Ukraine", "Kiev", "Street"));
        //hotelController.delete(129);
        //System.out.println(hotelController.findById(135));
        //System.out.println(hotelController.findByName("PARK INN"));
        //System.out.println(hotelController.findByCity("Kiev"));
    }


}

