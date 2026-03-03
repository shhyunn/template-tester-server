package codenine.template_tester.tag.dto.response;

import codenine.template_tester.tag.entity.Tag;
import codenine.template_tester.tag.entity.TagType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TagResponse {

    private Long id;
    private String name;
    private TagType type;

    public static TagResponse from(Tag tag) {
        return new TagResponse(
                tag.getId(),
                tag.getName(),
                tag.getType()
        );
    }
}
