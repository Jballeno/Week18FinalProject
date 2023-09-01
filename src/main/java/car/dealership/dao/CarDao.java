package car.dealership.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import car.dealership.entity.Car;

public interface CarDao extends JpaRepository<Car, Long> {


	Optional<Car> findByCarName(String name);
}
