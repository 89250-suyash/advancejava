package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Category;
import entities.Product;

public class ProductDaoImpl implements ProductDao {

	

	@Override
	public String addProductsToCategory(Long categoryId, List<Product> products) {
		String msg = "Add Products into category Failed....!";
		
		Session session = utils.HibernateUtils.getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
			
			Category category = session.get(Category.class, categoryId);
			if(category!=null) {
				products.forEach(p->category.addProduct(p));
				msg = "Add Products into category Successfully";
			}
			tx.commit();
			
		}catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
			// TODO: handle exception
		}
		return null;
	}

	

}
