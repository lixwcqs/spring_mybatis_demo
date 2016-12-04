package com.cqs.demo.jdbc;

import com.cqs.demo.base.BaseConfigurationTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by cqs on 16-12-4.
 */
public class JdbcTemplateProcessCallTest extends BaseConfigurationTest {

    @Resource
    JdbcTemplateProcessCall jdbcTemplateProcessCall;

    @Test
    public void callProcessResultSet() throws Exception {
        jdbcTemplateProcessCall.callProcessResultSet();
    }

    @Test
    public void callProcessResultSetWithInput() throws Exception {
        jdbcTemplateProcessCall.callProcessResultSetWithInput();
    }

    @Test
    public void callProcessResultSetWithSimpleJdbcCall() throws Exception {
        jdbcTemplateProcessCall.callProcessResultSetWithSimpleJdbcCall();
    }

}