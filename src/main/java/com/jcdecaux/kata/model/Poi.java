package com.jcdecaux.kata.model;

import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Poi {

    @CsvBindByPosition(position = 0)
    String id;

    @CsvBindByPosition(position = 1)
    Double latitude;

    @CsvBindByPosition(position = 2)
    Double longitute;
}
