package yahtzee;



public class YahzteeMain {

	public static Thread guiThread;  
	
	/**
	 * All this main class does is launch the thread
	 * @param args
	 */
	public static void main(String[] args) {
		
		//This creates and runs the thread object that starts the GUI frame
		guiThread = new Thread(new GuiThread2016());
		guiThread.start();
		
		
	}


}
