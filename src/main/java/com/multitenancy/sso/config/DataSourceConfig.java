package com.multitenancy.sso.config;


import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {


    @Bean
    public DataSource dataSource() {
        MultiTenantRoutingDataSource routingDataSource = new MultiTenantRoutingDataSource();

        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put("tenant1", createDataSource("jdbc:mysql://localhost:3306/dev_uat_db", "root", "root"));
        dataSourceMap.put("tenant2", createDataSource("jdbc:mysql://localhost:3306/local_db", "root", "root"));

        routingDataSource.setTargetDataSources(dataSourceMap);
        routingDataSource.setDefaultTargetDataSource(createDataSource("jdbc:mysql://localhost:3306/local_db", "root", "root"));

        return routingDataSource;
    }

    private DataSource createDataSource(String url, String username, String password) {
        return DataSourceBuilder.create()
                .url(url)
                .username(username)
                .password(password)
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }
}
