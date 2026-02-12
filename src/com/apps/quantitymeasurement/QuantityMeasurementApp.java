package com.apps.quantitymeasurement;

import com.apps.quantitymeasurement.Length.LengthUnit;

public class QuantityMeasurementApp {

	
	public static boolean demonstrateLengthEquality(Length length1, Length length2) {
		
		return false;
	}
	
	public static void demonstrateFeetEquality() {
		Length length1 = new Length(1.0, LengthUnit.FEET);
		Length length2 = new Length(1.0, LengthUnit.FEET);
		System.out.println(length1.equals(length2));
	}
	
	public static void demonstrateInchesEquality() {
		Length length1 = new Length(1.0, LengthUnit.INCHES);
		Length length2 = new Length(1.0, LengthUnit.INCHES);
		System.out.println(length1.equals(length2));
	}
	
	public static void demonstrateFeetInchesComparison() {
		Length length1 = new Length(1.0, LengthUnit.FEET);
		Length length2 = new Length(12.0, LengthUnit.INCHES);
		System.out.println(length1.equals(length2));
	}

	public static void main(String[] args) {
		demonstrateFeetEquality();
		demonstrateInchesEquality();
		demonstrateFeetInchesComparison();
	}
}
