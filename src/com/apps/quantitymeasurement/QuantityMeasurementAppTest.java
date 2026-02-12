package com.apps.quantitymeasurement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.apps.quantitymeasurement.QuantityMeasurmentApp.Feet;
import com.apps.quantitymeasurement.QuantityMeasurmentApp.Inches;

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
	
	@Test
	public void testFeetEquality_SameValue() {
		Feet feet1 = new Feet(1.0);
		Feet feet2 = new Feet(1.0);
		assertTrue(feet1.equals(feet2));
	}
	
	@Test
	public void testFeetEquality_DifferenceValue() {
		Feet feet1 = new Feet(1.0);
		Feet feet2 = new Feet(2.0);
		assertFalse(feet1.equals(feet2));
	}
	
	@Test
	public void testFeetEquality_NullComparison() {
		Feet feet1 = new Feet(1.0);
		Feet feet2 = null;
		assertFalse(feet1.equals(feet2));
	}
	
	@Test
	public void testFeetEquality_DifferentClass() {
		Feet feet1 = new Feet(1.0);
		Feet feet2 = new Feet(1.0);
		assertTrue(feet1.getClass() == feet2.getClass());
	}
	
	@Test
	public void testFeetEquality_SameReference() {
		Feet feet1 = new Feet(1.0);
		assertTrue(feet1.equals(feet1));
	}
	
	@Test
	public void testInchesEquality_SameValue() {
		Inches inches1 = new Inches(1.0);
		Inches inches2 = new Inches(1.0);
		assertTrue(inches1.equals(inches2));
	}
	
	@Test
	public void testInchesEquality_DifferenceValue() {
		Inches inches1 = new Inches(1.0);
		Inches inches2 = new Inches(2.0);
		assertFalse(inches1.equals(inches2));
	}
	
	@Test
	public void testInchesEquality_NullComparison() {
		Inches inches1 = new Inches(1.0);
		Inches inches2 = null;
		assertFalse(inches1.equals(inches2));
	}
	
	@Test
	public void testInchesEquality_DifferentClass() {
		Inches inches1 = new Inches(1.0);
		Inches inches2 = new Inches(1.0);
		assertTrue(inches1.getClass() == inches2.getClass());
	}
	
	@Test
	public void testInchesEquality_SameReference() {
		Inches inches1 = new Inches(1.0);
		assertTrue(inches1.equals(inches1));
	}

}
