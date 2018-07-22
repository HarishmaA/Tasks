package CollectionRealWorldExample;

public class Bike {
	private String brandName;
	private double mileageInkgml;
	private double engineDisplacementIncc;
	private int stdWarranty;

	public Bike(String brandName, double mileageInkgml, double engineDisplacementIncc, int stdWarranty) {
		this.brandName = brandName;
		this.mileageInkgml = mileageInkgml;
		this.engineDisplacementIncc = engineDisplacementIncc;
		this.stdWarranty = stdWarranty;

	}

	public String getBrandName() {
		return this.brandName;
	}

	public double getMileageInkgml() {
		return this.mileageInkgml;
	}

	public double getEngineDisplacementIncc() {
		return this.engineDisplacementIncc;
	}

	public int getStdWarranty() {
		return this.stdWarranty;
	}
	@Override
	public String toString() {
		return "   The brandName is "+getBrandName() + "\n" +"The mileage is " +getMileageInkgml()+" kgml \nThe Engine Displacement is " + getEngineDisplacementIncc()+" cc \nThe Standard Warranty is " + getStdWarranty()+" years\n\n";
	}
}
