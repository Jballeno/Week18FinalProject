package car.dealership.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Entity
@Data
public class Model {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long modelId;
	
	private String name;
	
	
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "model_Id", nullable = false)
	private Car car;
	

	
}
