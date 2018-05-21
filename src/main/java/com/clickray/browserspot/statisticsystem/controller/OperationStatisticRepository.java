/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clickray.browserspot.statisticsystem.controller;


import com.clickray.entitylib.entity.DataProxyOperation;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author michalnowak
 */

public interface OperationStatisticRepository extends CrudRepository<DataProxyOperation, Integer> {

    @Query("SELECT p FROM DataProxyOperation p WHERE p.status = ?1")
    public List<DataProxyOperation> findByStatus(@Param("status") Integer status);
    
    @Query("SELECT p FROM DataProxyOperation p WHERE p.idUser = ?1")
    public List<DataProxyOperation> getOperationsByUserId(@Param("idUser") String userId);
    
    @Query("SELECT p FROM DataProxyOperation p WHERE p.createDate >= ?1 and p.createDate <=?2 and p.deleted = false")
    public List<DataProxyOperation> findByDate(@Param("startTime") Timestamp startTime, @Param("endTime") Timestamp endTime);
    
    @Query("SELECT p FROM DataProxyOperation p WHERE p.deleted = false and p.createDate >= ?1 and p.createDate <=?2 and p.idUser = ?3 and p.status = ?4"  )
    public List<DataProxyOperation> findByDateAndUserAndStatus(@Param("startTime") Timestamp startTime, @Param("endTime") Timestamp endTime, @Param("idUser")String idUser, @Param("status")int status);

    @Query("SELECT p FROM DataProxyOperation p WHERE p.deleted = true")
    public List<DataProxyOperation> getAllDeletedOperations();
    
    @Query("SELECT DISTINCT idUser FROM DataProxyOperation")
    public List<String> findDistinctUserId();    
    
    @Override
    DataProxyOperation save(DataProxyOperation topic);

}
