public class Client2 {

	public static void main(String[] args) {
		int portW = 2021;
		int portR = 2020;
		ThreadWrite W = new ThreadWrite(portW);
		W.start();
		ThreadRead R = new ThreadRead(portR);
		R.start();
	}
}