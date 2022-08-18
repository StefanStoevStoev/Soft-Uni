package com.example.irrigation2.service;

import com.example.irrigation2.model.CurrentUserDetails;
import com.example.irrigation2.model.DTO.AddPumpDTO;
import com.example.irrigation2.model.DTO.OrderDTO;
import com.example.irrigation2.model.DTO.PumpDTO;
import com.example.irrigation2.model.entity.*;
import com.example.irrigation2.repository.PumpNumRepository;
import com.example.irrigation2.repository.PumpRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class PumpService {

    private final PumpRepository pumpRepository;
    private final PumpNumRepository pumpNumRepository;
    private final ModelMapper mapper;

    public PumpService(PumpRepository pumpRepository, PumpNumRepository pumpNumRepository, ModelMapper mapper) {
        this.pumpRepository = pumpRepository;
        this.pumpNumRepository = pumpNumRepository;
        this.mapper = mapper;
    }

    public void initPumps() {

        if (pumpRepository.count() == 0) {
            PumpEntity hiPeri1_5 = new PumpEntity();
            hiPeri1_5
                    .setKind("Вихрова помпа")
                    .setModel("HiPeri 1-5")
                    .setMake("Willo")
                    .setCode("02001")
                    .setHead("49,71")
                    .setMaxWorkingPressure("6,5")
                    .setDiameterInlet("1\"")
                    .setDiameterOutlet("1\"")
                    .setWeight("6,4")
                    .setVoltage("230")
                    .setPower("0,55")
                    .setCurrent("3,7")
                    .setPieces(20)
                    .setPrice(BigDecimal.valueOf(239))
                    .setUrlDiagram("/images/pumps/pump-hiperi-1-5(dgm).jpg")
                    .setUrlPic("/images/pumps/pump-hiperi-1-5.png");
            pumpRepository.save(hiPeri1_5);

            PumpEntity pf_1_30 = new PumpEntity();
            pf_1_30.setKind("Центробежна помпа")
                    .setModel("PF-1-30")
                    .setMake("Grundfos")
                    .setCode("02002")
                    .setHead("49,71")
                    .setMaxWorkingPressure("6,5")
                    .setDiameterInlet("1\"")
                    .setDiameterOutlet("1\"")
                    .setWeight("5")
                    .setVoltage("220-240")
                    .setPower("0,3")
                    .setCurrent("2")
                    .setPieces(15)
                    .setPrice(BigDecimal.valueOf(220))
                    .setUrlPic("/images/pumps/pump-PF1-30.jpg")
                    .setUrlDiagram("/images/pumps/pump-PF1-30(dgm).png");
            pumpRepository.save(pf_1_30);

        }
    }

    public void initPumpNums() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        if (pumpNumRepository.count() == 0) {

            String str2 = "2021-03-08 04:01";
            LocalDateTime dateTime2 = LocalDateTime.parse(str2, formatter);
            PumpNumbers pumpNumbers1 = new PumpNumbers();
            pumpNumbers1.
                    setUserId(2L)
                    .setPumpId(2L)
                    .setNumbers(1)
                    .setStatus("Обработва се")
                    .setPrice(BigDecimal.valueOf(28.14))
                    .setRegisteredAt(dateTime2);
            pumpNumRepository.save(pumpNumbers1);

            String str3 = "2021-01-01 23:59";
            LocalDateTime dateTime3 = LocalDateTime.parse(str3, formatter);
            PumpNumbers pumpNumbers2 = new PumpNumbers();
            pumpNumbers2.setUserId(2L)
                    .setPumpId(1L)
                    .setNumbers(3)
                    .setPrice(BigDecimal.valueOf(338.14))
                    .setRegisteredAt(dateTime3);
            pumpNumRepository.save(pumpNumbers2);
        }
    }

    public List<PumpEntity> getAllPumps() {
        return pumpRepository.findAll();
    }

    public void addPumpToDB(AddPumpDTO addPumpDTO) {
        PumpEntity pump = mapper.map(addPumpDTO, PumpEntity.class);
        pumpRepository.save(pump);
    }

    //AuthController
    public List<PumpEntity> getPumpNumsByUser(Long userId) {
        List<PumpEntity> pumps = new ArrayList<>();

        List<PumpNumbers> allPumpsNum = pumpNumRepository
                .findAllByUserIdOrderByRegisteredAtAsc(userId)
                .stream()
                .filter(e -> e.getStatus() == null).toList();

        for (PumpNumbers e : allPumpsNum) {
            PumpEntity pumpEntity = pumpRepository.findById(e.getPumpId()).orElse(null);

            if (pumpEntity != null) {
                pumpEntity.setTemporaryPieces(e.getNumbers())
                        .setPrice(e.getPrice());
                pumps.add(pumpEntity);
            }
        }
        return pumps;
    }

    public List<PumpEntity> getOrdersByUser(Long userId) {
        List<PumpNumbers> pumpNumbersStream = pumpNumRepository
                .findAllByUserIdOrderByRegisteredAtAsc(userId)
                .stream()
                .filter(e -> e.getStatus() != null).toList();

        List<PumpEntity> pumps = new ArrayList<>();

        for (PumpNumbers pumpNumber : pumpNumbersStream) {

            PumpEntity tempSprinkler = pumpRepository
                    .findById(pumpNumber.getPumpId()).orElseThrow()
                    .setPieces(pumpNumber.getNumbers())
                    .setPrice(pumpNumber.getPrice())
                    .setOrderDate(pumpNumber.getRegisteredAt())
                    .setStatus(pumpNumber.getStatus());
            pumps.add(tempSprinkler);
        }
        return pumps;
    }

    //OrderController
    public void orderPumpToUser(OrderDTO orderDTO, Long userId) {
        List<PumpNumbers> pumpNumbers = pumpNumRepository.findByUserIdAndPumpId(userId, orderDTO.getId());
        int size = pumpNumbers.size();

        PumpEntity pumpEntity = pumpRepository.findById(orderDTO.getId()).orElse(null);

        assert pumpEntity != null;
        int numbers = pumpEntity.getPieces() - orderDTO.getPieces();
        pumpEntity.setPieces(numbers);
        pumpRepository.save(pumpEntity);

        pumpNumbers.get(size - 1).setStatus("Обработва се")
                .setNumbers(orderDTO.getPieces())
                .setPrice(orderDTO.getPrice());
        pumpNumRepository.save(pumpNumbers.get(size - 1));
    }

    //OrderController
    public void deletePumpById(Long id, Long userId) {
        List<PumpNumbers> pump = pumpNumRepository.findByUserIdAndPumpId(userId, id);
        int size = pump.size();
        pumpNumRepository.deleteById(pump.get(size - 1).getId());
    }

    public void addPumpToUser(PumpDTO pumpDTO, CurrentUserDetails currentUser) {

        List<PumpNumbers> pumpNums = pumpNumRepository.findAllByUserIdOrderByRegisteredAtAsc(currentUser.getId());

        if (pumpNums.isEmpty() || !pumpNums.stream().findFirst().map(e -> e.getPumpId().equals(pumpDTO.getId()) && e.getStatus() == null).orElseThrow()) {
            PumpEntity pump = pumpRepository.getById(pumpDTO.getId());

            pump.setTemporaryPieces(pumpDTO.getPieces());

            PumpNumbers pumpAndUser = new PumpNumbers();
            pumpAndUser
                    .setPumpId(pumpDTO.getId())
                    .setPrice(pumpDTO.getPrice())
                    .setUserId(currentUser.getId())
                    .setNumbers(pumpDTO.getPieces())
                    .setRegisteredAt(LocalDateTime.now());

            pumpRepository.save(pump);
            pumpNumRepository.save(pumpAndUser);
        }
    }
}
