package exception;


public class InvalidMertekegysegException extends Exception {
	private String mertekegyseg;

	public InvalidMertekegysegException(String message, String mertekegyseg) {
		super(message);
		this.mertekegyseg = mertekegyseg;
	}

	public InvalidMertekegysegException(String mertekegyseg) {
		this("Invalid mertekegyseg: " + mertekegyseg, mertekegyseg);
	}

	public String getMertekegyseg() {
		return this.mertekegyseg;
	}
}
