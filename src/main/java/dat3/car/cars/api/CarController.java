package dat3.car.cars.api;


import dat3.car.cars.dto.CarRequest;
import dat3.car.cars.dto.CarResponse;
import dat3.car.cars.dto.MemberRequest;
import dat3.car.cars.dto.MemberResponse;
import dat3.car.cars.entity.Car;
import dat3.car.cars.repository.CarRepository;
import dat3.car.cars.service.CarService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarController {

    CarRepository carRepository;
    CarService carService;

    public CarController(CarRepository carRepository, CarService carService){
        this.carRepository = carRepository;
        this.carService = carService;
    }


    // Admin with id
    @GetMapping()
    List<CarResponse> getCars(){
        return carService.getAllCars(true);
    }

    // No id
    @GetMapping("/id")
    List<CarResponse> getCarsNoId(){
        return carService.getAllCars(false);
    }
    //Security Admin
    @GetMapping(path = "/{id}")
    CarResponse getMemberById(@PathVariable int id) throws Exception {
        return carService.findById(id);
    }
    //Security --> Anonymous
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CarResponse addCar(@RequestBody CarRequest body) {
        return carService.addCar(body);
    }

    @PutMapping("/{id}")
    CarResponse editMember(@RequestBody CarRequest body, @PathVariable int id){
        return carService.editCar(body, id);
    }

    //Security ADMIN ONLY
    @PatchMapping("/price/{id}/{newPrice}")
    void setPrice(@PathVariable int id, @PathVariable double newPrice) {
        carService.setPrice(id, newPrice);
    }
    //Security ADMIN ONLY
    @PatchMapping("/discount/{id}/{newDiscount}")
    void setPrice(@PathVariable int id, @PathVariable int newDiscount) {
        carService.setDiscount(id, newDiscount);
    }

    // Security ADMIN ONLY
    @DeleteMapping("/{id}")
    ResponseEntity<Boolean> deleteCar(@PathVariable int id) {
        return carService.deleteCar(id);
    }



}
