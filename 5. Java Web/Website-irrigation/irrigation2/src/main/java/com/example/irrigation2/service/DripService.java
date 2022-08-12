package com.example.irrigation2.service;

import com.example.irrigation2.model.CurrentUserDetails;
import com.example.irrigation2.model.DTO.DripDTO;
import com.example.irrigation2.model.DTO.OrderDripDTO;
import com.example.irrigation2.model.entity.DripEntity;
import com.example.irrigation2.model.entity.DripNumbers;
import com.example.irrigation2.repository.DripNumRepository;
import com.example.irrigation2.repository.DripRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DripService {

    private final DripRepository dripRepository;
    private final DripNumRepository dripNumRepository;

    public DripService(DripRepository dripRepository, DripNumRepository dripNumRepository) {
        this.dripRepository = dripRepository;
        this.dripNumRepository = dripNumRepository;
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
                    .setName("Многосезонен маркуч 20")
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
                    .setName("Многосезонен маркуч 30")
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

    public void initDripNums() {

        if (dripNumRepository.count() == 0) {
            DripNumbers dripNumbers = new DripNumbers();
            dripNumbers.setUserId(2L)
                    .setDripId(1L)
                    .setNumbers(5)
                    .setPrice(BigDecimal.valueOf(25.14))
                    .setRegisteredAt(LocalDateTime.parse("2019-03-27T10:15:30"));
            dripNumRepository.save(dripNumbers);

            DripNumbers dripNumbers1 = new DripNumbers();
            dripNumbers1.setUserId(2L)
                    .setDripId(2L)
                    .setNumbers(1)
                    .setPrice(BigDecimal.valueOf(28.14))
                    .setRegisteredAt(LocalDateTime.parse("2019-03-27T10:15:30"));
            dripNumRepository.save(dripNumbers1);

            DripNumbers dripNumbers2 = new DripNumbers();
            dripNumbers2.setUserId(1L)
                    .setDripId(3L)
                    .setNumbers(3)
                    .setPrice(BigDecimal.valueOf(28.14))
                    .setRegisteredAt(LocalDateTime.parse("2019-03-27T10:15:30"));
            dripNumRepository.save(dripNumbers2);

            DripNumbers dripNumbers3 = new DripNumbers();
            dripNumbers3.setUserId(2L)
                    .setDripId(3L)
                    .setNumbers(1)
                    .setPrice(BigDecimal.valueOf(21.14))
                    .setRegisteredAt(LocalDateTime.parse("2019-03-27T10:15:30"));
            dripNumRepository.save(dripNumbers3);
        }

    }

    public DripEntity getDripByUserId(Long id) {
        return dripRepository.findById(id).orElse(null);
    }

    @JsonIgnoreProperties({"extra", "uselessValue"})
    public List<DripEntity> getAllDrips() {
        return dripRepository.findAll();
    }

    public void addDripToUser(DripDTO dripDTO, CurrentUserDetails currentUser) {

        List<DripNumbers> dripNums = dripNumRepository.findAllByUserIdOrderByRegisteredAtAsc(currentUser.getId());

        if(!dripNums.stream().findFirst().map(e -> e.getDripId().equals(dripDTO.getId())).orElseThrow()){
            DripEntity drip = dripRepository.getById(dripDTO.getId());

            drip.setTemporaryPieces(dripDTO.getPieces());

            DripNumbers dripAndUser = new DripNumbers();
            dripAndUser
                    .setDripId(dripDTO.getId())
                    .setPrice(dripDTO.getPrice())
                    .setUserId(currentUser.getId())
                    .setNumbers(dripDTO.getPieces())
                    .setRegisteredAt(LocalDateTime.now());

            dripRepository.save(drip);
            dripNumRepository.save(dripAndUser);
        }
    }

    public List<DripEntity> getDripNumsByUser(Long userId) {
        List<DripEntity> drips = new ArrayList<>();

        List<DripNumbers> allDripsNum = dripNumRepository.findAllByUserIdOrderByRegisteredAtAsc(userId);

        for (DripNumbers e : allDripsNum) {
            DripEntity dripEntity = dripRepository.findById(e.getDripId()).orElse(null);

            if (dripEntity != null) {
                dripEntity.setTemporaryPieces(e.getNumbers())
                        .setPrice(e.getPrice());
                drips.add(dripEntity);
            }
        }
        return drips;
    }

    public void orderDripToUser(OrderDripDTO orderDripDTO, Long id) {

    }

}
