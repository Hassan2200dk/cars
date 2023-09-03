package dat3.car.cars.dto;

import dat3.car.cars.entity.Car;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarRequest {
    private int id;
    private String brand;
    private String model;
    private double pricePrDay;
    private Integer bestDiscount;

    // Conversion method to create a Car entity from CarRequest
    public static Car toCarEntity(CarRequest c) {
        return new Car(c.getId(), c.brand, c.model, c.pricePrDay, c.bestDiscount);
    }

    public CarRequest(Car car) {
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.pricePrDay = car.getPricePrDay();
        this.bestDiscount = car.getBestDiscount();
    }

}
