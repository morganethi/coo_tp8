package up.coo.tp10;

import java.lang.reflect.InvocationTargetException;

public class cooUnitmain {
	
	

	public static void main(String[] args) {
		
		COOUnit c = new COOUnit(new COOUnitTestCaseDemo());
		try {
			c.drive();
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
