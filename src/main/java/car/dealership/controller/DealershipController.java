package car.dealership.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import car.dealership.controller.model.LocationData;
import car.dealership.controller.model.LocationData.LocationCar.CarData;
import car.dealership.service.DealershipSevice;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/car_dealership")
@Slf4j
public class DealershipController {
	
	@Autowired
	private DealershipSevice dealershipService;
	
	@PostMapping("/car")
	@ResponseStatus(code = HttpStatus.CREATED)
	public CarData insertCar (
			@RequestBody CarData carData) {
		log.info("Creating car {}", carData);
		return dealershipService.savecar(carData);
}
	
	@GetMapping("/car")
	public List<CarData> retrieveAllCars() {
		log.info(":retrieve all cars called.");
		return dealershipService.retrieveAllCars();
	}
	@GetMapping("car/(carId")
	public CarData RetrieveCarById(@PathVariable Long carId ) {
	log.info("retrieveing car with ID=()", carId);
	return dealershipService.retrieveCarById(carId);
	
}
	
	@DeleteMapping("/car")
	public void deleteAllCars() {
		log.info("Attempting to delete all cars");
		throw new UnsupportedOperationException(
				"Deleteing all cars is not allowed");
	}
	
	@DeleteMapping("/car/{carId}")
	public Map<String, String> deleteContributorById(@PathVariable Long carId) {
		log.info("Deleting car with ID=()", carId);
		
		dealershipService.deletecarById(carId);
		
		return Map.of("message", "Deletion of car ID=" + carId + "was successful.");
		
	}
	
	@PostMapping("/car/{carId}/location")
	@ResponseStatus(code = HttpStatus.CREATED)
	public LocationData insertLocation(@PathVariable Long carId, @RequestBody LocationData locationData) {
		log.info("Creating dealership {} for car with ID={}", locationData, carId );
		
		return dealershipService.saveLocation(carId, locationData);
	}
	


	@PutMapping("/car/(carrId)/car/{carId}")
	public LocationData updatelocatData(@PathVariable Long carId, 
			@PathVariable Long locationId,
			@RequestBody LocationData locationData) {
		
			locationData.setLocationId(locationId);
			
		log.info("Creating dealership {} for car with ID={}", locationData,  carId);
		
		
		return dealershipService.saveLocation(carId, locationData);
		
	}

		@GetMapping("/car/{carId}/locationId/{locationId}")
		public LocationData retrieveLocationById(@PathVariable Long carId,
				@PathVariable Long locationId) {
			log.info("Retrieving dealership with ID={} for car with ID={}", locationId, carId);
			
			return dealershipService.retrieveLocationById(carId, locationId);
			
			
		}
	}













