package com.xor.chatter.service;

import java.util.Date;
import java.util.List;

import com.xor.chatter.form.Message;

public interface MessageService {

	public Integer createMessage(Message message);
	public List<Message> getMessagesBySenderAndReceiverID(Integer senderID,Integer receiverID);
	public Message getMessageByMessageID(Integer msgID);
	public List<Message> getMessageBetweenDate(Date fromDate,Date toDate);
	public List<Message> getMessagesBySenderID(Integer senderID);
	public List<Message> getMessagesByReceiverID(Integer receiverID);
	public List<Message> getMessageBetweenUsers(Integer uid_1,Integer uid_2);
}
