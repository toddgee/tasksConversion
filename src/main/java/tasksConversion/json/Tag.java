package tasksConversion.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tag {

	@JsonProperty
	public int color;
	@JsonProperty
	public int icon;
	@JsonProperty
	public String name;
	@JsonProperty
	public int order;
	@JsonProperty
	public String remoteId;
	@JsonProperty
	public String tagOrdering;

}
