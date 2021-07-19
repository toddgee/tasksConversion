package tasksConversion.json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {

	@JsonProperty
	public List<Alarm> alarms = new ArrayList<>();
	@JsonProperty
	public List<String> attachments = new ArrayList<>();
	@JsonProperty
	public List<CaldavTask> caldavTasks = new ArrayList<>();
	@JsonProperty
	public List<Comment> comments = new ArrayList<>();
	@JsonProperty
	public List<String> geofences = new ArrayList<>();
	@JsonProperty
	public List<String> google = new ArrayList<>();
	@JsonProperty
	public List<String> locations = new ArrayList<>();
	@JsonProperty
	public List<TaskTag> tags = new ArrayList<>();
	@JsonProperty
	public TaskData task;

}
