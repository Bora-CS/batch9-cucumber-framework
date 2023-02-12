package utilities;

public class Util1 {

	public static String startsWith(String[]arry,String startsWith) {
		String lcStartsWith = startsWith.toLowerCase();
		for (String element:arry) {
			if(element.toLowerCase().startsWith(lcStartsWith)) {
				return element;
			}
		}
			
		return "";
		
		

	}

}
