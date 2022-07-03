package com.sophos.Agenda_citas_laboratorio.dto;

import java.util.Date;

public class JoinDto {

	private Integer id_affiliate;
	private String name_affiliate;
	private Integer age;
	private String mail;
	private Integer id_appoinment;
	private Date date;
	private String hour;
	private String name_test;

	public JoinDto(Integer id_affiliate, String name_affiliate, Integer age, String mail, Integer id_appoinment,
			Date date, String hour, String name_test) {

		this.id_affiliate = id_affiliate;
		this.name_affiliate = name_affiliate;
		this.age = age;
		this.mail = mail;
		this.id_appoinment = id_appoinment;
		this.date = date;
		this.hour = hour;
		this.name_test = name_test;
	}

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

	public String getName_test() {
		return name_test;
	}

	public void setName_test(String name_test) {
		this.name_test = name_test;
	}

}
