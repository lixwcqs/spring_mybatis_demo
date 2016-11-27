package com.cqs.demo.models.unit.strategy.dao;

import com.cqs.demo.models.unit.strategy.entity.Strategy;

import java.util.List;

public interface StrategyDao {

    int insert(Strategy record);

    Strategy selectById(int id);

    void batchInsert(List<Strategy> strategies);

    List<Strategy> findAll();
}