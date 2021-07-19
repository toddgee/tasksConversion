package tasksConversion.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@XmlRootElement(name="astrid")
@XmlAccessorType(XmlAccessType.FIELD)
public class Astrid {

	@XmlAttribute
	public String version;
	@XmlAttribute
	public String format;

	@XmlElement(name="task")
	public List<Task> tasks;
	@XmlElement(name="tagdata")
	public List<Tagdata> tagdatas;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Tagdata> getTagdatas() {
		return tagdatas;
	}

	public void setTagdatas(List<Tagdata> tagdatas) {
		this.tagdatas = tagdatas;
	}
}
