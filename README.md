# Use Handlebars with Spark

If you're using the [Spark web framework](https://github.com/perwendel/spark) to develop your Java web application, you
might have been looking for a way to use [Handlebars.java](https://github.com/jknack/handlebars.java) for templating.
This project provides a Spark `route` which accept handlebars templates.

## How to use:

    Spark.get(new HandlebarsRoute("/some-route") {
        @Override
        public ModelAndView handle(Request request, Response response) {
            Map<String, Object> model = new HashMap<>();
            attributes.put("key", "Hey Handlebars!");

            // Remember to put your files in the {classpath}/resources/* folder
            return modelAndView(attributes, "templateFile");
        }
    });

## Where do I put my templates?

In the `resources/templates/` folder of your project. I.e. `{projectName}/src/main/resources/templates/myTemplate.hbs`.

The standard Handlebars extension is .hbs, so remember to name your files accordingly.

## Can I configure Handlebars as I like?

For sure man! Simply create a `HandlebarsConfig` object, and set it up to fit your needs. Use it like so:


    HandlebarsConfig config = new HandlebarsConfig("some/path/prefix", ".suffix");
    Spark.get(new HandlebarsRoute("/some-route", config) {
            @Override
            public ModelAndView handle(Request request, Response response) {
                // handle
            }
        });

To be honest though - this might be a bit unpractical for you. Remember that this is an open sourced project, and if you
 really want a custom suffix or to put your templates some other place than /resources/templates, simply change the
 original code to fit your needs. :-)

## More information

* Check out [Spark on Github](https://github.com/perwendel/spark) for more about this awesome micro framework
* Also look at [Handlebars.java on Github](https://github.com/jknack/handlebars.java) for more on how to use this templating framework
* Lastly, all the stuff you need to know about Handlebars templates can be found on [their website](http://handlebarsjs.com).