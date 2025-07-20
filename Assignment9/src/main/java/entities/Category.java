package entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "category")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true, exclude = "products")

public class Category extends BaseEntity {
//	id : Long - PK
//	 - creation date
//	 - updation time stamp
//	 - name (unique) - varchar(50)
//	 - description - varchar(255)

	@Column(length = 50, unique = true)
	private String name;

	private String description;

	@OneToMany(mappedBy = "proCategory", cascade = CascadeType.ALL)
	private List<Product> products = new ArrayList<>();

	public Category(String name, String description) {
		super();
		this.name = name;
		this.description = description;

	}
	
	public void addProduct(Product product) {
		this.products.add(product);
		product.setProCategory(this);
		
	}
	
	public void deleteProduct(Product product) {
		this.products.remove(product);
		product.setProCategory(null);
	}
	

}
