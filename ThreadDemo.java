 public class ThreadDemo {

 	public static void main (String[]args) {

		Thread t1 = new Thread("Thread 1") {

			public void run() {
				for (int i = 1; i <= 10; i++) {
					System.out.println(getName()+ " " + i);
				}
			} //Run

		}; //Thread 1

		Thread t2 = new Thread("Thread 2") {

			public void run() {
				for (int i = 1; i <= 10; i++) {
					System.out.println(getName()+ " " + i);
				}
			} //Run

		}; //Thread 2

		t1.start();
		t2.start();
		try {
			t1.join();				//Makes MAIN THREAD wait until Thread 1 finishes --> Thread 2 and Main Thread continue in random order
			t2.join();				//Makes MAIN THREAD start after Threads 1 & 2 finish
		} catch (Exception e) {}

		for (int i = 1; i <= 10; i++) {
			System.out.println("Main Thread " + i);
		}
	} //Main


 } //Class