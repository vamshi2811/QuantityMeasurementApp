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
		assertEquals("Cannot read field \"conversionFactor\" because the return value of \"com.apps.quantitymeasurement.Length.getUnit()\" is null", ex.getMessage());
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
	public void testEquality_YardToYard_SameValue() {
		Length length1 = new Length(1.0, LengthUnit.YARDS);
		Length length2 = new Length(1.0, LengthUnit.YARDS);
		assertTrue(length1.equals(length2));
	}
	
	@Test
	public void testEquality_YardToYard_DifferentValue() {
		Length length1 = new Length(2.0, LengthUnit.YARDS);
		Length length2 = new Length(1.0, LengthUnit.YARDS);
		assertFalse(length1.equals(length2));
	}
	
	@Test
	public void testEquality_YardToFeet_EquivalentValue() {
		Length length1 = new Length(1.0, LengthUnit.YARDS);
		Length length2 = new Length(3.0, LengthUnit.FEET);
		assertTrue(length1.equals(length2));
	}
	
	@Test
	public void testEquality_FeetToYard_EquivalentValue() {
		Length length1 = new Length(3.0, LengthUnit.FEET);
		Length length2 = new Length(1.0, LengthUnit.YARDS);
		assertTrue(length1.equals(length2));
	}
	
	@Test
	public void testEquality_YardToInches_EquivalentValue() {
		Length length1 = new Length(1.0, LengthUnit.YARDS);
		Length length2 = new Length(36.0, LengthUnit.INCHES);
		assertTrue(length1.equals(length2));
	}
	
	@Test
	public void testEquality_InchesToYard_EquivalentValue() {
		Length length1 = new Length(36.0, LengthUnit.INCHES);
		Length length2 = new Length(1.0, LengthUnit.YARDS);
		assertTrue(length1.equals(length2));
	}
	
	@Test
	public void testEquality_YardToFeet_NonEquivalentValue() {
		Length length1 = new Length(1.0, LengthUnit.YARDS);
		Length length2 = new Length(2.0, LengthUnit.FEET);
		assertFalse(length1.equals(length2));
	}
	
	@Test
	public void testEquality_centimetersToInches_EquivalentValue() {
		Length length1 = new Length(1.0, LengthUnit.CENTIMETERS);
		Length length2 = new Length(0.393701, LengthUnit.INCHES);
		assertTrue(length1.equals(length2));
	}
	
	@Test
	public void testEquality_centimetersToFeet_NonEquivalentValue() {
		Length length1 = new Length(1.0, LengthUnit.CENTIMETERS);
		Length length2 = new Length(1.0, LengthUnit.FEET);
		assertFalse(length1.equals(length2));
	}
	
	@Test
	public void testEquality_YardWithNullUnit() {
		Length length1 = new Length(1.0, LengthUnit.YARDS);
		Length length2 = new Length(1.0, null);
		Exception ex = assertThrows(NullPointerException.class, () -> length1.equals(length2));
		assertEquals("Cannot read field \"conversionFactor\" because the return value of \"com.apps.quantitymeasurement.Length.getUnit()\" is null", ex.getMessage());
	}
	
	@Test
	public void testEquality_YardSameReference() {
		Length length1 = new Length(1.0, LengthUnit.YARDS);
		assertTrue(length1.equals(length1));
	}
	
	@Test
	public void testEquality_YardNullComparison() {
		Length length1 = new Length(1.0, LengthUnit.YARDS);
		assertFalse(length1.equals(null));
	}
	
	@Test
	public void testEquality_CentimetersWithNullUnit() {
		Length length1 = new Length(1.0, LengthUnit.CENTIMETERS);
		Length length2 = new Length(1.0, null);
		Exception ex = assertThrows(NullPointerException.class, () -> length1.equals(length2));
		assertEquals("Cannot read field \"conversionFactor\" because the return value of \"com.apps.quantitymeasurement.Length.getUnit()\" is null", ex.getMessage());
	}
	
	@Test
	public void testEquality_CentimetersSameReference() {
		Length length1 = new Length(1.0, LengthUnit.CENTIMETERS);
		assertTrue(length1.equals(length1));
	}
	
	@Test
	public void testEquality_CentimetersNullComparison() {
		Length length1 = new Length(1.0, LengthUnit.CENTIMETERS);
		assertFalse(length1.equals(null));
	}
	
	/*
	 * @Test public void testEquality_AllUnits_ComplexScenario() { Length length1 =
	 * new Length(2.0, LengthUnit.YARDS); Length length2 = new Length(6.0,
	 * LengthUnit.FEET); Length length3 = new Length(72.0, LengthUnit.INCHES);
	 * assertTrue(length1.equals(length2)); assertTrue(length2.equals(length3));
	 * assertTrue(length1.equals(length3)); }
	 */
	
	/*
	 * @Test public void testEquality_MultiUnit_TransitiveProperty() { Length
	 * length1 = new Length(1.0, LengthUnit.YARDS); Length length2 = new Length(3.0,
	 * LengthUnit.FEET); Length length3 = new Length(36.0, LengthUnit.INCHES);
	 * assertTrue(length2.equals(length3)); assertTrue(length1.equals(length3));
	 * assertTrue(length1.equals(length2)); }
	 */
	
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
	
	@Test
	public void testConversion_FeetToInches() {
		assertEquals(String.valueOf(12.0), QuantityMeasurementApp.demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCHES).toString());
	}
	
	@Test
	public void testConversion_InchesToFeet() {
		assertEquals(String.valueOf(2.0), QuantityMeasurementApp.demonstrateLengthConversion(24.0, LengthUnit.INCHES, LengthUnit.FEET).toString());
	}
	
	@Test
	public void testConversion_YardsToInches() {
		assertEquals(String.valueOf(36.0), QuantityMeasurementApp.demonstrateLengthConversion(1.0, LengthUnit.YARDS, LengthUnit.INCHES).toString());
	}
	
	@Test
	public void testConversion_InchesToYards() {
		assertEquals(String.valueOf(2.0), QuantityMeasurementApp.demonstrateLengthConversion(72.0, LengthUnit.INCHES, LengthUnit.YARDS).toString());
	}
	
	@Test
	public void testConversion_FeatToYard() {
		assertEquals(String.valueOf(2.0), QuantityMeasurementApp.demonstrateLengthConversion(6.0, LengthUnit.FEET, LengthUnit.YARDS).toString());
	}
	
	@Test
	public void testConversion_RoundTrip_PreservesValue() {
		assertEquals(String.valueOf(6.0), (QuantityMeasurementApp.demonstrateLengthConversion(Double.parseDouble(QuantityMeasurementApp.demonstrateLengthConversion(6.0, LengthUnit.FEET, LengthUnit.YARDS).toString()), LengthUnit.YARDS, LengthUnit.FEET)).toString());
	}

	@Test
	public void testConversion_ZeroValue() {
		assertEquals(String.valueOf(0.0), QuantityMeasurementApp.demonstrateLengthConversion(0.0, LengthUnit.FEET, LengthUnit.INCHES).toString());
	}
	
	@Test
	public void testConversion_NegativeValue() {
		assertEquals(String.valueOf(-12.0), QuantityMeasurementApp.demonstrateLengthConversion(-1.0, LengthUnit.FEET, LengthUnit.INCHES).toString());
	}
	
	@Test
	public void testConversion_InvalidUnit_Throws() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> QuantityMeasurementApp.demonstrateLengthConversion(-1.0, LengthUnit.valueOf("METER"), LengthUnit.INCHES).toString());
		assertEquals("No enum constant com.apps.quantitymeasurement.Length.LengthUnit.METER", ex.getMessage());
	}
	
	@Test
	public void testConversion_NaNOrInfinite_Throws() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> QuantityMeasurementApp.demonstrateLengthConversion(Double.NEGATIVE_INFINITY, LengthUnit.FEET, LengthUnit.INCHES).toString());
		assertEquals("Infinite or NaN", ex.getMessage());
	}

	@Test
	public void testConversion_PrecisionTolerance() {
		assertEquals(String.valueOf(Math.floor(1.2E7)), QuantityMeasurementApp
				.demonstrateLengthConversion(1e6, LengthUnit.FEET, LengthUnit.INCHES).toString());
	}
	/*
	 * @Test public void testConversion_CentimetersToInches() {
	 * assertEquals(String.valueOf(~1.0),
	 * QuantityMeasurementApp.demonstrateLengthConversion(2.54,
	 * LengthUnit.CENTIMETERS, LengthUnit.INCHES).toString()); }
	 */
	
	@Test
	public void testAddition_SameUnit_FeetPlusFeet() {
		Length length1 = new Length(1.0, LengthUnit.FEET);
		Length length2 = new Length(2.0, LengthUnit.FEET);
		assertEquals(String.valueOf(3.0), QuantityMeasurementApp.demonstrateLengthAddition(length1, length2).toString());
	}
	
	@Test
	public void testAddition_SameUnit_InchPlusInch() {
		Length length1 = new Length(6.0, LengthUnit.INCHES);
		Length length2 = new Length(6.0, LengthUnit.INCHES);
		assertEquals(String.valueOf(12.0), QuantityMeasurementApp.demonstrateLengthAddition(length1, length2).toString());
	}
	
	@Test
	public void testAddition_CrossUnit_FeetPlusInches() {
		Length length1 = new Length(1.0, LengthUnit.FEET);
		Length length2 = new Length(12.0, LengthUnit.INCHES);
		assertEquals(String.valueOf(2.0), QuantityMeasurementApp.demonstrateLengthAddition(length1, length2).toString());
	}
	
	@Test
	public void testAddition_CrossUnit_InchPlusFeet() {
		Length length1 = new Length(12.0, LengthUnit.INCHES);
		Length length2 = new Length(1.0, LengthUnit.FEET);
		assertEquals(String.valueOf(24.0), QuantityMeasurementApp.demonstrateLengthAddition(length1, length2).toString());
	}
	
	@Test
	public void testAddition_CrossUnit_YardPlusFeet() {
		Length length1 = new Length(1.0, LengthUnit.YARDS);
		Length length2 = new Length(3.0, LengthUnit.FEET);
		assertEquals(String.valueOf(2.0), QuantityMeasurementApp.demonstrateLengthAddition(length1, length2).toString());
	}
	
	@Test
	public void testAddition_CrossUnit_CentimeterPlusInch() {
		Length length1 = new Length(2.54, LengthUnit.CENTIMETERS);
		Length length2 = new Length(1.0, LengthUnit.INCHES);
		assertEquals(String.valueOf(5.08), QuantityMeasurementApp.demonstrateLengthAddition(length1, length2).toString());
	}
	
	@Test
	public void testAddition_Commutavity() {
		Length length1 = new Length(1.0, LengthUnit.FEET);
		Length length2 = new Length(12.0, LengthUnit.INCHES);
		
		Length length3 = new Length(12.0, LengthUnit.INCHES);
		Length length4 = new Length(1.0, LengthUnit.FEET);
		
		Length resultLength1 = QuantityMeasurementApp.demonstrateLengthAddition(length1, length2);
		
		Length resultLength2 = QuantityMeasurementApp.demonstrateLengthAddition(length3, length4);
		assertTrue(resultLength1.convertTo(resultLength2.getUnit()).equals(resultLength2));
	}

	@Test
	public void testAddition_WithZero() {
		Length length1 = new Length(5.0, LengthUnit.FEET);
		Length length2 = new Length(0.0, LengthUnit.INCHES);
		assertEquals(String.valueOf(5.0), QuantityMeasurementApp.demonstrateLengthAddition(length1, length2).toString());
	}
	
	@Test
	public void testAddition_NegativeValues() {
		Length length1 = new Length(5.0, LengthUnit.FEET);
		Length length2 = new Length(-2.0, LengthUnit.FEET);
		assertEquals(String.valueOf(3.0), QuantityMeasurementApp.demonstrateLengthAddition(length1, length2).toString());
	}
	
	@Test
	public void testAddition_NullSecondOperand() {
		Length length1 = new Length(5.0, LengthUnit.FEET);
		Length length2 = null;
		Exception ex = assertThrows(NullPointerException.class, () -> QuantityMeasurementApp.demonstrateLengthAddition(length1, length2));
		assertEquals("Cannot read field \"value\" because \"length\" is null", ex.getMessage());
	}

	@Test
	public void testAddition_LargeValues() {
		Length length1 = new Length(1e6, LengthUnit.FEET);
		Length length2 = new Length(1e6, LengthUnit.FEET);
		assertEquals(String.valueOf(2e6), QuantityMeasurementApp.demonstrateLengthAddition(length1, length2).toString());
	}
	
	@Test
	public void testAddition_SmallValues() {
		Length length1 = new Length(0.004, LengthUnit.FEET);
		Length length2 = new Length(0.005, LengthUnit.FEET);
		assertEquals(String.valueOf(0.01), QuantityMeasurementApp.demonstrateLengthAddition(length1, length2).toString());
	}
	
	@Test
	public void testAddition_ExplicitTargetUnit_Feet() {
		Length length1 = new Length(1.0, LengthUnit.FEET);
		Length length2 = new Length(12.0, LengthUnit.INCHES);
		assertEquals(String.valueOf(2.0), QuantityMeasurementApp.demonstrateLengthAddAndConvert(length1, length2, LengthUnit.FEET).toString());
	}

	@Test
	public void testAddition_ExplicitTargetUnit_Inches() {
		Length length1 = new Length(1.0, LengthUnit.FEET);
		Length length2 = new Length(12.0, LengthUnit.INCHES);
		assertEquals(String.valueOf(24.0),
				QuantityMeasurementApp.demonstrateLengthAddAndConvert(length1, length2, LengthUnit.INCHES).toString());
	}
	  
	@Test
	public void testAddition_ExplicitTargetUnit_Yards() {
		Length length1 = new Length(1.0, LengthUnit.FEET);
		Length length2 = new Length(12.0, LengthUnit.INCHES);
		assertEquals(String.valueOf(0.67),
				QuantityMeasurementApp.demonstrateLengthAddAndConvert(length1, length2, LengthUnit.YARDS).toString());
	}

	@Test
	public void testAddition_ExplicitTargetUnit_Centimeters() {
		Length length1 = new Length(1.0, LengthUnit.INCHES);
		Length length2 = new Length(1.0, LengthUnit.INCHES);
		assertEquals(String.valueOf(5.08), QuantityMeasurementApp
				.demonstrateLengthAddAndConvert(length1, length2, LengthUnit.CENTIMETERS).toString());
	}
			  
	@Test
	public void testAddition_ExplicitTargetUnit_SameAsFirstOperand() {
		Length length1 = new Length(2.0, LengthUnit.YARDS);
		Length length2 = new Length(3.0, LengthUnit.FEET);
		assertEquals(String.valueOf(3.0),
				QuantityMeasurementApp.demonstrateLengthAddAndConvert(length1, length2, LengthUnit.YARDS).toString());
	}
	
	@Test
	public void testAddition_ExplicitTargetUnit_SameAsSecondOperand() {
		Length length1 = new Length(2.0, LengthUnit.YARDS);
		Length length2 = new Length(3.0, LengthUnit.FEET);
		assertEquals(String.valueOf(9.0),
				QuantityMeasurementApp.demonstrateLengthAddAndConvert(length1, length2, LengthUnit.FEET).toString());
	}
	
	@Test
	public void testAddition_ExplicitTargetUnit_Commutavity() {
		Length length1 = new Length(1.0, LengthUnit.FEET);
		Length length2 = new Length(12.0, LengthUnit.INCHES);
		
		Length length3 = new Length(12.0, LengthUnit.INCHES);
		Length length4 = new Length(1.0, LengthUnit.FEET);
		
		Length resultLength1 = QuantityMeasurementApp.demonstrateLengthAddAndConvert(length1, length2, LengthUnit.YARDS);
		
		Length resultLength2 = QuantityMeasurementApp.demonstrateLengthAddAndConvert(length3, length4, LengthUnit.YARDS);
		
		assertTrue(resultLength1.equals(resultLength2));
	}
	
	@Test
	public void testAddition_ExplicitTargetUnit_WithZero() {
		Length length1 = new Length(5.0, LengthUnit.FEET);
		Length length2 = new Length(0.0, LengthUnit.INCHES);
		assertEquals(String.valueOf(1.67),
				QuantityMeasurementApp.demonstrateLengthAddAndConvert(length1, length2, LengthUnit.YARDS).toString());
	}
	
	@Test
	public void testAddition_ExplicitTargetUnit_NegativeValues() {
		Length length1 = new Length(5.0, LengthUnit.FEET);
		Length length2 = new Length(-2.0, LengthUnit.FEET);
		assertEquals(String.valueOf(36.0),
				QuantityMeasurementApp.demonstrateLengthAddAndConvert(length1, length2, LengthUnit.INCHES).toString());
	}
	
	@Test
	public void testAddition_ExplicitTargetUnit_NullTargetUnit() {
		Length length1 = new Length(1.0, LengthUnit.FEET);
		Length length2 = new Length(12.0, LengthUnit.INCHES);
		Exception ex = assertThrows(NullPointerException.class, () -> QuantityMeasurementApp.demonstrateLengthAddAndConvert(length1, length2, null));
		assertEquals("Cannot read field \"conversionFactor\" because \"toTargetUnit\" is null", ex.getMessage());
	}
	
	@Test
	public void testAddition_ExplicitTargetUnit_LargeToSmallScale() {
		Length length1 = new Length(1000.0, LengthUnit.FEET);
		Length length2 = new Length(500.0, LengthUnit.FEET);
		assertEquals(String.valueOf(18000.0),
				QuantityMeasurementApp.demonstrateLengthAddAndConvert(length1, length2, LengthUnit.INCHES).toString());
	}
	
	@Test
	public void testAddition_ExplicitTargetUnit_SmallToLargeScale() {
		Length length1 = new Length(12.0, LengthUnit.INCHES);
		Length length2 = new Length(12.0, LengthUnit.INCHES);
		assertEquals(String.valueOf(0.67),
				QuantityMeasurementApp.demonstrateLengthAddAndConvert(length1, length2, LengthUnit.YARDS).toString());
	}
	
	@Test
	public void testAddition_ExplicitTargetUnit_AllUnitComibinations() {
		//TODO : Multiple combinations lengths addition and target to specific unit
	}
			 
}
