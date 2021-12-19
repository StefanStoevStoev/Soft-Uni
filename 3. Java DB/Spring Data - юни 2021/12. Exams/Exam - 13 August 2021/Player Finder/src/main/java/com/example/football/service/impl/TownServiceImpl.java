package com.example.football.service.impl;

import com.example.football.models.dto.TownsSeedDto;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;

import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;


@Service
public class TownServiceImpl implements TownService {

    public static final String TOWNS_FILE_PATH = "src/main/resources/files/json/towns.json";

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final TownRepository townRepository;

    public TownServiceImpl(ModelMapper modelMapper
            , ValidationUtil validationUtil
            , Gson gson
            , TownRepository townRepository) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.townRepository = townRepository;
    }



    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWNS_FILE_PATH));
    }

    @Override
    public String importTowns() throws IOException {

        StringBuilder sb = new StringBuilder();

       Arrays.stream(gson.fromJson(readTownsFileContent(), TownsSeedDto[].class))
               .filter(townsDto -> {
                   boolean isValid = validationUtil.isValid(townsDto);

                   sb.append(isValid ? String.format(
                           "Successfully imported Town %s - %d",
                           townsDto.getName(), townsDto.getPopulation())
                           : "Invalid Town")
                           .append(System.lineSeparator());
                   return isValid;
               })
               .map(townsDto -> modelMapper.map(townsDto, Town.class))
               .forEach(townRepository::save);

        return sb.toString();
    }

    @Override
    public Town findTownByName(String name) {
        return townRepository.findTownByName(name);
    }


}
