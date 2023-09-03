package car.dealership.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import car.dealership.entity.Location;

public interface LocationDao extends JpaRepository<Location, Long> {
	
	
	Set<Location> findAllByLoctionId(Set<String> location);
}
