package com.example.irrigation2.service;

import com.example.irrigation2.model.CurrentUserDetails;
import com.example.irrigation2.model.DTO.AddSprinklerDTO;
import com.example.irrigation2.model.DTO.OrderDTO;
import com.example.irrigation2.model.DTO.SprinklerDTO;
import com.example.irrigation2.model.entity.DripEntity;
import com.example.irrigation2.model.entity.DripNumbers;
import com.example.irrigation2.model.entity.SprinklerEntity;
import com.example.irrigation2.model.entity.SprinklerNumbers;
import com.example.irrigation2.repository.SprinklerNumRepository;
import com.example.irrigation2.repository.SprinklerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class SprinklerService {

    private final SprinklerRepository sprinklerRepository;
    private final SprinklerNumRepository sprinklerNumRepository;
    private final ModelMapper mapper;


    public SprinklerService(SprinklerRepository sprinklerRepository, SprinklerNumRepository sprinklerNumRepository, ModelMapper mapper) {
        this.sprinklerRepository = sprinklerRepository;
        this.sprinklerNumRepository = sprinklerNumRepository;
        this.mapper = mapper;
    }

    public void initSprinklers() {

        if (sprinklerRepository.count() == 0) {
            SprinklerEntity sprinklerEntity = new SprinklerEntity();
            sprinklerEntity
                    .setKind("Роторен разпръсквач")
                    .setModel("S100-1")
                    .setMake("RAIN")
                    .setCode("01001")
                    .setSize("1\"")
                    .setPressure("2,76÷6,21")
                    .setNosel("5÷30")
                    .setVolume("19,3÷123")
                    .setRadius("13,1÷23,5")
                    .setPrice(BigDecimal.valueOf(121.5))
                    .setPieces(30)
                    .setUrl("/images/sprinkler/spr-s100.png");
            sprinklerRepository.save(sprinklerEntity);

            SprinklerEntity sprinklerEntity50 = new SprinklerEntity();
            sprinklerEntity50
                    .setKind("Роторен разпръсквач")
                    .setModel("S50")
                    .setMake("RAIN")
                    .setCode("01002")
                    .setSize("1/2\"")
                    .setPressure("2÷5")
                    .setNosel("0,75÷3")
                    .setVolume("2,84÷12,5")
                    .setRadius("5,1÷9,0")
                    .setPrice(BigDecimal.valueOf(27.5))
                    .setPieces(64)
                    .setUrl("/images/sprinkler/spr-s50.png");
            sprinklerRepository.save(sprinklerEntity50);

            SprinklerEntity sprinklerEntity50s = new SprinklerEntity();
            sprinklerEntity50s
                    .setKind("Роторен разпръсквач")
                    .setModel("S50S")
                    .setMake("RAIN")
                    .setCode("01003")
                    .setSize("1/2\"")
                    .setPressure("2÷5")
                    .setNosel("0,75÷3")
                    .setVolume("2,84÷12,5")
                    .setRadius("5,1÷9,0")
                    .setPrice(BigDecimal.valueOf(31.8))
                    .setPieces(8)
                    .setUrl("/images/sprinkler/spr-s50s.png");
            sprinklerRepository.save(sprinklerEntity50s);

            SprinklerEntity sprinklerEntity75s = new SprinklerEntity();
            sprinklerEntity75s
                    .setKind("Роторен разпръсквач")
                    .setModel("S075S")
                    .setMake("RAIN")
                    .setCode("01004")
                    .setSize("3/4\"")
                    .setPressure("2÷5")
                    .setNosel("0,5÷8")
                    .setVolume("1,7÷35,96")
                    .setRadius("7,9÷14,9")
                    .setPrice(BigDecimal.valueOf(44.90))
                    .setPieces(120)
                    .setUrl("/images/sprinkler/spr-075s.png");
            sprinklerRepository.save(sprinklerEntity75s);

            SprinklerEntity sprinklerEntity75d = new SprinklerEntity();
            sprinklerEntity75d
                    .setKind("Роторен разпръсквач")
                    .setModel("S075D")
                    .setMake("RAIN")
                    .setCode("01005")
                    .setSize("3/4\"")
                    .setPressure("2÷5")
                    .setNosel("0,5÷8")
                    .setVolume("4,5÷32,6")
                    .setRadius("6,7÷15,5")
                    .setPrice(BigDecimal.valueOf(33.30))
                    .setPieces(42)
                    .setUrl("/images/sprinkler/spr-075D.png");
            sprinklerRepository.save(sprinklerEntity75d);

            SprinklerEntity sprinklerEntity020 = new SprinklerEntity();
            sprinklerEntity020
                    .setKind("Дефлекторен разпръсквач")
                    .setModel("def-06")
                    .setMake("RAIN")
                    .setCode("01006")
                    .setSize("1/2\"")
                    .setPrice(BigDecimal.valueOf(4.5))
                    .setPieces(55)
                    .setUrl("/images/sprinkler/spr-def-06.png");
            sprinklerRepository.save(sprinklerEntity020);
        }
    }

    public void initSprinklerNums() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        if (sprinklerNumRepository.count() == 0) {
            String str1 = "2014-04-08 12:30";
            LocalDateTime dateTime1 = LocalDateTime.parse(str1, formatter);
            SprinklerNumbers sprNumbers = new SprinklerNumbers();
            sprNumbers.setUserId(2L)
                    .setSprinklerId(1L)
                    .setNumbers(5)
                    .setStatus("Обработва се")
                    .setPrice(BigDecimal.valueOf(25.14))
                    .setRegisteredAt(dateTime1);
            sprinklerNumRepository.save(sprNumbers);

            String str2 = "2022-04-08 09:01";
            LocalDateTime dateTime2 = LocalDateTime.parse(str2, formatter);
            SprinklerNumbers sprNumbers1 = new SprinklerNumbers();
            sprNumbers1.setUserId(2L)
                    .setSprinklerId(2L)
                    .setNumbers(1)
                    .setStatus("Изпратена")
                    .setPrice(BigDecimal.valueOf(28.14))
                    .setRegisteredAt(dateTime2);
            sprinklerNumRepository.save(sprNumbers1);

            String str3 = "2021-01-01 23:59";
            LocalDateTime dateTime3 = LocalDateTime.parse(str3, formatter);
            SprinklerNumbers sprNumbers2 = new SprinklerNumbers();
            sprNumbers2.setUserId(1L)
                    .setSprinklerId(3L)
                    .setNumbers(3)
                    .setPrice(BigDecimal.valueOf(28.14))
                    .setRegisteredAt(dateTime3);
            sprinklerNumRepository.save(sprNumbers2);

            String str4 = "2022-11-30 23:59";
            LocalDateTime dateTime4 = LocalDateTime.parse(str4, formatter);
            SprinklerNumbers sprNumbers3 = new SprinklerNumbers();
            sprNumbers3.setUserId(2L)
                    .setSprinklerId(3L)
                    .setNumbers(1)
                    .setPrice(BigDecimal.valueOf(21.14))
                    .setRegisteredAt(dateTime4);
            sprinklerNumRepository.save(sprNumbers3);
        }
    }

    public List<SprinklerEntity> getAllSprinklers() {

        return sprinklerRepository.findAll();
    }

    public SprinklerEntity addSprinklerToDB(AddSprinklerDTO addSprinklerDTO) {
        SprinklerEntity sprinkler = mapper.map(addSprinklerDTO, SprinklerEntity.class);
        return sprinklerRepository.save(sprinkler);
    }

    public List<SprinklerEntity> getOrdersByUser(Long userId) {
        List<SprinklerNumbers> sprinklerNumbersStream = sprinklerNumRepository
                .findAllByUserIdOrderByRegisteredAtAsc(userId)
                .stream()
                .filter(e -> e.getStatus() != null).toList();

        List<SprinklerEntity> sprinkler = new ArrayList<>();

        for (SprinklerNumbers sprinklerNumbers : sprinklerNumbersStream) {

            SprinklerEntity tempSprinkler = sprinklerRepository
                    .findById(sprinklerNumbers.getSprinklerId()).orElseThrow()
                    .setPieces(sprinklerNumbers.getNumbers())
                    .setPrice(sprinklerNumbers.getPrice())
                    .setOrderDate(sprinklerNumbers.getRegisteredAt())
                    .setStatus(sprinklerNumbers.getStatus());
            sprinkler.add(tempSprinkler);
        }
        return sprinkler;
    }

    public void addSprklerToUser(SprinklerDTO sprinklerDTO, CurrentUserDetails currentUser) {
        List<SprinklerNumbers> sprinklerNumbers = sprinklerNumRepository.findAllByUserIdOrderByRegisteredAtAsc(currentUser.getId());

        if(!sprinklerNumbers.stream().findFirst().map(e -> e.getSprinklerId().equals(sprinklerDTO.getId())).orElseThrow()){
            SprinklerEntity sprinkler = sprinklerRepository.getById(sprinklerDTO.getId());

            sprinkler.setTemporaryPieces(sprinklerDTO.getPieces());

            SprinklerNumbers sprinklerAndUser = new SprinklerNumbers();
            sprinklerAndUser
                    .setSprinklerId(sprinklerDTO.getId())
                    .setPrice(sprinklerDTO.getPrice())
                    .setUserId(currentUser.getId())
                    .setNumbers(sprinklerDTO.getPieces())
                    .setRegisteredAt(LocalDateTime.now());

            sprinklerRepository.save(sprinkler);
            sprinklerNumRepository.save(sprinklerAndUser);
        }
    }
//AuthController
    public List<SprinklerEntity> getSprinklerNumsByUser(Long userId) {
        List<SprinklerEntity> sprinkler = new ArrayList<>();

        List<SprinklerNumbers> allSprinklerNum = sprinklerNumRepository
                .findAllByUserIdOrderByRegisteredAtAsc(userId)
                .stream()
                .filter(e -> e.getStatus() == null).toList();

        for (SprinklerNumbers e : allSprinklerNum) {
            SprinklerEntity dripEntity = sprinklerRepository.findById(e.getSprinklerId()).orElse(null);

            if (dripEntity != null) {
                dripEntity.setTemporaryPieces(e.getNumbers())
                        .setPrice(e.getPrice());
                sprinkler.add(dripEntity);
            }
        }
        return sprinkler;
    }

    public void orderDripToUser(OrderDTO orderDTO, Long userId) {

        SprinklerNumbers sprNumbers = sprinklerNumRepository.findByUserIdAndSprinklerId(userId, orderDTO.getId());
        SprinklerEntity sprEntity = sprinklerRepository.findById(orderDTO.getId()).orElse(null);

        assert sprEntity != null;
        int numbers = sprEntity.getPieces() - orderDTO.getPieces();
        sprEntity.setPieces(numbers);
        sprinklerRepository.save(sprEntity);

        sprNumbers.setStatus("Обработва се")
                .setNumbers(orderDTO.getPieces())
                .setPrice(orderDTO.getPrice());
        sprinklerNumRepository.save(sprNumbers);
    }
}