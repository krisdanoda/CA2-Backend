package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "champion")
@NamedQuery(name = "Champion.deleteAllRows", query = "DELETE from Champion " +
        "")
public class Champion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String name;


    @ManyToMany
    @JoinTable( // This is now the owner side of the relationship
            name = "champs_people",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "champion_id"))
    private Set<User> users = new LinkedHashSet<>();

    public Champion() {
    }

    public Champion( String name, String id) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Champion{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +

                '}';
    }
}
