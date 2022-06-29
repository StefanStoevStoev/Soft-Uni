package com.example.exam25;

import com.example.exam25.model.entity.StyleEntity;
import com.example.exam25.model.entity.enums.StyleEnum;
import com.example.exam25.repository.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StylesSeed implements CommandLineRunner {

    private StyleRepository styleRepository;

    @Autowired
    public StylesSeed(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (this.styleRepository.count() == 0) {
            List<StyleEntity> style = Arrays.stream(StyleEnum.values())
                    .map(StyleEntity::new).toList();

            style.get(0).setName(StyleEnum.POP);
            style.get(1).setName(StyleEnum.ROCK);
            style.get(2).setName(StyleEnum.JAZZ);

            styleRepository.saveAll(style);
        }
    }
}
