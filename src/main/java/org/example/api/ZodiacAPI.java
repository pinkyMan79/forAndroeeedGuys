package org.example.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.HashSet;

@RequestMapping("/zodiac")
public interface ZodiacAPI {

    /**
     * @apiNote return map of input zodiac to connectable
     */
    @GetMapping("{sign}")
    String getConnect(@PathVariable(name = "sign") String connectable);

}
