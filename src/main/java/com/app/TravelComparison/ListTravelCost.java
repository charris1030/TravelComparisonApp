package com.app.TravelComparison;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Chris Harris on 6/24/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@RestController
@RequestMapping(value="/rest/listPrices")
public class ListTravelCost {

        @RequestMapping(value="/travelModes/{id}")
        public TravelMode getStudent(@PathVariable String id){

            String URL="http://localhost:8080/rest/travelModes/"+id;

            RestTemplate template=new RestTemplate();

            TravelMode travelMode =template.getForObject(URL,TravelMode.class);

            return travelMode;
        }
}
