package tasksConversion;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import tasksConversion.json.Alarm;
import tasksConversion.json.CaldavAccount;
import tasksConversion.json.CaldavCalendar;
import tasksConversion.json.CaldavTask;
import tasksConversion.json.Comment;
import tasksConversion.json.Data;
import tasksConversion.json.Tag;
import tasksConversion.json.Task;
import tasksConversion.json.TaskData;
import tasksConversion.json.TaskTag;
import tasksConversion.json.TasksJSON;
import tasksConversion.xml.Astrid;
import tasksConversion.xml.Metadata;
import tasksConversion.xml.Tagdata;

public class TasksConvert {

	public static final String NEW_NEWLINE = "\\n";
	public static final String OLD_NEWLINE = "&#10;";
	private static final String CALDAV_CALENDAR_UUID = "257652027890575039";

	public static long remoteId = 1008000000000000000l;


	public static void main(String[] args) {

		TasksConvert tc = new TasksConvert();
		tc.convert(args[0]);

	}


	public void convert(String xmlFilename) {

		Astrid astrid = null;
		try {
			File file = new File(xmlFilename);
			JAXBContext jaxbContext = JAXBContext.newInstance(Astrid.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			astrid = (Astrid)jaxbUnmarshaller.unmarshal(file);
			//System.out.println(astrid);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		// Do conversion
	    final TasksJSON tasksJSON = new TasksJSON();
	    tasksJSON.version = 111006;
	    tasksJSON.timestamp = System.currentTimeMillis();
	    tasksJSON.data = buildData(astrid);

	    // Write out the JSON
	    final String jsonFilename = xmlFilename + ".json";
	    try {
	    	final ObjectMapper mapper = new ObjectMapper();

	    	// String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tasksJSON);
	    	// System.out.println(json);

	    	mapper.writeValue(Paths.get(jsonFilename).toFile(), tasksJSON);

		} catch (IOException e) {
			e.printStackTrace();
		}

	    System.out.println("Done. Wrote filename: " + jsonFilename);
	}

	/** Really, all of this logic should have gone in */
	public Data buildData(Astrid astrid) {
		final Data data = new Data();

		// Set up default data
		data.caldavAccounts.add(getCaldavAccountRecord());
		data.caldavCalendars.add(getCaldavCalendarRecord());

		// More default data (string prefs)
		Map<String, String> stringPrefs = data.stringPrefs;
		stringPrefs.put("p_def_hide", "0");
		stringPrefs.put("start_of_week", "0");
		stringPrefs.put("picker_mode_date", "0");
		stringPrefs.put("last_viewed_list", "0:0");
		stringPrefs.put("p_def_reminders", "6");
		stringPrefs.put("p_def_location_reminders", "0");
		stringPrefs.put("default_recurrence_from", "0");
		stringPrefs.put("chip_style", "0");
		stringPrefs.put("p_backup_dir", "content://com.android.externalstorage.documents/tree/4F6F-D29A%3AAndroid.old");
		stringPrefs.put("beast_mode_order_v6", "TEA_ctrl_hide_until_pref;TEA_ctrl_when_pref;TEA_ctrl_repeat_pref;TEA_ctrl_importance_pref;TEA_ctrl_locations_pref;TEA_ctrl_lists_pref;TEA_ctrl_gtask;TEA_ctrl_subtask_pref;TEA_ctrl_reminders_pref;TEA_ctrl_files_pref;TEA_ctrl_notes_pref;TEA_ctrl_gcal;TEA_ctrl_timer_pref;TEA_ctrl_hide_section_pref;");
		stringPrefs.put("p_def_imp", "2");
		stringPrefs.put("rmd_default_reminder_mode", "0");
		stringPrefs.put("p_def_urg", "0");
		stringPrefs.put("chip_appearance", "0");
		stringPrefs.put("notif_default_reminder", "0");
		stringPrefs.put("map_theme", "0");
		stringPrefs.put("default_remote_list", ("4:" + CALDAV_CALENDAR_UUID));
		stringPrefs.put("picker_mode_time", "0");

		// Convert XML tags into field 'tags'.
		// Store them for later
		for (Tagdata tagdata : astrid.tagdatas) {
			Tag tag = new Tag();
			tag.color = 0;
			tag.icon = -1;
			tag.name = tagdata.name;
			tag.order = -1;
			tag.remoteId = tagdata.remoteId;
			tag.tagOrdering = "[]";
			data.tags.add(tag);
		}

		// Convert XML tasks into field 'tasks'.
		for (tasksConversion.xml.Task xmlTask : astrid.tasks) {
			Task jsonTask = new Task();

			// Add a single CaldavTask
			CaldavTask ct = new CaldavTask();
			ct.calendar = CALDAV_CALENDAR_UUID;
			ct.deleted = 0;
			ct.lastSync = 0;
			ct.remoteId = getRemoteId();
			ct.object = ct.remoteId + ".ics";
			jsonTask.caldavTasks.add(ct);

			// Comments
			if (xmlTask.comments != null) {
				for (tasksConversion.xml.Comment xmlComment : xmlTask.comments) {
					Comment comment = new Comment();
					comment.created = Long.parseLong(xmlComment.created_at);
					comment.message = xmlComment.message;
					comment.picture = "";
					comment.remoteId = xmlComment.remoteId;
					jsonTask.comments.add(comment);
				}
			}

			// Metadata: Tags & Alarms
			if (xmlTask.metadatas != null) {
				for (Metadata metadata : xmlTask.metadatas) {
					if (StringUtils.equals(metadata.key, "tags-tag")) {
						if (StringUtils.equals(metadata.deleted, "0")) {
							TaskTag taskTag = new TaskTag();
							taskTag.name = metadata.value;
							taskTag.tagUid = metadata.value2;
							jsonTask.tags.add(taskTag);
						}

					} else if (StringUtils.equals(metadata.key, "alarm")) {
						Alarm alarm = new Alarm();
						alarm.time = Long.parseLong(metadata.value);
						jsonTask.alarms.add(alarm);
					}
				}
			}

			// Data in TaskData
			TaskData td = jsonTask.task = new TaskData();
			td.completionDate = Long.parseLong(xmlTask.completed);
			td.creationDate = Long.parseLong(xmlTask.created);
			td.deletionDate = Long.parseLong(xmlTask.deleted);
			td.dueDate = Long.parseLong(xmlTask.dueDate);
			td.elapsedSeconds = Long.parseLong(xmlTask.elapsedSeconds);
			td.estimatedSeconds = Long.parseLong(xmlTask.estimatedSeconds);
			td.hideUntil = Long.parseLong(xmlTask.hideUntil);
			td.isCollapsed = false;
			td.modificationDate = Long.parseLong(xmlTask.modified);
			td.notes = fixNotes(xmlTask.notes);
			td.priority = Integer.parseInt(xmlTask.importance);
			td.reminderFlags = Integer.parseInt(xmlTask.notificationFlags);
			td.reminderLast = Long.parseLong(xmlTask.lastNotified);
			td.reminderPeriod = Long.parseLong(xmlTask.notifications);
			td.reminderSnooze = Long.parseLong(xmlTask.snoozeTime);
			td.remoteId = xmlTask.remoteId;
			td.repeatUntil = Long.parseLong(xmlTask.repeatUntil);
			td.timerStart = Long.parseLong(xmlTask.timerStart);
			td.title = xmlTask.title;

			data.tasks.add(jsonTask);
		}

		return data;
	}

	/** Converts old notes to the new notes */
	private static String fixNotes(String notes) {
		String newNotes = StringUtils.replace(notes, OLD_NEWLINE, NEW_NEWLINE);
		return newNotes;
	}

	/** Generates a new remoteId */
	public static String getRemoteId() {
		remoteId++;
		return Long.toString(remoteId);
	}

    public static CaldavAccount getCaldavAccountRecord() {
    	CaldavAccount ca = new CaldavAccount();
		ca.accountType = 2;
		ca.isCollapsed = false;
		ca.isSuppressRepeatingTasks = false;
		ca.name = "";
		ca.serverType = -1;
		ca.url = "";
		ca.username = "";
		ca.uuid = "local";
    	return ca;
    }

    public static CaldavCalendar getCaldavCalendarRecord() {
		CaldavCalendar cc = new CaldavCalendar();
		cc.access = 0;
		cc.account = "local";
		cc.color = 0;
		cc.icon = -1;
		cc.name = "Default list";
		cc.order = -1;
		cc.url = "";
		cc.uuid = CALDAV_CALENDAR_UUID;
		return cc;
	}

}
