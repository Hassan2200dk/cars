package dat3.car.cars.config;

import dat3.car.cars.entity.Car;
import dat3.car.cars.entity.Member;
import dat3.car.cars.repository.CarRepository;
import dat3.car.cars.repository.MemberRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;


@Controller
public class DeveloperData implements ApplicationRunner {

    CarRepository carRepository;
    MemberRepository memberRepository;



    public DeveloperData(CarRepository carRepository, MemberRepository memberRepository){
        this.carRepository = carRepository;
        this.memberRepository = memberRepository;

    }



    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1, "Toyota", "Camry", 50.0, 5));
        cars.add(new Car(2, "Honda", "Civic", 45.0, 10));
        cars.add(new Car(3, "Ford", "Mustang", 100.0, 15));
        cars.add(new Car(4, "Chevrolet", "Corvette", 150.0, 20));
        cars.add(new Car(5, "BMW", "M3", 200.0, 25));
        cars.add(new Car(6, "Mercedes-Benz", "S-Class", 250.0, 30));
        cars.add(new Car(7, "Audi", "A8", 300.0, 35));
        cars.add(new Car(8, "Lamborghini", "Aventador", 500.0, 40));
        cars.add(new Car(9, "Ferrari", "458 Italia", 600.0, 45));
        cars.add(new Car(10, "Bugatti", "Veyron", 1000.0, 50));

        carRepository.saveAll(cars);

        List<Member> members = new ArrayList<>();
        members.add(new Member("user1", "pass1", "user1@example.com", "John", "Doe", "123 Street", "City1", "12345"));
        members.add(new Member("user2", "pass2", "user2@example.com", "Jane", "Smith", "456 Avenue", "City2", "67890"));
        members.add(new Member("user3", "pass3", "user3@example.com", "Bob", "Johnson", "789 Road", "City3", "54321"));

        memberRepository.saveAll(members);


    }
}
