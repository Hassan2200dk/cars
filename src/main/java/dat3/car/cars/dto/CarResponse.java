package dat3.car.cars.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.car.cars.entity.Car;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarResponse {
    private int id;
    private String brand;
    private String model;
    private double pricePrDay;
    private Integer bestDiscount;

    public CarResponse(Car car, boolean includeAll) {
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.pricePrDay = car.getPricePrDay();
        this.bestDiscount = car.getBestDiscount();

        if (includeAll){
            this.id = car.getId();
        }
    }
}
