import java.io.*;
import java.util.ArrayList;

public class ThreadPractice {

	public static void main (String[]args) {

		ArrayList<Integer> list = new ArrayList<>();

		Thread thread = new Thread("File Reader") {

			public void run() {

				File file = new File("C:\\Users\\10012826\\AndroidStudioProjects\\ThreadsPractice\\integers.txt");
				try {
					BufferedReader br = new BufferedReader(new FileReader(file));
					String st;
					while ((st = br.readLine()) != null) {
						list.add(Integer.parseInt(st));
					}
				} catch (Exception e){}
			}
		};

		thread.start();
		try {
			thread.join();
		} catch(Exception e){}

		int number = 0;

		for (int i = 0; i < list.size(); i++) {
			number+=list.get(i);
		}

		System.out.println(number);
	}

}