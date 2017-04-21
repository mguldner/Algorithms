package example.titanic.features;

public class Frame {

	private double min;
	private double max;
	
	public Frame(double min, double max) {
		this.min = min;
		this.max = max;
	}

	public double getMin() {
		return min;
	}

	public double getMax() {
		return max;
	}
}
