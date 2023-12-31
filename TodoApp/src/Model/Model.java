package Model;

import java.io.Serializable;
import java.time.LocalDate;

public class Model implements Serializable{
	// we want to add our mission into listView component as model.
	
	private static final long serialVersionUID=1L;
	private LocalDate localDate;
	private String descriptionMission;
	
	public Model(LocalDate localDate, String descriptionMission) {
		
		this.localDate = localDate;
		this.descriptionMission = descriptionMission;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public String getDescriptionMission() {
		return descriptionMission;
	}

	public void setDescriptionMission(String descriptionMission) {
		this.descriptionMission = descriptionMission;
	}
	
	@Override
	public String toString() {
		
		String dataString = "Görev zamanı: " + this.getLocalDate() +" -----> "+ "\tGörev Tanımı: " + this.getDescriptionMission();
		
		return dataString;
	}
	
	
	
	
	 
}
