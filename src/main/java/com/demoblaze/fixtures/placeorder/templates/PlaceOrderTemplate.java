package com.demoblaze.fixtures.placeorder.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.demoblaze.pages.entity.PlaceOrderData;
import com.github.javafaker.Faker;

public class PlaceOrderTemplate implements TemplateLoader {

    @Override
    public void load() {
        Faker faker = new Faker();
        Fixture.of(PlaceOrderData.class).addTemplate("valid_random", new Rule() {{
            add("userName", faker.name().firstName());
            add("country", faker.country().name());
            add("city", faker.address().city());
            add("creditCard", faker.finance().creditCard());
            add("month", String.valueOf(faker.number().numberBetween(1, 13)));
            add("year", String.valueOf(faker.number().numberBetween(1970, 2023)));
        }});
    }
}
