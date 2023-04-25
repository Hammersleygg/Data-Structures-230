public class hashFunction{

	public static int hFunction(String key) {
		int i;
		
		char k;
		int total = 1;
		for(i = 1; i < key.length() + 1; i++) {
			k = key.charAt(i - 1);
			total = (total * ((k + 1) * i) % 24583);
		}
		return total;
	}
}
