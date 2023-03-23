package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.models.TaroEntity;
import org.example.models.dto.TaroResponse;
import org.example.repository.TaroCardRepository;
import org.example.service.TaroService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@RequiredArgsConstructor
@Component
public class TaroServiceImpl implements TaroService {

    private final Function<TaroEntity, TaroResponse> fromEntityToResponse = ent -> {
        if (ent.getLasso().equals("higher")){
            return TaroResponse.builder()
                    .description(ent.getDescription())
                    .dignity(ent.getDignity())
                    .lasso(ent.getLasso())
                    .name(ent.getName())
                    /*.suit(ent.getSuit()) nothing here */
                    .build();
        }else {
            return TaroResponse.builder()
                    .description(ent.getDescription())
                    .dignity(ent.getDignity())
                    .lasso(ent.getLasso())
                    /*.name(ent.getName()) nothing here */
                    .suit(ent.getSuit())
                    .build();
        }
    };

    private final TaroCardRepository repository;

    @Override
    public TaroResponse getOneCardById(UUID uuid) {
        return fromEntityToResponse.apply(repository.getById(uuid));
    }

    @Override
    public List<TaroResponse> getAllCards() {
        List<TaroResponse> responses = new ArrayList<>();
        for (TaroEntity taroEntity : repository.findAll()) {
            responses.add(fromEntityToResponse.apply(taroEntity));
        }
        return responses;
    }

    @Override
    public List<TaroResponse> getRandomCountOfCards(Integer countOfCards) {
        return getAllCards().stream().limit(countOfCards).toList();
    }
}
