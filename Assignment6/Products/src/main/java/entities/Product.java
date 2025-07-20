package entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue
	(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name" ,length = 20 , unique = true)
	private String name;
	
	@Column(length = 300)
	private String description;
	
	
	private LocalDate mDate;
	
	private double price;
	private int quantity;
	@Enumerated(EnumType.STRING)
	private Category category;
	public Product() {
		super();
	}
	public Product( String name, String description, LocalDate mDate, double price, int quantity,
			Category category) {
		super();
		
		this.name = name;
		this.description = description;
		this.mDate = mDate;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}
	
	
	public Product(long id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getmDate() {
		return mDate;
	}
	public void setmDate(LocalDate mDate) {
		this.mDate = mDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", mDate=" + mDate + ", price="
				+ price + ", quantity=" + quantity + ", category=" + category + "]";
	}
	
	

}
