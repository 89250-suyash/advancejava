package tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.ProductDao;
import dao.ProductDaoImpl;
import entities.Product;
import utils.HibernateUtils;

public class AddMultipleProductsToCategory {
	public static void main(String[] args) {
		try (SessionFactory sf = HibernateUtils.getFactory()) {
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter Category Id ");
			Long cId = sc.nextLong();

			ProductDao pdo = new ProductDaoImpl();

			List<Product> plList = new ArrayList<>();

			System.out.println("How Many Product Do You Wand To Add ?");
			int productCount = sc.nextInt();
//			 String name, String description, LocalDate mDate, double price, int quantity
			while (productCount > 0) {
				System.out.println(
						"Enter Product Name |" + "Descripption |" + "Manufacturing date |" + "Price |" + "Quantity ");
				Product product = new Product(sc.next(), sc.next(), LocalDate.parse(sc.next()), sc.nextDouble(),
						sc.nextInt());
				plList.add(product);

				productCount--;
			}

			System.out.println(pdo.addProductsToCategory(cId, plList));

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
