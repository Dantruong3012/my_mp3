package com.dantruong.my_mp3.service;

import com.dantruong.my_mp3.connection.MusicRepo;
import com.dantruong.my_mp3.entity.Music;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MusicService {
    private final MusicRepo musicRepo;

    public MusicService(MusicRepo musicRepo) {
        this.musicRepo = musicRepo;
    }

    // them
    @Transactional(rollbackFor = Exception.class)
    public  void  InserMusic(Music music){
        musicRepo.save(music);
    }

    // list music da luu
    public List<Music> showMusic(){
        return musicRepo.findAll();
    }

    // tim kiem
    public List<Music> findMusic(String name){
      return   musicRepo.findByNameContainingIgnoreCase(name);
    }

    // delete music
    public String deleteMusic(Integer id){
       if (id != null){
           Music music = musicRepo.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy bài nhạc này"));
           musicRepo.delete(music);
           return "Đã xoá thành công bản nhạc này khỏi list";
       }
       return "Id không được phép null!";
    }
}
