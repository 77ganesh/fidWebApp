package group.G; 

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Repository
@EnableTransactionManagement
public class UserDaoImpl implements AbstractDao {
	// TODO - autocommit/flush config
	// to prevent too many jdbc connections

	private SessionFactory sessionFactory;

	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void save(UserModel t) {
		this.sessionFactory.getCurrentSession().save(t);
	}

	@Transactional
	public void update(UserModel t) {
		this.sessionFactory.getCurrentSession().update(t);
	}

	@Transactional
	public void delete(UserModel t) {
		this.sessionFactory.getCurrentSession().delete(t);
	}

	@Transactional
	public UserModel findById(String id) {
		// TODO - change get() to load()
		UserModel t = this.sessionFactory.getCurrentSession().get(UserModel.class, id);
		return t;
	}

}