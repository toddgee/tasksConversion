package tasksConversion.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import org.apache.commons.lang3.builder.ToStringBuilder;

@XmlAccessorType(XmlAccessType.FIELD)
public class Metadata {

	@XmlAttribute
	public String created;
	@XmlAttribute
	public String deleted;
	@XmlAttribute
	public String key;
	@XmlAttribute
	public String value;
	@XmlAttribute
	public String value2;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
