  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clickray.browserspot.statisticsystem.controller.service;

  import com.clickray.browserspot.statisticsystem.controller.DataProxyOperationStatistic;
  import com.clickray.browserspot.statisticsystem.controller.OperationFailedStatisticRepository;
  import com.clickray.entitylib.entity.DataBrowser;
  import com.clickray.entitylib.entity.DataProxyOperation;
  import com.clickray.entitylib.entity.statistic.OperationFailed;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.beans.factory.config.ConfigurableBeanFactory;
  import org.springframework.context.annotation.Scope;
  import org.springframework.stereotype.Component;

  import java.sql.Timestamp;
  import java.util.ArrayList;
  import java.util.List;

/**
 *
 * @author michalnowak
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DataProxyOperationStatisticController {
    
    @Autowired
    DataProxyOperationStatistic dataProxyOperationStatistic;
    
    @Autowired
    OperationFailedStatisticRepository operationFailedStatisticRepository;
     
    public List<DataProxyOperation> getOperationByStatus(int status){
        List<DataProxyOperation> operations = dataProxyOperationStatistic.findByStatus(status);
        return operations;
    }
      
    public int getOperationsByDate(String startTime, String endTime) {
        Timestamp startTimeQuery = DateOperations.convertDate(startTime);
        Timestamp endTimeQuery = DateOperations.convertDate(endTime);
        List<DataProxyOperation> operations = dataProxyOperationStatistic.findByDate(startTimeQuery, endTimeQuery);
        return operations.size();
    }
    
    public int getOperationsByDateAndUserIdAndStatus(String startTime, String endTime, String idUser, int status) {
        Timestamp startTimeQuery = DateOperations.convertDate(startTime);
        Timestamp endTimeQuery = DateOperations.convertDate(endTime);
        List<DataProxyOperation> operations = dataProxyOperationStatistic.findByDateAndUserAndStatus(startTimeQuery, endTimeQuery, idUser, status);
        return operations.size();
    }

    public int getOperationsByDateAndAndStatus(String startTime, String endTime, String idUser, int status) {
        Timestamp startTimeQuery = DateOperations.convertDate(startTime);
        Timestamp endTimeQuery = DateOperations.convertDate(endTime);
        List<DataProxyOperation> operations = dataProxyOperationStatistic.findByDateAndStatus(startTimeQuery, endTimeQuery, status);
        return operations.size();
    }

    public int getFailedOperationsByDate(String startTime, String endTime) {
        Timestamp startTimeQuery = DateOperations.convertDate(startTime);
        Timestamp endTimeQuery = DateOperations.convertDate(endTime);
        List<DataProxyOperation> operations = dataProxyOperationStatistic.findByDateFailedOperations(startTimeQuery, endTimeQuery);
        return operations.size();
    }
    
    public List<DataProxyOperation> getDeletedDataProxyOperations(){
        List<DataProxyOperation> operations = new ArrayList<>();
        return operations;
    }
    
    public List<DataProxyOperation> getOperationByUserId(String userId) {
        return dataProxyOperationStatistic.getOperationsByUserId(userId);
    }  
    
    public List<OperationFailed> getOperationFailed(){
        return operationFailedStatisticRepository.findAll();
    }
    
    public List<OperationFailed> getOperationFailedByDate(String startTime, String endTime) {
        Timestamp startTimeQuery = DateOperations.convertDate(startTime);
        Timestamp endTimeQuery = DateOperations.convertDate(endTime);
        List<OperationFailed> operations = operationFailedStatisticRepository.getFailedOperationsByDate(startTimeQuery, endTimeQuery);
        return operations;
    }
    
    public List<String> getAllUsers(){
        return dataProxyOperationStatistic.findDistinctUserId();
    }
    
    public void save(){
        
        DataProxyOperation test =  new DataProxyOperation();
        DataBrowser d = new DataBrowser();
        d.setId(3);
        test.setOperationName("śćóąę");
        test.setDataBrowser(d);
        dataProxyOperationStatistic.save(test);
        
    }
}
