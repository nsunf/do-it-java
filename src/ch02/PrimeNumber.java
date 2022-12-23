package ch02;

public class PrimeNumber {
	public static void main(String[] args) {
		primeNum1();

		primeNum2();

		primeNum3();
	}
	
	public static void primeNum1() {
		long start = System.nanoTime();
		int count = 0;
		int idx = 0;
		int[] primes = new int[500];

		for (int n = 2; n <= 1000; n++) {
			int i;
			for (i = 2; i < n; i++) {
				count++; // % 연산 카운트
				if (n % i == 0)
					break;
			}
			if (n == i) {
				primes[idx++] = n;
//				System.out.println(n);
			}
		}

		long end = System.nanoTime();
		double time = (end - start) / 1000d / 1000d / 1000d;

		System.out.println("primeNum1() : " + count);
		System.out.printf("%.6f\n", time);
		System.out.println(primes.length);
	}
	
	public static void primeNum2() {
		long start = System.nanoTime();
		int count = 0;
		int idx = 0;
		
		int[] primes = new int[500];
		primes[idx++] = 2;

		for (int n = 3; n < 1000; n += 2) {
			int i = 0;
			for (i = 1; i < idx; i++) {
				count++; // % 연산 카운트
				if (n % primes[i] == 0)
					break;
			}
			if (i == idx)
				primes[idx++] = n;
		}
		
//		for (int i = 0; i < idx; i++) {
//			System.out.println(prime[i]);
//		}

		long end = System.nanoTime();
		double time = (end - start) / 1000d / 1000d / 1000d;
		System.out.println("primeNum2() : " + count);
		System.out.printf("%.6f\n", time);
		System.out.println(primes.length);
	}
	
	public static void primeNum3() {
		long start = System.nanoTime();
		
		int count = 0;
		int idx = 0;
		int[] primes = new int[500];
		
		primes[idx++] = 2;
		primes[idx++] = 3;
		
		for (int n = 5; n <= 1000; n += 2) {

			boolean flag = false;
			for (int i = 0; primes[i] * primes[i] <= n; i++) {
				count += 2; // * 연산, % 연산 카운트
				if (n % primes[i] == 0) {
					flag = true;
					break;
				}
			}
			
			if (!flag) {
				primes[idx++] = n;
				count++; // * 연산 카운트
			}
		}
		
		long end = System.nanoTime();
		double time = (end - start) / 1000d / 1000d / 1000d;
		System.out.println("primeNum3() : " + count);
		System.out.printf("%.6f\n", time);
		System.out.println(primes.length);
	}
}
