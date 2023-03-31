package com.demoblaze.api.fixtures.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.demoblaze.api.fixtures.entity.UserDetailsData;
import com.github.javafaker.Faker;

public class CreateUserTemplate implements TemplateLoader {

    @Override
    public void load() {
        Faker faker = new Faker();
        Fixture.of(UserDetailsData.class).addTemplate("valid_random", new Rule() {{
            add("username", faker.regexify("[a-zA-Z0-9]{" + 10 + "}"));
            add("password", faker.internet().password());
        }});
    }
}
