package dat3.car.cars.repository;

import dat3.car.cars.entity.Car;
import dat3.car.cars.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findAllByBrandAndModel(String brand, String model);

    List<Car> findAllByReservationsNull();
    List<Car> findAllByBestDiscount(Integer discount);



    @Query(value = "SELECT AVG(pricePrDay) FROM Car")

    Double findAveragePricePrDay();


}
