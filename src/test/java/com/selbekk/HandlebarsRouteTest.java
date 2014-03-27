package com.selbekk;

import org.junit.Test;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class HandlebarsRouteTest {

    @Test
    public void should_fetch_template() {

        final Map<String, Object> model = new HashMap<String, Object>();
        model.put("someKey", "handlebars rox");
        final ModelAndView mav = new ModelAndView(model, "com/selbekk/testTemplate");

        Route route = new HandlebarsRoute("/my-route") {

            @Override
            public ModelAndView handle(Request request, Response response) {
                return mav;
            }
        };

        assertEquals("<h1>handlebars rox</h1>", route.render(mav));
    }

    @Test
    public void should_respect_custom_config() {

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("someKey", "customization rox");

        HandlebarsConfig config = new HandlebarsConfig("/com/selbekk", ".customSuffix");
        final ModelAndView mav = new ModelAndView(model, "testTemplate");

        Route route = new HandlebarsRoute("/", config) {

            @Override
            public ModelAndView handle(Request request, Response response) {
                return mav;
            }
        };

        assertEquals("<h1>customization rox</h1>", route.render(mav));
    }
}
