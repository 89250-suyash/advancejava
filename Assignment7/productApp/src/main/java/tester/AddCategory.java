package tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CategoryDaoImpl;
import entities.Category;
import utils.HibernateUtils;

public class AddCategory {
	public static void main(String[] args) {
		try(SessionFactory sf = HibernateUtils.getFactory()){
			Scanner sc = new Scanner(System.in);
			
			CategoryDaoImpl cdo = new CategoryDaoImpl();
			System.out.println("Enter Category Name |"
					+ "Enter Category Description");
			Category category= new Category(sc.next(),sc.next());
			
			System.out.println(cdo.addCategory(category));
		}
	}

}
