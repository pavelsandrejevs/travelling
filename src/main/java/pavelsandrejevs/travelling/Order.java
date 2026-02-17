package pavelsandrejevs.travelling;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Order {

    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
    
    private List<Trip> trips = new ArrayList<>();
    
    public void addTrip(Trip trip) {
        trips.add(trip);
    }

}
