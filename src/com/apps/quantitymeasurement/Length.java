package com.apps.quantitymeasurement;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
		this.setUnit(unit);
	}

	private double convertToBaseUnit(Length length) {
		return length.value * length.getUnit().conversionFactor;
	}

	public boolean compare(Length thatLength) {
		return Double.compare(this.value, thatLength.value) == 0;
	}
	
	public Length convertTo(LengthUnit toTargetUnit) {
		this.value = new BigDecimal((this.value * this.unit.conversionFactor)/toTargetUnit.conversionFactor).setScale(2, RoundingMode.HALF_UP).doubleValue();
		this.unit = toTargetUnit;
		return this;
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

	public Length addAndConvert(Length length, LengthUnit targetUnit) {
		length.value = new BigDecimal(this.value+(convertToBaseUnit(length)/this.unit.conversionFactor)).setScale(2, RoundingMode.HALF_UP).doubleValue();
		length.unit = this.unit;
		length = length.convertTo(targetUnit);
		return length;
	}

	public static void main(String[] args) {
		Length length1 = new Length(2.54, LengthUnit.CENTIMETERS);
		Length length2 = new Length(1.0, LengthUnit.INCHES);
		length1.addAndConvert(length2, LengthUnit.CENTIMETERS);
		System.out.println("Addition of 2 lengths is : "+length2+" "+length2.getUnit());
	}
}
