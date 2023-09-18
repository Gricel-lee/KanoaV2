package uoy.mrs.uoy.mrs.auxiliary;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import uoy.mrs.uoy.mrs.types.ProblemSpecification;
import uoy.mrs.uoy.mrs.types.impl.Allocation;



/**
 * An XML parser for item lists
*/
public class XlmAllocParser {
 
	private DocumentBuilder builder;
	private XPath path;
	
	/**
	 * Read allocation - Alloy output file .xml
	 */
	public XlmAllocParser() {
		DocumentBuilderFactory dbfactory  = DocumentBuilderFactory.newInstance();
		try { builder = dbfactory.newDocumentBuilder();	}
		catch (ParserConfigurationException e) {e.printStackTrace();}
		XPathFactory xpfactory = XPathFactory.newInstance();
		path = xpfactory.newXPath();
	}
	
	
	/**
	 * Parses an XML file containing an Alloy allocation
	 * @param fileName the name of the file
	 * @return an array list containing alloy/instance in the XML file
	 */
	public Allocation parse(String fileName, ProblemSpecification problemSpec) {
	    Allocation allocation = null;

		try {
			HashMap<String, String> cap_to_robot = new HashMap<String, String>();
			HashMap<String, ArrayList<String>> robot_to_atomicTasks = new HashMap<String, ArrayList<String>>();
			
		    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder builder = factory.newDocumentBuilder();
		    Document doc = builder.parse(fileName); // Replace with your XML file path or input source
		    // Get the root element - alloy
		    Element root = doc.getDocumentElement();
		    // Get the element - instance
		    Element instance = (Element) root.getElementsByTagName("instance").item(0);
		    // Iterate through the "field" elements
		    NodeList fieldList = instance.getElementsByTagName("field");
		    for (int i = 0; i < fieldList.getLength(); i++) {
		        Element field = (Element) fieldList.item(i);
		        String label = field.getAttribute("label");
		        // -- capability
		        if("capability".equals(label)) {
		        	NodeList tupleList = field.getElementsByTagName("tuple");
                    for (int j = 0; j < tupleList.getLength(); j++) {
                    	
                    	Element tuple = (Element) tupleList.item(j);
                        //robot
                    	Node atom1 = tuple.getElementsByTagName("atom").item(0);
                        String robot = ((Element) atom1).getAttribute("label").split("\\$")[0]; //System.out.println("Tuple - Atom 1 Label: " + robot);
                        //capab
                        Node atom2 = tuple.getElementsByTagName("atom").item(1);
                        String capability = ((Element) atom2).getAttribute("label").split("\\$")[0]; //System.out.println("Tuple - Atom 2 Label: " + capability);
                        //------ save capab-robot 
                        cap_to_robot.put(capability,robot); //each capability belongs to one robot
                    }
		        }
		        // -- atomic tasks assigned (do)   //e.g.: <field label="do" ID="23" parentID="11"> \n   <tuple> <atom label="r5at1$0"/> <atom label="at1_1$0"/> </tuple>
		        if("do".equals(label)) {
		        	NodeList tupleList = field.getElementsByTagName("tuple");
                    for (int j = 0; j < tupleList.getLength(); j++) {
                    	Element tuple = (Element) tupleList.item(j);
                        //capab
                    	Node atom1 = tuple.getElementsByTagName("atom").item(0);
                    	String capability = ((Element) atom1).getAttribute("label").split("\\$")[0];//System.out.println("Tuple - Atom 1 Label: " + capability);
                        //atomic task
                    	Node atom2 = tuple.getElementsByTagName("atom").item(1);
                        String atomicTask = ((Element) atom2).getAttribute("label").split("\\$")[0];//System.out.println("Tuple - Atom 2 Label: " + atomicTask);
                        //robot
                        String r = cap_to_robot.get(capability);
                        if (robot_to_atomicTasks.keySet().contains(r)) {
                        	robot_to_atomicTasks.get(r).add(atomicTask);
                        }
                        else {
                        	ArrayList<String> myList = new ArrayList<>(); myList.add(atomicTask);
                        	robot_to_atomicTasks.put(r, myList );
            }}}}
	        // -- create allocation
		    allocation = new Allocation(robot_to_atomicTasks, fileName);
		    // --print
	        if(Constants.verbose) { allocation.print(); }
	        //System.out.println(fileName);
            //System.out.println(cap_to_robot); //e.g. {r4at1=r4, r5at1=r5, r1at4=r1, r1at2=r1, r1at3=r1}
	        //System.out.println(robot_to_atomicTasks); //e.g. {r4=[at1_1, at1_2], r5=[at1_1, at1_2], r1=[at4_6, at4_9, at4_3, at4_12, at3_13, at3_7, at3_4, at3_10, at2_11, at2_14, at2_8, at2_5]}
	      	        
		} catch (Exception e) {e.printStackTrace();}
		return allocation;
	}
	
	
}
