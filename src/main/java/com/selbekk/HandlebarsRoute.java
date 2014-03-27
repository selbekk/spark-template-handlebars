package com.selbekk;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
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
    public HandlebarsRoute(String path) {
        super(path);
        handlebars = new Handlebars();
    }

    /**
     * Constructor
     *
     * @param path The route path which is used for matching. (e.g. /hello, users/:name)
     * @param acceptType The accept type which is used for matching.
     */
    public HandlebarsRoute(String path, String acceptType) {
        super(path, acceptType);
        handlebars = new Handlebars();
    }

    /**
     * Constructor
     *
     * @param path The route path which is used for matching. (e.g. /hello, users/:name)
     * @param config A configuration object for Handlebars
     */
    public HandlebarsRoute(String path, HandlebarsConfig config) {
        super(path);
        TemplateLoader loader = config.getTemplateLoader();
        handlebars = new Handlebars(loader);
    }

    /**
     * Constructor
     *
     * @param path The route path which is used for matching. (e.g. /hello, users/:name)
     * @param acceptType The accept type which is used for matching.
     * @param config A configuration object for Handlebars
     */
    public HandlebarsRoute(String path, String acceptType, HandlebarsConfig config) {
        super(path, acceptType);
        TemplateLoader loader = config.getTemplateLoader();
        handlebars = new Handlebars(loader);
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
