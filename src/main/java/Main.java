//For Converting to and from JSON
import com.google.gson.Gson;

import static spark.Spark.*;


public class Main {

    public static void main(String[] args){

        //threadPool(10,1,3600);
        //initializing mapper
        final mobileService mobileservice = new mobileMapper();
        //spark will run in port 8080; e.g-localhost:8080
        port(8080);

        //get mapping for localhost:8080/hello
        get("/hello",(request, response) -> "hello world");
        //get mapping for localhost:8080/
        get("/",(request, response) -> "hello world");


        //get mapping for localhost:8080/:brand ; e.g-localhost:8080/samsung or  localhost:8080/symphony
        get("/:brand", (request, response) -> {
            response.type("application/json");
            //check if brand exist
            if (mobileservice.brandExist((request.params(":brand")))==true) {
                response.status(200);
                return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(mobileservice.getBrands(request.params(":brand")))));
            }
            else {
                response.status(404);
                return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS,"This Brand does not exist"));
            }
        });


        //post mapping for giving dummy below in JSON format using postman
        post("/:brand",(request, response) -> {
            response.type("application/json");
            //creating brand object from request body(JSON)
            Brand brand =new Gson().fromJson(request.body(),Brand.class);
            brand.setBrand(request.params(":brand"));
            //adding brand in multimap/hashmap
            mobileservice.addBrand(brand);
            response.status(201);
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS,"model is added"));
        });

        //get mapping for a particular model under a brand ; e.g-localhost:8080/samsung/j5
       get("/:brand/:name", (request, response) -> {
            response.type("application/json");
            //check if model exist
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
