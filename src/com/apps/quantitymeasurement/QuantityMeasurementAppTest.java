package com.apps.quantitymeasurement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.apps.quantitymeasurement.Length.LengthUnit;

class QuantityMeasurementAppTest {

	@Test
	public void testEquality_FeetToFeet_SameValue() {
		Length length1 = new Length(1.0, LengthUnit.FEET);
		Length length2 = new Length(1.0, LengthUnit.FEET);
		assertTrue(length1.equals(length2));
	}
	
	@Test
	public void testEquality_InchToInch_SameValue() {
		Length length1 = new Length(1.0, LengthUnit.INCHES);
		Length length2 = new Length(1.0, LengthUnit.INCHES);
		assertTrue(length1.equals(length2));
	}
	
	@Test
	public void testEquality_FeetToInch_EquivalentValue() {
		Length length1 = new Length(1.0, LengthUnit.FEET);
		Length length2 = new Length(12.0, LengthUnit.INCHES);
		assertTrue(length1.equals(length2));
	}
	
	@Test
	public void testEquality_FeetToFeet_DifferentValue() {
		Length length1 = new Length(1.0, LengthUnit.FEET);
		Length length2 = new Length(2.0, LengthUnit.FEET);
		assertFalse(length1.equals(length2));
	}
	
	@Test
	public void testEquality_InchToInch_DifferentValue() {
		Length length1 = new Length(1.0, LengthUnit.INCHES);
		Length length2 = new Length(2.0, LengthUnit.INCHES);
		assertFalse(length1.equals(length2));
	}
	
	@Test
	public void testEquality_InvalidUnit() {
		Length length1 = new Length(1.0, LengthUnit.INCHES);
		Exception ex = assertThrows(IllegalArgumentException.class, () -> length1.equals(new Length(1.0, LengthUnit.valueOf("METER"))));
		assertEquals("No enum constant com.apps.quantitymeasurement.Length.LengthUnit.METER", ex.getMessage());
	}
	
	@Test
	public void testEquality_NullUnit() {
		Length length1 = new Length(1.0, LengthUnit.FEET);
		Length length2 = new Length(2.0, null);
		Exception ex = assertThrows(NullPointerException.class, () -> length1.equals(length2));
		assertEquals("Cannot read field \"conversionFactor\" because \"length.unit\" is null", ex.getMessage());
	}
	
	@Test
	public void testEquality_SameReference() {
		Length length1 = new Length(1.0, LengthUnit.INCHES);
		assertTrue(length1.equals(length1));
	}
	
	@Test
	public void testEquality_NullComparison() {
		Length length1 = new Length(1.0, LengthUnit.INCHES);
		assertFalse(length1.equals(null));
	}

}
