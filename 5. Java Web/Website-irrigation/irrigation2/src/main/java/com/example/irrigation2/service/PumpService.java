package com.example.irrigation2.service;

import com.example.irrigation2.model.entity.DripEntity;
import com.example.irrigation2.model.entity.PumpEntity;
import com.example.irrigation2.repository.PumpRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PumpService {

    private final PumpRepository pumpRepository;

    public PumpService(PumpRepository pumpRepository) {
        this.pumpRepository = pumpRepository;
    }

    public PumpEntity getPumpById(Long id) throws Exception {
        return pumpRepository.findById(id).orElseThrow(() -> new Exception(String.format("Cannot find pump with id: %d", id)));
    }

    public void initPumps() {

        if (pumpRepository.count() == 0) {
            PumpEntity hiPeri1_5 = new PumpEntity();
            hiPeri1_5.setKind("Вихрова помпа")
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

    public List<PumpEntity> getAllPumps() {
        return pumpRepository.findAll();
    }
}
