package com.apps.quantitymeasurement;

public class Length {

	private double value;
	private LengthUnit unit;

	public enum LengthUnit {

		FEET(12.0),
		INCHES(1.0),
		YARDS(36.0),
		CENTIMETERS(0.393701);

		private final double conversionFactor;

		LengthUnit(double conversionFactor) {
			this.conversionFactor = conversionFactor;
		}

		public double getConversionFactor() {
			return conversionFactor;
		}

	}

	public Length(double value, LengthUnit unit) {
		this.value = value;
		this.unit = unit;
	}

	private double convertToBaseUnit(Length length) {
		return length.value * length.unit.conversionFactor;
	}

	public boolean compare(Length thatLength) {
		return Double.compare(this.value, thatLength.value) == 0;
	}
	
	public Length convertTo(LengthUnit toTargetUnit) {
		this.value = Math.round(this.value * this.unit.conversionFactor)/toTargetUnit.conversionFactor;
		return this;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.value);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj==null) {
			return false;
		}
		Length length = (Length) obj;
		if (this.unit==length.unit && this.value == length.value) {
			return true;
		} else if (obj != null && this != obj && this.unit!=length.unit) {
			this.value = convertToBaseUnit(this);
			length.value = convertToBaseUnit(length);
		}
		return compare(length);
	}

	public static void main(String[] args) {

		Length length1 = new Length(1.0, LengthUnit.FEET);
		Length length2 = new Length(12.0, LengthUnit.INCHES);
		System.out.println(length1.equals(length2));

		Length length3 = new Length(1.0, LengthUnit.YARDS);
		Length length4 = new Length(36.0, LengthUnit.INCHES);
		System.out.println(length3.equals(length4));

		Length length5 = new Length(100.0, LengthUnit.CENTIMETERS);
		Length length6 = new Length(39.3701, LengthUnit.INCHES);
		System.out.println(length5.equals(length6));
		 
	}

}
