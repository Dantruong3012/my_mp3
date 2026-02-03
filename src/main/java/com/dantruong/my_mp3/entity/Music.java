package com.dantruong.my_mp3.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "musics")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String artist;
    @Column(name = "music_genre")
    private String musicGenre;
    @Column(name = "music_path")
    private String musicPath;
}
