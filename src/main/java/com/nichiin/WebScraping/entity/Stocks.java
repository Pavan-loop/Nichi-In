package com.nichiin.WebScraping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Stocks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
