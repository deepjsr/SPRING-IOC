package com.jsp.dto;

import org.springframework.stereotype.Component;

@Component
public class Branch {
private int id;
private String address;
private long phone;
private String web;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getweb() {
	return web;
}
public void setweb(String web) {
	this.web = web;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}

}
