package car.dealership.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long carId;
	
	@EqualsAndHashCode.Exclude
	private String name;
	
	@EqualsAndHashCode.Exclude
	private int manufaturedYear;
	
	@EqualsAndHashCode.Exclude
	private String color;
	
	@EqualsAndHashCode.Exclude
	private String address;
	

	@ToString.Exclude	
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "models", cascade = CascadeType.ALL)
	private Set<Model> models = new HashSet<>();

@EqualsAndHashCode.Exclude
@ToString.Exclude
@ManyToMany(mappedBy = "cars")
	private Set<Location> locations = new HashSet<>();
	}
