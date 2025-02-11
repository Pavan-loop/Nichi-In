package com.nichiin.WebScraping.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@IdClass(StockId.class)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Nifty50IndexSummary")
public class Stocks {

    @Id
    @Column(name = "dt")
    private String dt;
    @Id
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "preclose")
    private String prev_close;
    @Column(name = "iep")
    private String iep;
    @Column(name = "chng")
    private String chng;
    @Column(name = "chngprc")
    private String perChng;
    @Column(name = "final")
    private String finaal;
    @Column(name = "quantity")
    private String finalQuality;
    @Column(name = "volumn")
    private String value;
    @Column(name = "cap")
    private String ffmcap;
    @Column(name = "price52wh")
    private String nm52wh;
    @Column(name = "price52wl")
    private String nm52wl;
    @Column(name = "updatesource")
    private String updateSource;
    @Column(name = "updatetime")
    private String updatetime;
}
