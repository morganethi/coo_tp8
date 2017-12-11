package up.coo.tp10;
import java.lang.reflect.*;
import java.util.List;

public class COOUnit {
	
	private List<Method> testMethod;
	private boolean hasSetUp;
	private boolean hastearDown;

	public COOUnit(Object O) {
		Method allMethod[] = O.getClass().getMethods();
	}

}
