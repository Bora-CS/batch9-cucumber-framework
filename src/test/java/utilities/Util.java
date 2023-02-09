package utilities;

public class Util {

	/*
	 * Sleeps for given number of seconds
	 * 
	 * @Author: Shaoling Stouder
	 */
	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
