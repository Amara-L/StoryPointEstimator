package jhack.spe.controllers.dto;

import lombok.Getter;

public class User {

    @Getter
    private final Integer id;

    @Getter
    private final String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

}
