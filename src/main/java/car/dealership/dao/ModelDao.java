package car.dealership.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import car.dealership.entity.Model;

public interface ModelDao extends JpaRepository<Model, String> {

	

	Optional<Model> findModelById(String models);
	
	//error occurring in ModelDao but unable to fix error

}
