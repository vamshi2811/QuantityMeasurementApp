package com.apps.quantitymeasurement;

import com.apps.quantitymeasurement.Length.LengthUnit;

public class QuantityMeasurementApp {
	
	public static void main(String[] args) {
		
		demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS, 3.0, Length.LengthUnit.FEET);
		
		demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS, 36.0, Length.LengthUnit.INCHES);
		
		demonstrateLengthComparison(2.0, Length.LengthUnit.YARDS, 2.0, Length.LengthUnit.YARDS);
		
		demonstrateLengthComparison(2.0, Length.LengthUnit.CENTIMETERS, 2.0, Length.LengthUnit.CENTIMETERS);
		
		demonstrateLengthComparison(1.0, Length.LengthUnit.CENTIMETERS, 0.393701, Length.LengthUnit.INCHES);
	}

	private static void demonstrateLengthComparison(double d, LengthUnit unit1, double e, LengthUnit unit2) {
		Length length1 = new Length(d, unit1);
		Length length2 = new Length(e, unit2);
		System.out.println(length1.equals(length2));
	}
}
