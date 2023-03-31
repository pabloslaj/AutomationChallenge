package com.demoblaze.utils;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class FixtureUtils {

    public static void loadFixtures() {
        FixtureFactoryLoader.loadTemplates("com.demoblaze.api.fixtures.templates");
        FixtureFactoryLoader.loadTemplates("com.demoblaze.fixtures.placeorder.templates");
    }
}
