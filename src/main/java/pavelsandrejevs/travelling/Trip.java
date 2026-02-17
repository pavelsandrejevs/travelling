package pavelsandrejevs.travelling;

import lombok.Data;
import java.util.List;
import java.util.ArrayList;

@Data
public class Trip {

    private String name = "";
    
    private List<Extra> extras = new ArrayList<>();

}
