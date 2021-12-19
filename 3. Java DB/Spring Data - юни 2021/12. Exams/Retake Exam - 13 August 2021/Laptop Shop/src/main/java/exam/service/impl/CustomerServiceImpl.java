package exam.service.impl;

import com.google.gson.Gson;
import exam.model.Customer;
import exam.model.dto.CustomerSeedRootDto;
import exam.repository.CustomerRepository;
import exam.service.CustomerService;
import exam.service.TownService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final String CUSTOMER_FILE_PATH = "src/main/resources/files/json/customers.json";

    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final CustomerRepository customerRepository;
    private final TownService townService;

    public CustomerServiceImpl(Gson gson,
                               ModelMapper modelMapper,
                               ValidationUtil validationUtil,
                               CustomerRepository customerRepository, TownService townService) {
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.customerRepository = customerRepository;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return Files.readString(Path.of(CUSTOMER_FILE_PATH));
    }

    @Override
    public String importCustomers() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readCustomersFileContent(), CustomerSeedRootDto[].class))
                .filter(customerDto -> {
                    boolean isValid = validationUtil.isValid(customerDto);

                    sb.append(isValid ? String.format("Successfully imported Customer %s %s - %s",
                            customerDto.getFirstName(),
                            customerDto.getLastName(),
                            customerDto.getEmail())
                            : "Invalid Customer")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(customerDto ->{
                            Customer customer = modelMapper.map(customerDto, Customer.class);
                            customer.setTown(townService.findAllByName(customerDto.getTown().getName()));

                            return customer;
                        })
                .forEach(customerRepository::save);

        return sb.toString();
    }
}
