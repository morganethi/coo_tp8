package up.coo.tp10;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class cooUnitmain {
	
	public static void main(String[] args) throws Throwable {
		
		Random r = new Random();
		int myi =  0 + r.nextInt(30 - 0);
		for(int i=0; i< myi; i++){
			System.out.println("COO UNIT"+(i+1));
			COOUnit c = new COOUnit( COOUnitGenerator.testLoader(i));
			try {
				c.drive();
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
	}

}
