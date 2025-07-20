package tester;


import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.ProductDaoImpl;
import entities.Category;
import entities.Product;
import utils.HibernateUtils;

public class AddProduct {
	
//	Typical product details -
//	product id : Long (auto increment)
//	name : string (unique) : varchar(20)
//	product description : string : varchar(300)
//	manufacture date : LocalDate
//	price : double
//	available quantity : int
//	category : enum (STATIONARY,SHOES,GRAINS,OIL...)
	
	public static void main(String[] args) {
		try(SessionFactory sf = HibernateUtils.getFactory()){
			Scanner sc = new Scanner(System.in);
			
			ProductDaoImpl pdo = new ProductDaoImpl();
			
			System.out.println("Enter Product Name | "
					+ "Enter Product Description |"
					+ "Enter Product Manufacture Date |"
					+ "Enter product Price |"
					+ "Enter Product Quality |"
					+ "Enter Product Category (STATIONARY,SHOES,GRAINS,OIL,MILK) ");
			Product newProduct = new Product(sc.next(),
					sc.next(),
					LocalDate.parse(sc.next()),
					sc.nextDouble(),
					sc.nextInt(),
					Category.valueOf(sc.next().toUpperCase())
					);
			System.out.println(pdo.addProduct(newProduct));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
