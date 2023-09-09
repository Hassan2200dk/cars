package dat3.car.cars.repository;

import dat3.car.cars.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {

    boolean existsByCar_IdAndRentalDate(int carId, LocalDate date);



}


