package Tasks;

/*
 * instance method gets the memory at the time of object creation, 
 * each object will have the copy of the instance method, 
 */
public class Bike1 {
	private int distance;
	private int time;
	private double speed;

	// static method not used
	public double convertMeterPerSecondToKilometerPerSecond(double speed) {
		return speed * 18 / 5;
	}

	public Bike1(int distance, int time) {
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
		Bike1 b1 = new Bike1(4, 2);
		Bike1 b2 = new Bike1(10, 2);
		System.out.println(b1.toCalculateSpeed() + " km/hr");
		System.out.println(b2.toCalculateSpeed() + " km/hr");
	}
}
