package stream;

import java.util.Objects;

public class CarsParking {
    private String name;
    private int age;
    private KindOfTransport kindOfTransport;

    public CarsParking(String name, int age, KindOfTransport kindOfTransport) {
        this.name = name;
        this.age = age;
        this.kindOfTransport = kindOfTransport;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public KindOfTransport getKindOfTransport() {
        return kindOfTransport;
    }

    @Override
    public String toString() {
        return "CarsParking{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", kindOfTransport=" + kindOfTransport +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarsParking that = (CarsParking) o;
        return age == that.age && Objects.equals(name, that.name) && kindOfTransport == that.kindOfTransport;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, kindOfTransport);
    }
}
