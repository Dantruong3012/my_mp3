package com.dantruong.my_mp3.connection;

import com.dantruong.my_mp3.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicRepo extends JpaRepository<Music, Integer> {
    List<Music> findByNameContainingIgnoreCase(String name);
}
