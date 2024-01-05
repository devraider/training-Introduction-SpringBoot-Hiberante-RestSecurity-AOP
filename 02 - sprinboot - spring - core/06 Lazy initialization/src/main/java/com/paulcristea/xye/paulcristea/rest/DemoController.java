package com.paulcristea.xye.paulcristea.rest;

import com.paulcristea.xye.paulcristea.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for  dependency
    private Coach myCoach;

//    Commented out constructor injection to make use of setter injection
//    define a constructor for dependency injection
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
    }


//    Setter injection
/*    @Autowired
    public void setCoach(Coach theCoach) {
        myCoach = theCoach;
    }
*/

    @GetMapping("/getWorkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
