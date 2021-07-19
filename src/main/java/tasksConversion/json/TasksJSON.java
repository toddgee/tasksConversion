package tasksConversion.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TasksJSON {

	@JsonProperty
	public Data data;
	@JsonProperty
	public int version;
	@JsonProperty
	public long timestamp;

}
