package dtos;

import entities.Champion;
import org.glassfish.jersey.internal.guava.MoreObjects;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class ChampionDTO {
    String name;
    String key;

    public Champion createEntity(){
        return new Champion(name, key);
    }

    public ChampionDTO(String name, String key) {
        this.name = name;
        this.key = key;
    }

    public ChampionDTO(Champion champion) {
        this.name = champion.getName();
        this.key = champion.getId();

    }

}


