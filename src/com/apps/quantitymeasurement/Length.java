package com.apps.quantitymeasurement;

public class Length {

	private double value;
	private LengthUnit unit;

	public enum LengthUnit {

		FEET(12.0),
		INCHES(1.0);

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
	}

}
