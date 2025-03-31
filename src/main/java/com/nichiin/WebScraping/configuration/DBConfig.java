package com.nichiin.WebScraping.configuration;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class DBConfig {
    private String dbUrl;
    private String dbUsername;
    private String dbPassword;
    private String dbDriver;
    private String hibernateDialect;
    private String ddlAuto;

    public void setDBConfig(
            String dbUrl,
            String dbUsername,
            String dbPassword,
            String dbDriver,
            String hibernateDialect,
            String ddlAuto
    ) {
        this.dbUrl = dbUrl;
        this.dbUsername = dbUsername;
        this.dbPassword = dbPassword;
        this.dbDriver = dbDriver;
        this.hibernateDialect = hibernateDialect;
        this.ddlAuto = ddlAuto;
    }
}
