package com.jpmchase.tsp;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.transaction.PlatformTransactionManager;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

@ComponentScan("com.jpmchase")
@Configuration
@EnableJdbcHttpSession 
public class Config {

//        @Bean
//        public EmbeddedDatabase dataSource() {
//                return new EmbeddedDatabaseBuilder() 
//                                .setType(EmbeddedDatabaseType.H2)
//                                .addScript("org/springframework/session/jdbc/schema-h2.sql").build();
//        }
        
        @Bean
        public DataSource mysqlDataSource() {
    		MysqlDataSource mysqlDS = null;
    		try {
    			mysqlDS = new MysqlDataSource();
    			mysqlDS.setURL("jdbc:mysql://localhost:3306/spring");
    			mysqlDS.setUser("root");
    			mysqlDS.setPassword("password");
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		return mysqlDS;
        }

        @Bean
        public PlatformTransactionManager transactionManager(DataSource dataSource) {
                return new DataSourceTransactionManager(dataSource); 
        }

}
