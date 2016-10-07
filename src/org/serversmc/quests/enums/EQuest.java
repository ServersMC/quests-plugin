package org.serversmc.quests.enums;

import org.serversmc.quests.quests.TestQuest;
import org.serversmc.quests.types.Quest;

public enum EQuest {
	
	TEST(new TestQuest());
	
	public Quest quest;
	
	private EQuest(Quest quest) {
		this.quest = quest;
	}
	
	public static EQuest parse(Quest quest) {
		for (EQuest equest : values()) {
			if (equest.quest.equals(quest)) {
				return equest;
			}
		}
		return null;
	}
	
}
