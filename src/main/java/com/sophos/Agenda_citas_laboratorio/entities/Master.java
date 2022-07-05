package com.sophos.Agenda_citas_laboratorio.entities;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name =  "masters")
public class Master {
	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_affiliate")
	private Integer id_affiliate;
	
	
	@Column(name = "name_affiliate")
	private String name_affiliate;
	
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "mail")
	private String mail;
	
	@Id
	@Column(name = "id_appoinment")
	private Integer id_appoinment;
	
	@Column(name = "date_appoinment")
	private Date date;
	
	@Column(name = "hour")
	private String hour;
	
	@Column(name = "test_name")
	private String test_name;
	
	
		
	public Integer getId_affiliate() {
		return id_affiliate;
	}
	public void setId_affiliate(Integer id_affiliate) {
		this.id_affiliate = id_affiliate;
	}
	public String getName_affiliate() {
		return name_affiliate;
	}
	public void setName_affiliate(String name_affiliate) {
		this.name_affiliate = name_affiliate;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Integer getId_appoinment() {
		return id_appoinment;
	}
	public void setId_appoinment(Integer id_appoinment) {
		this.id_appoinment = id_appoinment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public String getTest_name() {
		return test_name;
	}
	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}
	
	
	
	
	
	

}
