package com.sophos.Agenda_citas_laboratorio.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AFFILIATES")
public class Affiliate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "ID")
	private Integer id;
	//@Column(name = "NAME")
	private String name;
	//@Column(name = "AGE")
	private Integer age;
	//@Column(name = "MAIL")
	private String mail;
	
	


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
