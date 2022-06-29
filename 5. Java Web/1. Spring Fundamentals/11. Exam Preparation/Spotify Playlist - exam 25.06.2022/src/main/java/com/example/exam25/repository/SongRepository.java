package com.example.exam25.repository;

import com.example.exam25.model.DTO.SongDTO;
import com.example.exam25.model.entity.SongEntity;
import com.example.exam25.model.entity.StyleEntity;
import com.example.exam25.model.entity.enums.StyleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<SongEntity, Long> {

//    List<SongEntity> findByStyle(StyleEntity style);
//
//
//    List<SongDTO> findAllById(Long id);

    List<SongEntity> findAllByStyleName(StyleEnum styleEnum);
}
