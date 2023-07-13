/*
		 * 10개의 수를 입력 받아, 그 중에서 홀수만 더한 값을 출력
		 * (각 수는 0 이상 10000 이하의 정수이다.)
		 */
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			int sum = 0;
			
			for (int i = 0; i < 10; i++) {
				int num = sc.nextInt();
				
				if (num % 2 != 0) sum += num; 
			}
			
			System.out.printf("#%d %d\n", t + 1, sum);
		}