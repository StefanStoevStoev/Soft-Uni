package com.example.irrigation2.service;

import com.example.irrigation2.model.entity.DripEntity;
import com.example.irrigation2.model.entity.DripNumbers;
import com.example.irrigation2.repository.DripNumRepository;
import com.example.irrigation2.repository.DripRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DripServiceTest {

    @Mock
    private DripRepository mockDripRepository;
    @Mock
    private DripNumRepository mockDripNumRepository;
    @Mock
    private ModelMapper mockModelMapper;
    private DripService toTest;

    @BeforeEach
    void setUp(){
        toTest = new DripService(mockDripRepository,
                mockDripNumRepository, mockModelMapper);
    }

    @Test
    void getAllDrips_dripsExists(){

        DripEntity dripOneSeason = new DripEntity();
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
        List<DripEntity> drips = new ArrayList<>();
        drips.add(dripOneSeason);
        when(mockDripRepository.findAll()).thenReturn(drips);

        List<DripEntity> getAllDrips = toTest.getAllDrips();

        Assertions.assertEquals(dripOneSeason.getSize(), getAllDrips.get(0).getSize());
        Assertions.assertEquals(dripOneSeason.getCode(), getAllDrips.get(0).getCode());
        Assertions.assertEquals(dripOneSeason.getName(), getAllDrips.get(0).getName());
        Assertions.assertEquals(dripOneSeason.getDiameter(), getAllDrips.get(0).getDiameter());
        Assertions.assertEquals(dripOneSeason.getDistBtwDrips(), getAllDrips.get(0).getDistBtwDrips());
        Assertions.assertEquals(dripOneSeason.getFlowPerDrip(), getAllDrips.get(0).getFlowPerDrip());
        Assertions.assertEquals(dripOneSeason.getMaxPressure(), getAllDrips.get(0).getMaxPressure());
        Assertions.assertEquals(dripOneSeason.getTimeOfUse(), getAllDrips.get(0).getTimeOfUse());
        Assertions.assertEquals(dripOneSeason.getUrlPic(), getAllDrips.get(0).getUrlPic());
        Assertions.assertEquals(dripOneSeason.getPieces(), getAllDrips.get(0).getPieces());
        Assertions.assertEquals(dripOneSeason.getPrice(), getAllDrips.get(0).getPrice());
        Assertions.assertEquals(dripOneSeason.getId(), getAllDrips.get(0).getId());
    }
    @Test
    void getAllDrips_dripsNotExists(){
        when(mockDripRepository.findAll())
                .thenReturn(null);

        Assertions.assertNull(mockDripRepository.findAll());
    }

    @Test
    void testGetDripNumsByUser_dripsExists(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String str1 = "2014-04-08 12:30";
        LocalDateTime dateTime1 = LocalDateTime.parse(str1, formatter);
        DripNumbers dripNumbers1 = new DripNumbers();
        dripNumbers1.setUserId(1L)
                .setDripId(1L)
                .setNumbers(5)
                .setStatus("Обработва се")
                .setPrice(BigDecimal.valueOf(25.14))
                .setRegisteredAt(dateTime1);

        String str2 = "2015-04-08 12:30";
        LocalDateTime dateTime2 = LocalDateTime.parse(str2, formatter);
        DripNumbers dripNumbers2 = new DripNumbers();
        dripNumbers2.setUserId(2L)
                .setDripId(2L)
                .setNumbers(2)
                .setPrice(BigDecimal.valueOf(23.14))
                .setRegisteredAt(dateTime2);

        DripEntity dripOneSeason = new DripEntity();
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

        List<DripNumbers> dripsNum = new ArrayList<>();
        dripsNum.add(dripNumbers1);
        dripsNum.add(dripNumbers2);

        List<DripNumbers> drNum = mockDripNumRepository.findAllByUserIdOrderByRegisteredAtAsc(2L);
        when(drNum).thenReturn(dripsNum);

        Optional<DripEntity> drEn = mockDripRepository.findById(2L);
        when(drEn).thenReturn(Optional.of(dripOneSeason));

        List<DripEntity> getDripNumsByUser = toTest.getDripNumsByUser(2L);

        Assertions.assertEquals(dripsNum.get(0).getDripId(),getDripNumsByUser.get(0).getId());
        Assertions.assertEquals(dripsNum.get(1).getPrice(),getDripNumsByUser.get(0).getPrice());
        Assertions.assertEquals(dripsNum.get(1).getNumbers(),getDripNumsByUser.get(0).getTemporaryPieces());
    }
    @Test
    void testGetDripNumsByUser_dripsNotExists(){
        when(mockDripRepository.findById(1L))
                .thenReturn(null);
        when(mockDripNumRepository.findAllByUserIdOrderByRegisteredAtAsc(1L))
                .thenReturn(null);


        Assertions.assertNull(mockDripRepository.findById(1L));
        Assertions.assertNull(mockDripNumRepository.findAllByUserIdOrderByRegisteredAtAsc(1L));
    }

    @Test
    void testGetOrdersByUser_dripsExists(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String str1 = "2014-04-08 12:30";
        LocalDateTime dateTime1 = LocalDateTime.parse(str1, formatter);
        DripNumbers dripNumbers1 = new DripNumbers();
        dripNumbers1.setUserId(1L)
                .setDripId(1L)
                .setNumbers(5)
                .setStatus("Обработва се")
                .setPrice(BigDecimal.valueOf(25.14))
                .setRegisteredAt(dateTime1);

        String str2 = "2015-04-08 12:30";
        LocalDateTime dateTime2 = LocalDateTime.parse(str2, formatter);
        DripNumbers dripNumbers2 = new DripNumbers();
        dripNumbers2.setUserId(2L)
                .setDripId(2L)
                .setNumbers(2)
                .setPrice(BigDecimal.valueOf(23.14))
                .setRegisteredAt(dateTime2);

        DripEntity dripOneSeason = new DripEntity();
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

        List<DripNumbers> dripsNum = new ArrayList<>();
        dripsNum.add(dripNumbers1);
        dripsNum.add(dripNumbers2);

        List<DripNumbers> drNum = mockDripNumRepository.findAllByUserIdOrderByRegisteredAtAsc(1L);
        when(drNum).thenReturn(dripsNum);

        Optional<DripEntity> drEn = mockDripRepository.findById(1L);
        when(drEn).thenReturn(Optional.of(dripOneSeason));

        List<DripEntity> getOrdersByUser = toTest.getOrdersByUser(1L);

        Assertions.assertEquals(dripsNum.get(0).getDripId(),getOrdersByUser.get(0).getId());
        Assertions.assertEquals(dripsNum.get(0).getPrice(),getOrdersByUser.get(0).getPrice());
        Assertions.assertEquals(dripsNum.get(0).getNumbers(),getOrdersByUser.get(0).getPieces());
        Assertions.assertEquals(dripsNum.get(0).getRegisteredAt(),getOrdersByUser.get(0).getOrderDate());
        Assertions.assertEquals(dripsNum.get(0).getStatus(),getOrdersByUser.get(0).getStatus());
    }
}
