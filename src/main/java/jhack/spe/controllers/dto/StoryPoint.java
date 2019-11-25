package jhack.spe.controllers.dto;

import lombok.Getter;

public class StoryPoint {

    @Getter
    private final Integer id;

    @Getter
    private final String name;

    @Getter
    private final String description;

    @Getter
    private final Integer userId;

    public StoryPoint(Integer id, String name, String description, Integer userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.userId = userId;
    }

}
