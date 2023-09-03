package car.dealership.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import car.dealership.entity.Car;

public interface CarDao extends JpaRepository<Car, Long> {

	Set<Car> findAllByModelId(Set<String> cars);
}
