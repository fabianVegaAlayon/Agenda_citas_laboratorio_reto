package com.sophos.Agenda_citas_laboratorio.entities;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_test")
	@Fetch(FetchMode.JOIN)
	private Test test;
	// @Column(name = "ID_AFFILIATE")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_affiliate")
	@Fetch(FetchMode.JOIN)
	private Affiliate affiliate;

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

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public Affiliate getAffiliate() {
		return affiliate;
	}

	public void setAffiliate(Affiliate affiliate) {
		this.affiliate = affiliate;
	}

}
