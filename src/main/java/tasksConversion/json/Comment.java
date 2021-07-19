package tasksConversion.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Comment {

	@JsonProperty
	public long created;
	@JsonProperty
	public String message;
	@JsonProperty
	public String picture;
	@JsonProperty
	public String remoteId;

}
