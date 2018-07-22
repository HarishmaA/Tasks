package Tasks;
//static variable will get the memory only once

public class Bike {
	private int distance;
	private int time;
	private double speed;

	public static double convertMeterPerSecondToKilometerPerSecond(double speed) {
		return speed * 18 / 5;
	}

	public Bike(int distance, int time) {
		this.distance = distance;
		this.time = time;
	}

	public double toCalculateSpeed() {
		// double result = this.distance/this.time;
		this.speed = this.distance / this.time;
		// this.speed=convertMeterPerSecondToKilometerPerSecond(result);
		this.speed = convertMeterPerSecondToKilometerPerSecond(this.speed);
		return this.speed;
	}

	public static void main(String[] args) {
		Bike b1 = new Bike(4, 2);
		Bike b2 = new Bike(10, 2);
		System.out.println(b1.toCalculateSpeed() + " km/hr");
		System.out.println(b2.toCalculateSpeed() + " km/hr");
	}
}
