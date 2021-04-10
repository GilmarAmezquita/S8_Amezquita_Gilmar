package ui;

import java.util.Scanner;

import exceptions.NotAllowedException;
import exceptions.UnderAgeException;
import model.Register;

public class Menu {
	private final static int REGISTER = 1;
	private final static int CONSULT = 2;
	private final static int EXIT = 3;
	
	private Register register;
	private static Scanner sc;
	
	public Menu() {
		sc = new Scanner(System.in);
		register = new Register();
	}
	
	public void showMenu() {
		System.out.println("************** MENU **************");
		System.out.println("1) Registrar ingreso");
		System.out.println("2) Consultar intentos de registro");
		System.out.println("3) Salir");
		System.out.println("************** MENU **************");
	}
	
	public void showMenuDocumentType() {
		System.out.println("********** DOCUMENT TYPE **********");
		System.out.println("(1) TI");
		System.out.println("(2) CC");
		System.out.println("(3) PP");
		System.out.println("(4) CE");
		System.out.println("********** DOCUMENT TYPE **********");
	}
	
	public int readChoice() {
		System.out.print("Opcion: ");
		int choice = sc.nextInt();
		sc.nextLine();
		return choice;
	}
	
	public void registerNewPerson() {
		int choice;
		do {
			showMenuDocumentType();
			System.out.println("Ingrese el tipo de documento:");
			choice = readChoice();
		}while(choice<1 || choice>4);
		System.out.println("Ingrese el numero del documento:");
		long id = sc.nextLong();
		try {
			register.intentToRegister(id, choice);
		} catch (NotAllowedException e) {
			System.err.println(e.getMessage());
		} catch (UnderAgeException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void doOperation(int choice) {
		switch(choice) {
			case REGISTER:
				registerNewPerson();
				break;
			case CONSULT:
				System.out.println(register.getIntents());
				System.out.println(register.getRegisters());
				break;
			case EXIT:
				break;
			default:
				System.out.println("Opcion invalida, ingrese otra opcion");
		}
	}
	
	public void startProgram() {
		int choice;
		do {
			showMenu();
			choice = readChoice();
			doOperation(choice);
		}while(choice != 3);
	}
}
