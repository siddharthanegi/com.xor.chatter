package com.xor.chatter.controller;

import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpSession;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xor.chatter.form.User;
import com.xor.chatter.service.UserService;

@Controller
public class NavController {

	@Autowired private UserService userService;
	
	@RequestMapping(value="/")
	public String welcome(Model model){
		
		return "Login";
	}
	

	@RequestMapping(value="Registration")
	public String registerNewUser(@ModelAttribute("user")User user, BindingResult rs){
		
		System.out.println(user.getFirstName()+" "+user.getPassword());
		Integer id=userService.createUser(user);
		return "index";
	}
	
	@RequestMapping(value="Authorization")
	public String credentialCheck(HttpSession session,@RequestParam("username")String username, @RequestParam("password")String password,Model model){
		
		User user=userService.getUserByUsernameAndPassword(username, password);
		if(user==null){
			System.out.println("Doesn't Exist");
			return "index";
		}
		else{
			session.setAttribute("user", user);
			model.addAttribute("friend",new User());
			System.out.println(user.getFirstName());
			return "UserPage";
		}
			
	}
	@RequestMapping(value="StartChat")
	public @ResponseBody String initChat(HttpSession session,@RequestParam("uid")Integer uid){
		
		User currentUser=(User) session.getAttribute("user");
		User friend=userService.getUserByID(uid);
		System.out.println("User:"+currentUser.getFirstName()+" Friend: "+friend.getFirstName());
		session.setAttribute("friend", friend);
		return "yo";
	}

	@RequestMapping(value="redirect")
	public String redirectToChat(){
		return "Message";
	}
	
	@RequestMapping(value="AddFriend")
	public String addFriend(){
		
		User friend=userService.getUserByID(3);
		System.out.println(friend.getFirstName());
		userService.addFriend(1, friend);
		return "index";
	}
	
	@RequestMapping(value="test")
	public String test(){
		
		User user1=userService.getUserByID(1);
		User user2=userService.getUserByID(2);
		
		Set<User> friends1=user1.getFriends();
		Set<User> friends2=user2.getFriends();
		
		Iterator<User> it=friends1.iterator();
		Iterator<User> it2=friends2.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next().getFirstName());
		}
		while(it2.hasNext()){
			System.out.println(it2.next().getFirstName());
		}
		return "index";
		
	}
}
