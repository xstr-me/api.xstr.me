package me.xstr.api.models.anidb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement(name = "title")
@XmlAccessorType(XmlAccessType.NONE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnidbRawTitle {	
	
	@XmlAttribute
    private String type;
	
	@XmlAttribute(name="lang",namespace="http://www.w3.org/XML/1998/namespace")
    private String language;
	
	@XmlValue
    private String title;

}
