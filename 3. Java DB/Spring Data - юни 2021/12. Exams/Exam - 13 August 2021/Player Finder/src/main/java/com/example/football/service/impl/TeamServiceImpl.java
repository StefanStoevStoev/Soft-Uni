package com.example.football.service.impl;

import com.example.football.models.dto.TeamsSeedDto;
import com.example.football.models.entity.Team;
import com.example.football.repository.TeamRepository;
import com.example.football.service.TeamService;
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
public class TeamServiceImpl implements TeamService {

    public static final String TEAMS_FILE_PATH = "src/main/resources/files/json/teams.json";

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final TeamRepository teamRepository;
    private final TownService townService;

    public TeamServiceImpl(ModelMapper modelMapper
            , ValidationUtil validationUtil
            , Gson gson
            , TeamRepository teamRepository
            , TownService townService) {

        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.teamRepository = teamRepository;
        this.townService = townService;
    }




    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(Path.of(TEAMS_FILE_PATH));
    }

    @Override
    public String importTeams() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readTeamsFileContent(), TeamsSeedDto[].class))
                .filter(teamsSeedDto -> {
                    boolean isValid = validationUtil.isValid(teamsSeedDto);

                    sb.append(isValid ? String.format(
                            "Successfully imported Team %s - %d",
                            teamsSeedDto.getName(), teamsSeedDto.getFanBase())
                            : "Invalid Team")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(teamsSeedDto -> {
                    Team team = modelMapper.map(teamsSeedDto, Team.class);
                    team.setTowns(townService.findTownByName(teamsSeedDto.getTownName()));
                    return team;
                })
                .forEach(teamRepository::save);

        return sb.toString();
    }

    @Override
    public Team findTeamByName(String name) {
        return teamRepository.findTeamByName(name);
    }
}
