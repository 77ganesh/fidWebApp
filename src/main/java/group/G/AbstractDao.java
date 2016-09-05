package group.G; 

public interface AbstractDao {

	public void save(UserModel t);
	void update(UserModel t);
	void delete(UserModel t);
	UserModel findById(String t);
}