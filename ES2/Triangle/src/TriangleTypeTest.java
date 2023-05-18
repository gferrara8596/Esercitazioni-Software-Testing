// Introduction to Software Testing
// Authors: Paul Ammann & Jeff Offutt
// Chapter 6; page ??
// JUnit for TriangleType.java

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.Assert.*;

public class TriangleTypeTest {
    public int x;
    public int y;
    public int z;
    public Triangle t;


	@ParameterizedTest
	@CsvFileSource(resources = "ECCExpected.csv")	
	void testECCExpected(int s1, int s2, int s3, String e) {
		System.out.println("testECCExpected");
		Triangle t=TriangleType.triangle(s1, s2, s3);
		System.out.println(s1+","+s2+","+s3+","+t+". Expected : "+e);
		assertEquals(e,t.toString());
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "BCCCartesian.csv", numLinesToSkip= 1)	
	void testBCCCartesian(int s1, int s2, int s3, String e) {
		System.out.println("BCCCartesian");
		Triangle t=TriangleType.triangle(s1, s2, s3);
		System.out.println(s1+","+s2+","+s3+","+t+". Expected : "+e);
		assertEquals(e,t.toString());
	}
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "BCCCartesianExtended.csv", numLinesToSkip= 1)	
	void testBCCCartesianExtended(int s1, int s2, int s3, String e) {
		System.out.println("BCCCartesianExtended");
		Triangle t=TriangleType.triangle(s1, s2, s3);
		System.out.println(s1+","+s2+","+s3+","+t+". Expected : "+e);
		assertEquals(e,t.toString());
	}
	
	
	
    
   
}

