package com.kristoferselbekk;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;
import spark.ModelAndView;
import spark.TemplateViewRoute;

import java.io.IOException;

public abstract class HandlebarsRoute extends TemplateViewRoute {

    private Handlebars handlebars;

    /**
     * Constructor
     *
     * @param path The route path which is used for matching. (e.g. /hello, users/:name)
     */
    protected HandlebarsRoute(String path) {
        super(path);
        handlebars = new Handlebars();
    }

    /**
     * Constructor
     *
     * @param path The route path which is used for matching. (e.g. /hello, users/:name)
     * @param acceptType The accept type which is used for matching.
     */
    protected HandlebarsRoute(String path, String acceptType) {
        super(path, acceptType);
        handlebars = new Handlebars();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String render(ModelAndView modelAndView) {

        try {
            Template template = handlebars.compile(modelAndView.getViewName());
            return template.apply(modelAndView.getModel());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
