package org.example.api.controller;

import org.example.api.ZodiacAPI;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ZodiacController implements ZodiacAPI {

    // it is better
    private HashMap<String, String> zodiacMap = reConnect();

    @Contract(pure = true)
    private @NotNull HashMap<String, String> reConnect(){
        HashMap<String, String> map = new HashMap<>();

        return map;
    }

    @Override
    public String getConnect(String connectable) {
        return null;
    }
}
