package rc.bootsecurity.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.Set;

// Эта хрень не нужна потому что роли должны быть в базе

//enum RoleEnum {
//    ADMIN,
//    USER;
//}

@Entity
@Getter
@Setter
public class Role implements GrantedAuthority {

    public Role() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    @NotNull(message = "Name may not be null........")
    //@Enumerated(EnumType.STRING)
    private String name;


//    public String getName() {
//        return getAuthority();
//    };


    @Override
    public String getAuthority() {
        return name; //"ROLE_" +
    }


    public void setAuthority(String s) {
        name = s; //RoleEnum.valueOf(s);
    }


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")

//            indexes = {
//                @Index(name = "idx1", columnList = "role_id"),
//                @Index(name = "idx2", columnList = "user_id")
//            }
    )

    //@ForeignKey(name = "fk_testkey", inverseName = "fk_testkey_inverse")
    private Collection<User> users;


    @Override
    public String toString() {
        return "Role{" + name + '}';
    }
}