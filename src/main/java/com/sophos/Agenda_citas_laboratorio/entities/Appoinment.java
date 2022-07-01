package com.sophos.Agenda_citas_laboratorio.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APPOINMENTS")
public class Appoinment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "DATE_APPOINMENT")
	private Date date;
	@Column(name = "HOUR")
	private Date hour;
	@Column(name = "ID_TEST")
	private Integer id_test;
	@Column(name = "ID_AFFILIATE")
	private Integer id_affiliate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getHour() {
		return hour;
	}

	public void setHour(Date hour) {
		this.hour = hour;
	}

	public Integer getId_test() {
		return id_test;
	}

	public void setId_test(Integer id_test) {
		this.id_test = id_test;
	}

	public Integer getId_affiliate() {
		return id_affiliate;
	}

	public void setId_affiliate(Integer id_affiliate) {
		this.id_affiliate = id_affiliate;
	}

}
