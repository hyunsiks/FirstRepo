package javaEx;


public class A01_Escape {

	public static void main(String[] args) {
		
		/*
			# Escape ����
				
				- Ư���� ����� ���� ���ڵ�
				- �׳� ����Ϸ��� �ϸ� ������ �߻��ϴ� Ư���� ���ڵ�
				- �տ� \(��������)�� ���� ���ڴ� Escape���ڷ� �����Ѵ�
				- �տ� ���� \�� ���� ���ڰ� �������� �ϳ��� ���ڷ� �νĵȴ�
		 */
		
		System.out.println("�ȳ��ϼ���, �ݰ����ϴ�.");

		// \n : ���� �ٲ��� ����� ���� ����(linefeed, breakline, newline, ...)
		System.out.println("�ȳ��ϼ���, ��\n��\n��\n�ϴ�.");
		
		// \t : TabŰ�� ����� ���� Ư�� ����
		System.out.println("�ȳ��ϼ���, ��\t��\t��\t�ϴ�.");
		
		// \\ : Escape������ ����� �̿����� �ʰ� �׳� ����ϰ� ������ ���		
		System.out.println("�ȳ��ϼ���, ��\\t��\\t��\\t�ϴ�.");
		System.out.println("C:\\Program Files\\Java\\JDK");
		
		// \" : �׳� ū ����ǥ�� ����ϰ� ���� �� ����Ѵ�
		System.out.println("������ �������� \"�Ŷ��\"�� �Ծ�߰ڴ�");
		
		// \' : �׳� ���� ����ǥ�� ����ϰ� ���� �� ����Ѵ�
		System.out.println("������ �������� '�Ŷ��'�� �Ծ�߰ڴ�"); //��������ǥ�� �׳� ��°����ϴ� �׷���.
		System.out.println("������ �������� \'�Ŷ��\'�� �Ծ�߰ڴ�");
		System.out.println('\''); //�̰�쿡�� �������� (''')
	}
}