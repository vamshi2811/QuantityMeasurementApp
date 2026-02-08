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

	public static void main(String[] args) {
		Feet feet1 = new Feet(1.0);
		Feet feet2 = new Feet(1.0);
		System.out.println(feet1.equals(feet2));
	}

}
