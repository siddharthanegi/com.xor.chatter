package com.xor.chatter.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xor.chatter.dao.MessageDAO;
import com.xor.chatter.form.Message;
@Service
@Transactional
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDAO messageDAO;
	@Override
	public Integer createMessage(Message message) {
		// TODO Auto-generated method stub
		return messageDAO.createMessage(message);
	}

	@Override
	public List<Message> getMessagesBySenderAndReceiverID(Integer senderID,
			Integer receiverID) {
		// TODO Auto-generated method stub
		return messageDAO.getMessagesBySenderAndReceiverID(senderID, receiverID);
	}

	@Override
	public Message getMessageByMessageID(Integer msgID) {
		// TODO Auto-generated method stub
		return messageDAO.getMessageByMessageID(msgID);
	}

	@Override
	public List<Message> getMessageBetweenDate(Date fromDate, Date toDate) {
		// TODO Auto-generated method stub
		return messageDAO.getMessageBetweenDate(fromDate, toDate);
	}

	@Override
	public List<Message> getMessagesBySenderID(Integer senderID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getMessagesByReceiverID(Integer receiverID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getMessageBetweenUsers(Integer uid_1, Integer uid_2) {
		// TODO Auto-generated method stub
		return messageDAO.getMessageBetweenUsers(uid_1, uid_2);
	}

}
