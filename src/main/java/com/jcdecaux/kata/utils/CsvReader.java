package com.jcdecaux.kata.utils;

import com.jcdecaux.kata.model.Poi;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class CsvReader {

    public static List<Poi> readFile(MultipartFile file) throws IOException {
        Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));

        CsvToBean<Poi> csvToBean = new CsvToBeanBuilder(reader)
                .withType(Poi.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        List<Poi> pois = csvToBean.parse();

        return pois;
    }
}
