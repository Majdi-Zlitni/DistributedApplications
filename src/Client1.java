public class Client1 {

	public static void main(String[] args) {
		int portW = 2020;
		int portR = 2021;
		ThreadWrite W = new ThreadWrite(portW);
		W.start();
		ThreadRead R = new ThreadRead(portR);
		R.start();
	}
}