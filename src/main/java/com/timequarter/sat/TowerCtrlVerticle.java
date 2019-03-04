package com.timequarter.sat;

import io.vertx.core.AbstractVerticle;
/**
 * Hello world!
 *
 */
public class TowerCtrlVerticle extends AbstractVerticle
{
  @Override
  public void start(){
    vertx.createHttpServer()
        .requestHandler(req -> req.response().end("Hi from your Download TowerControl!!!"))
        .listen(8080);
  }
}

