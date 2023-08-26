package dat3.car.CarRepositoryTest;


import dat3.car.cars.entity.Car;
import dat3.car.cars.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class TestClass {


    @Autowired
    CarRepository carRepository;

    @Test
    void TestToSeeAddition(){
        carRepository.save(new Car(9, "Ferrari", "458 Italia", 600.0, 45));
        long size = carRepository.count();

        assertEquals(1,size);

    }
}
