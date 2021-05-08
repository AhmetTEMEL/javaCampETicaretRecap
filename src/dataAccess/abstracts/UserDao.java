package dataAccess.abstracts;

import entities.concretes.User;

public interface UserDao {

	void signIn(User user);
}
