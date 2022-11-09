package dtos;

import entities.Champion;
import entities.Role;
import entities.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDTO {

    String user_name;
    ArrayList<String> roles = new ArrayList<>();
    ArrayList<ChampionDTO> champions = new ArrayList<>();

    public UserDTO(User user){
        this.user_name = user.getUserName();
        this.champions = new ArrayList<>();
        this.roles = new ArrayList<>();

        this.roles.addAll(user.getRolesAsStrings());
        for (Champion champion: user.getChampions()) {
            this.champions.add(new ChampionDTO(champion));
        }

    }

    public User createEntity(){

        User user = new User();
        List<Role> entityRoles = new ArrayList<>();
        for (String role: roles) {
            entityRoles.add(new Role(role));
        }
        user.setRoleList(entityRoles);

        List<Champion> champions = new ArrayList<>();
        for (ChampionDTO championDTO: this.champions){
            champions.add(championDTO.createEntity());
        }
        user.setChampions(champions);
        return user;

    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public ArrayList<String> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }

    public ArrayList<ChampionDTO> getChampions() {
        return champions;
    }

    public void setChampions(ArrayList<ChampionDTO> champions) {
        this.champions = champions;
    }
}
