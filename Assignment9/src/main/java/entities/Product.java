package entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "products",uniqueConstraints = @UniqueConstraint(columnNames = {"name","category_id"}))
@NoArgsConstructor
@Getter
@Setter


public class Product extends BaseEntity {
	
	
	@Column(name = "name" ,length = 20 , unique = true )
	private String name;
	
	@Column(length = 300)
	private String description;
	
	
	private LocalDate mDate;
	
	private double price;
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category proCategory;

	public Product( String name, String description, LocalDate mDate, double price, int quantity) {
		super();
		
		this.name = name;
		this.description = description;
		this.mDate = mDate;
		this.price = price;
		this.quantity = quantity;
		
	}
	
	
	
	

}
