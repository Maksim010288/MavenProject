package stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamOutput {

    public void filter_list(List<CarsParking> list) {
        for (CarsParking carsParking : list) {
            if (carsParking.getKindOfTransport().equals(KindOfTransport.PASSENGER_CAR)) {
                System.out.println(carsParking);
            }
        }
        System.out.println("-------------------------------------");
        List<CarsParking> listFilter = list.stream()
                .filter(carsParking -> carsParking.getKindOfTransport().equals(KindOfTransport.PASSENGER_CAR))
                .collect(Collectors.toList());
        listFilter.forEach(System.out::println);
    }

    public void sorted_list(List<CarsParking> list) {
        List<CarsParking> listSorted = list.stream()
                .sorted(Comparator.comparing(CarsParking::getName).reversed())
                .filter(carsParking -> carsParking.getKindOfTransport().equals(KindOfTransport.PASSENGER_CAR))
                .collect(Collectors.toList());
        listSorted.forEach(System.out::println);
    }

    public void allMath(List<CarsParking> list) {
        boolean listAllMath = list.stream()
                .allMatch(carsParking -> carsParking.getAge() >= 1988);
        System.out.println(listAllMath);
    }

    public void anyMath(List<CarsParking> list) {
        boolean listAnyMath = list.stream()
                .anyMatch(carsParking -> carsParking.getAge() > 2005);
        System.out.println(listAnyMath);
    }

    public void noneMath(List<CarsParking> list) {
        boolean listNoneMath = list.stream()
                .anyMatch(carsParking -> carsParking.getName().equals("Volkswagen"));
        System.out.println(listNoneMath);
    }

    public void maxMeaningList(List<CarsParking> list) {
        list.stream().max(Comparator.comparing(CarsParking::getAge))
                .ifPresent((System.out::println));
    }

    public void minMeaningList(List<CarsParking> list) {
        list.stream().min(Comparator.comparing(CarsParking::getAge))
                .ifPresent((System.out::println));
    }

    public void groupList(List<CarsParking> list) {
        Map<KindOfTransport, List<CarsParking>> kindOfTransportListMap = list.stream()
                .collect(Collectors.groupingBy(CarsParking::getKindOfTransport));

        kindOfTransportListMap.forEach((((kindOfTransport, carsParkings) -> {
            System.out.println(kindOfTransport);
            carsParkings.forEach(System.out::println);
            System.out.println();
        })));
    }

    public void distinctList(List<CarsParking> list) {
        list.stream()
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
}
