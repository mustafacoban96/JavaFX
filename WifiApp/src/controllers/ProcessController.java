package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ProcessController {
	private static Process process;
	private static final String MY_PATH="C:/wifi-password/"; 
	
	public static void mkDirectory() throws IOException, ParserConfigurationException, SAXException {
		
		File file = new File("C:/wifi-password");
		 
				if(file.mkdir() == true) {
					try {
						commandLineWorker();
						File[] files = file.listFiles();
						for(int i = 0; i < files.length; i++){
					        String filename = files[i].getName();
					        if(filename.endsWith(".xml")||filename.endsWith(".XML")) {
					        	parserKey(filename);
					        	   
					        }
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else {
					System.out.println("not okey");
		}
		
	}
	
	@SuppressWarnings("deprecation")
	private static void commandLineWorker() throws IOException, InterruptedException {
		process = Runtime.getRuntime().exec("netsh wlan show profile");
		//process = new ProcessBuilder("netsh", "wlan","show","profile").start();
		process.waitFor();
		process = Runtime.getRuntime().exec("netsh wlan export profile folder=C:\\wifi-password\\ key=clear");
		//process = new ProcessBuilder("netsh", "wlan", "export", "profile", "folder=C:/wifi-password/" ,"key=clear").start();
		process.waitFor();
		System.out.println("command was completed....");
		Thread.sleep(1000);
	}
	
	private static void parserKey(String file_name) throws ParserConfigurationException, SAXException, IOException {
		File xmlFile = new File(MY_PATH + file_name);

	    if (xmlFile.exists()) {
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        FileInputStream inputStream = new FileInputStream(xmlFile);

	        try {
	            Document document = builder.parse(inputStream);

	            NodeList keyMaterialList = document.getElementsByTagName("keyMaterial");
	            NodeList nameList = document.getElementsByTagName("name");
	            
	            if (keyMaterialList.getLength() > 0) {
	                // Extract the text content of the <keyMaterial> element
	                String keyMaterial = keyMaterialList.item(0).getTextContent();
	                String wifiName = nameList.item(0).getTextContent();

	                // Print the extracted value
	                System.out.println(wifiName + ": " + keyMaterial);
	            } else {
	                System.out.println("<keyMaterial> element not found in the XML.");
	            }
	        } finally {
	            inputStream.close();
	        }
	    } else {
	        System.out.println("File not found: " + xmlFile.getAbsolutePath());
	    }
	}
	
	
	

}
