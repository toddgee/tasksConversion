package tasksConversion.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CaldavCalendar {

	@JsonProperty
	public int access;
	@JsonProperty
	public String account;
	@JsonProperty
	public int color;
	@JsonProperty
	public int icon;
	@JsonProperty
	public String name;
	@JsonProperty
	public int order;
	@JsonProperty
	public String url;
	@JsonProperty
	public String uuid;

}
