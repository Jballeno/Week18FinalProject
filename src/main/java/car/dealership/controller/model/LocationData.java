package car.dealership.controller.model;

import java.util.HashSet;
import java.util.Set;

import car.dealership.entity.Location;
import car.dealership.entity.Model;
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
	private ModelLocation model;
	private Set<String> models = new HashSet<>();
	
	
	
	public LocationData(Location location) {
		locationId = location.getLocationId();
		businessName = location.getBusinessName();
		address = location.getAddress();
		city = location.getCity();
		state = location.getState();
		zip = location.getZip();
		phone = location.getPhone();
		model = new ModelLocation();
		
		for(Model model : location.getModel()) {
			models.add(model.getName());
		}
	}
	@Data
	@NoArgsConstructor
	public static class ModelLocation {
		private Long modelId;
		private String Name;
		
		
		
		public ModelLocation(Model model) {
			modelId = model.getModelId();
			Name = model.getName();
			
			
		}
	
		
		@Data
		@NoArgsConstructor
		public class ModelData {
				private Long modelId;
				private String name;
				private Set<LocationResponse> locations = new HashSet<>();
				
				
			public ModelData(Model model) {
				modelId = model.getModelId();
				name = model.getName();
				
				
				for(Location location : model.getLocations()) {
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
					private Set<String> models = new HashSet<>();
					
					LocationResponse(Location location) {
						locationId = location.getLocationId();
						businessName = location.getBusinessName();
						address = location.getAddress();
						city = location.getCity();
						state = location.getState();
						zip = location.getZip();
						phone = location.getPhone();
						
						
						
						for(Model model: location.getModel()) {
							models.add(model.getName());
							
						}
					}
					
				}

				}

	}
}
	
