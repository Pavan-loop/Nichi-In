package com.nichiin.WebScraping.restConfiguration.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StocksDTO {

    private String stockName;
    private String prev_close;
    private String iep;
    private String chng;
    private String perChng;
    private String finaal;
    private String finalQuality;
    private String value;
    private String ffmcap;
    private String nm52wh;
    private String nm52wl;
}
