package group.G; 

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Repository
@EnableTransactionManagement
public class UserDaoImpl implements AbstractDao {

	/*
	void save(UserModel t);
	void update(UserModel t);
	void delete(UserModel t);
	UserModel findById(String t);
	*/

	private SessionFactory sessionFactory;

	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void save(UserModel t) {
		this.sessionFactory.getCurrentSession().save(t);
	}

}