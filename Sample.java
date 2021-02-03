import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;


public class Sample{
    public static void main(String[] args){

        Vertx vertx= Vertx.vertx();
        HttpServer httpServer=vertx.createHttpServer();

        Router router= Router.router(vertx);
        Route one=router
                .get("/neha/:id")
                .handler(routingContext -> {
                    String id = routingContext.request().getParam("id");
                    System.out.println("welcome to get:" + id);
                    HttpServerResponse response=routingContext.response();
                    response.setChunked(true);
                    response.write("Hi I'm one from get. \n");
                    response.end();
                });
        Route teo=router
                .post("/neha")
                .handler(routingContext -> {
                    System.out.println("welcome to post");
                    HttpServerResponse response=routingContext.response();
                    response.setChunked(true);
                    response.write("Hi I'm one from post \n.");
                    response.end();
                });

 /* Route three=router
 .route("/neha")
 .handler(routingContext -> {
 System.out.println(" ");
 HttpServerResponse response=routingContext.response();
 response.setChunked(true);
 response.write("Hi I'm three.");
 routingContext
 .vertx
 .setTimer(6000, tid->routingContext.next();
 }); */


        httpServer.requestHandler(router::accept).listen(8091);

    }


}
