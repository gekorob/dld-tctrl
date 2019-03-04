package com.timequarter.sat;

import io.vertx.core.Vertx;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(VertxUnitRunner.class)
public class TowerCtrlVerticleTest
{

  private Vertx vertx;

  @Before
  public void setup(TestContext tc){
    vertx = Vertx.vertx();
    vertx.deployVerticle(TowerCtrlVerticle.class.getName(), tc.asyncAssertSuccess());
  }

  @After
  public void teardown(TestContext tc){
    vertx.close(tc.asyncAssertSuccess());
  }

  @Test
  public void testThatTheServerIsStarted(TestContext tc) {
    Async async = tc.async();
    vertx.createHttpClient().getNow(8080, "localhost", "/", response -> {
      tc.assertEquals(response.statusCode(), 200);
      response.bodyHandler(body -> {
        tc.assertTrue(body.length() > 0);
        async.complete();
      });
    });
  }

}
