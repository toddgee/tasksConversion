package tasksConversion.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import org.apache.commons.lang3.builder.ToStringBuilder;

@XmlAccessorType(XmlAccessType.FIELD)
public class Tagdata {

	@XmlAttribute
	public String color;
	@XmlAttribute
	public String deleted;
	@XmlAttribute
	public String name;
	@XmlAttribute
	public String tagOrdering;
	@XmlAttribute
	public String remoteId;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
