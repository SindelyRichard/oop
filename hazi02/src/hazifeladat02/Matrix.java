package hazifeladat02;

import java.util.Scanner;

public class Matrix {

	public static void main(String[] args) {
		int[][] matrix = new int[4][4];
		feltolt(matrix);
		kiir(matrix);
		Scanner input = new Scanner(System.in);
		int n = beolvas(input);
		System.out.println(n);
		if (keres(matrix, n)) {
			System.out.println("A keresendő érték megtalálható a mátrixban");
		} else {
			System.out.println("A keresendő érték nem található meg a mátrixban");
		}
	}

	private static void kiir(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(" " + matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void feltolt(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = (int) (Math.random() * 100 - 1 + 1) + 1;
			}
		}
	}

	private static int beolvas(Scanner input) {
		int n = 0;
		do {
			System.out.println("Írjon be egy számot 1-100ig");
			while (!input.hasNextInt()) {
				System.out.println("A megadott érték nem szám!");
				input.next();
			}
			n = input.nextInt();
		} while (n < 1 || n > 100);
		return n;
	}

	private static boolean keres(int[][] matrix, int n) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == n) {
					return true;
				}
			}
		}
		return false;
	}

}
