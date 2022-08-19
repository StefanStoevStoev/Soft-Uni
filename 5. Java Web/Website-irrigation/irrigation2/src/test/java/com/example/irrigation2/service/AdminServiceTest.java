package com.example.irrigation2.service;

import com.example.irrigation2.model.entity.*;
import com.example.irrigation2.model.entity.enums.RoleEnum;
import com.example.irrigation2.model.views.AuthViewModel;
import com.example.irrigation2.repository.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {

    @Mock
    private PumpNumRepository mockPumpNumRepository;
    @Mock
    private PumpRepository mockPumpRepository;
    @Mock
    private DripNumRepository mockDripNumRepository;
    @Mock
    private DripRepository mockDripRepository;
    @Mock
    private SprinklerNumRepository mockSprinklerNumRepository;
    @Mock
    private SprinklerRepository mockSprinklerRepository;
    @Mock
    private UserRepository mockUserRepository;
    private AdminService toTest;

    @BeforeEach
    void setUp() {
        toTest = new AdminService(
                mockPumpNumRepository, mockPumpRepository, mockDripNumRepository,
                mockDripRepository, mockSprinklerNumRepository, mockSprinklerRepository,
                mockUserRepository
        );
    }

    @Test
    void testGetNotSendSprinklers_sprinklerExist() {
        //arrange
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime ldt1 = LocalDateTime.parse("2014-04-08 12:30", formatter);
        SprinklerNumbers sprinklernum1 = new SprinklerNumbers()
                .setNumbers(52)
                .setPrice(BigDecimal.valueOf(52.23))
                .setUserId(1L)
                .setSprinklerId(1L)
                .setRegisteredAt(ldt1)
                .setStatus("Обработва се");

        LocalDateTime ldt2 = LocalDateTime.parse("2018-04-08 12:30", formatter);
        SprinklerNumbers sprinklernum2 = new SprinklerNumbers()
                .setNumbers(52)
                .setPrice(BigDecimal.valueOf(52.23))
                .setUserId(1L)
                .setSprinklerId(1L)
                .setRegisteredAt(ldt2)
                .setStatus("Обработва се");
        List<SprinklerNumbers> sprNumList = new ArrayList<>();
        sprNumList.add(sprinklernum2);
        sprNumList.add(sprinklernum1);

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
                .setUrl("/images/sprinkler/spr-s50.png")
                .setId(1L);

        UserEntity user1 = new UserEntity()
                .setRole(List.of(new RoleEntity().setRole(RoleEnum.USER)))
                .setFirstName("Pesho")
                .setLastName("Peshev")
                .setEmail("pesho@gmail.com")
                .setAddress("ул. Стефан Караджа 42")
                .setPhone("0858636468")
                .setPassword(String.valueOf(123));

        when(mockSprinklerNumRepository.
                findAllByStatus("Обработва се",
                        Sort.by(Sort.Direction.ASC, "registeredAt")))
                .thenReturn(sprNumList);
        when(mockSprinklerRepository.getById(1L))
                .thenReturn(sprinklerEntity);

        when(mockUserRepository.getById(1L)).thenReturn(user1);

        List<AuthViewModel> notSendSprinklers = toTest.getNotSendSprinklers();

        Assertions.assertEquals(sprinklernum1.getNumbers(), notSendSprinklers.get(1).getPieces());
        Assertions.assertEquals(sprinklernum1.getPrice(), notSendSprinklers.get(1).getPrice());
        Assertions.assertEquals(sprinklernum1.getId(), notSendSprinklers.get(1).getId());
        Assertions.assertEquals(sprinklernum1.getRegisteredAt(), notSendSprinklers.get(1).getOrderedAt());

        Assertions.assertEquals(sprinklerEntity.getKind(), notSendSprinklers.get(0).getName());
        Assertions.assertEquals(sprinklerEntity.getCode(), notSendSprinklers.get(0).getCode());
        Assertions.assertEquals(sprinklerEntity.getPieces(), notSendSprinklers.get(0).getAllPieces());
        Assertions.assertEquals(sprinklerEntity.getPrice(), notSendSprinklers.get(0).getSinglePrice());
        Assertions.assertEquals(sprinklerEntity.getUrl(), notSendSprinklers.get(0).getUrlPic());

        Assertions.assertEquals(user1.getId(), notSendSprinklers.get(0).getUserId());
        Assertions.assertEquals(user1.getEmail(), notSendSprinklers.get(0).getUserEmail());
        Assertions.assertEquals(user1.getAddress(), notSendSprinklers.get(0).getUserAddress());
        Assertions.assertEquals(user1.getPhone(), notSendSprinklers.get(0).getUserPhone());
        Assertions.assertEquals(user1.getFirstName() + " " + user1.getLastName(), notSendSprinklers.get(0).getUserName());
    }

    @Test
    void testGetNotSendSprinklers_sprinklerNotExist() {

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

        when(mockSprinklerNumRepository.
                findAllByStatus("Обработва се",
                        Sort.by(Sort.Direction.ASC, "registeredAt")))
                .thenReturn(null);

        Assertions.assertThrows(
                NullPointerException.class, () -> toTest.getNotSendSprinklers());
    }

    @Test
    void testGetNotSendDrips_dripExist() {
        //arrange
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime ldt = LocalDateTime.parse("2014-04-08 12:30", formatter);
        DripNumbers dripNum = new DripNumbers()
                .setDripId(1L)
                .setNumbers(5)
                .setStatus("Обработва се")
                .setPrice(BigDecimal.valueOf(25.14))
                .setRegisteredAt(ldt);

        List<DripNumbers> dripNumList = new ArrayList<>();
        dripNumList.add(dripNum);

        DripEntity dripEntity = new DripEntity();
        dripEntity
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
                .setId(1L);

        UserEntity user1 = new UserEntity()
                .setRole(List.of(new RoleEntity().setRole(RoleEnum.USER)))
                .setFirstName("Pesho")
                .setLastName("Peshev")
                .setEmail("pesho@gmail.com")
                .setAddress("ул. Стефан Караджа 42")
                .setPhone("0858636468")
                .setPassword(String.valueOf(123));

        when(mockDripNumRepository.
                findAllByStatus("Обработва се",
                        Sort.by(Sort.Direction.ASC, "registeredAt")))
                .thenReturn(dripNumList);
        when(mockDripRepository.getById(1L))
                .thenReturn(dripEntity);

        when(mockUserRepository.getById(dripNum.getUserId())).thenReturn(user1);

        List<AuthViewModel> getNotSendDrips = toTest.getNotSendDrips();

        Assertions.assertEquals(dripNum.getNumbers(), getNotSendDrips.get(0).getPieces());
        Assertions.assertEquals(dripNum.getPrice(), getNotSendDrips.get(0).getPrice());
        Assertions.assertEquals(dripNum.getId(), getNotSendDrips.get(0).getId());
        Assertions.assertEquals(dripNum.getRegisteredAt(), getNotSendDrips.get(0).getOrderedAt());

        Assertions.assertEquals(dripEntity.getName(), getNotSendDrips.get(0).getName());
        Assertions.assertEquals(dripEntity.getCode(), getNotSendDrips.get(0).getCode());
        Assertions.assertEquals(dripEntity.getPieces(), getNotSendDrips.get(0).getAllPieces());
        Assertions.assertEquals(dripEntity.getPrice(), getNotSendDrips.get(0).getSinglePrice());
        Assertions.assertEquals(dripEntity.getUrlPic(), getNotSendDrips.get(0).getUrlPic());

        Assertions.assertEquals(user1.getId(), getNotSendDrips.get(0).getUserId());
        Assertions.assertEquals(user1.getEmail(), getNotSendDrips.get(0).getUserEmail());
        Assertions.assertEquals(user1.getAddress(), getNotSendDrips.get(0).getUserAddress());
        Assertions.assertEquals(user1.getPhone(), getNotSendDrips.get(0).getUserPhone());
        Assertions.assertEquals(user1.getFirstName() + " " + user1.getLastName(), getNotSendDrips.get(0).getUserName());
    }

    @Test
    void testGetNotSendDrips_dripNotExist() {

        when(mockDripNumRepository.
                findAllByStatus("Обработва се",
                        Sort.by(Sort.Direction.ASC, "registeredAt")))
                .thenReturn(null);

        Assertions.assertThrows(
                NullPointerException.class, () -> toTest.getNotSendDrips());
    }

    @Test
    void testGetNotSendPumps_pumpExist() {
        //arrange
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime ldt = LocalDateTime.parse("2014-04-08 12:30", formatter);
        PumpNumbers pumpNum = new PumpNumbers()
                .setUserId(2L)
                .setPumpId(2L)
                .setNumbers(1)
                .setStatus("Обработва се")
                .setPrice(BigDecimal.valueOf(28.14))
                .setRegisteredAt(ldt);

        List<PumpNumbers> pumpNumList = new ArrayList<>();
        pumpNumList.add(pumpNum);

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

        UserEntity user1 = new UserEntity()
                .setRole(List.of(new RoleEntity().setRole(RoleEnum.USER)))
                .setFirstName("Pesho")
                .setLastName("Peshev")
                .setEmail("pesho@gmail.com")
                .setAddress("ул. Стефан Караджа 42")
                .setPhone("0858636468")
                .setPassword(String.valueOf(123));

        when(mockPumpNumRepository.
                findAllByStatus("Обработва се",
                        Sort.by(Sort.Direction.ASC, "registeredAt")))
                .thenReturn(pumpNumList);
        when(mockPumpRepository.getById(pumpNum.getUserId()))
                .thenReturn(pumpEntity);

        when(mockUserRepository.getById(pumpNum.getUserId())).thenReturn(user1);

        List<AuthViewModel> getNotSendPumps = toTest.getNotSendPumps();

        Assertions.assertEquals(pumpNum.getNumbers(), getNotSendPumps.get(0).getPieces());
        Assertions.assertEquals(pumpNum.getPrice(), getNotSendPumps.get(0).getPrice());
        Assertions.assertEquals(pumpNum.getId(), getNotSendPumps.get(0).getId());
        Assertions.assertEquals(pumpNum.getRegisteredAt(), getNotSendPumps.get(0).getOrderedAt());

        Assertions.assertEquals(pumpEntity.getKind(), getNotSendPumps.get(0).getName());
        Assertions.assertEquals(pumpEntity.getCode(), getNotSendPumps.get(0).getCode());
        Assertions.assertEquals(pumpEntity.getPieces(), getNotSendPumps.get(0).getAllPieces());
        Assertions.assertEquals(pumpEntity.getPrice(), getNotSendPumps.get(0).getSinglePrice());
        Assertions.assertEquals(pumpEntity.getUrlPic(), getNotSendPumps.get(0).getUrlPic());

        Assertions.assertEquals(user1.getId(), getNotSendPumps.get(0).getUserId());
        Assertions.assertEquals(user1.getEmail(), getNotSendPumps.get(0).getUserEmail());
        Assertions.assertEquals(user1.getAddress(), getNotSendPumps.get(0).getUserAddress());
        Assertions.assertEquals(user1.getPhone(), getNotSendPumps.get(0).getUserPhone());
        Assertions.assertEquals(user1.getFirstName() + " " + user1.getLastName(), getNotSendPumps.get(0).getUserName());
    }

    @Test
    void testGetNotSendPumps_pumpNotExist() {

        when(mockPumpNumRepository.
                findAllByStatus("Обработва се",
                        Sort.by(Sort.Direction.ASC, "registeredAt")))
                .thenReturn(null);

        Assertions.assertThrows(
                NullPointerException.class, () -> toTest.getNotSendPumps());
    }

}
