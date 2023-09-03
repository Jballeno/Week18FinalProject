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
import car.dealership.controller.model.LocationData.ModelLocation.ModelData;
import car.dealership.service.DealershipSevice;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/car_dealership")
@Slf4j
public class DealershipController {
	
	@Autowired
	private DealershipSevice dealershipService;
	
	@PostMapping("/model")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ModelData insertCar (
			@RequestBody ModelData modelData) {
		log.info("Creating model {}", modelData);
		return dealershipService.savemodel(modelData);
}
	
	@GetMapping("/model")
	public List<ModelData> retrieveAllCars() {
		log.info(":retrieve all models called.");
		return dealershipService.retrieveAllModels();
	}
	@GetMapping("model/(modelId")
	public ModelData RetrieveById(@PathVariable Long modelId ) {
	log.info("retrieveing model with ID=()", modelId);
	return dealershipService.retrieveModelById(modelId);
	
}
	
	@DeleteMapping("/model")
	public void deleteAllCars() {
		log.info("Attempting to delete all models");
		throw new UnsupportedOperationException(
				"Deleteing all models is not allowed");
	}
	
	@DeleteMapping("/model/{modelId}")
	public Map<String, String> deleteModelById(@PathVariable Long modelId) {
		log.info("Deleting car with ID=()", modelId);
		
		dealershipService.deleteModelById(modelId);
		
		return Map.of("message", "Deletion of car ID=" + modelId + "was successful.");
		
	}
	
	@PostMapping("/car/{carId}/location")
	@ResponseStatus(code = HttpStatus.CREATED)
	public LocationData insertLocation(@PathVariable Long carId, @RequestBody LocationData locationData) {
		log.info("Creating dealership {} for car with ID={}", locationData, carId );
		
		return dealershipService.saveLocation(carId, locationData);
	}
	


	@PutMapping("/car/{carId}/{locationId}")
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













