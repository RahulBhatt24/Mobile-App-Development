public class ThreadDemo2 {

	static int i = 0;
	static int si = 0;

	public static synchronized void addMethod() {
		si++;
	}

	public static void main (String[]args) {

		for (int j = 0; j < 200; j++ )
			new MyThread().start();
		try {
			Thread.sleep(5000);
		} catch(Exception e) {}
		System.out.println("value of i: " + i);
				System.out.println("value of si: " + si);

	}

	public static class MyThread extends Thread {

		public void run() {
			try {
				Thread.sleep(2);
			} catch(Exception e) {}
			i++;
			addMethod();
		}

	}

}