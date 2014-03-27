package com.kristoferselbekk;

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
        final ModelAndView mav = new ModelAndView(model, "com/kristoferselbekk/testTemplate");

        Route route = new HandlebarsRoute("/") {

            @Override
            public ModelAndView handle(Request request, Response response) {
                return mav;
            }
        };

        assertEquals("<h1>handlebars rox</h1>", route.render(mav));
    }
}
