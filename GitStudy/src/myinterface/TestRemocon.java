package myinterface;

import myobj.remote.AirconditionRemocon;

//인터페이스를 통해 결합도가 낮은 코드를 작성할 수 있다
public class TestRemocon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test(new AirconditionRemocon());
	}
	
	public static void test(Remocon remocon) {
		remocon.power();
		remocon.up(1);
		remocon.down(1);
		remocon.change();
	}
}
