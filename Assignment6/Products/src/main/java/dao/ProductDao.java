package dao;



import java.time.LocalDate;
import java.util.List;

import entities.Category;
import entities.Product;

public interface ProductDao {
	String addProduct(Product product);
	
	
	List<Product> getAllProductDetails();
	
	List<Product>getProductByMdateAndCategory(LocalDate date , Category category);
	
	String changeProductPrice(String name, double newPrice );

}
