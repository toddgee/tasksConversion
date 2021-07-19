package tasksConversion.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskData {

	@JsonProperty
	public long completionDate;
	@JsonProperty
	public long creationDate;
	@JsonProperty
	public long deletionDate;
	@JsonProperty
	public long dueDate;
	@JsonProperty
	public long elapsedSeconds;
	@JsonProperty
	public long estimatedSeconds;
	@JsonProperty
	public long hideUntil;
	@JsonProperty
	public boolean isCollapsed;
	@JsonProperty
	public long modificationDate;
	@JsonProperty
	public String notes;
	@JsonProperty
	public int priority;
	@JsonProperty
	public int reminderFlags;
	@JsonProperty
	public long reminderLast;
	@JsonProperty
	public long reminderPeriod;
	@JsonProperty
	public long reminderSnooze;
	@JsonProperty
	public String remoteId;
	@JsonProperty
	public long repeatUntil;
	@JsonProperty
	public long timerStart;
	@JsonProperty
	public String title;

}
