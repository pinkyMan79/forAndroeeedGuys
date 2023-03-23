package org.example.api.controller;

import lombok.RequiredArgsConstructor;
import org.example.api.TaroAPI;
import org.example.models.dto.TaroResponse;
import org.example.service.TaroService;
import org.example.service.impl.TaroServiceImpl;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TaroController implements TaroAPI {

    private final TaroServiceImpl service;

    @Override
    public TaroResponse getOneCard(UUID uuid) {
        return service.getOneCardById(uuid);
    }

    @Override
    public List<TaroResponse> getAll() {
        return service.getAllCards();
    }

    @Override
    public List<TaroResponse> getWithRandomCount(Integer count) {
        return service.getRandomCountOfCards(count);
    }
}
