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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;
import org.netlib.util.doubleW;

import uoy.mrs.uoy.mrs.error.KanoaErrorHandler;

public class Utility {
	
	//*********************************************************************//
	//============== Casting type variables ====================//
	

	/**e.g. of string: "['at4_12,ct1_8']" */
	public static String[] stringToList(String s) {
		String[] result = s.replace("[", "").replace("]", "").replaceAll("'", "").split(",");
		return result;
	}
	

	/**Set to List*/
	public static ArrayList<String> setToList(Set<String> set){
		//e.g., when using hashmap.keySet()
		ArrayList<String> list = new ArrayList<String>(set);
		return list;
	}
	
	public static String fileToString(File pmfile){
		/**Convert path of a File type to string*/
		return pmfile.getPath();
		}
	
	public static Iterator<Object> collectionToIterator(Collection<Object> collection){
		//how to iterate: 
		//while (iter.hasNext()){ iter.next() }
		return collection.iterator();
	}
	
	public static Iterator<Object> arraylistToIterator(ArrayList<Object> arrayList){
		//how to iterate: 
		//while (iter.hasNext()){ iter.next() }
		return arrayList.iterator();
	}
	
	
	public static ArrayList<Object> iteratorToList(Iterator<Object> myIterator) {
		ArrayList<Object> arrayList = new ArrayList<>();
        // Convert Iterator to ArrayList
        while (myIterator.hasNext()) {
            Object item = myIterator.next();
            arrayList.add(item);
        }
		return arrayList;
	}

	/** Integer to String **/
	public static String int2string(Integer i) {
		return String.valueOf(i);
	}
	
	/** Double to String **/
	public static String doub2string(Double i) {
		return String.valueOf(i);
	}
	
	/**String to int number*/
	public static int string2int(String str) {
		int n = -100;
		if(str.contains(".")) { //e.g. "4.0"
			// parse the string as a double or float
			double doubleValue = Double.parseDouble(str);
			// cast the double to an integer
			n = (int) doubleValue;	
		}
		  else { //e.g. "2"
			  try { n = Integer.parseInt(str); }
			  catch (NumberFormatException e) {// This is not a valid integer, e.g. "abc"
				  System.err.println("Invalid number format: " + e.getMessage());
			  }
		  }
		  return n;
	}
	  
	/**String to double number*/
	public static double string2double(String str) {
		  double n = -100;
		  try { n = Double.parseDouble(str); }
		  catch (NumberFormatException e) {// This is not a valid integer, e.g. "abc"
			  System.err.println("Invalid number format: " + e.getMessage());
		  }
		  return n;
	}
	
	/**List of integers to string*/
	public static String arrayIntToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append(',');
        }
        return sb.toString();
    }
	
	
	//ArrayList<Integer> to double[]     //also works: double[] arr = res.stream().mapToDouble(Double::doubleValue).toArray(); //array to []
    public static double[] arrayInt2doubleList(ArrayList<Integer> l) {
		double[] doubleArray = new double[l.size()];
        for (int i = 0; i < l.size(); i++) {
            doubleArray[i] = l.get(i).doubleValue();
        }
        return doubleArray;
    }
    
  //ArrayList<Double> to double[]
    public static double[] arrayDouble2doubleList(ArrayList<Double> l) {
		double[] doubleArray = new double[l.size()];
        for (int i = 0; i < l.size(); i++) {
            doubleArray[i] = l.get(i).doubleValue();
        }
        return doubleArray;
    }
    	
    		
	
	
	public static boolean string2boolean(String s) {
		// .trim remove spaces 
        return Boolean.valueOf(s.trim());  //allows Boolean, which includes boolean
        // Boolean.parseBoolean(s.trim();  //only boolean
	}
	
	
	//double[] to string, e.g.: "[1.0, 40.0, 0.01604911362823439]"
	public static String arrayToString(double[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
	
	//*********************************************************************//
	//============== File related auxiliary functions ====================//
	
	public static void checkPath(String path) { //e.g. path= Constants.outputDir+"/Solutions" - make sure ends without /, i.e., "/Solutions/" not accepted
		/**Check if path exists and create one if it does not*/
		File dir = new File(path);
		if (!dir.exists()) dir.mkdirs();
	}
	
	/**Create a new file. Delete if exists and create new one*/
	public static void createEmptyFile (String filename) {
		File file = new File(filename);
		file.delete();
    	try {
			file.getParentFile().createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
	
	/**Create a new folder. Delete if exists and create new one*/
	public static void createEmptyFolder (String filename) {
		File file = new File(filename);
		file.delete();
    	file.getParentFile().mkdirs(); // create output file
	}
		
	/** Write to file, enters are added automatically "\n"*/
	public static void WriteToFile(String file , String newEntry) {
	    try {
			FileWriter myWriter = new FileWriter(file,true);
			myWriter.write(newEntry);
			myWriter.write(System.getProperty("line.separator"));
			myWriter.close();
			//System.out.println("\n"+"Successfully wrote to " + file);
	    } catch (IOException e) {
	    	System.out.println("\n"+"An error occurred writting to file: "+file);
	    	e.printStackTrace();
	    	System.exit(0);
    	}
	}
	
	/** Copy from one file to another */
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
	
	} //ERROR
		catch (IOException e) { e.printStackTrace(); System.exit(0); }
	}
	
	
	/**Make file in parent folder */
	public void makeParentFile(String filePath) {
		File f = new File(filePath); 		//to make XML file
    	f.getParentFile().mkdirs();
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
	
	
	/**Get only name of a file, without path nor extension*/
	public static String getfileNameWithoutExtension(String file) {
		return FilenameUtils.getBaseName(file);
		}
	
	/**Get last line of file*/
	public static String getFileLastLine(String inputFile) {
		String lastLine = "";
		String sCurrentLine;
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
			while ((sCurrentLine = br.readLine()) != null) 
			{lastLine = sCurrentLine;}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	    return lastLine;
		
	}
	
	
	/** Read file*/
	public static String readFile (String inputFile) {
	  StringBuilder contentBuilder = new StringBuilder();
	  try (BufferedReader br = new BufferedReader(new FileReader(inputFile))){
			String s;
			while ((s = br.readLine()) != null) { // read a line
			contentBuilder.append(s).append("\n");
		}
		br.close();
	} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	  return contentBuilder.toString();
	}
	  
	  
	/** Read file without first line */
	public static String readFile_noFirstLine (String inputFile) {
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
			e.printStackTrace();
			System.exit(0);
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
		    
	
	//*********************************************************************//
	//============== Maths ====================//
	
	public static int getFactorial(Integer num) {
		// get factorial
        int fact = 1;
        for(int i=1;i<=num;i++){    
            fact=fact*i;    
        }  
        return fact;
	}
	
	
	/**Get Euclidean distance between two locations as an integer*/
	public static int getEuclidianDistance(double x1, double x2,double y1,double y2) {
		 // Parse the coordinates as doubles
		// Calculate the Euclidean distance
        double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        // To integer
        int intdistance = (int) Math.round(distance);  //rounding to closest:
        //int intdistance = (int) distance;  //truncating
        
        if(intdistance<0) {intdistance=0;} //as a safe-guard
        return intdistance;
	}
	
	public static int checkEven(String numDescription, int num) {
		if (num % 2 != 0) {//odd
			KanoaErrorHandler.notEven(numDescription, num);
        }
		return num;
	}
	
	/**'Infinite' for integer type*/
	public static int infiniteInt = 2147483647;
	
	//*********************************************************************//
	//============== Strings ====================//
		
	/**Remove first character of a string*/
	  public static String removeFirstChars(String str,int n) {
		  return str.substring(n, str.length());
	  }
	  
	
	  /**Remove last character of a string*/
	  public static String removeLastChar(String str) {
		  return removeLastChars(str, 1);
	  }
	  
	  public static String removeLastChars(String str, int n) {
		  return str.substring(0, str.length() - n);
	  }
	  
	//*********************************************************************//
	//============== System ====================//
	
	public static void pauseIt(int n) {
	    try {
	            Thread.sleep(n);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	}
	
	//*********************************************************************//
	//============== Time ====================//
		

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
		
	
	
	//*********************************************************************//
	//============== Others ====================//
	
	
	
	/*
	*/ @Deprecated  
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
	
	
	  
  
	/*
	*  Read DSL and get num on the first line that contains string "lookForString"
	*  Depricated: DSL info is saved in infodsl.txt by Xtend
	*/ @Deprecated 
	public static String ReadDSLnumber (String lookForString, String numDefault, String dslFile) {
		String num = numDefault;
	    //default number of Alloy instances to get
	    String s;
		try (BufferedReader br = new BufferedReader(new FileReader(dslFile))){				
			while ((s = br.readLine()) != null) { // read a line
				if (s.contains(lookForString)) {
					num=s.replaceAll("\\D+",""); // get only number in String
					return num;					 // return when find declaration in DSL
			}} br.close();
		}
		catch (IOException e) {KanoaErrorHandler.NotAlloyFilePath();}
		return num;
	}
	  
	  
	  
	
	
	/*
	*/ @Deprecated 
	public static boolean readPythonAndFeasibility(Process process)  {
		try {
			return readPython(process,true);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return false;
		
	}
	
	/*
	*/ @Deprecated 
	public static void readPython(Process process) throws IOException {
		readPython(process, false);
			
	}
		
	/*
	*/ @Deprecated 
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
