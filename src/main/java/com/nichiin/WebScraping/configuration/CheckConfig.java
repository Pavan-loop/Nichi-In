package com.nichiin.WebScraping.configuration;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class CheckConfig {
    private String firstname;
    private String lastname;

    public void setCheck(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
