package codenine.template_tester.tag.dto.request;

import codenine.template_tester.tag.entity.TagType;
import lombok.Getter;

@Getter
public class TagUpdateRequest {

    private String name;
    private TagType type;
}

