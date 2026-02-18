package pavelsandrejevs.travelling;

import lombok.Data;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;

@Data
public class Trip {

    @NotNull
    //@Size(min=1, message="Name must be at least 1 character(s) long")
    @NotBlank(message="Name must not be blank")
    private String name = "";

    @NotNull
    @Size(min=1, message="You must choose at least 1 extra")
    private List<Extra> extras = new ArrayList<>();

}
