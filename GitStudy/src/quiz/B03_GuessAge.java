package quiz;

import java.util.Scanner;

public class B03_GuessAge {

	// 사용자로부터 태어난 해와 올해의 년도를 입력받으면
	// 그 사람의 한국 나이를 계산하여 몇 살인지 알려주는 프로그램을 만들어보세요
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("태어난 년도를 입력하시오 >> ");
		int bornYear = sc.nextInt();
		System.out.print("올해의 년도를 입력하시오 >> ");
		int year = sc.nextInt();
		System.out.println("당신이 태어난 년도는 " + (year - bornYear + 1) + "입니다.");
		
	}
	
}
