package exam.service.impl;

import com.google.gson.Gson;
import exam.model.Laptop;
import exam.model.Waranty;
import exam.model.dto.LaptopSeedRootDto;
import exam.repository.LaptopRepository;
import exam.service.LaptopService;
import exam.service.ShopService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class LaptopServiceImpl implements LaptopService {

    private static final String LAPTOP_FILE_PATH = "src/main/resources/files/json/laptops.json";

    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final LaptopRepository laptopRepository;
    private final ShopService shopService;

    public LaptopServiceImpl(Gson gson,
                             ModelMapper modelMapper,
                             ValidationUtil validationUtil,
                             LaptopRepository laptopRepository,
                             ShopService shopService) {
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.laptopRepository = laptopRepository;
        this.shopService = shopService;
    }

    @Override
    public boolean areImported() {
        return laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(Path.of(LAPTOP_FILE_PATH));
    }

    @Override
    public String importLaptops() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readLaptopsFileContent(), LaptopSeedRootDto[].class))
                .filter(laptopDto -> {
                    boolean isValid = validationUtil.isValid(laptopDto)
                            && !isValidWaranty(laptopDto.getWarrantyType());

                    sb.append(isValid ? String.format("Successfully imported Laptop %s - %.2f - %d - %d",
                            laptopDto.getMacAddress(),
                            laptopDto.getCpuSpeed(),
                            laptopDto.getRam(),
                            laptopDto.getStorage())
                            : "Invalid Laptop")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(laptopDto -> {
                    Laptop laptop = modelMapper.map(laptopDto, Laptop.class);

                    laptop.setShop(shopService.findAllByName(laptopDto.getShop().getName()));

                    return laptop;
                })
                .forEach(laptopRepository::save);

        return sb.toString();
    }

    private boolean isValidWaranty(String warrantyType) {

            Waranty[] values = Waranty.values();
            for (Waranty value : values) {
                if (value.name().compareTo(warrantyType) > 0){
                    return true;
                }
            }
            return false;
    }

    @Override
    public String exportBestLaptops() {

        StringBuilder sb = new StringBuilder();

        laptopRepository.findAllByOrderByCpuSpeedDescRamDescStorageDescMacAddress()
                .forEach(laptop -> {
                    sb.append(String.format("Laptop - %s\n" +
                            "*Cpu speed - %.2f\n" +
                            "**Ram - %d\n" +
                            "***Storage - %d\n" +
                            "****Price - %.2f\n" +
                            "#Shop name - %s\n" +
                            "##Town - %s\n",
                            laptop.getMacAddress(),
                            laptop.getCpuSpeed(),
                            laptop.getRam(),
                            laptop.getStorage(),
                            laptop.getPrice(),
                            laptop.getShop().getName(),
                            laptop.getShop().getTown().getName())
                    )
                            .append(System.lineSeparator());

                });

        return sb.toString();
    }
}
