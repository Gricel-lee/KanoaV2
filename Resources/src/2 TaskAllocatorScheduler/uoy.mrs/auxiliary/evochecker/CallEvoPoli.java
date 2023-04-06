package uoy.mrs.uoy.mrs.auxiliary.evochecker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mdpSynthesis.MainMDPSynthesis;
import uoy.mrs.uoy.mrs.auxiliary.Constants;
import uoy.mrs.uoy.mrs.auxiliary.Utility;
import uoy.mrs.uoy.mrs.RunApp;


public class CallEvoPoli{
	
	
	public static void main(String[] args) {

		for (String element : Arrays.asList("config3.properties","config4.properties")) {
			System.out.println("\n\n\n\nRunning EvoPoli..." + element);
			String configFile1 = element; //"resources/config.properties";
			
			MainMDPSynthesis evopoli1 = new mdpSynthesis.MainMDPSynthesis();
			evopoli1.specifyCommandLine(configFile1);
			
		}
	}
	
	public static void runEvoPoli() {
		
		
		for (File evofile : RunApp.mdp_pm_files) {
			String configFile1 = "/Users/gris/eclipse-workspace/uoy.mrs/tests/TestEvoPoli/config.properties"; //"resources/config.properties";
			
			System.out.println("\n\nRunning EvoPoli...");
			System.out.println("...config.prop: "+ configFile1);
			
			
			MainMDPSynthesis evopoli1 = new mdpSynthesis.MainMDPSynthesis();
			evopoli1.specifyCommandLine(configFile1);
		}
		
		try {
			
			for (File evofile : RunApp.mdp_pm_files) {
				System.out.println(evofile.toString());
			}
			
			for (File evofile : RunApp.mdp_pm_files) {
				
				String configFile = EvoConfigName(evofile); //"resources/config.properties";
				
				System.out.println("\n\n\n\nRunning EvoPoli...");
				System.out.println("...config.prop: "+ configFile);
				
				
				MainMDPSynthesis evopoli = new mdpSynthesis.MainMDPSynthesis();
				evopoli.specifyCommandLine(configFile);
				
			}
		
		} 
		catch (Exception e) {
			//evochecker.auxiliary.Utility.cleanPropertiesInstance(); //added Gris
			e.printStackTrace();
			System.err.println("EvoChecker error");
			System.exit(0);
		}
	}
	
	
	/** Get all content (subfolders and files) in folder.*/
	public static String EvoConfigName(File filepm) {
		String evofile = Utility.fileToString(filepm);
		String id = Utility.getfileNameWithoutExtension(evofile);
		// return config.properties file name 
		String configFile = Constants.EVOCONFIGPROP + id +"config.properties";
		return configFile;
	}
	
	
	
	
	
	
	
	
	
	/**Get subfolders in /data folder from EvoChecker output
	 * @throws Exception */
	private static void getDataSubFolders(){
		try {
		//get subfolders of /data/
		File[] folderData = Utility.checkContentNames(Constants.EVOCHECKER_OUTPUT_DIR,true,true);
		
		for(File f : folderData) {
			
			try {
				// Create EvoChecker output class
				EvoOutputClass eoc = new EvoOutputClass();
				eoc.configData(f);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		} 
	   }
	
	public static void readEvoPoli() throws IOException{
		getDataSubFolders();
	}
}



