package controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProcessController {
	private static Process process;
	
	
	
	
	
	public static void mkDirectory() throws IOException {
		
		File file = new File("C:/wifi-password");
		 
				if(file.mkdir() == true) {
					try {
						commandLineWorker();
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
	}
	
	

}
