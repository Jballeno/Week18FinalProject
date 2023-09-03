package car.dealership.service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import car.dealership.controller.model.LocationData;
import car.dealership.controller.model.LocationData.ModelLocation.ModelData;
import car.dealership.dao.CarDao;
import car.dealership.dao.LocationDao;
import car.dealership.dao.ModelDao;
import car.dealership.entity.Car;
import car.dealership.entity.Location;
import car.dealership.entity.Model;

@Service
public class DealershipSevice {
	@Autowired
	private ModelDao modelDao;

	@Autowired
	private CarDao carDao;

	@Autowired
	private LocationDao locationDao;

	@Transactional(readOnly = false)
	public ModelData savemodel(ModelData modelData) {
		Long modelId = modelData.getModelId();
		Model model = findOrCreateModel(modelId, modelData.getName());

		setFieldsModel(model, modelData);
		return new ModelData(modelDao.save(model));
	}

	private void setFieldsModel(Model model, ModelData modelData) {
		model.setName(modelData.getName());
		model.setModelId(modelData.getModelId());
	}

	private Model findOrCreateModel(Long modelId, String name) {
		Model model;

		if (Objects.isNull(modelId)) {
			Optional<Model> opModel = modelDao.findModelById(name);

			if (opModel.isPresent()) {
				throw new DuplicateKeyException("Car with name " + name + " already exsits");
			}

			model = new Model();
		} else {
			model = findModelById(modelId);
		}
		return model;
	}

	private Model findModelById(Long modelId) {
		return modelDao.findById(modelId)
				.orElseThrow(() -> new NoSuchElementException("model with ID=" + modelId + "was not found."));
	}

	@Transactional(readOnly = true)
	public List<ModelData> retrieveAllModels() {
		List<Model> models = modelDao.findAll();
		List<ModelData> response = new LinkedList<>();

		for (Model model : models) {
			response.add(new ModelData(model));
			
			///No enclosing instance of type LocationData.ModelLocation is accessible
		}
		return response;
	}

	@Transactional(readOnly = true)
	public ModelData retrieveModelById(Long carId) {
		Model model = findModelById(carId);
		return new ModelData(model);
	}

	@Transactional(readOnly = false)
	public void deleteModelById(Long carId) {
		Model model = findModelById(carId);
		modelDao.delete(model);

	}
@Transactional(readOnly = false)
	public LocationData saveLocation(Long modelId, 
			LocationData locationData) {
	Model model = findModelById(modelId);
	
	Set<Car> cars = carDao.findAllByModelId(locationData.getModels());
	
	Location location = findOrCreateLocation(locationData.getLocationId());
	setLocationFields(location, locationData);
	
		model.getLocations().add(location);
	
	for(Car car : cars) {
		car.getModels().add(model);
		location.getModel().add(model);
	}
		Location dbLocation = locationDao.save(location);
		return new LocationData(dbLocation);
	}

	private void setLocationFields(Location location, LocationData locationData) {
		location.setBusinessName(locationData.getBusinessName());
		location.setAddress(locationData.getAddress());
		location.setCity(locationData.getCity());
		location.setState(locationData.getState());
		location.setZip(locationData.getZip());
		location.setPhone(locationData.getPhone());
		
	}

	private Location findOrCreateLocation(Long locationId) {
		Location location;
		
		if(Objects.isNull(locationId)) {
			location = new Location();
		}
		else {
			location = findLocationById(locationId);
		}
		return location;
	}
	
	private Location findLocationById(Long locationId) {
		return locationDao.findById(locationId).orElseThrow(() -> new NoSuchElementException("Location with ID=" + locationId + " does not exsist."));
	}


	@Transactional(readOnly = true)
	public LocationData retrieveLocationById(Long modelId, Long locationId) {
		findModelById(modelId);
		Location location = findLocationById(locationId);

		if(location.getLocationId() != modelId) {
			throw new IllegalStateException(
					"Location with ID=" + modelId + " is not associated with model ID..." + modelId);
		}
		return new LocationData(location);
	}

	
}