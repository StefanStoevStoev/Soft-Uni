package com.example.irrigation2.service;

import com.example.irrigation2.model.entity.PumpEntity;
import com.example.irrigation2.model.entity.PumpNumbers;
import com.example.irrigation2.repository.PumpNumRepository;
import com.example.irrigation2.repository.PumpRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PumpServiceTest {
    @Mock
    private PumpRepository mockPumpRepository;
    @Mock
    private PumpNumRepository mockPumpNumRepository;
    @Mock
    private ModelMapper mockModelMapper;
    private PumpService toTest;

    @BeforeEach
    void setUp(){
        toTest = new PumpService(mockPumpRepository,
                mockPumpNumRepository, mockModelMapper);
    }

    @Test
    void getAllPumps_pumpsExists(){

        PumpEntity pumpEntity = new PumpEntity();
        pumpEntity
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

        List<PumpEntity> pumps = new ArrayList<>();
        pumps.add(pumpEntity);
        when(mockPumpRepository.findAll()).thenReturn(pumps);

        List<PumpEntity> getAllPumps = toTest.getAllPumps();

        Assertions.assertEquals(pumpEntity.getKind(), getAllPumps.get(0).getKind());
        Assertions.assertEquals(pumpEntity.getCode(), getAllPumps.get(0).getCode());
        Assertions.assertEquals(pumpEntity.getMake(), getAllPumps.get(0).getMake());
        Assertions.assertEquals(pumpEntity.getMaxWorkingPressure(), getAllPumps.get(0).getMaxWorkingPressure());
        Assertions.assertEquals(pumpEntity.getModel(), getAllPumps.get(0).getModel());
        Assertions.assertEquals(pumpEntity.getOrderDate(), getAllPumps.get(0).getOrderDate());
        Assertions.assertEquals(pumpEntity.getTemporaryPieces(), getAllPumps.get(0).getTemporaryPieces());
        Assertions.assertEquals(pumpEntity.getUrlDiagram(), getAllPumps.get(0).getUrlDiagram());
        Assertions.assertEquals(pumpEntity.getUrlPic(), getAllPumps.get(0).getUrlPic());
        Assertions.assertEquals(pumpEntity.getPieces(), getAllPumps.get(0).getPieces());
        Assertions.assertEquals(pumpEntity.getPrice(), getAllPumps.get(0).getPrice());
        Assertions.assertEquals(pumpEntity.getHead(), getAllPumps.get(0).getHead());
        Assertions.assertEquals(pumpEntity.getDiameterInlet(), getAllPumps.get(0).getDiameterInlet());
        Assertions.assertEquals(pumpEntity.getDiameterOutlet(), getAllPumps.get(0).getDiameterOutlet());
        Assertions.assertEquals(pumpEntity.getWeight(), getAllPumps.get(0).getWeight());
        Assertions.assertEquals(pumpEntity.getVoltage(), getAllPumps.get(0).getVoltage());
        Assertions.assertEquals(pumpEntity.getPower(), getAllPumps.get(0).getPower());
        Assertions.assertEquals(pumpEntity.getCurrent(), getAllPumps.get(0).getCurrent());
    }
    @Test
    void getAllPumps_pumpsNotExists(){
        when(mockPumpRepository.findAll())
                .thenReturn(null);

        Assertions.assertNull(mockPumpRepository.findAll());
    }
    @Test
    void testGetPumpNumsByUser_pumpExists(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String str2 = "2021-03-08 04:01";
        LocalDateTime dateTime2 = LocalDateTime.parse(str2, formatter);
        PumpNumbers pumpNumbers1 = new PumpNumbers();
        pumpNumbers1.
                setUserId(2L)
                .setPumpId(2L)
                .setNumbers(1)
                .setStatus("Обработва се")
                .setPrice(BigDecimal.valueOf(28.14))
                .setRegisteredAt(dateTime2)
                .setId(1L);

        String str3 = "2021-01-01 23:59";
        LocalDateTime dateTime3 = LocalDateTime.parse(str3, formatter);
        PumpNumbers pumpNumbers2 = new PumpNumbers();
        pumpNumbers2.setUserId(2L)
                .setPumpId(1L)
                .setNumbers(3)
                .setPrice(BigDecimal.valueOf(338.14))
                .setRegisteredAt(dateTime3)
                .setId(2L);

        PumpEntity pumpEntity = new PumpEntity();
        pumpEntity
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
                .setUrlPic("/images/pumps/pump-hiperi-1-5.png")
                .setId(1L);

        List<PumpNumbers> dripsNum = new ArrayList<>();
        dripsNum.add(pumpNumbers1);
        dripsNum.add(pumpNumbers2);

        List<PumpNumbers> drNum = mockPumpNumRepository.findAllByUserIdOrderByRegisteredAtAsc(1L);
        when(drNum).thenReturn(dripsNum);

        Optional<PumpEntity> drEn = mockPumpRepository.findById(1L);
        when(drEn).thenReturn(Optional.of(pumpEntity));

        List<PumpEntity> getDripNumsByUser = toTest.getPumpNumsByUser(1L);

        Assertions.assertEquals(dripsNum.get(1).getPumpId(),getDripNumsByUser.get(0).getId());
        Assertions.assertEquals(dripsNum.get(1).getPrice(),getDripNumsByUser.get(0).getPrice());
        Assertions.assertEquals(dripsNum.get(1).getNumbers(),getDripNumsByUser.get(0).getTemporaryPieces());
    }

    @Test
    void testGetOrdersByUser_dripsExists(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String str2 = "2021-03-08 04:01";
        LocalDateTime dateTime2 = LocalDateTime.parse(str2, formatter);
        PumpNumbers pumpNumbers1 = new PumpNumbers();
        pumpNumbers1.
                setUserId(2L)
                .setPumpId(2L)
                .setNumbers(1)
                .setStatus("Обработва се")
                .setPrice(BigDecimal.valueOf(28.14))
                .setRegisteredAt(dateTime2)
                .setId(1L);

        String str3 = "2021-01-01 23:59";
        LocalDateTime dateTime3 = LocalDateTime.parse(str3, formatter);
        PumpNumbers pumpNumbers2 = new PumpNumbers();
        pumpNumbers2.setUserId(2L)
                .setPumpId(1L)
                .setNumbers(3)
                .setPrice(BigDecimal.valueOf(338.14))
                .setRegisteredAt(dateTime3)
                .setId(2L);

        PumpEntity pumpEntity = new PumpEntity();
        pumpEntity
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
                .setUrlPic("/images/pumps/pump-hiperi-1-5.png")
                .setId(1L);

        List<PumpNumbers> dripsNum = new ArrayList<>();
        dripsNum.add(pumpNumbers1);
        dripsNum.add(pumpNumbers2);

        List<PumpNumbers> drNum = mockPumpNumRepository.findAllByUserIdOrderByRegisteredAtAsc(1L);
        when(drNum).thenReturn(dripsNum);

        Optional<PumpEntity> drEn = mockPumpRepository.findById(2L);
        when(drEn).thenReturn(Optional.of(pumpEntity));

        List<PumpEntity> getOrdersByUser = toTest.getOrdersByUser(1L);

        Assertions.assertEquals(dripsNum.get(1).getPumpId(),getOrdersByUser.get(0).getId());
        Assertions.assertEquals(dripsNum.get(0).getPrice(),getOrdersByUser.get(0).getPrice());
        Assertions.assertEquals(dripsNum.get(0).getNumbers(),getOrdersByUser.get(0).getPieces());
        Assertions.assertEquals(dripsNum.get(0).getRegisteredAt(),getOrdersByUser.get(0).getOrderDate());
        Assertions.assertEquals(dripsNum.get(0).getStatus(),getOrdersByUser.get(0).getStatus());
    }

}
