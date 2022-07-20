package com.example.irrigation.service;

import com.example.irrigation.model.entity.DripEntity;
import com.example.irrigation.model.entity.UserEntity;
import com.example.irrigation.repository.DripRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DripService {

    private final DripRepository dripRepository;

    public DripService(DripRepository dripRepository) {
        this.dripRepository = dripRepository;
    }


    public DripEntity getDripById(Long id) {
        return dripRepository.findById(id).orElse(null);
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
                    .setNumbers(42)
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
                    .setNumbers(2)
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
                    .setNumbers(22)
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
                    .setNumbers(52)
                    .setId(4L);
            dripRepository.save(dripHose2);
        }
    }


    public List<DripEntity> listDripItems(UserEntity user) {
        return dripRepository.findByUserEntity(user);
    }
}
