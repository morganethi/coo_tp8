package up.coo.tp10;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.regex.*;

public class COOUnit {
	
	private HashMap<Integer,Method> testMethod;
	private boolean hasSetUp;
	private boolean hastearDown;

	public COOUnit(Object O) {
		this.hasSetUp=false;
		this.hastearDown=false;
		this.testMethod = new HashMap<Integer,Method>();
		Method allMethod[] = O.getClass().getDeclaredMethods();
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
				this.hasSetUp=true;
			}else if(matear.find()){
				this.hastearDown=true;
			}
		}
		for(Method m : this.testMethod.values()){
			System.out.println(m.getName());
		}
		
		
		
	}

}
