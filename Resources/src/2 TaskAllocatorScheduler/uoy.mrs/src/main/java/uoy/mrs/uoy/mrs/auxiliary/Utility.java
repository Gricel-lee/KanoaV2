package uoy.mrs.uoy.mrs.auxiliary;

import java.io.BufferedReader;
import java.io.File;  // Import the File class
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FilenameUtils;

import uoy.mrs.uoy.mrs.error.KanoaErrorHandler;

public class Utility {
	

	public static void pauseIt(int n) {
	    try {
	            Thread.sleep(n);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	}
	
	public static int getFactorial(Integer num) {
		
		System.out.println("Fact of:");
		System.out.println(num);
		
		// max. number possible for which perm. is possible to calculate by the tool (not sure if by Python or Java)
		if (num>10) {
			num = 10; // 20 is the max. int in Java for which its factorial can be saved in an int: https://www.geeksforgeeks.org/factorial-large-number/
		}
		
		System.out.println(num);
		
		// get factorial
        int i = 1;
        int factorial = 1;
        while(i <= num)
        {
            factorial *= i;
            System.out.println(factorial);
            i++;
        }
        
        System.out.println(factorial);
        
        // set max. number of permutations
        if (factorial>Constants.maxPermutations)
        	factorial = Constants.maxPermutations;
        
        return factorial;
	}
	
	
	/**e.g. of string: "['at4_12,ct1_8']" */
	public static String[] stringToList(String s) {
		String[] result = s.replace("[", "").replace("]", "").replaceAll("'", "").split(",");
		return result;
	}
	
	
	public void makeParentFile(String file) {
		//Make XML file
    	File f = new File(file);
    	f.getParentFile().mkdirs();
	}
	
	
	public static void checkPath(String path) {
		/**Check if path exists and create one if it does not*/
		File dir = new File(path);
		if (!dir.exists()) dir.mkdirs();
	}
	
	
	//Create a new file
	//Delete if exists and create new one
	public static void createEmptyFile (String filename) {
		File file = new File(filename);
		file.delete();
    	file.getParentFile().mkdirs(); // create output file
	}
	
	
	// NOT USED as more than one MDP file
	// may be possible when >1 clusters
	// called: File fpm = Utility.getLatestFilefromDir(Constants.prismFilesDir, ".mdp");
	
	
	
	
	// Write to file, enters are added automatically "\n"
	public static void WriteToFile(String file , String newEntry) {
	    try {
	      FileWriter myWriter = new FileWriter(file,true);
	      myWriter.write(newEntry);
	      myWriter.write(System.getProperty("line.separator"));
	      myWriter.close();
	      //System.out.println("\n"+"Successfully wrote to " + file);
	    } catch (IOException e) {
	    	System.out.println("\n"+"An error occurred creating file "+file);
	    	e.printStackTrace();
	    	System.exit(0);
	    }
	  }
	/*
	 * * Copy from one file to another
	 */
	public static void FileCopy (String inputFile , String outputFile) {
		try {
			FileReader fr = new FileReader(inputFile);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(outputFile, true);
			String s;
 
			while ((s = br.readLine()) != null) { // read a line
			fw.write("\n"+ s); // write to output file
			fw.flush();
		}
		br.close();
		fw.close();
        //System.out.println("\n"+"Initialization file "+ inputFile+" copied");
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static String getNumOfAllocation(String fileName) {
		String s ="";
		String[] f =fileName.split("//");
		s = f[f.length-1].replace(".xml", "").replace("Allocation", "");;
		
		return s;
	}
	
	public static String fileToString(File pmfile){
		/**Convert path of a File type to string*/
		return pmfile.getPath();
		}
	
	/**
	 *  Get files with extension in directory
	 * @param directory
	 */
	public static File[] getFilesWithPrefix(String filesDirectory, final String prefix) {
		
		File dir = new File(filesDirectory);
		File [] files = dir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.startsWith(prefix); //e.g., ".xml"
				}
			});
		//e.g. to use in for:
		//for (File xmlfile : files) {System.out.println(xmlfile);}
		return files;
	}
	
	public static File[] getFilesFromChromosome(String filesDirectory, final String genesVal) {
		
		File dir = new File(filesDirectory);
		File [] files = dir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				String n = name;
				n = n.replaceAll("PM.mdp","").replaceAll("\\s+","");
				//System.out.println(n);
				return n.endsWith(genesVal.replaceAll("\\s+","")); //e.g., ".xml"
				}
			});
		//e.g. to use in for:
		//for (File xmlfile : files) {System.out.println(xmlfile);}
		return files;
	}
	
	/**
	 *  Get files with extension in directory
	 * @param directory
	 */
	public static File[] getFilesWithExtension(String filesDirectory, final String extension) {
		
		File dir = new File(filesDirectory);
		File [] files = dir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(extension); //e.g., ".xml"
				}
			});
		//e.g. to use in for:
		//for (File xmlfile : files) {System.out.println(xmlfile);}
		return files;
		}
	
	public static String getfileNameWithoutExtension(String file) {
		/**Get only name of a file, without path nor extension*/
		return FilenameUtils.getBaseName(file);
		}
	
	
	public static String getFileLastLine(String inputFile) {
		String lastLine = "";
		String sCurrentLine;
		try {
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
	    	while ((sCurrentLine = br.readLine()) != null) 
			{lastLine = sCurrentLine;}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	    return lastLine;
		
	}
	

	  // Read file
	  public static String FileRead (String inputFile) {
		  StringBuilder contentBuilder = new StringBuilder();
		  try (BufferedReader br = new BufferedReader(new FileReader(inputFile))){
				String s;
				while ((s = br.readLine()) != null) { // read a line
					contentBuilder.append(s).append("\n");
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  return contentBuilder.toString();
		}
	  
	  
	// Read file
		  public static String FileRead_firstLine (String inputFile) {
			  StringBuilder contentBuilder = new StringBuilder();
			  String first_line = "";
			  try (BufferedReader br = new BufferedReader(new FileReader(inputFile))){
					String s;
					first_line = br.readLine(); // remove first line
					while ((s = br.readLine()) != null) { // read a line
						contentBuilder.append(s).append("\n");
					}
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  return first_line;
			}

	
	/**Return, print and check all content in folder
	* (subfolders and files)
	*/
	public static File[] checkContentNames(String path, Boolean print, Boolean returnContent) throws IOException {
	    // get content as string
		File directoryPath = new File(path);
	    String[] contents = directoryPath.list();
	    
	    // ERROR HANDLING:
	    if (contents.length==0) {
	    	System.err.println("WARNING: No content in directory: "+directoryPath.toString());
	    	}
	    // print content
	    if (print) { // print if needed
	    	for(int i=0; i<contents.length; i++) {
	    		System.out.println("List of data in directory:"+directoryPath.toString());
	    		System.out.println(contents[i]);
	    		}
	    	}
	    if (returnContent) {
	    	return getDirContent(path);
	    }
	    return null;
	    }
	
	/**Get all content (subfolders and files) in folder **/
	public static File[] getDirContent(String path) throws IOException {
		  //Creating a File object for directory
		  File directoryPath = new File(path);
		  return directoryPath.listFiles();
	}
		    
	  
	  
	  /*
	   *  Read DSL and get num on the first line that contains string "lookForString"
	   */
	  public static String ReadDSLnumber (String lookForString, String numDefault, String dslFile) {

		  String num = numDefault;
		  
		  //default number of Alloy instances to get
		  String s;
			try (BufferedReader br = new BufferedReader(new FileReader(dslFile))){				
				while ((s = br.readLine()) != null) { // read a line
					if (s.contains(lookForString)) {
						num=s.replaceAll("\\D+",""); // get only number in String
						return num;					 // return when find declaration in DSL
				}}
				br.close();
			}
			catch (IOException e) {KanoaErrorHandler.NotAlloyFilePath();}
			return num;
		}
	  
	  
	  
	  
	  
	
	  //Remove last character of a string
	  public static String removeLastChar(String str) {
		  return removeLastChars(str, 1);
	  }
	  
	  public static String removeLastChars(String str, int chars) {
		  return str.substring(0, str.length() - chars);
	  }
	
	/** Method: Miliseconds to date
	 * @param  currentDateTime   time to change format
	 * @return 
	 * 
	 * */
	public static Date milliseconds2Date(long currentDateTime) {
		
		//creating Date from millisecond
		Date currentDate = new Date(currentDateTime);
		
		//printing value of Date
		return currentDate;
		
    }
	
	/** Method: Miliseconds to time
	 * @param  currentDateTime   time to change format
	 * 
	 * */
	public static void PrintMilliseconds2Time(long currentDateTime) {
		//creating Date format
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		
		//formatted value of current Date
		System.out.println("\n Time: " + df.format(currentDateTime));
    }
	
	
	
	public static boolean readPythonAndFeasibility(Process process)  {
		try {
			return readPython(process,true);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return false;
		
	}
		
	public static void readPython(Process process) throws IOException {
		readPython(process, false);
			
	}
		
	
	public static Boolean readPython(Process process, boolean readFeas) throws IOException {
		String lines=null;
		Boolean isempty = true; // check if nothing sent from Python
		
		Boolean feasible = true;
		
		// 4.1) read python output
    	BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    	
    	while ((lines=reader.readLine())!=null) {
			System.out.println(lines);
    		
    		if (readFeas && lines.toString().contains("Not feasible") ){
    			// Not frasible after checked each robot's allocated tasks ORDER vs ordered tasks in DSL (from Python)
    			feasible = false;
    			//System.out.println("Not feasible by checking each robot permutation of tasks");
    		}
    		else if (readFeas){
    			isempty = false;
    		}
    		else {
    			isempty = false;}
    	}
    	
    	// 4.2) read python errors
    	BufferedReader readerErr = new BufferedReader(new InputStreamReader(process.getErrorStream()));
    	if (readerErr.readLine()!=null) {
    		while ((lines=readerErr.readLine())!=null) {
        		System.err.println(lines);
        		isempty = false;
        	}
    		System.err.println("Solve the problem above from Python code.");
    		System.exit(0);
    	}
    	
    	// ERROR: If no answer received
    	if (isempty){
        	System.err.println("ERROR: No feedback from python. Check if PYTHON3_DIRECTORY is correct in config.properties."
        	+ "\nNote: Try running an example separately with python.");
        	System.exit(0);
        }

    return feasible;
	}
	
}
