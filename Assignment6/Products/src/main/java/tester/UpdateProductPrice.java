package tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.ProductDaoImpl;
import utils.HibernateUtils;

public class UpdateProductPrice {
	public static void main(String[] args) {
		try (SessionFactory sf = HibernateUtils.getFactory()) {

			ProductDaoImpl pdo = new ProductDaoImpl();
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter Product name| Enter New Price");

			System.out.println(pdo.changeProductPrice(sc.next(), sc.nextDouble()));

		}
	}

}
