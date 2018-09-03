import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

/**
 * Test methods in the ArrayMath class.
 */
public class ArrayMathTest {
	/** A small tolerance for floating point round-off (precision) error. */
	static final double TOL = 1.0E-6;

	@Test
	public void testDotProductTinyVectors() {
		// vector of length one
		double[] x = {5.2};
		double[] y = {-7.5};
		double expected = x[0]*y[0];
		assertEquals( expected, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( expected, ArrayMath.dotProduct(y, x), TOL);
		
		// vector of size 0?
		x = new double[] { };
		y = new double[] { };
		assertEquals( 0.0, ArrayMath.dotProduct(x, y), TOL);
	}

	@Test
	public void testVectorsLargerThanOne() {
		// vector length of two
		double[] x = {3.2, -6.7};
		double[] y = {6.4, 5.8};
		double expected = -18.38;
		assertEquals( expected, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( expected, ArrayMath.dotProduct(y, x), TOL);

		// vector length of two
		x = new double[]{3.6, 8.9, 8.9};
		y = new double[]{5.4, -5.5, -6.6};
		expected = -88.25;
		assertEquals( expected, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( expected, ArrayMath.dotProduct(y, x), TOL);

		// vector length of five
		x = new double[]{2.2, 7.9, 7.1, -5.4, -1.2};
		y = new double[]{5.1, -2.5, -6.6, 4.5, -8.2};
		expected = -69.85;
		assertEquals( expected, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( expected, ArrayMath.dotProduct(y, x), TOL);
	}

	@Test
	public void testDotProductHugeVectors() {
		int len = 1_000_000;
		double[] x = new double[len];
		double[] y = new double[len];
		Random rand = new Random();
		double product = 0.0;
		for(int k=0; k<len; k++) {
			// to avoid overflowing the product using floats for elements
			double xk = (double) rand.nextFloat();
			double yk = (double) rand.nextFloat();
			x[k] = xk;
			y[k] = yk;
			product += xk*yk;
		}
		assertEquals( product, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( product, ArrayMath.dotProduct(y, x), TOL);
	}

	/** 
	 * This test should throw an exception,
	 * but not after you change the spec for dotProduct!
	 */
	@Test(expected=java.lang.IllegalArgumentException.class)
	public void testDotProductLengthsNotSame() {
		double[] x = new double[] {1, 3, 5, 7, 9};
		double[] y = new double[] {-2, 0.5, 4};
		assertEquals( 19.5, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( 19.5, ArrayMath.dotProduct(y, x), TOL);
	}

}
