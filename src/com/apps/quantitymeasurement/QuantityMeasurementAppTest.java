package com.apps.quantitymeasurement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.apps.quantitymeasurement.QuantityMeasurmentApp;
import com.apps.quantitymeasurement.QuantityMeasurmentApp.Feet;

public class QuantityMeasurementAppTest {
	
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


}
