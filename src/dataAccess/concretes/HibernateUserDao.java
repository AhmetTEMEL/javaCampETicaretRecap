package dataAccess.concretes;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class HibernateUserDao implements UserDao{

	@Override
	public void signIn(User user) {

		System.out.println("Successfully signed in :"+user.getFirstName());
	}

}
