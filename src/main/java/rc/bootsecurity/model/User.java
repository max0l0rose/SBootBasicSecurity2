package rc.bootsecurity.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User extends BaseEntity {

    @NotNull()
    @Size(min=10, max=20)
//    @NotEmpty()
    @Column(nullable = false)
    private String username;

    @NotNull()
    @Size(min=3, max=80)
//    @NotEmpty(message = "Name may not be empty.")
    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"),

//            indexes = {
////                    @Index(name = "idx1", columnList = "role_id"),
////                    @Index(name = "idx2", columnList = "user_id")
//            }

            uniqueConstraints = {
                @UniqueConstraint(columnNames = {"role_id", "user_id" })
            }
    )
    private Collection<Role> roles;

    //private String permissions = "";

//    public List<String> getRoleList() {
//        if(this.roles.length() > 0){
//            return Arrays.asList(this.roles.split(","));
//        }
//        return new ArrayList<>();
//    }
//
//    public List<String> getPermissionList(){
//        if(this.permissions.length() > 0){
//            return Arrays.asList(this.permissions.split(","));
//        }
//        return new ArrayList<>();
//    }
}
