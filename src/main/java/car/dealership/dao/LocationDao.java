package car.dealership.dao;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import car.dealership.entity.Location;

public interface LocationDao extends JpaRepository<Location, Long> {
	
	
	Optional<Location> findByAddress(String locationAddress);
}
