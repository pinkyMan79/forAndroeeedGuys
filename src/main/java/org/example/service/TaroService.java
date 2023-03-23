package org.example.service;


import org.example.models.dto.TaroResponse;

import java.util.List;
import java.util.UUID;

public interface TaroService {

    TaroResponse getOneCardById(UUID uuid);
    List<TaroResponse> getAllCards();
    List<TaroResponse> getRandomCountOfCards(Integer countOfCards);

}
