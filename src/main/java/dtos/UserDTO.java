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
    Set<String> roles;
    Set<ChampionDTO> champions ;

    public UserDTO(User user){
        this.user_name = user.getUserName();
        this.champions = new HashSet<>();
        this.roles = new HashSet<>();

        this.roles.addAll(user.getRolesAsStrings());
        for (Champion champion: user.getChampions()) {
            this.champions.add(new ChampionDTO(champion));
        }

    }

    public User createEntity(){

        User user = new User();
        user.setUserName(this.user_name);
        List<Role> entityRoles = new ArrayList<>();
        for (String role: roles) {
            entityRoles.add(new Role(role));
        }
        user.setRoleList(entityRoles);

        List<Champion> champions = new ArrayList<>();
        for (ChampionDTO championDTO: this.champions){
            user.addChampion(championDTO.createEntity());
        }

        return user;

    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Set<ChampionDTO> getChampions() {
        return champions;
    }

    public void setChampions(Set<ChampionDTO> champions) {
        this.champions = champions;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "user_name='" + user_name + '\'' +
                ", roles=" + roles +
                ", champions=" + champions +
                '}';
    }
}
