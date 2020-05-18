package com.clockworkjava.castle.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuestTest {

    @Test
    public void settingStartedFlagToFalseShouldSetStartDate() {
        Quest quest = new Quest(1, "Testowe zadanie");
        quest.setStarted(true);

        assertNotNull(quest.startDate);
    }

    @Test
    public void questSchouldBeComplited() {
        Quest quest = new Quest(1, "Testowe zadanie");
        quest.setStarted(true);
        quest.lenghtInSeconds = -60;
        assertTrue(quest.isCompleted());
        assertTrue(quest.isCompleted());
    }

    @Test
    public void questSchouldNotBeComplited() {
        Quest quest = new Quest(1, "Testowe zadanie");
        quest.setStarted(true);
        quest.lenghtInSeconds = 60;
        assertFalse(quest.isCompleted());
        assertFalse(quest.isCompleted());
    }

}
