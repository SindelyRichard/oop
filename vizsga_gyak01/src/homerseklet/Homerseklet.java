package homerseklet;

import enums.Mertekegyseg;
import exception.InvalidMertekegysegException;

public class Homerseklet {
	private double homerseklet;
	private Mertekegyseg mertekegyseg;

	public Homerseklet(double homerseklet, String mertekegyseg) throws InvalidMertekegysegException {
		if(!(Mertekegyseg.CELSIUS.name().equals(mertekegyseg) || Mertekegyseg.KELVIN.name().equals(mertekegyseg))) {
			throw new InvalidMertekegysegException(mertekegyseg);
		}
		this.homerseklet = homerseklet;
		this.mertekegyseg = Mertekegyseg.valueOf(mertekegyseg);
	}

	public Homerseklet(double homerseklet) {
		this.homerseklet = homerseklet;
		this.mertekegyseg = Mertekegyseg.CELSIUS;
	}

	public void setHomerseklet(double homerseklet) {
		this.homerseklet = homerseklet;
	}

	public void setMertekegyseg(Mertekegyseg mertekegyseg) {
		this.mertekegyseg = mertekegyseg;
	}

	public double getHomerseklet() {
		return this.homerseklet;
	}

	public Mertekegyseg getMertekegyseg() {
		return this.mertekegyseg;
	}

	public static double convert(double homerseklet, Mertekegyseg mertekegyseg) {
		if (mertekegyseg.equals(Mertekegyseg.CELSIUS)) {
			return homerseklet - 273.15;
		} else if (mertekegyseg.equals(Mertekegyseg.KELVIN)) {
			return 273.15 + homerseklet;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Homerseklet: " + homerseklet + " Mertekegyseg: " + mertekegyseg;
	}
}
