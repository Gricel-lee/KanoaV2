package uoy.mrs.uoy.mrs.types;

import java.io.File;
import java.io.FilenameFilter;

public class ProblemSpecific {
  
	public static String[] pythonDir;
	static File [] files;
	
	
	
	
	public static void getAlloyOutputFiles(String directory) {
		File dir = new File(directory);
		files = dir.listFiles(new FilenameFilter() {
		    @Override
		    public boolean accept(File dir, String name) {
		        return name.endsWith(".als");
		    }
		});	
	}
	
	public static void test_printAlloyOutputFiles() {
		getAlloyOutputFiles("/Users/gris/eclipse-workspace/uoy.mrs/resources/dslmodel/src-gen");
		for (File xmlfile : files) {
		    System.out.println(xmlfile);
		}
	}
}