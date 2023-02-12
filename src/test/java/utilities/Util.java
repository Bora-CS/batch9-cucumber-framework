package utilities;

public class Util {
	
/* addNumbers function
 * author zulfia
 */
	public static void main(String[]argrs) {
		
		welcome();
	}
	
	
	
	    	
	    public static void welcome() {
	    	System.out.println("Welcome to challanges!");
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
