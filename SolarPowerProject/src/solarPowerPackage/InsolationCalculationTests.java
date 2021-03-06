package solarPowerPackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class InsolationCalculationTests {

	InsolationCalculation calculator = new InsolationCalculation();
	
	
	//test various values
	@Test
	public void testDegreesToRadians(){
		double testDegrees = 180;
		double expectedRadians = (testDegrees * Math.PI) / 180;
		double actualRadians = calculator.DegreesToRadians(testDegrees);
		String expectedString = "Expected " + expectedRadians + " but was: " + actualRadians;
		assertEquals(expectedString, expectedRadians, actualRadians, 0.1);
	}
	
	@Test
	public void testDegreesToRadians2(){
		double testDegrees = 0;
		double expectedRadians = (testDegrees * Math.PI) / 180;
		double actualRadians = calculator.DegreesToRadians(testDegrees);
		String expectedString = "Expected " + expectedRadians + " but was: " + actualRadians;
		assertEquals(expectedString, expectedRadians, actualRadians, 0.1);
	}
	
	@Test
	public void testDegreesToRadians3(){
		double testDegrees = 360;
		double expectedRadians = (testDegrees * Math.PI) / 180;
		double actualRadians = calculator.DegreesToRadians(testDegrees);
		String expectedString = "Expected " + expectedRadians + " but was: " + actualRadians;
		assertEquals(expectedString, expectedRadians, actualRadians, 0.1);
	}
	
	@Test
	public void testDegreesToRadians4(){
		double testDegrees = 1.11111111;
		double expectedRadians = (testDegrees * Math.PI) / 180;
		double actualRadians = calculator.DegreesToRadians(testDegrees);
		String expectedString = "Expected " + expectedRadians + " but was: " + actualRadians;
		assertEquals(expectedString, expectedRadians, actualRadians, 0.1);
	}
	
	@Test
	public void testYearlyOutput(){
		double testLatitude = 0;
		int simulationLength = 1;
		
		double totalInsolation = calculator.TotalSolarInsolation(testLatitude, simulationLength);
		
		System.out.println(totalInsolation);

	}
	
	@Test
	public void testYearlyOutput2(){
		double testLatitude = 45;
		int simulationLength = 1;
		
		double totalInsolation = calculator.TotalSolarInsolation(testLatitude, simulationLength);
		
		System.out.println(totalInsolation);

	}
	
	@Test
	public void testYearlyOutput3(){
		double testLatitude = 66.5;
		int simulationLength = 1;
		
		double totalInsolation = calculator.TotalSolarInsolation(testLatitude, simulationLength);
		
		System.out.println(totalInsolation);

	}
	
	@Test
	public void testYearlyOutput4(){
		double testLatitude = -45;
		int simulationLength = 1;
		
		double totalInsolation = calculator.TotalSolarInsolation(testLatitude, simulationLength);
		
		System.out.println(totalInsolation);

	}
	
	@Test
	public void testYearlyOutput5(){
		double testLatitude = -66.5;
		int simulationLength = 1;
		
		double totalInsolation = calculator.TotalSolarInsolation(testLatitude, simulationLength);
		
		System.out.println(totalInsolation);

	}
	
	@Test
	public void testDailyOutput(){
		double testLatitude = 67;
		double dayInsolation = 0;
		for (int i = 1; i < 365; i = i + 30){
			dayInsolation = calculator.DailyInsolation(testLatitude, i);
			
			//System.out.println(dayInsolation);
		}
	}
	
	@Test
	public void testZenithAngleRange(){
		double testDeclination = calculator.SolarDeclinaton(1);
		double testHourAngle = calculator.HourToHourAngle(12);
		double zenithAngle;
		
			zenithAngle = calculator.ZenithAngle(67, testDeclination, testHourAngle);
			//System.out.println(zenithAngle);

	}
	@Test
	public void testHourlyInsolationLatitudeRange(){
		int hour = 12;
		int day = 180;
		double insolation;
		for (int i = -90; i <= 90; i = i +10){
			insolation = calculator.HourInsolaton(i, hour, day);
			
			String aString = "Lat: " + i + ", Insolation: " + insolation;
			
			//System.out.println(aString);
			
		}
	}
	
}
