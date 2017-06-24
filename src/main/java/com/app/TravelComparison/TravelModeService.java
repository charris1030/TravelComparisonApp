package com.app.TravelComparison;

import com.app.TravelComparison.TravelComparisonApplication;
import com.app.TravelComparison.TravelMode;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Created by Chris Harris on 6/24/2017.
 */

@RestController
@RequestMapping(value="/rest/travelModes")
public class TravelModeService {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public HashMap<Long, TravelMode> getAllTravelModes() {
        return TravelComparisonApplication.hmTravelMode;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public TravelMode addTravelMode(@RequestParam(value = "travelModeName") String travelModeName) {

        TravelMode travelMode = new TravelMode(travelModeName);
        TravelComparisonApplication.hmTravelMode.put(new Long(travelMode.getId()), travelMode);
        return travelMode;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public TravelMode updateTravelMode(@RequestBody TravelMode travelMode) throws Exception {

        if (TravelComparisonApplication.hmTravelMode.containsKey(new Long(travelMode.getId()))) {
            TravelComparisonApplication.hmTravelMode.put(new Long(travelMode.getId()), travelMode);
        } else {
            throw new Exception("TravelMode " + travelMode.getId() + " does not exists");
        }
        return travelMode;
    }
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public TravelMode getTravelMode(@PathVariable long id){
        return TravelComparisonApplication.hmTravelMode.get(new Long(id));
    }

    @RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
    public TravelMode deleteTravelMode(@PathVariable long id) throws Exception {

        TravelMode travelMode;

        if(TravelComparisonApplication.hmTravelMode.containsKey(new Long(id))){
            travelMode=TravelComparisonApplication.hmTravelMode.get(new Long(id));
            TravelComparisonApplication.hmTravelMode.remove(new Long(id));
        }else{
            throw new Exception("Travel Mode "+id+" does not exists");
        }
        return travelMode;
    }

}