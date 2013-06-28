package com.xor.chatter.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xor.chatter.form.User;
@Repository
public class UserDAOimpl implements UserDAO {
	
	@Autowired private SessionFactory sessionFactory;
	public Integer createUser(User user) {
		// TODO Auto-generated method stub
		return (Integer) sessionFactory.getCurrentSession().save(user);
	}
	public void addFriend(Integer uid, User friend) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.openSession();
		User user= (User) session.load(User.class, uid);
		Transaction tx=session.beginTransaction();
		user.getFriends().add(friend);
		user.getFriendOf().add(friend);
		tx.commit();
		session.close();
		
		
	}
	public User getUserByID(Integer uid) {
		// TODO Auto-generated method stub
		return (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("uid", uid)).uniqueResult();
	}
	public User getUserByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("username", username)).add(Restrictions.eq("password", password)).uniqueResult();
	}

}
