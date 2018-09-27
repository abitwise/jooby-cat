package ee.bigbank;

import org.junit.Test;

/**
 * @author jooby generator
 */
public class AppTest extends BaseTest {

  @Test
  public void index() throws Exception {
    server.get("/api/cat/Pudding")
        .expect(200)
        .header("Content-Type", "application/json;charset=utf-8");
  }

}
