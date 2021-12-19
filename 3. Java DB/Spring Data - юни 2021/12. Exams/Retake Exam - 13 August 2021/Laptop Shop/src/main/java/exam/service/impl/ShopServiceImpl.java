package exam.service.impl;

import exam.model.Shop;
import exam.model.dto.shopseed.ShopSeedRootDto;
import exam.repository.ShopRepository;
import exam.service.ShopService;
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
public class ShopServiceImpl implements ShopService {

    private static final String SHOPS_FILE_PATH = "src/main/resources/files/xml/shops.xml";

    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final ShopRepository shopRepository;
    private final TownService townService;

    public ShopServiceImpl(XmlParser xmlParser,
                           ModelMapper modelMapper,
                           ValidationUtil validationUtil,
                           ShopRepository shopRepository, TownService townService) {
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.shopRepository = shopRepository;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(Path.of(SHOPS_FILE_PATH));
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        xmlParser.parseXml(ShopSeedRootDto.class, SHOPS_FILE_PATH)
                .getShop()
                .stream()
                .filter(shopSeedDto -> {
                    boolean isValid = validationUtil.isValid(shopSeedDto)
                            && !isNameShopExists(shopSeedDto.getName());

                    sb.append(isValid ? String.format("Successfully imported Shop %s - %.0f ",
                                    shopSeedDto.getName(), shopSeedDto.getIncome())
                                    : "Invalid shop")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(shopSeedDto -> {
                    Shop shop = modelMapper.map(shopSeedDto, Shop.class);

                    shop.setTown(townService.findAllByName(shopSeedDto.getTown().getName()));

                    return shop;
                })
                .forEach(shopRepository::save);


        return sb.toString();
    }

    @Override
    public Shop findAllByName(String name) {
        return shopRepository.findAllByName(name);
    }

    private boolean isNameShopExists(String name) {
        return shopRepository.existsByName(name);
    }
}
