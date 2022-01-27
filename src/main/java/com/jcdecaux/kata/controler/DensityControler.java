package com.jcdecaux.kata.controler;

import com.jcdecaux.kata.model.Poi;
import com.jcdecaux.kata.model.Zone;
import com.jcdecaux.kata.service.DensityService;
import com.jcdecaux.kata.utils.CsvReader;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController("/")
public class DensityControler {

    private final DensityService densityService;

    public DensityControler(DensityService densityService) {
        this.densityService = densityService;
    }

    @PostMapping("/density")
    public Long getDensity(@RequestParam("file") MultipartFile file,
                              @RequestParam("minLat") Double minLat,
                              @RequestParam("minLong") Double minLong) throws IOException {
        List<Poi> pois = CsvReader.readFile(file);
        return densityService.getDensity(minLat, minLong, pois);
    }

    @PostMapping("/denseZones")
    public List<Zone> getMostDenseZones(@RequestParam("file") MultipartFile file,
                           @RequestParam("zoneCount") Integer zoneCount) throws IOException {
        List<Poi> pois = CsvReader.readFile(file);
        return densityService.getMostDenseZones(zoneCount, pois);
    }
}
