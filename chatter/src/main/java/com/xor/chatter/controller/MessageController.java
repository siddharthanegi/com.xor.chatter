package com.xor.chatter.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.xor.chatter.form.Message;
import com.xor.chatter.form.User;
import com.xor.chatter.service.MessageService;

@Controller
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	
	@RequestMapping(value="Message", method=RequestMethod.POST)
	public @ResponseBody String sendMessage(@RequestParam("msg")String message,HttpSession session){
		
		Message sendMsg=new Message();
		//System.out.println(message);
		User loggedUser=(User) session.getAttribute("user");
		User friend=(User)session.getAttribute("friend");
		Date currentDate=new Date();
		sendMsg.setMessage(message);
		sendMsg.setSenderID(loggedUser.getUid());
		sendMsg.setSenderName(loggedUser.getFirstName());
		sendMsg.setReceiverName(friend.getFirstName());
		sendMsg.setReceiverID(friend.getUid());
		sendMsg.setMsgDate(currentDate);
		messageService.createMessage(sendMsg);
		return "3";
	}
	
	@RequestMapping(value="PreviousConvo")
	public @ResponseBody String getConvo(HttpSession session){
		
		User loggedUser=(User) session.getAttribute("user");
		User friend=(User)session.getAttribute("friend");
		List<Message> conversation=messageService.getMessageBetweenUsers(loggedUser.getUid(),friend.getUid());
		Gson gson=new Gson();
		System.out.println(gson.toJson(conversation));
		return gson.toJson(conversation);
	}
		
}
