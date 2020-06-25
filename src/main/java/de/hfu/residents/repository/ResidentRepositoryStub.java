package de.hfu.residents.repository;

import java.util.ArrayList;
import java.util.List;

import de.hfu.residents.domain.Resident;

public class ResidentRepositoryStub implements ResidentRepository{
	private List<Resident> Residents=new ArrayList<Resident>();
	
	@Override
	public List<Resident> getResidents() {
		return this.Residents;	
	}
	public void hinzufuegen(Resident eingabe) {
		this.Residents.add(eingabe);
	}
	public void delete(Resident eingabe) {
		this.Residents.remove(eingabe);
	}

}
