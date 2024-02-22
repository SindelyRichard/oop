package hazi;

public class Ikerprim {

	public static void main(String[] args) {
		System.out.println("Házi feladat. 1.feladat");
		int db = 0;

		for (int i = 2; i < 100; i++) {
			if (primszam(i)) {
				for (int j = 2; j < 100; j++) {
					if (primszam(j) && (j - i) == 2 && j != i) {
						db++;
					}
				}

			}
		}
		System.out.println("Megoldás: " + db + " db ilyen számpár van");
	}

	public static boolean primszam(int szam) {
		if (szam <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(szam); i++) {
			if (szam % i == 0) {
				return false;
			}
		}
		return true;
	}
}
