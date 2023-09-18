package uoy.mrs.uoy.mrs.auxiliary;



/**
 * Timers to check time
 * @author Gricel
 *
 */
public class Timer {
	
	public Timer()	{
		
	} 
	
	// for tracking time from the beggining
	private static long trackTime; //nanosec
	
	// for timing algorithms, function, etc. 
	public static long restartTimer; //nanosec
	
	
	/**
	 *  Initialise timer (do it just once)
	 */
	public static void startTimer() {
		restartTimer = System.nanoTime();
		trackTime = System.nanoTime();
	}
	
	/**
	 * Get duration and reset (ms)
	 * @return
	 */
	public static long getTime_restart() {
		// get duration from init() to now
		long duration = (System.nanoTime() - restartTimer)/1000000;  //divide by 1000000 to get milliseconds.
		// restart
		restartTimer = System.nanoTime();
		
		return (duration);
	}
	
	/**
	 *  Get duration from last timer reset (ms)
	 * @return
	 */
	public static long getTime_no_restart() {
		// get duration from init() to now
		long duration = (System.nanoTime() - restartTimer)/1000000;  //divide by 1000000 to get milliseconds.
		
		return (duration);
	}
	
	
	/**
	 * Return total time (from the beginning, not from restarting timer)
	 * @return
	 */
	public static long getTimeSoFar() {
		long duration = (System.nanoTime() - trackTime)/1000000;  //divide by 1000000 to get milliseconds.
		
		return (duration);
	}
	
		
	
}
