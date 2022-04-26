package stream;

import java.util.List;

public class CarsParkingList {

    public static List<CarsParking> carsParkingList() {
        List<CarsParking> carsParkingList = List.of(
                new CarsParking("Opel", 1988, KindOfTransport.PASSENGER_CAR),
                new CarsParking("BMV", 2005, KindOfTransport.PASSENGER_CAR),
                new CarsParking("Kamaz", 1990, KindOfTransport.CARGO),
                new CarsParking("ZIL_130", 1966, KindOfTransport.CARGO),
                new CarsParking("GAZ_53", 1978, KindOfTransport.CARGO),
                new CarsParking("Audi", 2012, KindOfTransport.PASSENGER_CAR),
                new CarsParking("Reno", 2005, KindOfTransport.PASSENGER_CAR),
                new CarsParking("Infinity", 2021, KindOfTransport.PASSENGER_CAR)
        );
        return carsParkingList;
    }
}
