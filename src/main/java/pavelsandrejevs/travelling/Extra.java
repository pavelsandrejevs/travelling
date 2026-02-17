package pavelsandrejevs.travelling;

import lombok.Data;

@Data
public class Extra {

    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        FOOD, SLEEPING
    }

}
