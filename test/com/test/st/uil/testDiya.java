package com.test.st.uil;
import com.st.uil.*;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class testDiya {

	@Test
	public void test_size_0() {
		
		int[][] a = Diya.returnSpiralMatrix(0);
		int[][] b = new int[0][0];
		assertTrue("expected " + Arrays.deepToString(b) + " found:" +Arrays.deepToString(a), Arrays.deepEquals(a, b));
		
	}
	
	@Test
	public void test_size_1() {
		int[][] a = Diya.returnSpiralMatrix(1);
		int[][] b = {{1}};
		assertTrue("expected " + Arrays.deepToString(b) + " found:" +Arrays.deepToString(a), Arrays.deepEquals(a, b));
	}
	
	@Test
	public void test_size_2() {
		int[][] a = Diya.returnSpiralMatrix(2);
		int[][] b = {{1,2},
		             {4,3}};
		assertTrue("expected " + Arrays.deepToString(b) + " found:" +Arrays.deepToString(a), Arrays.deepEquals(a, b));
	}
	
	@Test
	public void test_size_3() {
		int[][] a = Diya.returnSpiralMatrix(3);
		int[][] b = {{1,2,3},
				     {8,9,4},{7,6,5}};
		assertTrue("expected " + Arrays.deepToString(b) + " found:" +Arrays.deepToString(a), Arrays.deepEquals(a, b));
	}

}
