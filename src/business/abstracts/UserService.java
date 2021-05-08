package business.abstracts;

import java.util.List;

import entities.concretes.User;

public interface UserService {

	void signIn(User user);
	void logIn(User user);
	List<User> getAll();
}
