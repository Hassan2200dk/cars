package dat3.car.MemberService;

import dat3.car.cars.dto.CarRequest;
import dat3.car.cars.dto.CarResponse;
import dat3.car.cars.entity.Car;
import dat3.car.cars.repository.CarRepository;
import dat3.car.cars.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CarServiceH2Test {

    @Autowired
    CarRepository carRepository;
    CarService carService;

    Car car1, car2;

    @BeforeEach
    void setUp() {
        car1 = carRepository.save(new Car(0, "Brand1", "Model1", 100.0, 10));
        car2 = carRepository.save(new Car(0, "Brand2", "Model2", 120.0, 15));

        carService = new CarService(carRepository);
    }



    @Test
    void testGetCars() {
        List<CarResponse> carResponses = carService.getAllCars(true);
        assertEquals(2, carResponses.size());
    }

}
