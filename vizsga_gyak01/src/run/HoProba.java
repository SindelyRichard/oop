package run;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import enums.Mertekegyseg;
import exception.InvalidMertekegysegException;
import homerseklet.Homerseklet;

public class HoProba {

	public static void main(String[] args) throws InvalidMertekegysegException {
		ArrayList<Homerseklet> array = new ArrayList<Homerseklet>();
		filebolOlvas(array);
		System.out.println(array.get(0).getHomerseklet() + " " + array.get(0).getMertekegyseg().name() + " : "
				+ Homerseklet.convert(array.get(0).getHomerseklet(), Mertekegyseg.KELVIN) + " KELVIN");
		System.out.println(array.get(1).getHomerseklet() + " " + array.get(1).getMertekegyseg().name() + " : "
				+ Homerseklet.convert(array.get(1).getHomerseklet(), Mertekegyseg.CELSIUS) + " CELSIUS");
		System.out.println("Szamitas");
		System.out.println("Az atlag homerseklet: " + atlag(array) + " KELVIN");
		kiir(array);
		convertToOneMertekegyseg(array);
		kiir(array);
		filebaIr(array);
		Comparator<Homerseklet> c = new Comparator<Homerseklet>() {
			public int compare(Homerseklet o1, Homerseklet o2) {
				return (int) (o1.getHomerseklet() - o2.getHomerseklet());
			}
		};
		array.sort(c.reversed());
		kiir(array);
		int index = Collections.binarySearch(array, new Homerseklet(28), c); //28 CELSIUS erteket keresi
		System.out.println("A keresett elem:" + array.get(index));
	}

	public static void convertToOneMertekegyseg(ArrayList<Homerseklet> array) {
		try (Scanner input = new Scanner(System.in)) {
			int n = 0;
			do {
				System.out.println("1 - KELVIN , 2 - CELSIUS");
				while (!input.hasNextInt()) {
					System.out.println("That's not a number");
				}
				n = input.nextInt();
			} while (n != 2 && n != 1);

			for (int i = 0; i < array.size(); i++) {
				if (n == 1) {
					if (array.get(i).getMertekegyseg().equals(Mertekegyseg.CELSIUS)) {
						array.get(i).setMertekegyseg(Mertekegyseg.KELVIN);
						array.get(i).setHomerseklet(
								Homerseklet.convert(array.get(i).getHomerseklet(), Mertekegyseg.KELVIN));
					}
				} else {
					if (array.get(i).getMertekegyseg().equals(Mertekegyseg.KELVIN)) {
						array.get(i).setMertekegyseg(Mertekegyseg.CELSIUS);
						array.get(i).setHomerseklet(
								Homerseklet.convert(array.get(i).getHomerseklet(), Mertekegyseg.CELSIUS));
					}
				}
			}
		}
	}

	public static double homersekletErtek() {
		try (Scanner inp = new Scanner(System.in)) {
			int n = 0;
			do {
				System.out.println("Enter a number 15 or 300");
				while (!inp.hasNextInt()) {
					System.out.println("That's not a number");
					inp.next();
				}
				n = inp.nextInt();
			} while (n != 15 && n != 300);

			return (double) n;
		}
	}

	public static void kiir(ArrayList<Homerseklet> array) {
		System.out.println("Tömb elemeinek listázása:");
		for (int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i));
		}
	}

	public static double atlag(ArrayList<Homerseklet> array) {
		double sum = 0;
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i).getMertekegyseg().equals(Mertekegyseg.CELSIUS)) {
				sum += Homerseklet.convert(array.get(i).getHomerseklet(), Mertekegyseg.KELVIN);
			} else
				sum += array.get(i).getHomerseklet();
		}
		return sum / array.size();
	}

	public static void filebaIr(ArrayList<Homerseklet> array) {
		File outputFile = new File("mertekegysegek.txt");
		try (FileWriter wr = new FileWriter(outputFile)) {
			for (int i = 0; i < array.size(); i++) {
				wr.write("Homerseklet: " + array.get(i).getHomerseklet() + " Mertekegyseg: "
						+ array.get(i).getMertekegyseg().name() + "\n");
			}
			System.out.println("Fajlba iras sikeres!");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void filebolOlvas(ArrayList<Homerseklet> array) throws InvalidMertekegysegException {
		File inputFile = new File("input.txt");

		try (FileReader in = new FileReader(inputFile); BufferedReader read = new BufferedReader(in)) {
			String line;

			while ((line = read.readLine()) != null) {
				String[] temp = line.split(";");
				array.add(new Homerseklet(Integer.parseInt(temp[0]), temp[1]));
			}
			System.out.println("Filebol olvasas sikeres!");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
