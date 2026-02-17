package com.apps.quantitymeasurement;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Length {

	private double value;
	private LengthUnit unit;

	public enum LengthUnit {
		//2 FEET -> INCHES - Length(value, unit) -> (2, FEET) -> 2 * 12 -> 24 INCHES

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
		this.setUnit(unit);
	}

	//2 FEET -> INCHES - Length(value, unit) -> (2, FEET) -> 2 * 12 -> 24 INCHES
	private double convertToBaseUnit(Length length) {
		return length.value * length.unit.conversionFactor;
	}

	public boolean compare(Length thatLength) {
		return Double.compare(this.value, thatLength.value) == 0;
	}
	
	//6 FEET -> YARDS - Length(6, FEET), YARDS -> 6 * 12 -> 72(INCHES)/36(YARDS) 				2 YARDS
	public Length convertToTargetUnit(Length lengthToConvert) {
		double value = new BigDecimal(convertToBaseUnit(lengthToConvert)/lengthToConvert.getUnit().conversionFactor).setScale(2, RoundingMode.HALF_UP).doubleValue();
		LengthUnit unit = lengthToConvert.getUnit();
		return new Length(value, unit);
	}
	
	public Length convertToTargetUnit_(Length length) {
		double value = length.value / length.unit.conversionFactor;
		return new Length(value,length.getUnit());
	}
	
	public Length add(Length length) {
		//System.out.println("Length 1 = "+this.value+" "+this.unit+"\nLength 2 = "+length.value+" "+length.unit);
		length.value = new BigDecimal(this.value+(convertToBaseUnit(length)/this.unit.conversionFactor)).setScale(2, RoundingMode.HALF_UP).doubleValue();
		length.unit = this.unit;
		return length;
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
		if (this.getUnit()==length.getUnit() && this.value == length.value) {
			return true;
		} else if (obj != null && this != obj && this.getUnit()!=length.getUnit()) {
			this.value = convertToBaseUnit(this);
			length.value = convertToBaseUnit(length);
		}
		return compare(length);
	}

	public LengthUnit getUnit() {
		return unit;
	}

	public void setUnit(LengthUnit unit) {
		this.unit = unit;
	}

	public Length addAndConvert(Length length1, Length length2, LengthUnit targetUnit) {
		length1.value = convertToBaseUnit(length1);
		length2.value = convertToBaseUnit(length2);
		double length3 = length1.value+length2.value;
		return convertToTargetUnit_(new Length(length3, targetUnit));
	}

	public static void main(String[] args) {
		Length length1 = new Length(1.0, LengthUnit.YARDS);
		Length length2 = new Length(3.0, LengthUnit.FEET);
		Length length3 = length1.addAndConvert(length1, length2, LengthUnit.YARDS);
		System.out.println("Addition of 2 lengths is : "+length3.value+" "+length3.getUnit());
	}
}
