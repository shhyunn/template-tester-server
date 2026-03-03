package codenine.template_tester.tag.entity;

import codenine.template_tester.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(
        name = "tags",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"name", "type"})
        }
)
public class Tag extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING) // 🔥 반드시 이거
    @Column(nullable = false)
    private TagType type;

    public Tag(String name, TagType type) {
        this.name = name;
        this.type = type;
    }

    public void update(String name, TagType type) {
        this.name = name;
        this.type = type;
    }
}

