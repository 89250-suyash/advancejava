package tester;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.ProductDaoImpl;
import entities.Category;
import entities.Product;
import utils.HibernateUtils;

public class GetProductByMdateAndCategory {
	public static void main(String[] args) {
		try (SessionFactory sf = HibernateUtils.getFactory()) {
			Scanner sc = new Scanner(System.in);
		
			ProductDaoImpl pdo = new ProductDaoImpl();
			System.out.println("Enter Manufacture date And category");
			pdo.getProductByMdateAndCategory(LocalDate.parse(sc.next()), Category.valueOf(sc.next().toUpperCase()))
					.forEach(p -> System.out.println(p.getId()+" "+p.getName()+" "+p.getPrice()));
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
