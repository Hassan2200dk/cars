package dat3.car.cars.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Car extends AdminDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "car_brand", length = 50, nullable = false)
    private String brand;

    @Column(name = "car_model", length = 60, nullable = false)

    private String model;

    @Column(name = "rental_price_day")

    private double pricePrDay;

    @Column(name = "max_discount")

    private Integer bestDiscount;


    @OneToMany(mappedBy = "car")
    List<Reservation> reservations;


    public Car(int id, String brand, String model, double pricePrDay, Integer bestDiscount) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
        this.bestDiscount = bestDiscount;
    }

    public Car(String brand, String model, double pricePrDay, Integer bestDiscount) {
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
        this.bestDiscount = bestDiscount;
    }
    public void addReservation(Reservation reservation){
        if (reservations == null){
            reservations = new ArrayList<>();
        }
        reservations.add(reservation);
    }
}
