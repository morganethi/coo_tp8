package up.coo.tp10;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.regex.*;

public class COOUnit {
	
	private HashMap<Integer,Method> testMethod;
	private Method setUp;
	private Method tearDown;
	private Object obj;

	public COOUnit(Object o) {
		this.obj = o;
		this.setUp = null;
		this.tearDown = null;
		this.testMethod = new HashMap<Integer,Method>();
		Method allMethod[] = o.getClass().getDeclaredMethods();
		Pattern p = Pattern.compile("test[0-9]+");
		Pattern set = Pattern.compile("setUp");
		Pattern tear = Pattern.compile("tearDown");
		for(int i=0; i< allMethod.length; i++){
			
			Matcher m = p.matcher(allMethod[i].getName());
			Matcher matset = set.matcher(allMethod[i].getName());
			Matcher matear = tear.matcher(allMethod[i].getName());
			if(m.find()){
				String mres = m.group();
				String num = mres.replaceAll("test","");
				testMethod.put(Integer.valueOf(num),allMethod[i]);
			}else if(matset.find()){
				this.setUp = allMethod[i];
			}else if(matear.find()){
				this.tearDown = allMethod[i];
			}
		}	
	}
	
	public void drive() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		for(Method m : this.testMethod.values()){
			if(this.setUp!=null){
				this.setUp.invoke(this.obj,new Object[0]);
			}
			m.invoke(this.obj, new Object[0]);
			if(this.tearDown!=null){
				this.tearDown.invoke(this.obj, new Object[0]);
			}
		}
	}

}
