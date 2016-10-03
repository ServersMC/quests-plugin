package org.serversmc.quests.enums;

import org.serversmc.quests.quests.TestQuest;
import org.serversmc.quests.types.Quest;

public enum EQuests {
	
	TEST(new TestQuest());
	
	public Quest quest;
	
	private EQuests(Quest quest) {
		this.quest = quest;
	}
	
}
