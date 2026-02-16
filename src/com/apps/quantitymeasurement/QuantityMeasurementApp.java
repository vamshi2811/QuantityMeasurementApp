package com.apps.quantitymeasurement;

import com.apps.quantitymeasurement.Length.LengthUnit;

public class QuantityMeasurementApp {
	
	public static void main(String[] args) {
		Length length1 = new Length(5.0, LengthUnit.FEET);
		Length Length2 = new Length(-2.0, LengthUnit.FEET);
		demonstrateLengthAddition(length1, Length2);
	}

	public static boolean demonstrateLengthEquality(Length length1, Length length2) {
		return length1.equals(length2);
	}
	
	public static boolean demonstrateLengthComparison() {
		return false;
	}
	
	public static Length demonstrateLengthConversion(double value, LengthUnit fromUnit, LengthUnit toUnit) {
		Length length1 = new Length(value, fromUnit);
		length1 = length1.convertTo(toUnit);
		System.out.println("Converted value of : "+value +" "+ fromUnit +" to Unit "+toUnit+" is : " +length1.toString());
		return length1;
	}
	
	public static void demonstrateFeetInchesComparison() {
		demonstrateLengthConversion(3.0, LengthUnit.YARDS, LengthUnit.FEET);
	}
	
	public static Length demonstrateLengthAddition(Length length1, Length length2) {
		length2 = length1.add(length2);
		System.out.println("Addition of 2 lengths is : "+length2+" "+length2.getUnit());
		return length2;
	}

}
