package com.xor.chatter.form;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="Message_DB")
public class Message {

	@Id
	@GeneratedValue
	@Column(name="msg_ID")
	private Integer msgID;
	
	@Column(name="sender_ID" , nullable=false)
	private Integer senderID;
	
	@Column(name="senderName")
	private String senderName;
	
	@Column(name="receiverName")
	private String receiverName;
	
	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	@Column(name="receiver_ID", nullable=false)
	private Integer receiverID;
	
	@Column(name="message")
	private String message;
	
	@Column(name="msg_date")
	private Date msgDate;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getMsgID() {
		return msgID;
	}

	public void setMsgID(Integer msgID) {
		this.msgID = msgID;
	}

	public Integer getSenderID() {
		return senderID;
	}

	public void setSenderID(Integer senderID) {
		this.senderID = senderID;
	}

	public Integer getReceiverID() {
		return receiverID;
	}

	public void setReceiverID(Integer receiverID) {
		this.receiverID = receiverID;
	}

	public Date getMsgDate() {
		return msgDate;
	}

	public void setMsgDate(Date msgDate) {
		this.msgDate = msgDate;
	}
}
