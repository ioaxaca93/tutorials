/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ioaxaca.tutorials.configurations;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Israel
 */
@Configuration
public class Configurations {

    @Value("${datasource.url}")
    private String url;
    @Value("${datasource.user}")
    private String usr;
    @Value("${datasource.passwd}")
    private String passwd;
    @Value("${datasource.driver}")
    private String driver;
    
    @Bean
    public DataSource dataSourceBean(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource(url, usr, passwd);
        dataSource.setDriverClassName(driver);
        return dataSource;
    }
}
