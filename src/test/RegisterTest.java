package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import exceptions.NotAllowedException;
import exceptions.UnderAgeException;
import model.Register;

class RegisterTest {
	private Register register;
	
	private void setUpScenary1() {
		register = new Register();
	}
	@Test
	public void testRegister1() {
		setUpScenary1();
		long id;
		if(LocalDate.now().getDayOfMonth()% 2 == 0) {
			id = 1006351546;
		}else id = 1006351556;
		int dcType = 2;
		try{
			register.intentToRegister(id, dcType);
			assertEquals(id, register.getRegister(id).getIdentification());
			assertEquals(1, register.getIntents());
		}catch (NotAllowedException nae) {
			fail("Not NotAllowedException excepted");
		} catch (UnderAgeException uae) {
			fail("Not UnderAgeException expected");
		}
	}
	@Test
	public void testRegister2() {
		setUpScenary1();
		long id;
		if(LocalDate.now().getDayOfMonth()% 2 == 0) {
			id = 1006351546;
		}else id = 1006351556;
		int dcType = 1;
		try {
			register.intentToRegister(id, dcType);
			fail("UnderAgeException expected");
		}catch(NotAllowedException nae){
			fail("UnderAgeException expected, not NotAllowedException");
		}catch(UnderAgeException uae){
			assertEquals(null, register.getRegister(id));
			assertEquals(1, register.getIntents());
		}
	}
	@Test
	public void testRegister3() {
		setUpScenary1();
		long id;
		if(LocalDate.now().getDayOfMonth()% 2 == 0) {
			id = 1006351556;
		}else id = 1006351546;
		int dcType = 3;
		try {
			register.intentToRegister(id, dcType);
			fail("NotAllowedException expected");
		}catch(NotAllowedException nae) {
			assertEquals(null, register.getRegister(id));
			assertEquals(1, register.getIntents());
		}catch(UnderAgeException uae) {
			fail("NotAllowedException expected, not UnderAgeException");
		}
	}
}
