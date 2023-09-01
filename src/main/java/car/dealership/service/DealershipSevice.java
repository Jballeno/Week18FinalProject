package car.dealership.service;


import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import car.dealership.controller.model.LocationData;
import car.dealership.controller.model.LocationData.LocationCar.CarData;
import car.dealership.dao.CarDao;
import car.dealership.dao.LocationDao;
import car.dealership.dao.ModelDao;
import car.dealership.entity.Car;
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
	public CarData savecar(CarData carData) {
		Long carId = carData.getCarId();
		Car car = findOrCreateCar(carId, carData.getCarName());
		
		setFieldsCar(car, carData);
		return new CarData(carDao.save(car));
	}
	
	private void setFieldsCar(Car car, CarData carData) {
		car.setName(carData.getCarName());
		car.setCarId(carData.getCarId());
	}



	private Car findOrCreateCar(Long carId, String name) {
	Car car;
	
	if(Objects.isNull(carId)) {
		Optional<Car> opCar = carDao.findByCarName(name);
		
		if(opCar.isPresent()) {
			throw new DuplicateKeyException(
					"Car with name " + name + " already exsits");
		}
		
		car = new Car();
	} else {
		car = findCarById(carId);
	}
		return car;
	}

	private Car findCarById(Long carId) {
	return carDao.findById(carId).orElseThrow(
			() -> new NoSuchElementException("Car with ID=" + carId + "was not found"));
	}
	@Transactional(readOnly = true)
	public List<CarData> retrieveAllCars() {
		List<Car> cars = carDao.findAll();
		List<CarData> response = new LinkedList<>();
		
		for(Car car : cars) {
			response.add(new CarData(car));
		}
		return response;
	}


	



	public CarData retrieveCarById(Long carId) {
		// TODO Auto-generated method stub
		return null;
	}



	public void deletecarById(Long carId) {
		// TODO Auto-generated method stub
		
	}



	public LocationData saveLocation(Long carId, LocationData locationData) {
		// TODO Auto-generated method stub
		return null;
	}



	public LocationData retrieveLocationById(Long carId, Long locationId) {
		// TODO Auto-generated method stub
		return null;
	}

	


}