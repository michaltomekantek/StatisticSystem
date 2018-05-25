package com.clickray.browserspot.statisticsystem.controller.service;

import com.clickray.browserspot.statisticsystem.model.UserStatistic;
import com.clickray.browserspot.statisticsystem.sqlite.UserStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserStatisticController {

    @Autowired
    UserStatisticRepository userStatisticRepository;

    public void addUserStatistic(UserStatistic userStatistic){
        userStatisticRepository.save(userStatistic);
    }
}
