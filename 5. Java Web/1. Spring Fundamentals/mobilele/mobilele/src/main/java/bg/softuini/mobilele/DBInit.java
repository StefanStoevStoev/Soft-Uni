package bg.softuini.mobilele;

import bg.softuini.mobilele.model.entities.*;
import bg.softuini.mobilele.model.entities.enums.EngineEnum;
import bg.softuini.mobilele.model.entities.enums.ModelCategoryEnum;
import bg.softuini.mobilele.model.entities.enums.TransmissionEnum;
import bg.softuini.mobilele.model.entities.enums.UserRoleEnum;
import bg.softuini.mobilele.repository.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleRepository userRoleRepository;

    public DBInit(ModelRepository modelRepository,
                  BrandRepository brandRepository,
                  OfferRepository offerRepository,
                  UserRepository userRepository,
                  PasswordEncoder passwordEncoder,
                  UserRoleRepository userRoleRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        BrandEntity fordBrand = new BrandEntity();
        fordBrand.setName("Ford");

        BrandEntity hondaBrand = new BrandEntity();
        hondaBrand.setName("Honda");

        brandRepository.saveAll(List.of(fordBrand, hondaBrand));

        ModelEntity fiestaModel = initFiesta(fordBrand);
        initEscort(fordBrand);
        init758S(hondaBrand);
        createFiestaOffer(fiestaModel);

        initUsers();
    }

    private void initUsers() {

        UserRoleEntity adminRole = new UserRoleEntity().setRole(UserRoleEnum.ADMIN);
        UserRoleEntity userRole = new UserRoleEntity().setRole(UserRoleEnum.USER);

        userRoleRepository.saveAll(List.of(adminRole, userRole));

        UserEntity admin = new UserEntity();

        admin
                .setFirstName("Kiril")
                .setLastName("Dimitrov")
                .setUsername("admin")
                .setPassword(passwordEncoder.encode("topsecret"))
                .setUserRoles(List.of(adminRole, userRole));

        UserEntity pesho = new UserEntity();
        pesho
                .setFirstName("Petar")
                .setLastName("Ivanov")
                .setUsername("pesho")
                .setPassword(passwordEncoder.encode("topsecret"))
                .setUserRoles(List.of(userRole));

        userRepository.saveAll(List.of(admin,pesho));
    }



    private void createFiestaOffer(ModelEntity model) {
        OfferEntity fiestaOffer = new OfferEntity();

        fiestaOffer.setEngine((EngineEnum.GASOLINE)).
                setImageUrl("https://www.motopfohe.bg/files/news/archive/2017/08/blob-server.jpg").
                setMillage(40000).
                setPrice(BigDecimal.valueOf(10000)).
                setYear(2019).
                setDescription("Karana e ot nemska baba. Zimata v garaj").
                setTransmission(TransmissionEnum.MANUAL).
                setModel(model);

        offerRepository.save(fiestaOffer);
    }

    private ModelEntity init758S(BrandEntity hondaBrand) {
        ModelEntity nc758s = new ModelEntity();

        nc758s.
                setName("NC758S").
                setCategory(ModelCategoryEnum.MOTORCYCLE).
                setImageUrl("https://powersports.honda.com/street/adventure/-/media/products/family/nc750x/gallery/extended/nc750x/2022/2022-nc750x-gallery-01-2400xauto.jpg").
                setStartYear(2014).
                setBrand(hondaBrand);

        return modelRepository.save(nc758s);
    }

    private ModelEntity initEscort(BrandEntity fordBrand) {
        ModelEntity escort = new ModelEntity();

        escort.
                setName("Escort").
                setCategory(ModelCategoryEnum.CAR).
                setImageUrl("https://upload.wikimedia.org/wikipedia/commons/c/cc/Ford_Escort_3_by_seaside.jpg").
                setStartYear(1968).
                setEndYear(2000).
                setBrand(fordBrand);


        return modelRepository.save(escort);
    }


    private ModelEntity initFiesta(BrandEntity fordBrand) {
        ModelEntity fiesta = new ModelEntity();

        fiesta.
                setName("Fiesta").
                setCategory(ModelCategoryEnum.CAR).
                setImageUrl("https://images.ams.bg/images/galleries/107476/ford-fiesta-1460777781_big.jpg").
                setStartYear(1976).
                setBrand(fordBrand);


        return modelRepository.save(fiesta);
    }


}
