package com.rommelrico.trainings.jaxrs;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CheckList", namespace = "rommelrico.com")
public class ChecksList {
	
	private List<Check> checks;

	public List<Check> getChecks() {
		return checks;
	}

	public void setChecks(List<Check> checks) {
		this.checks = checks;
	}
	 
	

}
