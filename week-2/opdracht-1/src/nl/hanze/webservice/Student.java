package nl.hanze.webservice;

import com.thoughtworks.xstream.XStream;

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
	private XStream xstream = new XStream();
	
	@XmlElement(required=true)
	private String naam;
	@XmlElement(required=true)
	private int leetijd;
	@XmlElement(required=true)
	private boolean geslacht;
	
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public int getLeetijd() {
		return leetijd;
	}
	public void setLeetijd(int leetijd) {
		this.leetijd = leetijd;
	}
	public boolean isGeslacht() {
		return geslacht;
	}
	public void setGeslacht(boolean geslacht) {
		this.geslacht = geslacht;
	}
	
	protected String toXML() {
		//week 2, opgave 1a
        return xstream.toXML(this);
	}
}
