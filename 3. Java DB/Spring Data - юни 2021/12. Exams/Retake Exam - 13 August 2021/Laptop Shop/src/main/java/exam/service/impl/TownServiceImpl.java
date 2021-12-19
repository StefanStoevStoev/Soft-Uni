package exam.service.impl;

import exam.model.Town;
import exam.model.dto.townseed.TownSeedRootDto;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.util.ValidationUtil;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TownServiceImpl implements TownService {

    private static final String TOWNS_FILE_PATH = "src/main/resources/files/xml/towns.xml";

    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final TownRepository townRepository;

    public TownServiceImpl(XmlParser xmlParser,
                           ModelMapper modelMapper,
                           ValidationUtil validationUtil,
                           TownRepository townRepository) {
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
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
    public String importTowns() throws JAXBException, FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        xmlParser.parseXml(TownSeedRootDto.class, TOWNS_FILE_PATH)
                .getTown()
                .stream()
                .filter(townSeedDto -> {
                    boolean isValid = validationUtil.isValid(townSeedDto);

                    sb.append(isValid ? String.format("Successfully imported Town %s",
                            townSeedDto.getName())
                            : "Invalid town")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(townSeedDto -> modelMapper.map(townSeedDto, Town.class))
                .forEach(townRepository::save);

        return sb.toString();
    }

    @Override
    public Town findAllByName(String name) {
        return townRepository.findAllByName(name);
    }
}
