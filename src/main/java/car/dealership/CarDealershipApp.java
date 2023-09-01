package car.dealership; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import car.dealership.controller.model.LocationData.LocationCar.CarData;
import car.dealership.service.DealershipSevice;




@SpringBootApplication
public class CarDealershipApp implements CommandLineRunner  {
@Autowired
private DealershipSevice dealershipService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CarDealershipApp.class, args);
		

	}
	
	@Override
	public void run(String... args) throws Exception {
		List<CarData> models = dealershipService.retrieveAllCars();
		models.forEach(System.out::println);
	}
}
