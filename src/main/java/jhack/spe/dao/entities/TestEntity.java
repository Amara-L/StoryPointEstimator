package jhack.spe.dao.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Description entity.
 *
 * @author FirstName S. LastName
 * @version 1.0.0 created 09.11.2019
 */
@Entity  // <--- annotation indicating entity
@Table(name = "test")  // <--- annotation indicating table by name table
public class TestEntity {

    /**
     * Variable id.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "test_seq")
    @SequenceGenerator(name = "test_seq",
            sequenceName = "test_seq", allocationSize = 1)
    @Setter
    @Getter
    private int id;

    /**
     * Variable name.
     */
    @Column(name = "name")
    @Setter
    @Getter
    private String name;


}
