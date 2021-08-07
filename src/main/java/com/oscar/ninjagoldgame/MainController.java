package com.oscar.ninjagoldgame;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@RequestMapping("/Gold")
	public String gold(HttpSession session, Model model) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		if(session.getAttribute("activities") == null) {
			ArrayList<Activity> list = new ArrayList<Activity>();
			session.setAttribute("activities", list);
		}
		if((Integer)session.getAttribute("gold") < -100) {
			return "prison.jsp";
		}
		model.addAttribute("gold", session.getAttribute("gold"));
		model.addAttribute("activities", session.getAttribute("activities"));
		return "gold.jsp";
	}
	
	@RequestMapping(value = "/place", method=RequestMethod.POST)
	public String place(HttpSession session, @RequestParam(value="location") String location) {
		if(session.getAttribute("gold") == null || location == null || location.equals("")
				|| session.getAttribute("activities") == null) {
			return "redirect:/Gold";
		}
		
		Random rand = new Random();
		ArrayList<Activity> list = (ArrayList<Activity>)session.getAttribute("activities");
		
		if(location.equals("farm")) {
			int amount = rand.nextInt(11) + 10;
			Date date = Calendar.getInstance().getTime();
			Activity activity = new Activity(amount, "Farm", date);
			session.setAttribute("gold", (Integer) session.getAttribute("gold") 
					+ amount);
			list.add(0, activity);
			session.setAttribute("activities", list);
			
		}
		else if(location.equals("cave")) {
			int amount = rand.nextInt(6) + 5;
			Date date = Calendar.getInstance().getTime();
			Activity activity = new Activity(amount, "Cave", date);
			session.setAttribute("gold", (Integer) session.getAttribute("gold") 
					+ amount);
			list.add(0, activity);
			session.setAttribute("activities", list);
		}
		else if(location.equals("house")) {
			int amount = rand.nextInt(4) + 2;
			Date date = Calendar.getInstance().getTime();
			Activity activity = new Activity(amount, "House", date);
			session.setAttribute("gold", (Integer) session.getAttribute("gold") 
					+ amount);
			list.add(0, activity);
			session.setAttribute("activities", list);
		}
		else if(location.equals("casino")) {
			//track gain/loss
			int amount = rand.nextInt(51);
			boolean gain = rand.nextInt(2) == 1;
			if (gain) {
				amount *= -1;
			}
			Date date = Calendar.getInstance().getTime();
			Activity activity = new Activity(amount, "Casino", date);
			session.setAttribute("gold", (Integer) session.getAttribute("gold") 
					+ amount);
			list.add(0, activity);
			session.setAttribute("activities", list);
		} 
		else if(location.equals("spa")) {
			int amount = (rand.nextInt(16) + 5) * -1;
			Date date = Calendar.getInstance().getTime();
			Activity activity = new Activity(amount, "Spa", date);
			session.setAttribute("gold", (Integer) session.getAttribute("gold") 
					+ amount);
			list.add(0, activity);
			session.setAttribute("activities", list);
		} 
		else if(location.equals("reset")) {
			session.setAttribute("gold", 0);
			session.removeAttribute("activities");
		}
		return "redirect:/Gold";
	}
	
	
}
