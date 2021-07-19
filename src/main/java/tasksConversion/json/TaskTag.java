package tasksConversion.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskTag {

	@JsonProperty
	public String name;
	@JsonProperty
	public String tagUid;

}
