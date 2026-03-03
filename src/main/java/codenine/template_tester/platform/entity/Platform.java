package codenine.template_tester.platform.entity;

import codenine.template_tester.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "platforms")
public class Platform extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public Platform(String name) {
        this.name = name;
    }

    public void update(String name) {
        this.name = name;
    }
}


