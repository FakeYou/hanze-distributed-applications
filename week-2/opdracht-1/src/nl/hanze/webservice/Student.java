package nl.hanze.webservice;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={
		"naam",
		"leeftijd",
		"geslacht"
})
@XmlRootElement(name="student")

public class Student {
	private static XStream xstream = new XStream(new DomDriver());

	@XmlElement(required=true)
	private String naam;
	@XmlElement(required=true)
	private int leeftijd;
	@XmlElement(required=true)
	private boolean geslacht;
	
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public int getLeeftijd() {
		return leeftijd;
	}
	public void setLeeftijd(int leeftijd) {
		this.leeftijd = leeftijd;
	}
	public boolean isGeslacht() {
		return geslacht;
	}
	public void setGeslacht(boolean geslacht) {
		this.geslacht = geslacht;
	}
	
	protected String toXML() {
        return xstream.toXML(this);
	}
}
