package dat3.car.cars.config;

import dat3.car.cars.entity.Car;
import dat3.car.cars.entity.Member;
import dat3.car.cars.entity.Reservation;
import dat3.car.cars.repository.CarRepository;
import dat3.car.cars.repository.MemberRepository;
import dat3.car.cars.repository.ReservationRepository;
import dat3.car.security.entity.Role;
import dat3.car.security.entity.UserWithRoles;
import dat3.car.security.repository.UserWithRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Controller
public class DeveloperData implements ApplicationRunner {

    MemberRepository memberRepository;
    CarRepository carRepository;
    ReservationRepository reservationRepository;
    final String passwordUsedByAll = "test12";

    public DeveloperData(MemberRepository memberRepository, CarRepository carRepository, ReservationRepository reservationRepository) {
        this.memberRepository = memberRepository;
        this.carRepository = carRepository;
        this.reservationRepository = reservationRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1, "Toyota", "Camry", 50.0, 5));
        cars.add(new Car( 2,"Honda", "Civic", 45.0, 10));
        cars.add(new Car(3, "Ford", "Mustang", 100.0, 15));
        cars.add(new Car(4, "Chevrolet", "Corvette", 150.0, 20));
        cars.add(new Car(5, "BMW", "M3", 200.0, 25));
        cars.add(new Car(6, "Mercedes-Benz", "S-Class", 250.0, 30));
        cars.add(new Car(7, "Audi", "A8", 300.0, 35));
        cars.add(new Car(8, "Lamborghini", "Aventador", 500.0, 40));
        cars.add(new Car(40, "Ferrari", "458 Italia", 600.0, 45));
        cars.add(new Car(10, "Bugatti", "Veyron", 1000.0, 50));
        cars.add(new Car(11, "ddasd", "sdasd", 1000.0, 50));
        cars.add(new Car( 20,"Honda", "Civic", 45.0, 10));
        cars.add(new Car( 40,"Honda", "Civic", 45.0, 10));

        System.out.println(cars.size());


        carRepository.saveAll(cars);

        List<Member> members = new ArrayList<>();
        members.add(new Member("user1", "pass1", "user1@example.com", "John", "Doe", "123 Street", "City1", "12345"));
        members.add(new Member("user2", "pass2", "user2@example.com", "Jane", "Smith", "456 Avenue", "City2", "67890"));
        members.add(new Member("user3", "pass3", "user3@example.com", "Bob", "Johnson", "789 Road", "City3", "54321"));

        memberRepository.saveAll(members);


        Car car1 = new Car("VW", "Golf", 760, 25);
        Member m1 = new Member("Jan","test12","a@b.dk","Jan","Jensen","Lyngbyvej 1","Lyngby","2800");
        carRepository.save(car1);
        memberRepository.save(m1);



        LocalDate date1 = LocalDate.of(2023,12,12);
        LocalDate date2 = date1.plusDays(1);
        Reservation r1 = new Reservation(date1, car1, m1);
        Reservation r2 = new Reservation(date2, car1, m1);
        reservationRepository.save(r1);
        reservationRepository.save(r2);

        System.out.println("xxxx ------> "+car1.getReservations().size());
        System.out.println("xxxx ------> "+m1.getReservations().size());


        //System.out.println("Should find: " reservationRepository.existsByCar_IdAndRentalDate());

        setupUserWithRoleUsers();

        getCars();

        Double averagePrice = carRepository.findAveragePricePrDay();

        System.out.println("average price is " + averagePrice);

    }
    @Autowired
    UserWithRolesRepository userWithRolesRepository;



    /*****************************************************************************************
     NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL
     iT'S ONE OF THE TOP SECURITY FLAWS YOU CAN DO
     *****************************************************************************************/
    private void setupUserWithRoleUsers() {

        System.out.println("******************************************************************************");
        System.out.println("******* NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL ************");
        System.out.println("******* REMOVE THIS BEFORE DEPLOYMENT, AND SETUP DEFAULT USERS DIRECTLY  *****");
        System.out.println("**** ** ON YOUR REMOTE DATABASE                 ******************************");
        System.out.println("******************************************************************************");
        UserWithRoles user1 = new UserWithRoles("user-1", passwordUsedByAll, "user1@a.dk");
        UserWithRoles user2 = new UserWithRoles("user-2", passwordUsedByAll, "user2@a.dk");
        UserWithRoles user3 = new UserWithRoles("user-3", passwordUsedByAll, "user3@a.dk");
        UserWithRoles user4 = new UserWithRoles("user-4", passwordUsedByAll, "user4@a.dk");
        user1.addRole(Role.USER);
        user1.addRole(Role.ADMIN);
        user2.addRole(Role.USER);
        user3.addRole(Role.ADMIN);
        //No Role assigned to user4
        userWithRolesRepository.save(user1);
        userWithRolesRepository.save(user2);
        userWithRolesRepository.save(user3);
        userWithRolesRepository.save(user4);
    }

    public List<Car> getCars (){


        String  j = "Honda";
        String k = "Civic";

        List<Car> cars = carRepository.findAllByBrandAndModel(j,k);

        System.out.println("hejejjejeje");
        System.out.println(cars.size());


        for (int i = 0; i <cars.size() ; i++) {
            System.out.println(cars.get(i).getBrand() + " " + cars.get(i).getModel());

        }



        return cars;

    }


}
