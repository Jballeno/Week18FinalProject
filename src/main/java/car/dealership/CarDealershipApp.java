package car.dealership; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import car.dealership.controller.model.LocationData.ModelLocation.ModelData;
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
		List<ModelData> models = dealershipService.retrieveAllModels();
		models.forEach(System.out::println);
	}
}
