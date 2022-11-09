package dtos;

import entities.Champion;
import entities.User;

import java.util.ArrayList;

public class UserDTO {

    String user_name;

    ArrayList<ChampionDTO> champions = new ArrayList<>();

    public UserDTO(User user){
        this.user_name = user.getUserName();
        this.champions = new ArrayList<>();
        for (Champion champion: user.getChampions()) {
            this.champions.add(new ChampionDTO(champion));
        }

    }

}
