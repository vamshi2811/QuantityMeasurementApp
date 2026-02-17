package com.apps.quantitymeasurement;

import com.apps.quantitymeasurement.Length.LengthUnit;

public class QuantityMeasurementApp {
	
	public static void main(String[] args) {
		Length length1 = new Length(2.54, LengthUnit.CENTIMETERS);
		Length length2 = new Length(1.0, LengthUnit.INCHES);
		demonstrateLengthAddAndConvert(length1, length2, LengthUnit.CENTIMETERS);
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
		//System.out.println("Converted value of : "+value +" "+ fromUnit +" to Unit "+toUnit+" is : " +length1.toString());
		return length1;
	}
	
	public static void demonstrateFeetInchesComparison() {
		demonstrateLengthConversion(3.0, LengthUnit.YARDS, LengthUnit.FEET);
	}
	
	public static Length demonstrateLengthAddition(Length length1, Length length2) {
		length2 = length1.add(length2);
		//System.out.println("Addition of 2 lengths is : "+length2+" "+length2.getUnit());
		return length2;
	}
	
	public static Length demonstrateLengthAddAndConvert(Length length1, Length length2, LengthUnit targetUnit) {
		System.out.print("Addition of 2 lengths "+length1.toString()+length1.getUnit()+" and "+length2.toString()+length2.getUnit()+" is : ");
		length2 = length1.addAndConvert(length2, targetUnit);
		System.out.println(length2+" "+length2.getUnit());
		return length2;
	}

}
