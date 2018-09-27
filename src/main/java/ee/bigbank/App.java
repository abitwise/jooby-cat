package ee.bigbank;

import org.jooby.*;
import org.jooby.MediaType;
import org.jooby.json.Jackson;
import org.jooby.apitool.ApiTool;

/**
 * Cat Service
 */
public class App extends Jooby {

    {
        use(new Jackson());

        /**
         * @param name Cat name
         *
         * @return Returns a cat {@link Cat}
         */
        get("/api/cat/:name", req -> {
            Cat cat = new Cat();
            cat.setName(req.param("name").value());

            return cat;
        }).produces(MediaType.json);

        use(new ApiTool().swagger(new ApiTool.Options("/swagger")));
    }

    public static void main(final String[] args) throws Throwable {
        run(App::new, args);
    }

}
