package utilities;

public class Util {
	
/* helloWorld function
 * author zulfia
 */
	
	public static void main(String[]args) {
		
	}
	public static int addNumbers(int a, int b) {
	    return a + b;
	}

	/*
	 * Sleeps for given number of seconds
	 */
	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
