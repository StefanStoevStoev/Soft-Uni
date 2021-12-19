package com.example.football.service.impl;

import com.example.football.models.dto.seedplayers.PlayersSeedRootDto;
import com.example.football.models.entity.Player;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PlayerServiceImpl implements PlayerService {

    public static final String PLAYERS_FILE_PATH = "src/main/resources/files/xml/players.xml";

    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final PlayerRepository playerRepository;
    private final ValidationUtil validationUtil;
    private final TownService townService;
    private final TeamService teamService;

    public PlayerServiceImpl(XmlParser xmlParser, ModelMapper modelMapper, PlayerRepository playerRepository, ValidationUtil validationUtil, TownService townService, TeamService teamService) {
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.playerRepository = playerRepository;
        this.validationUtil = validationUtil;
        this.townService = townService;
        this.teamService = teamService;
    }


    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {

        return Files.readString(Path.of(PLAYERS_FILE_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException, IOException {

        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(PLAYERS_FILE_PATH, PlayersSeedRootDto.class)
                .getPlayers()
                .stream()
                .filter(playersSeedDto -> {
                    boolean isValid = validationUtil.isValid(playersSeedDto);

                    sb.append(isValid ? String
                            .format("Successfully imported Player %s %s - %s",
                                    playersSeedDto.getFirstName(),
                                    playersSeedDto.getLastName(),
                                    playersSeedDto.getPosition())
                            : "Invalid Player")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(playersSeedDto -> {
                    Player player = modelMapper.map(playersSeedDto, Player.class);
                    player.setTown(townService.findTownByName(playersSeedDto.getTown().getName()));
                    player.setTeam(teamService.findTeamByName(playersSeedDto.getTeam().getName()));
                    return player;
                })
                .forEach(playerRepository::save);

        return sb.toString();
    }

    @Override
    public String exportBestPlayers() {

        StringBuilder sb = new StringBuilder();

        playerRepository.findPlayersByStatOrderByShootingDescPassingDescAndLastName()
                .forEach(player -> {
                    sb.append(String.format("Player - %s %s\n" +
                            "\tPosition - %s\n" +
                            "\tTeam - %s\n" +
                            "\tStadium - %s",
                            player.getFirstName(),
                            player.getLastName(),
                            player.getPosition(),
                            player.getTeam().getName(),
                            player.getTeam().getStadiumName()))
                            .append(System.lineSeparator());

                });
        return sb.toString();
    }
}
