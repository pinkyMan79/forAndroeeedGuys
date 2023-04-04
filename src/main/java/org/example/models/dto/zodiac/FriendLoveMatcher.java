package org.example.models.dto.zodiac;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
        // сделано в угоду большей производительности,
        // так как куда быстрее вытащить подготовленный объект ежели собирать его по кускам в runtime из строки
public class FriendLoveMatcher {

    private String zodiac;
    private Integer val1;
    private Integer val2;

}
