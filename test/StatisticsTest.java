import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test the Statistics by using JUnit
 * @author Supaluk Jaroensuk
 * @version 2018.09.04
 */
public class StatisticsTest {
	/** A small tolerance for floating point round-off (precision) error. */
	static final double TOL = 1.0E-6;

	/**
	 * Test slightly average difference
	 */
	@Test
	public void testAverageTinyArray() {
		double[] x = { 123.01 };
		assertEquals( x[0], Statistics.average(x), TOL);
		double[] y = { 123.01, 123.02 };
		assertEquals( 123.015, Statistics.average(y), TOL);
	}

	/**
	 * Test average mixed values
	 */
	@Test
	public void testAverageMixedValues() {
		double[] x = new double[99];
		java.util.Arrays.fill(x, 12.5);
		assertEquals( 12.5, Statistics.average(x), TOL);
		// many values spaced around a known mean
		double avg = 1.125;
		int n = x.length;
		java.util.Arrays.fill(x, avg);
		for(int k=0; k<=n/2; k++) {
			x[k] -= 0.5*k;
			x[n-k-1] += 0.5*k;
		}
		assertEquals( avg, Statistics.average(x), TOL);
	}

	/**
	 * Test empty or null array
	 */
	@Test
	public void testEmptyArray() {
		double[] x = null;
		assertNull(x);

		double[] y = new double[0];
		assertEquals(0, y.length);
	}

	/**
	 * Test variance formula
	 */
	@Test
	public void testVariance() {
		double[] x = {3, 21, 98, 203, 17, 9};
		assertEquals(5183.25, Statistics.variance(x), TOL);

		double[] y = {170, 300, 430, 470, 600};
		assertEquals(21704, Statistics.variance(y), TOL);
	}

	/**
	 * Test variance by very large array
	 */
	@Test
	public void testLargeArray() {
		double[] x = new double[1000];
		for(int i = 0; i < x.length; i++){
			x[i] = i;
		}
		assertEquals(83333.25000000012, Statistics.variance(x), TOL);
	}

	/**
	 * Test variance by different values
	 */
	@Test
	public void testDifferentValues() {
		double[] x = {1, 22, 40, 100, 810, 1921, 2941, 9000};
		assertEquals(8312281.734375, Statistics.variance(x), TOL);
	}

	/**
	 * Test covariance formula
	 */
	@Test
	public void testCovariance(){
		double[] x = {5,20,40,80,100};
		double[] y = {10,24,33,54,10};

		assertEquals(150.2, Statistics.covariance(x, y), TOL);

		double[] a = {187,198.2,172,204,211.2};
		double[] b = {171,249,228.1,198.33,188};

		assertEquals(-89.80528, Statistics.covariance(a, b), TOL);
	}

}
