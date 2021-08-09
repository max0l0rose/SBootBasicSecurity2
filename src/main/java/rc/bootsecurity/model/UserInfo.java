package rc.bootsecurity.model;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserInfo extends BaseEntity {

    @NotNull(message = "Name may not be null........")
    @Size(min = 10, max = 20, message = "Size name 10-20")
    @NotEmpty(message = "Name may not be empty.")
    @Column(nullable = false)
    private String fio;

}