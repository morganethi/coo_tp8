package up.coo.tp10;
import javassist.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class cooUnitmain {
	
	

	public static void main(String[] args) throws Throwable {
		
		
		for(int i=0; i< 10; i++){
			System.out.println("COO UNIT"+(i+1));
			Random r = new Random();
			int val = 0 + r.nextInt(400 - 0);
			COOUnit c = new COOUnit( COOUnitGenerator.testLoader(val));
			try {
				c.drive();
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
