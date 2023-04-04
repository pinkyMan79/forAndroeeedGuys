package org.example.api.controller;

import lombok.*;
import org.example.api.ZodiacAPI;
import org.example.models.dto.zodiac.FriendLoveMatcher;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.random.RandomGenerator;

@RestController
public class ZodiacController implements ZodiacAPI {

    // it is better
    private HashMap<Pair, FriendLoveMatcher> zodiacMap = reConnect();

    @Contract(pure = true)
    private @NotNull HashMap<Pair, FriendLoveMatcher> reConnect(){
        HashMap<Pair, FriendLoveMatcher> map = new HashMap<>();

        map.put(new Pair("oven", "Овен"), new FriendLoveMatcher("Овен", 70, 70)); // вот сюда забить всю инфу в подобном стиле
        map.put(new Pair("oven", "Телец"), new FriendLoveMatcher("Телец", 70, 70)); // вот сюда забить всю инфу в подобном стиле

        return map;
    }

    @Override
    public List<FriendLoveMatcher> getConnect(String connectable) {
        List<FriendLoveMatcher> matcherList = new ArrayList<>();
        Set<Pair> pairSet = zodiacMap.keySet();
        for (Pair pair : pairSet) {
            if (pair.zod1 == connectable){
                   matcherList.add(zodiacMap.get(pair));
            }
        }
        return matcherList;
    }


    @Getter
    @Setter
    @EqualsAndHashCode
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class Pair{
        private String zod1;
        private String zod2;

        @Override
        public String toString() {
            return zod1 + "_" + zod2;
        }
    }
}
