package missionSerializer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Model.Model;

public class MissionSerializer {
	
	private static final String DATA_PATH="data.bin";
	
	public static void serialize(Object[] missions) throws IOException{
		
		try(var serializer = new ObjectOutputStream(new FileOutputStream(DATA_PATH))){
			serializer.writeObject(missions);
		}
	}
	
	public static Model[] deserializer() throws IOException,ClassNotFoundException{
		
		try(var deserializer = new ObjectInputStream(new FileInputStream(DATA_PATH))){
			Object[] gorev = (Object[]) deserializer.readObject();
			Model[] myArray = new Model[gorev.length];
			
			for(int i= 0; i<gorev.length; i++) {
				myArray[i] = (Model) gorev[i];
			}
			return myArray;
		}
	}
}
