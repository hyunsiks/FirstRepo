package javaEx;


public class B11_For {

	public static void main(String[] args) {
		
	/*
		# 반복문 (Loop)
			- for, while, do-while(안배울것임) ...등등
			- 똑같은 코드를 여러번 반복하고 싶을 때 사용한다
			
			#for (초기화; 조건; 증가값){
				가운데 있는 조건이 true인 동안 반복될 명령어들을 적는 곳
			}
	 */
//		1. 가장 기본적인 형태의 for문
//			(원하는 횟수만큼 반복하기 가장 좋은 형태의 for문)
		
		for(int i = 0; i < 5; i++) {
			System.out.println("hello, world! " + i);
		}		
		
//		2. 초기값, 증가값, 조건은 마음대로 변경할 수 있다
		for(int i = 70; i <= 555; i +=10) {
			System.out.println(i);
		}
		for(int i = 3000; i > 0; i -= 100) {
			System.out.println("2번째 반복문 : " + i);
		}
		
//		3. 초기값과 증가값의 위치는 마음대로 변경할 수 있다
		int x = 0;
		for(; x < 10 ;) {
			System.out.println("3번째 반복문 " + x++);
		}
		
//		4. 반복문 내부에 다른 문법들도 자유롭게 사용할 수 있다
		for(int month = 1; month <= 12; ++month) {
			String season;
			switch(month) {
			case 12 : case 1 : case 2 :
				season = "겨울";
				break;
			case 3 : case 4 : case 5 :
				season = "봄";
				break;
			case 6 : case 7 : case 8 :
				season = "여름";
				break;
			case 9 : case 10 : case 11 :
				season = "가을";
				break;
			default :
				season = "잘못된 입력입니다.";
				break;
			}
			System.out.printf("%02d월은 [%s]입니다. \n", month, season);
		}
		
//		5. for문은 조건을 비워놓으면 무한반복한다
//			(반복문은 원하는 타이밍에 break문을 통해 탈출할 수 있다)
		int count = 0;
		for(;;) {
			System.out.println("hello world!" + count++);
			if(count == 7)
				break;
		}
		
//		6. 반복문 내부에서 continue를 만나면 바로 다음번 반복으로 넘어간다
		for(int i = 1; i <= 50; ++i) {
			System.out.printf("%02d ", i);
			
			if(i % 10 != 0) {
			continue; //컨티뉴가 나오면 아래부분은 무시하고 다음 반복이 됨(아래있는 애들을 무시)
			}
			System.out.println();
			
		}
		
		//연습문제 : continue를 이용하여 5000부터 100사이에 존재하는 
//		 		  홀수만 출력하고, 10번 출력할때마다 줄바꿈을 할 것
		int a = 0;
		for(int i = 5000; i >= 100; --i) {
			if(i % 2 == 0) {
				continue;				
			}			
			System.out.printf("%04d ", i);
			a++;
			if(a % 10 == 0) {
				System.out.println();
			}
		}
		
//		7. 반복문으로 총합 구하기
//		 (1) 반복문 바깥쪽에 총합을 저장할 변수를 하나 선언하고 0으로 초기화 해둔다
//		 (2) 반복문을 진행하면서 해당 변수에 값을 누적시킨다
		
//		ex) 80부터 333사이의 3의 배수의 총합을 구해보기
		int sum = 0;
		for(int i = 80; i <= 333; i++) {
			if(i % 3 == 0) {
				sum += i;
			}
		}
		System.out.println("80부터 333사이의 3의 배수 총합 : " + sum);
		
		
		
	}

}
