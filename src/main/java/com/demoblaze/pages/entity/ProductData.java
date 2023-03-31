package com.demoblaze.pages.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ProductData {

    private boolean containImage;
    private String productName;
    private String productPrice;
    private String productDescription;

}
