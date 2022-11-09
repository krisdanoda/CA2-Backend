package entities;

import dtos.ChampionDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "champion")
@NamedQuery(name = "Champion.deleteAllRows", query = "DELETE from Champion " +
        "")
public class Champion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private String name;


    @ManyToMany(mappedBy = "champions")
    private List<User> userList;

    public Champion() {
    }

    public Champion( String name, Long id) {
        this.id = id;
        this.name = name;
    }

    public ChampionDTO createDTO(){
        return new ChampionDTO( name, id);
    }

    @Override
    public String toString() {
        return "Champion{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +

                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
