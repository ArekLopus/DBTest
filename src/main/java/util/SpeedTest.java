package util;

public class SpeedTest {
	
	private static long start;
	private static long end;
	
	public static void start() {
		start = System.currentTimeMillis();
	}
	
	public static void end() {
		end = System.currentTimeMillis();
		System.out.println("Time: "+(end - start)+" ms");
	}
	
}
