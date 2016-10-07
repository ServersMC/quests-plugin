package org.serversmc.quests.enums;

public enum EDirectory {

	DATAFOLDER("plugins/Quests/"),
	PLAYERS(DATAFOLDER + "players");
	
	private String path;
	
	private EDirectory(String path) {
		this.path = path;
	}
	
	@Override
	public String toString() {
		return path;
	}
	
}
