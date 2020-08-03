package autoRegLand;

import com.google.gson.JsonArray;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

public class CheckLeadBO {
    public void checkApi(String email) throws UnirestException {
        String searchQueryApi = "https://postman-echo.com/get";
        JsonNode body = Unirest.get(searchQueryApi)
                .asJson()
                .getBody();
     //   System.out.println(body.getArray());         // gives the full json response
      //  System.out.println(body.getArray().length());  // gives the no of items
     //   Assert.assertTrue();
        JSONObject myObj = body.getObject();
        //JSONArray headers = myObj.getJSONArray("headers");

        String msg = myObj.getString("url");
        System.out.println(msg);
        Assert.assertTrue(msg.contains("https://postman-echo.com/get"));
    }

}
