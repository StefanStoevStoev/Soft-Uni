package com.example.irrigation2.service;

import com.example.irrigation2.model.DTO.AddSprinklerDTO;
import com.example.irrigation2.model.entity.SprinklerEntity;
import com.example.irrigation2.repository.SprinklerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SprinklerService {

    private final SprinklerRepository sprinklerRepository;
    private final ModelMapper mapper;


    public SprinklerService(SprinklerRepository sprinklerRepository, ModelMapper mapper) {
        this.sprinklerRepository = sprinklerRepository;
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

    public List<SprinklerEntity> getAllSprinklers(){

        return sprinklerRepository.findAll();
    }

    public SprinklerEntity addSprinklerToDB(AddSprinklerDTO addSprinklerDTO) {
        SprinklerEntity sprinkler = mapper.map(addSprinklerDTO, SprinklerEntity.class);
        return sprinklerRepository.save(sprinkler);
    }
}
