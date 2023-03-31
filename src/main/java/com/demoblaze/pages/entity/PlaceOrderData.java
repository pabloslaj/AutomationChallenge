package com.demoblaze.pages.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Builder
public class PlaceOrderData {

    private String userName;
    private String country;
    private String city;
    private String creditCard;
    private String month;
    private String year;
}
