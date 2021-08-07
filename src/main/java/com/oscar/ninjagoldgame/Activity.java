package com.oscar.ninjagoldgame;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Activity {
	private int gold;
	private String location;
	private String date;
	
	public Activity() {
		this(0, "", Calendar.getInstance().getTime());
	}
	public Activity(int gold, String location, Date date) {
		setGold(gold);
		setLocation(location);
		
		String formattedDate = convertDate(date);
		setDate(formattedDate);
	}
	
	public String convertDate(Date date) {
		DateFormat daynumf = new SimpleDateFormat("dd");
		DateFormat monthf = new SimpleDateFormat("MMMM");
		DateFormat yearf = new SimpleDateFormat("yyyy");
		DateFormat tdf = new SimpleDateFormat("hh:mm aa");
		String dayNum = daynumf.format(date);
		String month = monthf.format(date);
		String year = yearf.format(date);
		String time = tdf.format(date);
		
		int num = Integer.parseInt(dayNum);
		
		if(num == 1 || num == 21 || num == 31) {
			dayNum += "st";
		} else if (num == 2 || num == 22) {
			dayNum += "nd";
		} else if (num == 3 || num == 23) {
			dayNum += "rd";
		} else {
			dayNum += "th";
		}
		
		return String.format("%s %s %s %s", month, dayNum, year, time);
	}
	
	//Getters & Setters
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
