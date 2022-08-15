package com.example.irrigation2.service;

import com.example.irrigation2.model.CurrentUserDetails;
import com.example.irrigation2.model.DTO.AddDripDTO;
import com.example.irrigation2.model.DTO.AddPumpDTO;
import com.example.irrigation2.model.DTO.DripDTO;
import com.example.irrigation2.model.DTO.OrderDripDTO;
import com.example.irrigation2.model.entity.DripEntity;
import com.example.irrigation2.model.entity.DripNumbers;
import com.example.irrigation2.model.entity.PumpEntity;
import com.example.irrigation2.repository.DripNumRepository;
import com.example.irrigation2.repository.DripRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class DripService {

    private final DripRepository dripRepository;
    private final DripNumRepository dripNumRepository;
    private final ModelMapper modelMapper;

    public DripService(DripRepository dripRepository, DripNumRepository dripNumRepository, ModelMapper modelMapper) {
        this.dripRepository = dripRepository;
        this.dripNumRepository = dripNumRepository;
        this.modelMapper = modelMapper;
    }

    public void deleteDripById(Long dripId, Long userId) {
        DripNumbers drip = dripNumRepository.findByUserIdAndDripId(userId, dripId);
        dripNumRepository.deleteById(drip.getId());
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
                    .setUrlPic("/images/drips/hose16-10.png")
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
                    .setUrlPic("/images/drips/hose16-30.png")
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
                    .setUrlPic("/images/drips/hose16-30-2.png")
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
                    .setUrlPic("/images/drips/hose16-30-3.png")
                    .setId(4L);
            dripRepository.save(dripHose2);
        }
    }

    public void initDripNums() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        if (dripNumRepository.count() == 0) {
            String str1 = "2014-04-08 12:30";
            LocalDateTime dateTime1 = LocalDateTime.parse(str1, formatter);
            DripNumbers dripNumbers = new DripNumbers();
            dripNumbers.setUserId(2L)
                    .setDripId(1L)
                    .setNumbers(5)
                    .setStatus("Обработва се")
                    .setPrice(BigDecimal.valueOf(25.14))
                    .setRegisteredAt(dateTime1);
            dripNumRepository.save(dripNumbers);

            String str2 = "2022-04-08 09:01";
            LocalDateTime dateTime2 = LocalDateTime.parse(str2, formatter);
            DripNumbers dripNumbers1 = new DripNumbers();
            dripNumbers1.setUserId(2L)
                    .setDripId(2L)
                    .setNumbers(1)
                    .setStatus("Изпратена")
                    .setPrice(BigDecimal.valueOf(28.14))
                    .setRegisteredAt(dateTime2);
            dripNumRepository.save(dripNumbers1);

            String str3 = "2021-01-01 23:59";
            LocalDateTime dateTime3 = LocalDateTime.parse(str3, formatter);
            DripNumbers dripNumbers2 = new DripNumbers();
            dripNumbers2.setUserId(1L)
                    .setDripId(3L)
                    .setNumbers(3)
                    .setPrice(BigDecimal.valueOf(28.14))
                    .setRegisteredAt(dateTime3);
            dripNumRepository.save(dripNumbers2);

            String str4 = "2022-11-30 23:59";
            LocalDateTime dateTime4 = LocalDateTime.parse(str4, formatter);
            DripNumbers dripNumbers3 = new DripNumbers();
            dripNumbers3.setUserId(2L)
                    .setDripId(3L)
                    .setNumbers(1)
                    .setPrice(BigDecimal.valueOf(21.14))
                    .setRegisteredAt(dateTime4);
            dripNumRepository.save(dripNumbers3);
        }
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

    //AuthController
    public List<DripEntity> getDripNumsByUser(Long userId) {
        List<DripEntity> drips = new ArrayList<>();

        List<DripNumbers> allDripsNum = dripNumRepository
                .findAllByUserIdOrderByRegisteredAtAsc(userId)
                .stream()
                .filter(e -> e.getStatus() == null).toList();

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

    //OrderController
    public void orderDripToUser(OrderDripDTO orderDripDTO, Long userId) {/////////////////

        DripNumbers dripNumbers = dripNumRepository.findByUserIdAndDripId(userId, orderDripDTO.getId());
        DripEntity dripEntity = dripRepository.findById(orderDripDTO.getId()).orElse(null);

        assert dripEntity != null;
        int numbers = dripEntity.getPieces()- orderDripDTO.getPieces();
        dripEntity.setPieces(numbers);
        dripRepository.save(dripEntity);

        dripNumbers.setStatus("Обработва се")
                .setNumbers(orderDripDTO.getPieces())
                .setPrice(orderDripDTO.getPrice());
        dripNumRepository.save(dripNumbers);
    }

    public List<DripEntity> getOrdersByUser(Long userId) {

        List<DripNumbers> dripNumbersStream = dripNumRepository
                .findAllByUserIdOrderByRegisteredAtAsc(userId)
                .stream()
                .filter(e -> e.getStatus() != null).toList();

        List<DripEntity> drip = new ArrayList<>();

        for (DripNumbers dripNumbers : dripNumbersStream) {

            DripEntity tempDrip = dripRepository
                    .findById(dripNumbers.getDripId()).orElseThrow()
                    .setPieces(dripNumbers.getNumbers())
                    .setPrice(dripNumbers.getPrice())
                    .setOrderDate(dripNumbers.getRegisteredAt())
                    .setStatus(dripNumbers.getStatus());
            drip.add(tempDrip);

        }
        return drip;
    }

    public void addDripToDB(AddDripDTO addDripDTO) {
        DripEntity drip = modelMapper.map(addDripDTO, DripEntity.class);
        dripRepository.save(drip);
    }
}
