package dao;

import java.util.List;

import entities.Product;

public interface ProductDao {
	

	String addProductsToCategory(Long categoryId, List<Product> products);

}
