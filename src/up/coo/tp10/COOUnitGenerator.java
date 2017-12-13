package up.coo.tp10;
import javassist.*;

import java.util.Random;

public class COOUnitGenerator {
	/**
	 * 
	 * @param testval
	 * @return un objet contenant une classe de test
	 * @throws NotFoundException
	 * @throws CannotCompileException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static Object testLoader(int testval) throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException{
		ClassPool cp = ClassPool.getDefault();
		Random rSetFear = new Random();
		int val = 0 + rSetFear.nextInt(3 - 0);
		
		//=======CREATION DE LA CLASSE =============
		CtClass testClass = cp.makeClass("testClass"+testval);
		CtMethod setUp = CtMethod.make("public void setUp() {System.out.println(\" === SET UP ===\");}", testClass);
		CtMethod teardown = CtMethod.make("public void tearDown() {System.out.println(\" === TEAR DOWN ===\");}", testClass);
		
		//=======AJOUT DES SETUP ET TEARDOWN========
		switch (val){
			case 0 : // Presence d'une setup et pas de tearDown
				testClass.addMethod(setUp); break;
			case 1 :  // Presence d'un teardown et pas de set up
				testClass.addMethod(teardown); break;
			case 2 : // Presence des deux methodes
				testClass.addMethod(setUp);testClass.addMethod(teardown); break;
			default : break;
		}
		
		Random rTest = new Random();
		int nbTest =  0 + rTest.nextInt(10 - 0);
		
		//=======AJOUT DES METHODES================
		for(int i=1; i< nbTest+1; i++){
			Random nbT = new Random();
			int numTest =  0 + nbT.nextInt(i - 0);
			try{
				testClass.getDeclaredMethod("test" + numTest);
				i--;
			}catch (NotFoundException e){
				CtMethod methodtest = CtMethod.make("public void test"+numTest+"() {System.out.println(\" === TEST "+ i+ " ===\");}", testClass);
				testClass.addMethod(methodtest);	
			}
		}	
		Object obj = testClass.toClass().newInstance();
		return obj;
	}
}
