package javaEx;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D09_Regex {

	/*
	 	# 정규표현식 (Regular Expression)
	  
	 	 - 문자열의 패턴을 표현하는 표현식
	 	 - 특정 프로그래밍 언어에 종속되지 않는다 (다른언어에서도 쓸수있다는것)
	   	 - 프로그래머가 원하는 문자열 패턴과 일치하는지 검사할때 사용한다
	   
	 	# Pattern 클래스
	 	
	 	 - 정규표현식을 다루는 클래스
	 	 
	 	# Matcher 클래스
	 	
	 	 - 패턴 인스턴스를 이용하여 문자열을 검사할 때 사용하는 클래스
	 */
	public static void main(String[] args) {
		
		// Pattern.matches(regex, input) : input이 regex에 매치되는 문자열인지 검사해주는 메서드
		System.out.println(Pattern.matches("sleep", "sleep")); 
		
		// [] : 해당 위치의 한 글자에 어떤 문자들이 올 수 있는지 정의하는 표현식
		System.out.println(Pattern.matches("s[lh@]eep", "sleep")); //true
		System.out.println(Pattern.matches("s[lh@]eep", "sheep")); //true
		System.out.println(Pattern.matches("s[lh@]eep", "s@eep")); //true
		
		/* [] 내부에 정의할 수 있는 것들
			
			 1. abc  : 해당자리에 a 또는 b 또는 c 를 허용한다
			 2. ^abc : 해당자리에 abc를 제외한 모든것을 허용
			 3. a-z	 : a 부터 z까지 모두 허용 (딱한자리)
			 4. &&	 : 교집합
		*/
		System.out.println(Pattern.matches("s[^lh@]eep", "sㄱeep")); //2. true 
		System.out.println(Pattern.matches("s[0-9]eep", "s5eep")); //3. true 
		System.out.println(Pattern.matches("s[a-d && c-f]eep", "sdeep")); //4. true [a-d]와[c-f]사이의 교집합
		
//		Pattern instance = Pattern.compile("[0-9]@[0-9]"); //instance 인스턴스를 생성해 패턴과 같은지 검사하겠다는것
		
		/* [] 내부에 정의할 수 있는 것들
		
		 5.   .   : 모든문자를 허용한다 ※ 예외로 [] 밖에 써야 하는 문자
		 6.  \d   : 모든숫자를 허용한다 (쓸때는 역슬래쉬를 쓰기위한 역슬래쉬를 써야하므로 \\d로 쓴다)
		 7.  \D   : 숫자를 제외한 모든 것
		 8.  \s	  : 모든 공백 허용 (\t, \n, \r 스페이스 .. 등의 모든 공백들 허용)
		 9.  \S   : 공백을 제외한 모든 것
		 10. \w   : 일반적인 문자들을 허용 [a-z A-Z 0-9]
		 11. \W   : 일반적인 문자들을 제외한 모든것을 허용
	*/
		System.out.println(Pattern.matches("s.eep", "sㄱeep")); //5. true  (모든문자)
		System.out.println(Pattern.matches("s[.]eep", "sㄱeep")); // . 만허용 
		System.out.println(Pattern.matches("s\\.eep", "sㄱeep")); // . 만허용 
		System.out.println(Pattern.matches("s\\deep", "s9eep")); //6. true 
		System.out.println(Pattern.matches("s\\Deep", "sAeep")); //7. true 
		System.out.println(Pattern.matches("\\D\\D\\D", "CAT")); //7. true 
		System.out.println(Pattern.matches("s\\seep", "s eep")); //8. true 
		System.out.println(Pattern.matches("s\\Seep", "s eep")); //9. false 
		
		
		/* 해당 패턴이 적용될 문자의 개수를 정의하는 방법
		
		 1. [ex]{n}   : {}앞의 패턴이 n개 일치해야 한다
		 2. [ex]{n,m} : {}앞의 패턴이 최소n개 이상, 최대 m개(포함) 일치해야한다
		 3. [ex]{n,}  : {}앞의 패턴이 최소n개 이상일치해야 한다
		 4. [ex]? 	  : 0번 또는 한번
		 5. [ex]+	  : 최소 한번 이상
		 6. [ex]*	  : 0번 또는 여러번
	*/	
		System.out.println(Pattern.matches("[\\D]{3}", "CAT")); //1. true \\D가 세번 쓰인다는것 
		System.out.println(Pattern.matches("[\\D3-5]{5}", "CA3TS")); //1. true ('\\D' 거나 '3-5')가 5번쓰인다는것 
		System.out.println(Pattern.matches("[\\D\\d]{5}", ".--2ㅇ")); //1. true  
		System.out.println(Pattern.matches("[\\D3-5]{2,4}\\.txt", "3a!f.txt")); //2. true(2~4개 맞아야하고 위에는 .txt 적어야함)  
		System.out.println(Pattern.matches("[\\D3-5]{2,}\\.txt", "3a!f.txt")); //3. true 
		System.out.println(Pattern.matches("[가-힣]{2,}\\.txt", "안녕하세요.txt")); //3. true 
		System.out.println(Pattern.matches(".{2,}\\.txt", "안녕하세요.txt")); //3. true  (모든글자 2개이상)
		
		String a = "바보아니냐잉";
		String regex1 = String.format(".{%d}\\.txt", a.length());
		System.out.println(Pattern.matches(regex1, ".......txt"));
		
		System.out.println(Pattern.matches("[가-힣]?\\.txt", ".txt"));
		System.out.println(Pattern.matches("[가-힣]?\\.txt", "한.txt"));
		System.out.println(Pattern.matches("[가-힣]?\\.txt", "한글.txt"));
		//전화번호정규표현식
		System.out.println(Pattern.matches("\\d{3}-?\\d{3,4}-?\\d{4}", "010-1234-1234")); //4. 숫자{3}개 '-' 는 0또는 1(있거나말거나) 다음으로 숫자{3,4}개 이런식
		System.out.println(Pattern.matches("\\d{3}-?\\d{3,4}-?\\d{4}", "010-234-1234"));
		System.out.println(Pattern.matches("\\d{3}-?\\d{3,4}-?\\d{4}", "01012341234"));
		
		//연습문제 : 자바에서 허용하는 변수명을 검사할 수 있는 정규표현식을 만들어보세요
		System.out.println(Pattern.matches("[$\\w\\D][$\\w]*", "$egex1_$"));
		
	/* 
		# Pattern.compile(regex)
	
		 - 전달한 정규표현식을 해석하여 Pattern 인스턴스를 생성하고 반환한다
		 - Pattern타입 인스턴스를 요구하는 곳에 사용할 수 있다	 
		 
		# split() : 컴파일된 패턴 인스턴스로 문자열 split()을 진행한다
		
		# matcher() :Matcher 인스턴스를 생성하여 반환한다
	*/
		String fruit_text = "apple/banana/orange/grpe/pineapple/peach/mango/redapple";
		String fruit_text2 = "apple/banana/orange/grpe/pineapple/peach/mango/redapple";
		
		//split()
		fruit_text2.split("/"); //이 방법으로 나눌수도 있지만
		String[] fruits2 = fruit_text2.split("/");
		Pattern regex = Pattern.compile("/"); //이 방법으로 나누기도한다
		regex.split(fruit_text); //컴파일 방식을 인스턴스로 설정해두고 설정해둔것으로 나눈다는것
		String[] fruits = regex.split(fruit_text);
		System.out.println(Arrays.toString(fruits));
		System.out.println(Arrays.toString(fruits2));
		
//		Pattern regex2 = Pattern.compile("^a.*e$"); //a로 시작해서 e로 끝나는것
		Pattern regex2 = Pattern.compile("apple");
		
		Matcher matcher = regex2.matcher(fruit_text);
		
		while(matcher.find()) { //문자를 검색할수있다
			System.out.println("찾은 것 : " + matcher.group());
			System.out.println("위치 : " + matcher.start() + "부터 " + matcher.end() + "까지");
		}
		
	}
}



















