package com.jd.inventory.tracker.controller;

import com.jd.inventory.tracker.domain.Page;
import com.jd.inventory.tracker.domain.Tracker;
import com.jd.inventory.tracker.domain.vo.TrackerVo;
import com.jd.inventory.tracker.service.TrackerService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tracker")
public class TrackerController {

    @Autowired
    TrackerService trackerService;

    private Logger logger = LoggerFactory.getLogger(getClass());


    @RequestMapping(value = "/toTrackerList", method = RequestMethod.GET)
    public String toTrackerList() {
        return "tracker/trackerList";
    }

    @ResponseBody
    @RequestMapping(value = "/getTrackers", method = RequestMethod.POST)
    public Page getTrackers(Page page, Tracker tracker) {
        logger.info("requestBody : page={},tracker={}", page);

        List<TrackerVo> trackerList = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            TrackerVo t = new TrackerVo();
            t.setEventno(String.valueOf(i));
            t.setCurrentStep(i);
            List<TrackerVo.KeyValuePair> list = new ArrayList<>();
            t.setKeyValuePairs(list);
            for (int j = 0; j < i; j++) {
                TrackerVo.KeyValuePair pair = t.new KeyValuePair();
                pair.setKey("10");
                pair.setValue("10");
                list.add(pair);
            }
            trackerList.add(t);
        }
        //List<Tracker> trackerList = trackerService.getTrackers(page, tracker);
        page.setRows(trackerList);
        return page;
    }
}
