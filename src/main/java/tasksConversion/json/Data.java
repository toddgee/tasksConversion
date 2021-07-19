package tasksConversion.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {

	@JsonProperty
	public Map<String, String> boolPrefs = new HashMap<>();
	@JsonProperty
	public List<CaldavAccount> caldavAccounts = new ArrayList<>();
	@JsonProperty
	public List<CaldavCalendar> caldavCalendars = new ArrayList<>();
	@JsonProperty
	public List<String> filters = new ArrayList<>();
	@JsonProperty
	public List<String> googleTaskAccounts = new ArrayList<>();
	@JsonProperty
	public List<String> googleTaskLists = new ArrayList<>();
	@JsonProperty
	public Map<String, String> intPrefs = new HashMap<>();
	@JsonProperty
	public Map<String, String> longPrefs = new HashMap<>();
	@JsonProperty
	public List<String> places = new ArrayList<>();
	@JsonProperty
	public Map<String, String> stringPrefs = new HashMap<>();
	@JsonProperty
	public List<Tag> tags = new ArrayList<>();
	@JsonProperty
	public List<String> taskListMetadata = new ArrayList<>();
	@JsonProperty
	public List<Task> tasks = new ArrayList<>();

}
