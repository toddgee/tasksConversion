package tasksConversion.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@XmlAccessorType(XmlAccessType.FIELD)
public class Task {

	@XmlAttribute
	public String calendarUri;
	@XmlAttribute
	public String completed;
	@XmlAttribute
	public String created;
	@XmlAttribute
	public String deleted;
	@XmlAttribute
	public String dueDate;
	@XmlAttribute
	public String elapsedSeconds;
	@XmlAttribute
	public String estimatedSeconds;
	@XmlAttribute
	public String hideUntil;
	@XmlAttribute
	public String importance;
	@XmlAttribute
	public String modified;
	@XmlAttribute
	public String notes;
	@XmlAttribute
	public String recurrence;
	@XmlAttribute
	public String notificationFlags;
	@XmlAttribute
	public String lastNotified;
	@XmlAttribute
	public String notifications;
	@XmlAttribute
	public String snoozeTime;
	@XmlAttribute
	public String repeatUntil;
	@XmlAttribute
	public String timerStart;
	@XmlAttribute
	public String title;
	@XmlAttribute
	public String remoteId;

	@XmlElement(name="metadata")
	public List<Metadata> metadatas;
	@XmlElement(name="comment")
	public List<Comment> comments;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
