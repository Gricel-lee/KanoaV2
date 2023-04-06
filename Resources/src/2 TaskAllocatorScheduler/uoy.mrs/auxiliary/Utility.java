package uoy.mrs.uoy.mrs.auxiliary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.File;  // Import the File class

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.commons.io.FilenameUtils;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Utility {
	private static Properties properties;
	private static String fileName;
	
	
	
	/**public static String setPropertiesFile (String filename) {
		fileName = filename;
		return(fileName);
	}*/
	

	public static void pauseIt(int n) {
	    try {
	            Thread.sleep(n);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	}
	
	private static void loadPropertiesInstance(){
		try {
			if (properties == null){
				properties = new Properties();
				properties.load(new FileInputStream(fileName)); //add new properties from fileName file
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static String getProperty (String key){
		loadPropertiesInstance();
		String result = properties.getProperty(key).strip(); 
		if (result == null)
			  throw new IllegalArgumentException(key.toUpperCase() + " name not found!");
		return result;		
	}
	
	public static String getProperty (String key, String defaultValue){
		loadPropertiesInstance();
		String output = properties.getProperty(key);
		return (output != null ? output : defaultValue);
	}
	
	
	public static void checkPath(String path) {
		/**Check if path exists and create one if it does not*/
		File dir = new File(path);
		if (!dir.exists()) dir.mkdirs();
	}
	
	
	//Create a new file
	//Delete if exists and create new one
	public static void CreateFile (String filename) {
	    try {
	      File file = new File(filename);
	      if (file.createNewFile()) { // file doesn't exist	        //System.out.println("Empty file created: " + file.getName());
	        ; //pass
	      } else { // file exists
	    	file.delete();
	    	file.createNewFile();							        //System.out.println("Empty file created: " + file.getName());
	      }
	    } catch (IOException e) {
	      System.out.println("\n"+"An error occurred creating file "+filename);
	      e.printStackTrace();
	      System.exit(0);
	    }
	  
	}
	
	// Write to file, enters are added automatically "\n"
	public static void WriteToFile(String file , String newEntry) {
	    try {
	      FileWriter myWriter = new FileWriter(file,true);
	      myWriter.write(newEntry);
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
	
	
	public static String fileToString(File pmfile){
		/**Convert path of a File type to string*/
		return pmfile.getPath();
		}
	
	
	
	public static File[] getFilesWithExtension(String filesDirectory, final String extension) {
		/**Get name of files ending with extension*/
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
					}
				}
				br.close();

			} catch (IOException e) {
				System.err.println("ERROR 01: Path to Alloy Input file not found \n"
						+ "\nCheck uoy.mrs.uoy.mrs.scheduling.auxiliary Constants.*DSLFILE");
				System.exit(1);
				//e.printStackTrace();
			}
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
	
	
	
	
	
}
