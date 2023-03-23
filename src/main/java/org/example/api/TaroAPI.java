package org.example.api;

import org.example.models.dto.TaroResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@RequestMapping("/taro")
public interface TaroAPI {

    @GetMapping("/{id}")
    TaroResponse getOneCard(@PathVariable("id") UUID uuid);

    @GetMapping("/getAll")
    List<TaroResponse> getAll();

    @GetMapping("/{count}")
    List<TaroResponse> getWithRandomCount(@PathVariable("count") Integer count);
}
