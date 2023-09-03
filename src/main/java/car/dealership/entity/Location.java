package car.dealership.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long locationId;

	private String businessName;
	private String Address;
	private String city;
	private String state;
	private String zip;
	private String phone;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(mappedBy = "locations")
	private Set<Model> model = new HashSet<>();

//	@EqualsAndHashCode.Exclude
//	@ToString.Exclude
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "model_id", nullable = false)
//	private Model model;
//
//	@EqualsAndHashCode.Exclude
//	@ToString.Exclude
//	@ManyToMany(cascade = CascadeType.PERSIST)
//	@JoinTable(name = "car_location", joinColumns = @JoinColumn(name = "car_id"), inverseJoinColumns = @JoinColumn(name = "location_id"))
//	private Set<Car> cars = new HashSet<>();
}
