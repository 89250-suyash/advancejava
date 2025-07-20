package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Category;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public String addCategory(Category newCategory) {
		String msg = "Category Added Failed...!";

		Session session = utils.HibernateUtils.getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();
		try {
			session.persist(newCategory);
			tx.commit();
			msg = "Category Added Successfully";

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
			// TODO: handle exception
		}
		return msg;
	}

}
