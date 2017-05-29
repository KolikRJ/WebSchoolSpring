package ru.work.web.object;

public class Student {
	
	private int id;
	private String lastname;
	private String firstname;
	private String phone;
	private String dateofbirth;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firsname) {
		this.firstname = firsname;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getDateofbirth() {
		return dateofbirth;
	}
	
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	
	@Override
	public String toString() {
		return id + " " + firstname + " " + lastname + " " + phone + " " + dateofbirth.toString();
	}
}
