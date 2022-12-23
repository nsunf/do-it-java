package ch02;

import java.util.ArrayList;

public class PrimeNumber2 {
	public static int maxNum = 20000;
	public static long startTime = 0;
	public static long endTime = 0;

	public static void main(String[] args) {
		primeNum1();
		
		primeNum2();
		
		primeNum3();
	}
	
	public static void primeNum1() {
		timerStart();
		ArrayList<Integer> primeNum = new ArrayList<>();
		primeNum.add(2);

		loop1: for (int i = 3; i <= maxNum; i += 2) {
			for (int j = 2; j < i; j++) {
				if (i % j == 0)
					continue loop1;
			}
			primeNum.add(i);
		}
		
		System.out.println("1 ---> " + primeNum.size());
		timerEnd();
	}
	
	public static void primeNum2() {
		timerStart();
		
		ArrayList<Integer> primeNum = new ArrayList<>();
		primeNum.add(2);
		
		loop1: for (int i = 3; i <= maxNum; i += 2) {
			for (int j = 0; j < primeNum.size(); j++) {
				if (i % primeNum.get(j) == 0)
					continue loop1;
			}
			primeNum.add(i);
		}
		
		System.out.println("2 ---> " + primeNum.size());
		timerEnd();
	}
	
	public static void primeNum3() {
		timerStart();
		
		ArrayList<Integer> primeNum = new ArrayList<>();
		primeNum.add(2);
		
		loop1: for (int i = 3; i <= maxNum; i += 2) {
			for (int j = 0; j < primeNum.size(); j++) {
				if (primeNum.get(j) > Math.sqrt(i)) break;
				if (i % primeNum.get(j) == 0) continue loop1;
			}
			primeNum.add(i);
		}
		
		System.out.println("3 ---> " + primeNum.size());
		timerEnd();
	}

	public static void timerStart() {
		startTime = System.nanoTime();
	}

	public static void timerEnd() {
		endTime = System.nanoTime();
		System.out.printf("%.5f\n", (endTime - startTime)/1000d/1000d/1000d);
	}
}
