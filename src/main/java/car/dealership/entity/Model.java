package car.dealership.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long modelId;

	private String name;

	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "car_id", nullable = false)
	private Car car;

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "model_location", 
	joinColumns = @JoinColumn( name = "model_id"),
	inverseJoinColumns = @JoinColumn(name = "location_id"))
	private Set<Location> locations = new HashSet<>();
}
