package com.jd.inventory.tracker.controller;

import com.jd.inventory.tracker.domain.System;
import com.jd.inventory.tracker.domain.enums.ServiceStatusCodeEnum;
import com.jd.inventory.tracker.domain.enums.SystemStatusEnum;
import com.jd.inventory.tracker.domain.GenericResult;
import com.jd.inventory.tracker.domain.Page;
import com.jd.inventory.tracker.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/system")
public class SystemController {

    @Autowired
    SystemService systemService;

    private Logger logger = LoggerFactory.getLogger(getClass());


    @RequestMapping(value = "/toSystemList", method = RequestMethod.GET)
    public String toSystemList() {
        return "system/systemList";
    }

    @ResponseBody
    @RequestMapping(value = "/getSystems", method = RequestMethod.POST)
    public Page getSystems(Page page, System system) {
        logger.info("requestBody : page={},system={}", page);
        system.setStatus(SystemStatusEnum.VALID.getStatus());

        List<System> systemList = systemService.getSystems(page, system);
        page.setRows(systemList);
        return page;
    }

    @RequestMapping(value = "/toAddSystem", method = RequestMethod.GET)
    public String toAddSystem() {
        return "system/editSystem";
    }

    @RequestMapping(value = "/toEditSystem", method = RequestMethod.GET)
    public String toEditSystem(System system, Map map) {
        logger.info("requestBody : system={}", system);
        system.setStatus(SystemStatusEnum.VALID.getStatus());
        System existSystem = systemService.getSystem(system);
        map.put("system", existSystem);
        return "system/editSystem";
    }


    @ResponseBody
    @RequestMapping(value = "/doEditSystem", method = RequestMethod.POST)
    public GenericResult doEditSystem(System system) {
        logger.info("requestBody : system={}", system);
        if (system.getId() == null) {
            if (systemService.saveSystem(system))
                return new GenericResult(ServiceStatusCodeEnum.SUCCESS);
        } else {
            if (systemService.updateSystem(system))
                return new GenericResult(ServiceStatusCodeEnum.SUCCESS);
        }
        return new GenericResult(ServiceStatusCodeEnum.FAIL);
    }
}
