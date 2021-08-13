package rc.bootsecurity.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Base class with property 'id'.
 * Used as a base class for all objects that requires this property.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

@MappedSuperclass
@Data
public class BaseEntity {

    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreatedDate
    @Column(name = "created")
    private Date created;

    @LastModifiedDate
    @Column(name = "updated")
    private Date updated;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private Status status;
}
