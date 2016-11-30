package com.cqs.demo.models.unit.strategy.service;

import com.cqs.demo.jms.JmsMessageProducer;
import com.cqs.demo.models.unit.strategy.dao.StrategyDao;
import com.cqs.demo.models.unit.strategy.entity.Strategy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cqs on 16-11-24.
 */
@Service
public class StrategyService {

    @Resource
    private StrategyDao strategyDao;

    @Resource
    private JmsMessageProducer<Strategy> jmsMessageProducer;

    public int insert(Strategy strategy) {
        return strategyDao.insert(strategy);
    }

    public Strategy selectById(int id) {
        Strategy strategy = strategyDao.selectById(id);
        jmsMessageProducer.sendMessage(strategy);
        return strategy;
    }

    public void batchInsert(List<Strategy> strategies) {
        strategyDao.batchInsert(strategies);
    }

    public List<Strategy> findAll() {

        return strategyDao.findAll();
    }
}
