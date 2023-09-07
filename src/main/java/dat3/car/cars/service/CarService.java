package dat3.car.cars.service;


import dat3.car.cars.dto.CarRequest;
import dat3.car.cars.dto.CarResponse;
import dat3.car.cars.dto.MemberResponse;
import dat3.car.cars.entity.Car;
import dat3.car.cars.entity.Member;
import dat3.car.cars.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {



    CarRepository carRepository;

    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public List<CarResponse> getAllCars(boolean includeAll){
        List<Car> cars = carRepository.findAll();


        List<CarResponse> responses = new ArrayList<>();

        for (Car car: cars){
            CarResponse carResponse = new CarResponse(car, includeAll);
            responses.add(carResponse);
        }
        return responses;
    }

    public CarResponse findById(int id) {
        Car car = carRepository.findById(id).
                orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Member with this username does not exist"));
        return new CarResponse(car,true);
    }
    public CarResponse addCar(CarRequest carRequest) {
        // Check if the car already exists (You can use any unique identifier for a car)
        // For example, if you consider brand and model as unique:
        if (carRepository.existsById(carRequest.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This car already exists");
        }

        // Convert the CarRequest to a Car entity
        Car newCar = carRequest.toCarEntity(carRequest);

        // Save the new car entity
        newCar = carRepository.save(newCar);

        // Create and return a CarResponse object
        return new CarResponse(newCar,true);
    }

    public CarResponse editCar(CarRequest body, int id) {
        Car carToEdit = getCarIfExists(id);
        //ID can not be changed
        carToEdit.setBrand(body.getBrand());
        carToEdit.setModel(body.getModel());
        carToEdit.setPricePrDay(body.getPricePrDay());
        carToEdit.setBestDiscount(body.getBestDiscount());
        Car saved = carRepository.save(carToEdit);
        return new CarResponse(saved,true);
    }

    public void setPrice(int id, double newPrice) {
        Car carToEdit = getCarIfExists(id);
        carToEdit.setPricePrDay(newPrice);
        carRepository.save(carToEdit);
    }

    public void setDiscount(int id, int newDiscount) {
        Car carToEdit = getCarIfExists(id);
        carToEdit.setBestDiscount(newDiscount);
        carRepository.save(carToEdit);
    }

    public ResponseEntity<Boolean> deleteCar(int id) {
        if(!carRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car with this ID does not exist");
        }
        try {
            carRepository.deleteById(id);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not delete car. Most likely because it part of a rental/reservation");
        }
    }

    private Car getCarIfExists(int id){
        return carRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car with this ID does not exist"));
    }

}

