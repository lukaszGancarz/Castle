package com.clockworkjava.castle.domain.repository;

import com.clockworkjava.castle.domain.Quest;
import com.clockworkjava.castle.utils.Ids;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class QuestRepository {

    Random rand = new Random();
    Map<Integer, Quest> quests = new HashMap<>();

    public void createQuest(String description) {
        int newId = Ids.generateNewId(quests.keySet());
        Quest newQuest = new Quest(newId, description);
        quests.put(newId, newQuest);
    }

    public List<Quest> getAll() {
        return new ArrayList<>(quests.values());
    }

    public void deleteQuest(Quest quest) {
        quests.remove(quest.getId());
    }

//    @Scheduled(fixedDelay = 1000, initialDelay = 3000) //włącza się po 3 sek od wywołania metody i działa co 1 sek
//    @Scheduled(fixedRate = 1000) // wlacza sie przy wywolaniu metody
    @Scheduled(fixedDelayString = "${questCreationDelay}")
    public void createRandomQuest() {

        List<String> descriptions = new ArrayList<>();

        descriptions.add("Uratuj ksiezniczke");
        descriptions.add("Wez udzial w turnieju");
        descriptions.add("Zabij bande goblinow");
        descriptions.add("Zabij smoka");

        String description = descriptions.get(rand.nextInt(descriptions.size()));
        createQuest(description);

    }

    @Override
    public String toString() {
        return "QuestRepository{" +
                "quests=" + quests +
                '}';
    }

    public void update(Quest quest) {
        quests.put(quest.getId(), quest);
    }

    public Quest getQuest(Integer id) {
        return quests.get(id);
    }
}
