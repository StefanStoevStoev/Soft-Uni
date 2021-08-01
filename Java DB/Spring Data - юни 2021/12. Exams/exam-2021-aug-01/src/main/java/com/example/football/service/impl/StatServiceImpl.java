package com.example.football.service.impl;

import com.example.football.models.dto.seedstats.StatsSeedDto;
import com.example.football.models.dto.seedstats.StatsSeedRootDto;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class StatServiceImpl implements StatService {

    public static final String STATS_FILE_PATH = "src/main/resources/files/xml/stats.xml";

    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final StatRepository statRepository;
    private final ValidationUtil validationUtil;

    public StatServiceImpl(XmlParser xmlParser
            , ModelMapper modelMapper, StatRepository statRepository
            , ValidationUtil validationUtil) {

        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.statRepository = statRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(Path.of(STATS_FILE_PATH));
    }

    @Override
    public String importStats() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(STATS_FILE_PATH, StatsSeedRootDto.class)
                .getStats()
                .stream()
                .filter(statsSeedDto -> {
                    boolean isValid = validationUtil.isValid(statsSeedDto);

                    sb.append(isValid ? String
                            .format("Successfully imported Stat %.2f - %.2f - %.2f",
                                    statsSeedDto.getShooting()
                                    , statsSeedDto.getPassing()
                                    ,statsSeedDto.getEndurance())
                            : "Invalid Stat")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(statsSeedDto -> modelMapper.map(statsSeedDto, Stat.class))
                .forEach(statRepository::save);

        return sb.toString();
    }
}
