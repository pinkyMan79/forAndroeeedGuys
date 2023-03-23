package org.example.config.additions;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@PropertySource("classpath:app.yaml")
public class DataBasePropertySource {

    private String url;
    private String username;
    private String password;
    private String driver;
    private int maxPoolSize;

    public DataBasePropertySource(@Value("${db.url}") String url,
                                  @Value("${db.username}") String username,
                                  @Value("${db.password}") String password,
                                  @Value("${db.driver.classname}") String driver,
                                  @Value("${db.hikari.max-pool-size}") int maxPoolSize) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.driver = driver;
        this.maxPoolSize = maxPoolSize;
    }
}
