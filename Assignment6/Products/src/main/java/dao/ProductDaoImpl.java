package dao;

import java.nio.channels.SeekableByteChannel;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.*;

import entities.Category;
import entities.Product;
import utils.HibernateUtils;

public class ProductDaoImpl implements ProductDao {

	@Override
	public String addProduct(Product product) {
		String message = "Product Added successfully.....";

		Session session = utils.HibernateUtils.getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {

			session.persist(product);

			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();

			throw e;
		}
		return message;
	}
//============Get All Products==========================
	@Override
	public List<Product> getAllProductDetails() {
		List<Product>productslList=null;
		
		String jpql = "select p from Product p";
		
		Session session = HibernateUtils.getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			productslList= session.createQuery(jpql,Product.class).getResultList();
			
			tx.commit();
		}catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
			// TODO: handle exception
		}
		return productslList;
	}
	
	//===============Get Product By Category nad Manufacture date=================
	@Override
	public List<Product> getProductByMdateAndCategory(LocalDate date, Category category) {
		List<Product>prodtslList=null;
		
//		String jpql ="select p.id,p.name,p.price from Product p where p.mdate<:date and p.category=:category";
		String jpql = "select new entities.Product(p.id,p.name,p.price) from Product p where p.mDate<:date and p.category=:category ";
		Session session = HibernateUtils.getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
			prodtslList= session.createQuery(jpql ,Product.class).setParameter("date", date).setParameter("category", category).getResultList();
			tx.commit();
//			System.out.println(prodtslList.toString());
		}catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
			// TODO: handle exception
		}
		return prodtslList;
	}
	
	//============Change Product Price By Name==============
	
	@Override
	public String changeProductPrice(String name, double newPrice) {
		String msg="Price Update Failed....!";
		String jpql = "update Product p set p.price=:newPrice where p.name=:name";
		
		Session session = HibernateUtils.getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			
			int cnt = session.createMutationQuery(jpql).setParameter("newPrice", newPrice).setParameter("name", name).executeUpdate();
			System.out.println(cnt);
			tx.commit();
			
			msg="Price Update Successfully";
			
		}catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
			// TODO: handle exception
		}
		return msg;
	}

}
