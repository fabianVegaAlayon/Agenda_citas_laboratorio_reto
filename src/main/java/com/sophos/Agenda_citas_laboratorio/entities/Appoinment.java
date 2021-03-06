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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "DATE_APPOINMENT")
	private Date date;
	@Column(name = "HOUR")
	private String hour;
	@Column(name = "ID_TEST")
	private Integer id_test;
	@Column(name = "ID_AFFILIATE")
	private Integer id_affiliate;

	public Appoinment() {
	}

	public Appoinment(Date date, String hour, Integer id_test, Integer id_affiliate) {

		this.date = date;
		this.hour = hour;
		this.id_test = id_test;
		this.id_affiliate = id_affiliate;
	}

	public Appoinment(Integer id, Date date, String hour, Integer id_test, Integer id_affiliate) {
		super();
		this.id = id;
		this.date = date;
		this.hour = hour;
		this.id_test = id_test;
		this.id_affiliate = id_affiliate;
	}

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

	public String getHour() {

		return hour;
	}

	public void setHour(String hour) {
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

	@Override
	public String toString() {
		return "Appoinment [id=" + id + ", date=" + date + ", hour=" + hour + ", id_test=" + id_test + ", id_affiliate="
				+ id_affiliate + "]";
	}

}
