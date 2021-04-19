package quiz;

import java.util.Arrays;

public class C01_FunctionQuiz {

	/*
	  # ������ �Լ��� �����ϰ� �ùٸ��� �����ϴ��� �׽�Ʈ�غ�����
	  
	  	1. ������ ���ڰ� ���ĺ��̸� true�� ��ȯ, �ƴϸ� false�� ��ȯ�ϴ� �Լ�
	  	2. ������ ���ڰ� 3�� ����̸� true�� ��ȯ, �ƴϸ� false�� ��ȯ�ϴ� �Լ�
	  	3. ���ڸ� �ϳ� �����ϸ� ���ڿ� "¦���Դϴ�" �Ǵ� "Ȧ���Դϴ�"�� ��ȯ�ϴ� �Լ�
	  	4. ���ڸ� �����ϸ� �ش� ������ ��� ����� �迭 ���·� ��ȯ�ϴ� �Լ�
	  	5. ������ ������ �Ҽ���� true�� ��ȯ�ϰ� �ƴϸ� false�� ��ȯ�ϴ� �Լ�
	  	6. ���ڸ� �����ϸ� �ش� ������ ���丮�� ����� ��ȯ�ϴ� �Լ�
	  		(factorial : ���޹��� ���ں��� 1���� ���̸鼭 ��� ���ϴ°�)
	 */
	
	public static void main(String[] args) {
	
		System.out.println("1������ : " + alphabet('c'));
		System.out.println("2������ : " + threeTimes(36));
		System.out.println("3������ : " + evenOdd(25));
		System.out.print("4������ : ");
		
			System.out.print(Arrays.toString(findDevide(30)));
		
		System.out.println();
		System.out.println("5������ : " + prime(17));
		System.out.println("6������ : " + factorial(5));
	}
	//1
	public static boolean alphabet(char ch) {
		return(ch >= 'A' && ch <= 'z');
	}
	//2
	public static boolean threeTimes(int num) {
		
		return num % 3 == 0;
	}
	//3
	public static String evenOdd(int num) {
		
		return num % 2 == 0? "¦���Դϴ�" : "Ȧ���Դϴ�";
	}
//  4. ���ڸ� �����ϸ� �ش� ������ ��� ����� �迭 ���·� ��ȯ�ϴ� �Լ�
//	public static int[] yaksu(int num) {
//			
//		int count = 0;
//		for(int i = 2; i < num; i++) {
//			if(num % i == 0) {
//				count++;
//			}
//		}
//		int[] arr = new int[count - 1];
//	
//		String sum = "";
//		for(int i = 2; i < num; i++) { //num�� 5�϶� 2,3,4�� üũ
//			if(num % i == 0) {			//2,3,4 �� ������ �������°� ������
//				
//				sum += i + " ";					
//				
//			}
//			
//		}
//		sum.split(sum);
//		return arr;
//	}
	public static int[] findDevide(int num) {
		
		boolean[] divide = new boolean[num];
		
		int count = 0;
		for(int i = 1; i < num; i++) {
			if(num % i == 0) {
				divide[i - 1] = true;
				count++;
			}
		}
		int[] result = new int[count];
		int index = 0;
		for(int i = 0; i < divide.length; i++) {
			if(divide[i]) {
				result[index++] = i + 1;
			}
		}
		return result;
	}
	
//  5. ������ ������ �Ҽ���� true�� ��ȯ�ϰ� �ƴϸ� false�� ��ȯ�ϴ� �Լ�
	public static boolean prime(int num) {
		for(int i = 2; i < num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
//  6. ���ڸ� �����ϸ� �ش� ������ ���丮�� ����� ��ȯ�ϴ� �Լ�
	public static int factorial(int num) {
		int sum = 1;
		for(int i = num; i > 1; i--) {
			sum *= i;
		}
		return sum;
	}
}