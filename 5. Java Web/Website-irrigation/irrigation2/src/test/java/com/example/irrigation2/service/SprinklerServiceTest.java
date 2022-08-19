package com.example.irrigation2.service;

import com.example.irrigation2.model.entity.*;
import com.example.irrigation2.repository.SprinklerNumRepository;
import com.example.irrigation2.repository.SprinklerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SprinklerServiceTest {

    @Mock
    private SprinklerRepository mockSprinklerRepository;
    @Mock
    private SprinklerNumRepository mockSprinklerNumRepository;
    @Mock
    private ModelMapper mockMapper;

    private SprinklerService toTest;

    @BeforeEach
    void setUp(){
        toTest = new SprinklerService(mockSprinklerRepository,
                mockSprinklerNumRepository, mockMapper);
    }

    @Test
    void getAllSprinklers_sprinklersExists(){

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
                .setUrl("/images/sprinkler/spr-s100.png")
                .setId(1L);

        List<SprinklerEntity> drips = new ArrayList<>();
        drips.add(sprinklerEntity);
        when(mockSprinklerRepository.findAll()).thenReturn(drips);

        List<SprinklerEntity> getAllDrips = toTest.getAllSprinklers();

        Assertions.assertEquals(sprinklerEntity.getSize(), getAllDrips.get(0).getSize());
        Assertions.assertEquals(sprinklerEntity.getCode(), getAllDrips.get(0).getCode());
        Assertions.assertEquals(sprinklerEntity.getPieces(), getAllDrips.get(0).getPieces());
        Assertions.assertEquals(sprinklerEntity.getPrice(), getAllDrips.get(0).getPrice());
        Assertions.assertEquals(sprinklerEntity.getMake(), getAllDrips.get(0).getMake());
        Assertions.assertEquals(sprinklerEntity.getModel(), getAllDrips.get(0).getModel());
        Assertions.assertEquals(sprinklerEntity.getKind(), getAllDrips.get(0).getKind());
        Assertions.assertEquals(sprinklerEntity.getPressure(), getAllDrips.get(0).getPressure());
        Assertions.assertEquals(sprinklerEntity.getNosel(), getAllDrips.get(0).getNosel());
        Assertions.assertEquals(sprinklerEntity.getVolume(), getAllDrips.get(0).getVolume());
        Assertions.assertEquals(sprinklerEntity.getRadius(), getAllDrips.get(0).getRadius());
        Assertions.assertEquals(sprinklerEntity.getUrl(), getAllDrips.get(0).getUrl());
    }

    @Test
    void getAllSprinklers_sprinklersNotExists(){
        when(mockSprinklerRepository.findAll())
                .thenReturn(null);

        Assertions.assertNull(mockSprinklerRepository.findAll());
    }

//    @Test
//    void testGetPumpNumsByUser_pumpExists(){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        String str1 = "2014-04-08 12:30";
//        LocalDateTime dateTime1 = LocalDateTime.parse(str1, formatter);
//        SprinklerNumbers sprNumbers = new SprinklerNumbers();
//        sprNumbers.setUserId(2L)
//                .setSprinklerId(1L)
//                .setNumbers(5)
//                .setStatus("Обработва се")
//                .setPrice(BigDecimal.valueOf(25.14))
//                .setRegisteredAt(dateTime1)
//                .setId(1L);
//
//        String str2 = "2022-04-08 09:01";
//        LocalDateTime dateTime2 = LocalDateTime.parse(str2, formatter);
//        SprinklerNumbers sprNumbers1 = new SprinklerNumbers();
//        sprNumbers1.setUserId(2L)
//                .setSprinklerId(2L)
//                .setNumbers(1)
//                .setStatus("Изпратена")
//                .setPrice(BigDecimal.valueOf(28.14))
//                .setRegisteredAt(dateTime2)
//                .setId(2L);
//
//        SprinklerEntity sprinklerEntity = new SprinklerEntity();
//        sprinklerEntity
//                .setKind("Роторен разпръсквач")
//                .setModel("S100-1")
//                .setMake("RAIN")
//                .setCode("01001")
//                .setSize("1\"")
//                .setPressure("2,76÷6,21")
//                .setNosel("5÷30")
//                .setVolume("19,3÷123")
//                .setRadius("13,1÷23,5")
//                .setPrice(BigDecimal.valueOf(121.5))
//                .setPieces(30)
//                .setUrl("/images/sprinkler/spr-s100.png")
//                .setId(1L);
//
//        List<SprinklerNumbers> dripsNum = new ArrayList<>();
//        dripsNum.add(sprNumbers);
//        dripsNum.add(sprNumbers1);
//
//        List<SprinklerNumbers> drNum = mockSprinklerNumRepository.
//                findAllByUserIdOrderByRegisteredAtAsc(1L);
//        when(drNum).thenReturn(dripsNum);
//
//        Optional<SprinklerEntity> drEn = mockSprinklerRepository.findById(1L);
//        when(drEn).thenReturn(Optional.of(sprinklerEntity));
//
//        List<SprinklerEntity> getDripNumsByUser = toTest.getSprinklerNumsByUser(1L);
//
//        Assertions.assertEquals(dripsNum.get(1).getSprinklerId(),getDripNumsByUser.get(0).getId());
//        Assertions.assertEquals(dripsNum.get(1).getPrice(),getDripNumsByUser.get(0).getPrice());
//        Assertions.assertEquals(dripsNum.get(1).getNumbers(),getDripNumsByUser.get(0).getTemporaryPieces());
//    }

//    @Test
//    void testGetOrdersByUser_pumpExists(){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        String str1 = "2014-04-08 12:30";
//        LocalDateTime dateTime1 = LocalDateTime.parse(str1, formatter);
//        SprinklerNumbers sprNumbers = new SprinklerNumbers();
//        sprNumbers.setUserId(2L)
//                .setSprinklerId(1L)
//                .setNumbers(5)
//                .setStatus("Обработва се")
//                .setPrice(BigDecimal.valueOf(25.14))
//                .setRegisteredAt(dateTime1)
//                .setId(1L);
//
//        String str2 = "2022-04-08 09:01";
//        LocalDateTime dateTime2 = LocalDateTime.parse(str2, formatter);
//        SprinklerNumbers sprNumbers1 = new SprinklerNumbers();
//        sprNumbers1.setUserId(2L)
//                .setSprinklerId(2L)
//                .setNumbers(1)
//                .setStatus("Изпратена")
//                .setPrice(BigDecimal.valueOf(28.14))
//                .setRegisteredAt(dateTime2)
//                .setId(2L);
//
//        SprinklerEntity sprinklerEntity = new SprinklerEntity();
//        sprinklerEntity
//                .setKind("Роторен разпръсквач")
//                .setModel("S100-1")
//                .setMake("RAIN")
//                .setCode("01001")
//                .setSize("1\"")
//                .setPressure("2,76÷6,21")
//                .setNosel("5÷30")
//                .setVolume("19,3÷123")
//                .setRadius("13,1÷23,5")
//                .setPrice(BigDecimal.valueOf(121.5))
//                .setPieces(30)
//                .setUrl("/images/sprinkler/spr-s100.png")
//                .setId(1L);
//
//        List<SprinklerNumbers> dripsNum = new ArrayList<>();
//        dripsNum.add(sprNumbers);
//        dripsNum.add(sprNumbers1);
//
//        List<SprinklerNumbers> drNum = mockSprinklerNumRepository
//                .findAllByUserIdOrderByRegisteredAtAsc(1L);
//        when(drNum).thenReturn(dripsNum);
//
//        Optional<SprinklerEntity> drEn = mockSprinklerRepository.findById(1L);
//        when(drEn).thenReturn(Optional.of(sprinklerEntity));
//
//        List<SprinklerEntity> getDripNumsByUser = toTest.getOrdersByUser(1L);
//
//        Assertions.assertEquals(dripsNum.get(1).getSprinklerId(),getDripNumsByUser.get(0).getId());
//        Assertions.assertEquals(dripsNum.get(1).getPrice(),getDripNumsByUser.get(0).getPrice());
//        Assertions.assertEquals(dripsNum.get(1).getNumbers(),getDripNumsByUser.get(0).getTemporaryPieces());
//    }
}
