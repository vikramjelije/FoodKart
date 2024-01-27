package Utils;

public class IDGenerator {

	private static int id;
	
	public static int getID() {
		return ++id;
	}
}
