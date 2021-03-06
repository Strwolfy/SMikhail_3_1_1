package CRUD.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

// Этот класс реализует интерфейс GrantedAuthority, в котором необходимо переопределить только один метод getAuthority() (возвращает имя роли).
// Имя роли должно соответствовать шаблону: «ROLE_ИМЯ», например, ROLE_USER.
@Entity
@Data
@Table(name = "roles")
public class Role implements GrantedAuthority {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String role;

    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> user;

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    public Role() {

    }

    public Role(String role, Set<User> user) {
        this.role = role;
        this.user = user;
    }

    public Role(int id, String role, Set<User> user) {
        this.id = id;
        this.role = role;
        this.user = user;
    }



    @Override
    public String getAuthority() {
        return role;
    }
}
