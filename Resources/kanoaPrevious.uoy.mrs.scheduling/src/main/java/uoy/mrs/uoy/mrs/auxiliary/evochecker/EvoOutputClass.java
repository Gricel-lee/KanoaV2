package uoy.mrs.uoy.mrs.auxiliary.evochecker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

import uoy.mrs.uoy.mrs.auxiliary.Utility;


public class EvoOutputClass{
	
	/** DSL system specifications file*/
	public static String dslFile;
	
	public static File[] frontFiles;
	
	public static File[] setFiles;

	public File folderdata;

	public String problemName; // e.g.: 1_0  (allocation 1, cluster 0)

	public File folderNSGAII;
	
	public String frontData;
	
	public String setData;
	
	public EvoOutputClass() {};
	
	
	public static void main( File args)  throws Exception{
		EvoOutputClass eoc = new EvoOutputClass(); 	// create instance
		eoc.configData(args); 			// set variables values
		//eoc.runMRS(); 				// run code
    }
	
	
	
	/**Get data from /data/ folder */
	public void configData(File f) {
		// path to /data/ of current allocation-
		folderdata = f;
		// problem name
		problemName = Utility.getfileNameWithoutExtension(folderdata.toString());
		
		// NSGAII subfolder
		folderNSGAII = new File(folderdata.toString()+ "/NSGAII/");
		// Warning if more than two files (Front and Set) :
		if (folderNSGAII.listFiles().length>2){
			System.err.println("WARNING: Directory has more than one Front/Set pair: "+ folderNSGAII.toString());
		}
		// NSGAII files
		frontFiles = Utility.getFilesWithExtension(folderNSGAII.toString(), "Front");
		setFiles = Utility.getFilesWithExtension(folderNSGAII.toString(), "Set");
		
		//Read data
		frontData = read_data(frontFiles,true);
		setData = read_data(setFiles,false);
	}
	
	
	public String read_data(File[] files, Boolean front) {
		//Read data
		String data = "";
		String fname;
		for (File f: files) {
			
			fname = Utility.getfileNameWithoutExtension(f.toString());
			data += _fileRead_data(f.toString(),fname);
			
		}
		if (front) {
			//String firstline = read_firstLine(frontFiles)+"  FileName";
			String firstline = "Failure	Idle	Travel	File";
			System.out.println(firstline+"\n"+data);
		}
		else { // set
			String firstline = read_firstLine(files);
			System.out.println(firstline+"\n"+data);
		}
		
		
		
		return data;
		
	}
	
	
	public String read_firstLine(File[] f) {
		// read first line of first file
		// e.g. Pmin=?[G(r5_fail=0&r1_fail=0)]	R{"idle"}=?[Fdone]	R{"travelDistance"}=?[Fdone]
		return Utility.FileRead_firstLine(f[0].toString());
	}
	
	public String read_firstLine(File f) {
		// read first line
		// e.g. Pmin=?[G(r5_fail=0&r1_fail=0)]	R{"idle"}=?[Fdone]	R{"travelDistance"}=?[Fdone]
		return Utility.FileRead_firstLine(f.toString());
	}

	public void setFrontFiles(File[] files) throws Exception {
		frontFiles = files;
	}
	
	public void setSetFiles(File[] files) throws Exception {
		setFiles = files;
	}
	
	
	

	  /** Read content of data file, e.g. "1_0PM_NSGAII_145948_230522_Front" file */
	  public static StringBuilder _fileRead_data (String inputFile, String problemName) {
		  
		  StringBuilder contentBuilder = new StringBuilder();
		  String line;
		  
		  try (BufferedReader br = new BufferedReader(new FileReader(inputFile))){
				
				br.readLine(); // remove first line
				
				while ((line = br.readLine()) != null) { // read a line
					// if containts at least 1 number and not null
					if (line != null && Pattern.compile("[0-9]").matcher(line).find()) {
						// add line
						contentBuilder.append(line).append("	"+problemName+"\n");
					}
					
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  return contentBuilder;
		}
	  
	
	
}