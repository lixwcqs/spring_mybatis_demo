package com.cqs.demo.jdbc;

public class SumStrategyTraffic {
    private int strategyId;
    private float sumInTraffic;
    private float sumOutTraffic;

    public int getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(int strategyId) {
        this.strategyId = strategyId;
    }

    public float getSumInTraffic() {
        return sumInTraffic;
    }

    public void setSumInTraffic(float sumInTraffic) {
        this.sumInTraffic = sumInTraffic;
    }

    public float getSumOutTraffic() {
        return sumOutTraffic;
    }

    public void setSumOutTraffic(float sumOutTraffic) {
        this.sumOutTraffic = sumOutTraffic;
    }

    @Override
    public String toString() {
        return "SumStrategyTraffic{" +
                "strategyId=" + strategyId +
                ", sumInTraffic=" + sumInTraffic +
                ", sumOutTraffic=" + sumOutTraffic +
                '}';
    }

}