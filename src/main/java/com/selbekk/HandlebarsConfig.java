package com.selbekk;

import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;

public class HandlebarsConfig {

    private TemplateLoader templateLoader;

    public HandlebarsConfig(String prefix, String suffix) {
        templateLoader = new ClassPathTemplateLoader(prefix, suffix);
    }

    public HandlebarsConfig(String prefix) {
        templateLoader = new ClassPathTemplateLoader(prefix);
    }

    public HandlebarsConfig() {
        templateLoader = new ClassPathTemplateLoader();
    }

    public TemplateLoader getTemplateLoader() {
        return templateLoader;
    }

}
