package org.serversmc.quests.utils;

public class JSON {

	private String json = "{";
	
	public JSON(String text) {
		json += "\"text\":\"" + text + "\"";
	}
	
	public JSON hover(String text) {
		json += ",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"" + text + "\"}";;
		return this;
	}
	
	public JSON click(ClickEvent event, String value) {
		json += ",\"clickEvent\":{\"action\":\"" + event + "\",\"value\":\"" + value + "\"}";
		return this;
	}
	
	public JSON add(String text) {
		json += "},{\"text\":\"" + text + "\"";
		return this;
	}
	
	public String end() {
		return json + "}";
	}
	
	public static enum ClickEvent {
		RUN_COMMAND,
		SUGGEST_COMMAND,
		OPEN_URL,
		CHANGE_PAGE;
		
		@Override
		public String toString() {
			return name().toLowerCase();
		}
		
	}
	
}
