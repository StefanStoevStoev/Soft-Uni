package com.example.irrigation2.service;

import com.example.irrigation2.model.DTO.AdminDTO;
import com.example.irrigation2.model.DTO.DripDTO;
import com.example.irrigation2.model.entity.*;
import com.example.irrigation2.model.views.AuthViewModel;
import com.example.irrigation2.repository.*;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final PumpNumRepository pumpNumRepository;
    private final PumpRepository pumpRepository;
    private final DripNumRepository dripNumRepository;
    private final DripRepository dripRepository;
    private final SprinklerNumRepository sprinklerNumRepository;
    private final SprinklerRepository sprinklerRepository;
    private final UserRepository userRepository;

    public AdminService(PumpNumRepository pumpNumRepository, PumpRepository pumpRepository, DripNumRepository dripNumRepository, DripRepository dripRepository, SprinklerNumRepository sprinklerNumRepository, SprinklerRepository sprinklerRepository, UserRepository userRepository) {
        this.pumpNumRepository = pumpNumRepository;
        this.pumpRepository = pumpRepository;
        this.dripNumRepository = dripNumRepository;
        this.dripRepository = dripRepository;
        this.sprinklerNumRepository = sprinklerNumRepository;
        this.sprinklerRepository = sprinklerRepository;
        this.userRepository = userRepository;
    }

    public List<AuthViewModel> getNotSendSprinklers(){
        String status = "Обработва се";

        List<SprinklerNumbers> sprinklerNum = sprinklerNumRepository.
                findAllByStatus(status, Sort.by(Sort.Direction.ASC, "registeredAt"));

        List<AuthViewModel> sprViewModel = new ArrayList<>();

        AuthViewModel temporaryViewModel = new AuthViewModel();

        for (SprinklerNumbers spr : sprinklerNum) {

            SprinklerEntity sprinklerEntity = sprinklerRepository.getById(spr.getSprinklerId());
            UserEntity user = userRepository.getById(spr.getUserId());

            temporaryViewModel
                    .setId(spr.getId())
                    .setName(sprinklerEntity.getKind())
                    .setCode(sprinklerEntity.getCode())
                    .setPieces(spr.getNumbers())
                    .setAllPieces(sprinklerEntity.getPieces())
                    .setSinglePrice(sprinklerEntity.getPrice())
                    .setPrice(spr.getPrice())
                    .setOrderedAt(spr.getRegisteredAt())
                    .setUrlPic(sprinklerEntity.getUrl())
                    .setUserId(user.getId())
                    .setUserEmail(user.getEmail())
                    .setUserAddress(user.getAddress())
                    .setUserPhone(user.getPhone())
                    .setName(user.getFirstName() + " " + user.getLastName());

            sprViewModel.add(temporaryViewModel);
        }
        return  sprViewModel;
    }

    public List<AuthViewModel> getNotSendPumps(){
        String status = "Обработва се";

        List<PumpNumbers> pumpNum = pumpNumRepository.
                findAllByStatus(status, Sort.by(Sort.Direction.ASC, "registeredAt"));

        List<AuthViewModel> pumpViewModel = new ArrayList<>();

        AuthViewModel temporaryViewModel = new AuthViewModel();

        for (PumpNumbers pump : pumpNum) {

            PumpEntity pumpEntity = pumpRepository.getById(pump.getPumpId());
            UserEntity user = userRepository.getById(pump.getUserId());

            temporaryViewModel
                    .setId(pump.getId())
                    .setName(pumpEntity.getKind())
                    .setCode(pumpEntity.getCode())
                    .setAllPieces(pumpEntity.getPieces())
                    .setSinglePrice(pumpEntity.getPrice())
                    .setPrice(pump.getPrice())
                    .setPieces(pump.getNumbers())
                    .setOrderedAt(pump.getRegisteredAt())
                    .setUrlPic(pumpEntity.getUrlPic())
                    .setUserId(user.getId())
                    .setUserEmail(user.getEmail())
                    .setUserAddress(user.getAddress())
                    .setUserPhone(user.getPhone())
                    .setName(user.getFirstName() + " " + user.getLastName());

            pumpViewModel.add(temporaryViewModel);
        }
        return  pumpViewModel;
    }

    public List<AuthViewModel> getNotSendDrips(){
        String status = "Обработва се";

        List<DripNumbers> dripNum = dripNumRepository.
                findAllByStatus(status, Sort.by(Sort.Direction.ASC, "registeredAt"));

        List<AuthViewModel> dripViewModel = new ArrayList<>();

        for (DripNumbers drips : dripNum) {
            AuthViewModel temporaryViewModel = new AuthViewModel();
            DripEntity dripEntity = dripRepository.getById(drips.getDripId());
            UserEntity user = userRepository.getById(drips.getUserId());

            temporaryViewModel
                    .setId(drips.getId())
                    .setName(dripEntity.getName())
                    .setCode(dripEntity.getCode())
                    .setAllPieces(dripEntity.getPieces())
                    .setSinglePrice(dripEntity.getPrice())
                    .setPrice(drips.getPrice())
                    .setPieces(drips.getNumbers())
                    .setOrderedAt(drips.getRegisteredAt())
                    .setUrlPic(dripEntity.getUrlPic())
                    .setUserId(user.getId())
                    .setUserEmail(user.getEmail())
                    .setUserAddress(user.getAddress())
                    .setUserPhone(user.getPhone())
                    .setUserName(user.getFirstName() + " " + user.getLastName());

            dripViewModel.add(temporaryViewModel);
        }
        return  dripViewModel;
    }

    public void sendOrder(AdminDTO adminDTO) {

        switch (adminDTO.getName()) {
            case "drip" -> {
                DripNumbers dripNum = dripNumRepository.findById(adminDTO.getId()).orElse(null);
                assert dripNum != null;
                dripNum.setStatus("Изпратена")
                        .setSendOn(LocalDateTime.now());
                dripNumRepository.save(dripNum);
            }
            case "pump" -> {
                PumpNumbers pumpNum = pumpNumRepository.findById(adminDTO.getId()).orElse(null);
                assert pumpNum != null;
                pumpNum.setStatus("Изпратена")
                        .setSendOn(LocalDateTime.now());
                pumpNumRepository.save(pumpNum);
            }
            case "sprinkler" -> {
                SprinklerNumbers sprNum = sprinklerNumRepository.findById(adminDTO.getId()).orElse(null);
                assert sprNum != null;
                sprNum.setStatus("Изпратена")
                        .setSendOn(LocalDateTime.now());
                sprinklerNumRepository.save(sprNum);
            }
        }
    }
    public void deleteProductOrderById(AdminDTO adminDTO){
        if(adminDTO.getName().equals("drip")){
            dripNumRepository.deleteById(adminDTO.getId());
        } else if (adminDTO.getName().equals("pump")) {
            pumpNumRepository.deleteById(adminDTO.getId());
        } else if (adminDTO.getName().equals("sprinkler")) {
            pumpNumRepository.deleteById(adminDTO.getId());
        }
    }
}
