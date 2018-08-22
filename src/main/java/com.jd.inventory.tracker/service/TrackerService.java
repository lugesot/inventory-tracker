package com.jd.inventory.tracker.service;

import com.jd.inventory.tracker.dao.TrackerDao;
import com.jd.inventory.tracker.domain.Page;
import com.jd.inventory.tracker.domain.Tracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackerService {

    @Autowired
    TrackerDao trackerDao;

    public List<Tracker> getTrackers(Page page, Tracker tracker) {
        return trackerDao.gets(page, tracker);
    }
}
