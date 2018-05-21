/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clickray.browserspot.statisticsystem.rest.OperationFailed;

import com.clickray.browserspot.statisticsystem.controller.service.OperationStatisticService;
import com.clickray.entitylib.entity.statistic.OperationFailed;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author michalnowak
 */
@RestController
@RequestMapping("/operationfailed/")
public class OperationFailedRest {
    
    @Autowired
    OperationStatisticService operationStatisticService;
    
         /**
     * http://10.0.0.36:7770/operationstatistic/operationfailed
     * @return 
     */
    @RequestMapping(value = "all", method = RequestMethod.GET)
    @ResponseBody
    public  List<OperationFailed> getOperationFailed() {
        return operationStatisticService.getOperationFailed();
    }
    
     /**
     * http://10.0.0.36:7770/operationstatistic/operationfailed
     * @return 
     */
    @RequestMapping(value = "bydate", method = RequestMethod.GET)
    @ResponseBody
    public  List<OperationFailed> getOperationFailedByDate(@RequestParam String startTime, @RequestParam String endTime) {
        return operationStatisticService.getOperationFailed();
    }
    
}
