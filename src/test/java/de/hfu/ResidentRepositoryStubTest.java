package de.hfu;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepositoryStub;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;

public class ResidentRepositoryStubTest {
	ResidentRepositoryStub testR=new ResidentRepositoryStub();
	Resident nico=new Resident("Nico","Dietz","Teststrasse","Furtwangen",new Date(2017-02-02));
	Resident josh=new Resident("Joshua","Wehr","Teststrasse","Furtwangen",new Date(1804-12-05));
	
	BaseResidentService testService=new BaseResidentService();
	@Test
	public void testHinzufuegen() {
		int test1=2;
		
		testR.hinzufuegen(nico);
		testR.hinzufuegen(josh);
		
		List<Resident> test2=testR.getResidents();
		assertEquals(test1,test2.size());
		
		String test3="Nico";
		assertEquals(test3,test2.get(0).getGivenName());
		
		String test4="Joshua";
		assertEquals(test4,test2.get(1).getGivenName());
		
		testR.delete(nico);
		testR.delete(josh);
	}
	@Test
	public void testGetFilteredResidentsList() {
		testR.hinzufuegen(josh);
		testR.hinzufuegen(nico);
		testService.setResidentRepository(testR);
		
		Resident gesucht=new Resident("J*","*","*","*",null);
		List<Resident> liste=testService.getFilteredResidentsList(gesucht);
		if(liste.size() > 0) {
			for(Resident r : liste) {
				if(r.equals(josh)) {
					assertEquals(josh,r);
				}
				else {
					assertEquals(null,1);
				}
			}
		}else
			assertEquals(null,1);
		testR.delete(josh);
		testR.delete(nico);
		
	}
	@Test
	public void testGetFiltered2() {
		testR.hinzufuegen(josh);
		testR.hinzufuegen(nico);
		testService.setResidentRepository(testR);
		//ABC als EIngabewert gibt kein Ergebnis
		
		Resident gesucht=new Resident("ABC","*","*","*",null);
		List<Resident> liste=testService.getFilteredResidentsList(gesucht);
		if(liste.size() > 0) {
			for(Resident r : liste) {
				if(r.equals(josh)) {
					assertEquals(josh,r);
				}
				else {
					assertEquals(null,1);
				}
			}
		}else
			assertEquals(null,1);
		testR.delete(josh);
		testR.delete(nico);
	}
	@Test
	public void testGetFiltered3() {
		testR.hinzufuegen(josh);
		testR.hinzufuegen(nico);
		testService.setResidentRepository(testR);
		//Eingaben *a und *r liefern Ergebnisse
		
		Resident gesucht=new Resident("*a","*r","*","*",null);
		List<Resident> liste=testService.getFilteredResidentsList(gesucht);
		if(liste.size() > 0) {
			for(Resident r : liste) {
				if(r.equals(josh)) {
					assertEquals(josh,r);
				}
				else {
					assertEquals(null,1);
				}
			}
		}else
			assertEquals(null,1);
		testR.delete(josh);
		testR.delete(nico);
	}
	@Test
	public void testGetUnique() throws ResidentServiceException {
		testR.hinzufuegen(josh);
		testR.hinzufuegen(nico);
		testService.setResidentRepository(testR);
		
		Resident gesucht=new Resident();
		gesucht=testService.getUniqueResident(josh);
		//getUniqueResident() liefert den gewollten Resident zurück
		assertEquals(josh,gesucht);
		
		testR.delete(josh);
		testR.delete(nico);
	}
	@Test
	public void testGetUnique2() throws ResidentServiceException {
		testR.hinzufuegen(josh);
		testR.hinzufuegen(nico);
		testService.setResidentRepository(testR);
		
		Resident gesucht=new Resident();
		gesucht=testService.getUniqueResident(nico);
		//Ergebnis wird mit falschem Objekt verglichen
		assertEquals(josh,gesucht);
		
		testR.delete(josh);
		testR.delete(nico);
	}
	/*
	@Test
	public void testGetUnique3() throws ResidentServiceException {
		testR.hinzufuegen(josh);
		testR.hinzufuegen(nico);
		testService.setResidentRepository(testR);
		
		testR.delete(josh);
		testR.delete(nico);
	}*/
}
