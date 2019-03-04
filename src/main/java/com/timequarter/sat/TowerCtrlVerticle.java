package com.timequarter.sat;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class TowerCtrlVerticle extends AbstractVerticle
{
  @Override
  public void start(Future<Void> startFuture) throws Exception {
    Future<Void> startSequence = prepareRestServer();
    startSequence.setHandler(startFuture.completer());
  }

  private Future<Void> prepareRestServer(){
    Future<Void> future = Future.future();

    return future;
  }
//  @Override
//  public void start(){
//    vertx.createHttpServer()
//        .requestHandler(req -> req.response().end("Hi from your Download TowerControl!!!"))
//        .listen(8080);
//  }
}

