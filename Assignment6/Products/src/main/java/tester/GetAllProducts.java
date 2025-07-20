package tester;

import org.hibernate.SessionFactory;

import dao.ProductDaoImpl;
import utils.HibernateUtils;

public class GetAllProducts {
	public static void main(String[] args) {
		try (SessionFactory sf = HibernateUtils.getFactory()) {
			ProductDaoImpl pdo = new ProductDaoImpl();

			pdo.getAllProductDetails().forEach(p -> System.out.println(p));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
