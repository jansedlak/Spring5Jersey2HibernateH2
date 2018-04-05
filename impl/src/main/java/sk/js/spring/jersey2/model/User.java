package sk.js.spring.jersey2.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author jan.sedlak on 4/4/2018.
 */
@Entity
@Table(name = "User")
public class User implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
