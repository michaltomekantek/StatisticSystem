package com.clickray.browserspot.statisticsystem.sqlite;

import com.clickray.browserspot.statisticsystem.model.UserStatistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserStatisticRepository extends JpaRepository<UserStatistic, Integer> {

    @Override
    UserStatistic save(UserStatistic topic);

    @Query("Select u FROM UserStatistic u  join fetch u.failedOperationList f ")
    List<UserStatistic> findAll();

    @Override
    long count();
}
