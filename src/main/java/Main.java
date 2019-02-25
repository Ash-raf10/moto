
import com.google.gson.Gson;

import static spark.Spark.*;


public class Main {

    public static void main(String[] args){

        //threadPool(10,1,3600);

        final mobileService mobileservice = new mobileMapper();
        port(8080);

        get("/hello",(request, response) -> "hello world");
        get("/",(request, response) -> "hello world");

        get("/samsung", (request, response) -> {
            response.type("application/json");
            response.status(200);
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(mobileservice.getModels())));
        });

        post("/samsung",(request, response) -> {
            response.type("application/json");

            Samsung samsung =new Gson().fromJson(request.body(),Samsung.class);
            mobileservice.addModel(samsung);

            response.status(201);

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS,"model is added"));
        });

        get("/samsung/:name", (request, response) -> {
            response.type("application/json");
            response.status(200);
            if (mobileservice.modelExist((request.params(":name")))==true) {
                response.status(200);
                return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(mobileservice.getModel(request.params(":name")))));
            }
            else {
                response.status(404);
                return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS,"model does not exist"));
            }
        });





    }
}
