package com.apps.quantitymeasurement;

import com.apps.quantitymeasurement.Length.LengthUnit;

public class QuantityMeasurementApp {

	
	public static boolean demonstrateLengthEquality(Length length1, Length length2) {
		
		return false;
	}
	
	public static void demonstrateFeetEquality() {
		
	}
	
	public static void demonstrateInchesEquality() {
		
	}
	
	public static void demonstrateFeetInchesComparison() {

	}

	public static void main(String[] args) {
		Length length1 = new Length(1.0, LengthUnit.INCHES);
		Length length2 = new Length(1.0, LengthUnit.INCHES);
		System.out.println(length1.equals(length2));
		demonstrateFeetEquality();
		demonstrateInchesEquality();
		demonstrateFeetInchesComparison();
	}
}
