package car.dealership.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import car.dealership.entity.Model;

public interface ModelDao extends JpaRepository<Model, Long> {

	Set<Model> findAllByModelId(Set<String> string);

}
