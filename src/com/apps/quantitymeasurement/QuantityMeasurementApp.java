package com.apps.quantitymeasurement;

import com.apps.quantitymeasurement.Length.LengthUnit;

public class QuantityMeasurementApp {
	
	public static void main(String[] args) {
		
		demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCHES);
		demonstrateLengthConversion(3.0, LengthUnit.YARDS, LengthUnit.FEET);
		demonstrateLengthConversion(Double.POSITIVE_INFINITY, LengthUnit.INCHES, LengthUnit.YARDS);
		demonstrateLengthConversion(-1.0, LengthUnit.FEET, LengthUnit.INCHES);
		//demonstrateLengthConversion(Double.parseDouble(demonstrateLengthConversion(2.54, LengthUnit.CENTIMETERS, LengthUnit.INCHES).toString()), LengthUnit.INCHES, LengthUnit.CENTIMETERS);
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

}
