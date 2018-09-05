import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests of the StringUtil methods.
 * @author Patompong Sukcheep
 */
public class StringUtilTest {

	/**
	 * Tests of finding index of array
	 */
	@Test
	public void testIndexOf() {
		String[] fruit = {"Apple", "Banana", "Grapes"};
		assertEquals(0, StringUtil.indexOf("Apple", fruit));
		
	}
	
	/**
	 * Tests of checking array empty
	 */
	@Test
	public void testArrayEmpty(){
		String[] fruit = null;
		assertNull(fruit);
	}
	/**
	 * Tests of Repeated name of array
	 */
	@Test
	public void testRepeatedName(){
		String[] fruit ={"Apple", "Apple", "Grapes"};
		assertEquals(0,StringUtil.indexOf("Apple", fruit));
	}


}
