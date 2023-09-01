package car.dealership.controller.model;

import java.util.HashSet;
import java.util.Set;

import car.dealership.entity.Car;
import car.dealership.entity.Location;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LocationData {
	private Long locationId;
	private String businessName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private Set<String> cars = new HashSet<>();
	
	
	
	public LocationData(Location location) {
		locationId = location.getLocationId();
		businessName = location.getBusinessName();
		address = location.getAddress();
		city = location.getCity();
		state = location.getState();
		zip = location.getZip();
		phone = location.getPhone();
		
		for(Car car : location.getCars()) {
			cars.add(car.getName());
		}
	}
	@Data
	@NoArgsConstructor
	public static class LocationCar {
		private Long carId;
		private String carName;
		private String carAddress;
		
		public LocationCar(Car car) {
			carId = car.getCarId();
			carName = car.getName();
			carAddress = car.getAddress();
		}
		
		@Data
		@NoArgsConstructor
		public class CarData {
				private Long carId;
				private String carName;
				private String carAddress;
				private Set<LocationResponse> locations = new HashSet<>();
				
				
			public CarData(Car car) {
				carId = car.getCarId();
				carName = car.getName();
				carAddress = car.getAddress();
				
				for(Location location : car.getLocations()) {
					locations.add(new LocationResponse(location));
				}
				}
				
				@Data
				@NoArgsConstructor
				static class LocationResponse {
					private Long locationId;	
					private String businessName;
					private String address;
					private String city;
					private String state;
					private String zip;
					private String phone;
					private Set<String> cars = new HashSet<>();
					
					LocationResponse(Location location) {
						locationId = location.getLocationId();
						businessName = location.getBusinessName();
						address = location.getAddress();
						city = location.getCity();
						state = location.getState();
						zip = location.getZip();
						phone = location.getPhone();
						
						
						
						for(Car car : location.getCars()) {
							cars.add(car.getName());
							
						}
					}
					
				}

				}

	}
	
}
