package tasksConversion.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CaldavTask {

	@JsonProperty
	public String calendar;
	@JsonProperty
	public int deleted;
	@JsonProperty
	public int lastSync;
	@JsonProperty
	public String object;
	@JsonProperty
	public String remoteId;

}
