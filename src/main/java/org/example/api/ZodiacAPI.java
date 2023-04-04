package org.example.api;

import org.example.models.dto.zodiac.FriendLoveMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@RequestMapping("/zodiac")
public interface ZodiacAPI {

    /**
     * @apiNote return map of input zodiac to connectable
     * @apiNote http://localhost:8080/zodiac/oven
     */
    @GetMapping("{zod}")
    List<FriendLoveMatcher> getConnect(@PathVariable(name = "zod") String connectable);

}
