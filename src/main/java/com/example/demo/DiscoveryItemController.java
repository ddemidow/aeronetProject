package com.example.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import com.example.Utils.Utils;
import com.example.callout.controllers.AeronetDataLoadingController;
import com.example.entities.DiscoveryItem;
import com.example.exceptions.DatabaseNotSupportException;
import com.example.services.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscoveryItemController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private AeronetDataLoadingController loadingCo9ntroller;

    public DiscoveryItemController() {
        try {
            loadingCo9ntroller = new AeronetDataLoadingController(Utils.NO_BASE_NAME);
        } catch (DatabaseNotSupportException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/greeting")
    public DiscoveryItem calculateAverage(@RequestParam(value="site") String site,
                                          @RequestParam(value="year1") String year1,
                                          @RequestParam(value="month1") String month1,
                                          @RequestParam(value="day1") String day1,
                                          @RequestParam(value="year2") String year2,
                                          @RequestParam(value="month2") String month2,
                                          @RequestParam(value="day2") String day2) {
        LocalDateTime start = LocalDateTime.of(Integer.valueOf(year1), Integer.valueOf(month1), Integer.valueOf(day1), 0, 0);
        LocalDateTime end = LocalDateTime.of(Integer.valueOf(year2), Integer.valueOf(month2), Integer.valueOf(day2), 0, 0);

        ArrayList<DiscoveryItem> selectedItems = loadingCo9ntroller.getDiscoveryItems(site, start, end);

        return Utils.getAverageDiscoveryItem(selectedItems);
    }
}
