package com.cqs.demo.jdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class JdbcTemplateProcessCall {
    @Resource
    JdbcTemplate jdbcTemplate;

    public List<SumStrategyTraffic> callProcessResultSet() {
        List result = (List) jdbcTemplate.execute(
                con -> {
                    String storedProc = "{call sum_interface_traffic_result()}";//SQL
                    CallableStatement cs = con.prepareCall(storedProc);
                    return cs;
                }, (CallableStatementCallback) cs -> {
                    List<SumStrategyTraffic> list = new ArrayList<>();
                    boolean exist = cs.execute();
                    if (exist) {
                        ResultSet resultSet = cs.getResultSet();
                        //遍历结果集
                        while (resultSet.next()) {
//                            System.out.println("strategyId:" + resultSet.getInt(1) + "\tsum_in_traffic:" + resultSet.getFloat(2) + "\tsum_out_traffic:" + resultSet.getFloat(3));
                            SumStrategyTraffic sumStrategyTraffic = new SumStrategyTraffic();
                            sumStrategyTraffic.setStrategyId(resultSet.getInt(1));
                            sumStrategyTraffic.setSumInTraffic(resultSet.getFloat(2));
                            sumStrategyTraffic.setSumOutTraffic(resultSet.getFloat(3));
                            list.add(sumStrategyTraffic);
                        }
                    }
                    return list;
                });
        System.out.println("获得存储结果集:");
        result.forEach(System.out::println);
        return result;
    }

    //带有输入值的例子
    public void callProcessResultSetWithInput() {
        List result = (List) jdbcTemplate.execute(
                con -> {
                    String storedProc = "{call split_result(?)}";// 调用的sql
                    CallableStatement cs = con.prepareCall(storedProc);
                    cs.setString(1, "783,268");// 设置输入参数的值
                    //cs.registerOutParameter(2, JDBCType.REF_CURSOR);// 注册输出参数的类型
                    return cs;
                }, (CallableStatementCallback) cs -> {
                    List<String> list = new ArrayList<>();
                    boolean exist = cs.execute();
                    ResultSet resultSet = cs.getResultSet();
                    if (exist) {
                        while (resultSet.next()) {
//                            System.out.println(resultSet.getString(1));
                            list.add(resultSet.getString(1));
                        }
                    }
                    return list;
                });
        System.out.println("存储过程结果:" + result);
    }


    //通过SimpleJdbcCall调用存储过程
    public List<SumStrategyTraffic> callProcessResultSetWithSimpleJdbcCall() {
        SimpleJdbcCall call = new SimpleJdbcCall(this.jdbcTemplate)
                .withProcedureName("sum_interface_traffic_result")
                .withoutProcedureColumnMetaDataAccess()
                .returningResultSet("sumStrategyTraffic", BeanPropertyRowMapper.newInstance(SumStrategyTraffic.class));
        Map<String, Object> map = call.execute();
        @SuppressWarnings("unchecked")
        List<SumStrategyTraffic> result = (List<SumStrategyTraffic>) map.get("sumStrategyTraffic");
        System.out.println("存储过程结果:");
        result.forEach(System.out::println);
        return result;
    }


}


