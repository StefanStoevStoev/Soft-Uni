package com.example.irrigation2.service;

import com.example.irrigation2.model.CurrentUserDetails;
import com.example.irrigation2.model.DTO.UserPhoneAndAddressDTO;
import com.example.irrigation2.model.entity.DripEntity;
import com.example.irrigation2.model.entity.UserEntity;
import com.example.irrigation2.model.mapper.UserMapperPhoneAddress;
import com.example.irrigation2.repository.DripRepository;
import com.example.irrigation2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DripService {

    private final DripRepository dripRepository;
    private final UserRepository userRepository;
    private final UserMapperPhoneAddress userMapperPhoneAddress;

    public DripService(DripRepository dripRepository,
                       UserRepository userRepository,
                       UserMapperPhoneAddress userMapperPhoneAddress) {
        this.dripRepository = dripRepository;
        this.userRepository = userRepository;
        this.userMapperPhoneAddress = userMapperPhoneAddress;
    }


    public DripEntity getDripByUserId(Long id) {
        return dripRepository.findById(id).orElse(null);
    }

    public List<DripEntity> getAllDrips() {
        return dripRepository.findAll();
    }

    public void initDrips() {

        DripEntity dripOneSeason = new DripEntity();

        if (dripRepository.count() == 0) {
            dripOneSeason
                    .setName("Hydro-Drip-10")
                    .setCode("00001")
                    .setDiameter(16)
                    .setDistBtwDrips(10)
                    .setFlowPerDrip(1.6)
                    .setMaxPressure(0.7)
                    .setSize(100)
                    .setTimeOfUse("1")
                    .setPrice(BigDecimal.valueOf(16.20))
                    .setPieces(42)
                    .setUrl("/images/drips/hose16-10.png")
                    .setId(1L);
            dripRepository.save(dripOneSeason);

            DripEntity dripOneSeason20 = new DripEntity();
            dripOneSeason20
                    .setName("Hydro-Drip-20")
                    .setCode("00002")
                    .setDiameter(16)
                    .setDistBtwDrips(20)
                    .setFlowPerDrip(1.6)
                    .setMaxPressure(0.7)
                    .setSize(100)
                    .setTimeOfUse("1")
                    .setPrice(BigDecimal.valueOf(14.80))
                    .setPieces(2)
                    .setUrl("/images/drips/hose16-30.png")
                    .setId(2L);
            dripRepository.save(dripOneSeason20);

            DripEntity dripHose = new DripEntity();
            dripHose
                    .setName("Многосезонен маркуч")
                    .setCode("00003")
                    .setDiameter(16)
                    .setDistBtwDrips(20)
                    .setFlowPerDrip(2)
                    .setMaxPressure(1)
                    .setSize(100)
                    .setTimeOfUse("5")
                    .setPrice(BigDecimal.valueOf(32.40))
                    .setPieces(22)
                    .setUrl("/images/drips/hose16-30-2.png")
                    .setId(3L);
            dripRepository.save(dripHose);

            DripEntity dripHose2 = new DripEntity();
            dripHose2
                    .setName("Многосезонен маркуч")
                    .setCode("00004")
                    .setDiameter(16)
                    .setDistBtwDrips(30)
                    .setFlowPerDrip(2)
                    .setMaxPressure(1)
                    .setSize(100)
                    .setTimeOfUse("5")
                    .setPrice(BigDecimal.valueOf(27.80))
                    .setPieces(52)
                    .setUrl("/images/drips/hose16-30-3.png")
                    .setId(4L);
            dripRepository.save(dripHose2);
        }
    }

    public List<DripEntity> listDripItems(UserEntity user) {
        return dripRepository.findByUserEntityId(user.getId());
    }

    public void savePhoneAndAddress(UserPhoneAndAddressDTO userPhoneAndAddressDTO,
                                    CurrentUserDetails currentUser) {

        UserEntity userData = userMapperPhoneAddress.userDtoToUserEntity(userPhoneAndAddressDTO);
        UserEntity user = userRepository.findByEmail(currentUser.getEmail()).orElse(null);

        assert user != null;
        user.setPhone(userData.getPhone())
                .setAddress(userData.getAddress());

        userRepository.save(user);
    }
}
