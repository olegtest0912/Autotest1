package autoRegLand.BO;

import com.google.gson.JsonArray;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

public class CheckLeadBO {
    public void checkApi(String email) throws UnirestException {
        String searchQueryApi = "https://finmax-bo.com/api/checkEmail.php?email=" + email;
        System.out.println(searchQueryApi);
      //  int status = Unirest.get(searchQueryApi).asJson().getStatus();
        JsonNode body = Unirest.get(searchQueryApi)
                .asJson()
                .getBody();
        System.out.println("From API:");
        System.out.println(body.getArray());         // gives the full json response
      //  System.out.println(body.getArray().length());  // gives the no of items

        JSONObject myObj = body.getObject();
        //JSONArray headers = myObj.getJSONArray("headers");

        String mail = myObj.getString("email");
        String aid = myObj.getString("a_aid");

     //   Assert.assertTrue(status==200);
        Assert.assertTrue(mail.equals(email));
        Assert.assertTrue(aid.equals("957"));
    }

}
