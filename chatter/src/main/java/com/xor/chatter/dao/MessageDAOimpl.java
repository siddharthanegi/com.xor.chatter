package com.xor.chatter.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xor.chatter.form.Message;
@Repository
public class MessageDAOimpl implements MessageDAO {
	
	@Autowired private SessionFactory sessionFactory;
	public Integer createMessage(Message message) {
		// TODO Auto-generated method stub
		
		return (Integer) sessionFactory.getCurrentSession().save(message);
	}

	@SuppressWarnings("unchecked")
	public List<Message> getMessagesBySenderAndReceiverID(Integer senderID,
			Integer receiverID) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Message.class).add(Restrictions.eq("senderID", senderID)).add(Restrictions.eq("receiverID",receiverID)).list();
	}

	public Message getMessageByMessageID(Integer msgID) {
		// TODO Auto-generated method stub
		return (Message) sessionFactory.getCurrentSession().createCriteria(Message.class).add(Restrictions.eq("msgID", msgID)).uniqueResult();
	}

	public List<Message> getMessageBetweenDate(Date fromDate, Date toDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Message> getMessagesBySenderID(Integer senderID) {
		// TODO Auto-generated method stub
		return  sessionFactory.getCurrentSession().createCriteria(Message.class).add(Restrictions.eq("senderID", senderID)).list();
	}

	@SuppressWarnings("unchecked")
	public List<Message> getMessagesByReceiverID(Integer receiverID) {
		// TODO Auto-generated method stub
		return  sessionFactory.getCurrentSession().createCriteria(Message.class).add(Restrictions.eq("receiverID", receiverID)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> getMessageBetweenUsers(Integer uid_1, Integer uid_2) {
		// TODO Auto-generated method stub
		Integer[] array=new Integer[]{uid_1,uid_2};
		
		List<Message> allmsgs=sessionFactory.getCurrentSession().createCriteria(Message.class).add(Restrictions.in("senderID",array)).add(Restrictions.in("receiverID", array)).addOrder(Order.desc("msgDate")).list();
		return allmsgs;
	}

}
