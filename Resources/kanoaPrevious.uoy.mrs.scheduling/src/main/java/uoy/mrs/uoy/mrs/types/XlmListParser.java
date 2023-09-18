package uoy.mrs.uoy.mrs.types;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;



/**
 * An XML parser for item lists
*/
public class XlmListParser {
/**
Constructs a parser that can parse item lists
*/
	public XlmListParser() {
		
		
		
		//////////////////
		DocumentBuilderFactory dbfactory  = DocumentBuilderFactory.newInstance();
		try { builder = dbfactory.newDocumentBuilder();	}
		catch (ParserConfigurationException e) {e.printStackTrace();}
		XPathFactory xpfactory = XPathFactory.newInstance();
		path = xpfactory.newXPath();
	}
	
	
	public void another(String fileName) {
		try {
		    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder builder = factory.newDocumentBuilder();
		    Document doc = builder.parse(fileName); // Replace with your XML file path or input source

		    // Get the root element
		    Element root = doc.getDocumentElement();
		    
		    // Get the "alloy" element and its "builddate" attribute
		    String builddate = root.getAttribute("builddate");
		    System.out.println("Builddate: " + builddate);

		    // Get the "instance" element and its attributes
		    Element instance = (Element) root.getElementsByTagName("instance").item(0);
		    String bitwidth = instance.getAttribute("bitwidth");
		    String maxseq = instance.getAttribute("maxseq");
		    String command = instance.getAttribute("command");
		    String filename = instance.getAttribute("filename");
		    System.out.println("Bitwidth: " + bitwidth);
		    System.out.println("Maxseq: " + maxseq);
		    System.out.println("Command: " + command);
		    System.out.println("Filename: " + filename);
		    
		    
		 // Iterate through the "sig" elements
		    NodeList fieldList = instance.getElementsByTagName("field");
		    for (int i = 0; i < fieldList.getLength(); i++) {
		        Element field = (Element) fieldList.item(i);
		        String label = field.getAttribute("label");
		        if("capability".equals(label)) {
		        	NodeList tupleList = field.getElementsByTagName("tuple");
                    for (int j = 0; j < tupleList.getLength(); j++) {
                    	Element tuple = (Element) tupleList.item(j);
                        Node atom1 = tuple.getElementsByTagName("atom").item(0);
                        Node atom2 = tuple.getElementsByTagName("atom").item(1);
                        String atom1Label = ((Element) atom1).getAttribute("label").split("\\$")[0];
                        System.out.println("Tuple - Atom 1 Label: " + atom1Label);
                        String atom2Label = ((Element) atom2).getAttribute("label").split("\\$")[0];
                        System.out.println("Tuple - Atom 2 Label: " + atom2Label);
                    }
		        }
		    }
		    
		    // Iterate through the "sig" elements
		    NodeList sigList = instance.getElementsByTagName("sig");
		    for (int i = 0; i < sigList.getLength(); i++) {
		        Element sig = (Element) sigList.item(i);
		        String label = sig.getAttribute("label");
		        String ID = sig.getAttribute("ID");
		        String parentID = sig.getAttribute("parentID");
		        String builtin = sig.getAttribute("builtin");
		        String lone = sig.getAttribute("lone");

		        System.out.println("Sig Label: " + label);
		        System.out.println("Sig ID: " + ID);
		        System.out.println("Parent ID: " + parentID);
		        System.out.println("Builtin: " + builtin);
		        System.out.println("Lone: " + lone);

		        // If needed, you can further process the elements inside each "sig" element
		    }

		    // Similarly, iterate through and process the "field" elements and other elements as needed.

		} catch (Exception e) {
		    e.printStackTrace();
		}

	}
	
	
	
 
    /**
       Parses an XML file containing an item list
       @param fileName the name of the file
       @return an array list containing all items in the XML file
    */
	
	//public ArrayList<String> parse(String fileName){
	public void parse(String fileName){
    	File f = new File(fileName);
    	Document doc;
		try {
			doc = builder.parse(f);
			ArrayList<String> items = new ArrayList<String>();
	    	int itemCount = Integer.parseInt(path.evaluate(
	             "count(/alloy[1]/*)", doc));
	    	System.out.println(itemCount);
	    	System.out.println("hiiii");
	    	
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
//    	for (int i = 1; i <= itemCount; i++)
//    	{
//          String description = path.evaluate(
//                "/items/item[" + i + "]/product/@label", doc);
//          System.out.println(description);
////          
////          double price = Double.parseDouble(path.evaluate(
////                "/items/item[" + i + "]/product/price", doc));
////          Product pr = new Product(description, price);
////          int quantity = Integer.parseInt(path.evaluate(
////                "/items/item[" + i + "]/quantity", doc));
////          LineItem it = new LineItem(pr, quantity);
////          items.add(it);
//       }
//       return items;
    }
 
    private DocumentBuilder builder;
    private XPath path;
}
