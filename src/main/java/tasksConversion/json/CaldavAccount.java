package tasksConversion.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CaldavAccount {

	@JsonProperty
	public int accountType;
	@JsonProperty
	public boolean isCollapsed;
	@JsonProperty
	public boolean isSuppressRepeatingTasks;
	@JsonProperty
	public String name;
	@JsonProperty
	public int serverType;
	@JsonProperty
	public String url;
	@JsonProperty
	public String username;
	@JsonProperty
	public String uuid;

}
