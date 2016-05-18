package ee.bigbank;

import org.jooby.Jooby;
import org.jooby.MediaType;
import org.jooby.json.Jackson;
import org.jooby.raml.Raml;
import org.jooby.swagger.SwaggerUI;

/**
 * Cat Service
 */
public class App extends Jooby {

    {
        use(new Jackson());

        /**
         * Produces Cat object
         */
        use("/api/cat/")
                /**
                 * @param name Cat name
                 *
                 * @return Returns a cat {@link Cat}
                 */
                .get("/:name", req -> {
                    Cat cat = new Cat();
                    cat.setName(req.param("name").value());

                    return cat;
                })
                .produces(MediaType.json);

        new Raml().install(this);
        new SwaggerUI().install(this);
    }

    public static void main(final String[] args) throws Throwable {
        run(App::new, args);
    }

}
