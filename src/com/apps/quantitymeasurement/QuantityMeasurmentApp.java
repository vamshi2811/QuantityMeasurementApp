package com.apps.quantitymeasurement;

public class QuantityMeasurmentApp {

	public static class Feet {
		private final double value;

		public Feet(double value) {
			this.value = value;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null || this.getClass() != obj.getClass()) {
				return false;
			}
			if (!(obj instanceof Feet)) {
				return false;
			}
			Feet feet = (Feet) obj;
			if (Double.compare(this.value, feet.value) == 0) {
				return true;
			}
			return false;
		}
	}
	
	public static class Inches{
		private final double value;

		public Inches(double value) {
			this.value = value;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null || this.getClass() != obj.getClass()) {
				return false;
			}
			if (!(obj instanceof Inches)) {
				return false;
			}
			Inches inches = (Inches) obj;
			if (Double.compare(this.value, inches.value) == 0) {
				return true;
			}
			return false;
		}
	}

	private static void demonstrateInchesEquality() {
		Inches inches1 = new Inches(1.0);
		Inches inches2 = new Inches(1.0);
		System.out.println(inches1.equals(inches2));
	}

	private static void demonstrateFeetEquality() {
		Feet feet1 = new Feet(1.0);
		Feet feet2 = new Feet(1.0);
		System.out.println(feet1.equals(feet2));
	}
	
	public static void main(String[] args) {
		demonstrateFeetEquality();
		demonstrateInchesEquality();
	}
}
