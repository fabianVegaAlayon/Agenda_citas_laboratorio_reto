package com.sophos.Agenda_citas_laboratorio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.sophos.Agenda_citas_laboratorio.entities.Affiliate;
import com.sophos.Agenda_citas_laboratorio.entities.Appoinment;
import com.sophos.Agenda_citas_laboratorio.entities.Master;
import com.sophos.Agenda_citas_laboratorio.entities.TestL;

public class Datos {

	private static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	public static Optional<Affiliate> createAffiliate() {
		return Optional.of(new Affiliate(1, "quico", 22, "quico@any.com"));
	}

	public static Optional<Affiliate> createAffiliateNumbTwo() {
		return Optional.of(new Affiliate(2, "Chavo", 22, "chavo@any.com"));
	}

	public static Affiliate insertAffiliate() {
		Affiliate aff = new Affiliate(3, "Homero", 40, "homero@simpson.com");

		return aff;
	}

	public static Affiliate newAffiliate() {
		Affiliate aff = new Affiliate(4, "HomeroJay", 40, "homero@simpson.com");

		return aff;
	}

	public static String updateAffiliate() {

		return "Affiliate Updated";
	}

	public static Optional<Appoinment> createAppoinment() throws ParseException {
		Date fecha = (Date) formato.parse("09/12/2023");
		return Optional.of(new Appoinment(1, fecha, "16:55:24", 1, 1));
	}

	public static Optional<Appoinment> createAppoinmentTwo() throws ParseException {
		Date fecha = (Date) formato.parse("10/12/2023");
		return Optional.of(new Appoinment(2, fecha, "15:55:24", 2, 1));
	}

	public static Appoinment newAppoinment() throws ParseException {
		Date fecha = (Date) formato.parse("10/12/2023");
		
		return new Appoinment(2, fecha, "15:55:24", 2, 1);
	}

	public static Optional<TestL> createTest() throws ParseException {

		return Optional.of(new TestL(1, "Test Sangre", "Es el test de sangre"));
	}

	public static Optional<TestL> createTestNumbTwo() throws ParseException {

		return Optional.of(new TestL(2, "Test Horina", "Es el test de Horina"));
	}

	public static TestL newTest() throws ParseException {

		return new TestL(2, "Test Horina", "Es el test de Horina");
	}

	public static List<Master> getAffiliateById() throws ParseException {
		Date fecha = (Date) formato.parse("10/12/2023");
		Master master = new Master(1, "sara", 23, "sara@any.com", 1, fecha, "05:25:00", "analisis de sangre");

		List<Master> list = new ArrayList<Master>();
		list.add(master);

		return list;
	}

	public static List<Master> getAffiliateByDate() throws ParseException {
		Date fecha = (Date) formato.parse("10/12/2023");
		Master master = new Master(1, "sara", 23, "sara@any.com", 1, fecha, "05:25:00", "analisis de sangre");

		List<Master> list = new ArrayList<Master>();
		list.add(master);

		return list;
	}
	
	public static String whenTheAffiliateIsDeleted() 
	{
		return "Success";
	}
	

}
