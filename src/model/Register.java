package model;

import java.time.LocalDate;
import java.util.ArrayList;

import exceptions.NotAllowedException;
import exceptions.UnderAgeException;

public class Register {
	private int intents;
	private ArrayList<Person> registers;
	
	public Register() {
		intents = 0;
		registers = new ArrayList<>();
	}
	
	public void increaseIntents() {
		intents++;
	}
	
	public int getIntents() {
		return intents;
	}
	
	public void intentToRegister(long document, int documentType) throws NotAllowedException, UnderAgeException {
		increaseIntents();
		if(documentType == 1) {
			throw new UnderAgeException();
		}
		if(Long.toString(document).charAt(Long.toString(document).length() -2)%2 != LocalDate.now().getDayOfMonth()%2) {
			throw new NotAllowedException();
		}
		Person nP = new Person(document, documentType);
		registers.add(nP);
	}
	
	public String getRegisters() {
		String info = "";
		for(int i = 0; i<registers.size(); i++) {
			info += registers.get(i).getInfo();
		}
		return info;
	}
	public Person getRegister(long id) {
		boolean founded = false;
		Person current = null;
		for(int i = 0; i<registers.size() && !founded; i++) {
			if(registers.get(i).getIdentification() == id) current = registers.get(i);
		}
		return current;
	}
}
