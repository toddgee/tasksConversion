package tasksConversion.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import org.apache.commons.lang3.builder.ToStringBuilder;

@XmlAccessorType(XmlAccessType.FIELD)
public class Comment {

	@XmlAttribute
	public String action;
	@XmlAttribute(name="created_at")
	public String created_at;
	@XmlAttribute(name="deleted_at")
	public String deleted_at;
	@XmlAttribute
	public String message;
	@XmlAttribute
	public String picture;
	@XmlAttribute(name="target_id")
	public String target_id;
	@XmlAttribute
	public String remoteId;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
