package Compliment;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import sun.nio.cs.ext.SimpleEUCEncoder;

public class ComplimentClient {

    private static final String SERVER_URL = "https://shrouded-woodland-79620.herokuapp.com/";
    private static final String TEXT = "text"; //Reads JSON

    private static final String USER_ERROR_MSG = "<html>Sorry, an error happened. " +
            "<br>ood thing you are highly skilled at debugging!</html>";

    public static void getCompliment(final ComplimentGUI gui) {

        Unirest.get(SERVER_URL + "random")
                .header("accept", "application/json")
                .asJsonAsync(new Callback<JsonNode>() {
                    public void completed(HttpResponse<JsonNode> httpResponse) {
                        JSONObject json = httpResponse.getBody().getObject();
                        gui.complimentMessage(json.getString(TEXT));
                    }

                    public void failed(UnirestException e) {
                        gui.complimentMessage(USER_ERROR_MSG);
                    }

                    public void cancelled() {
                        System.out.println("Request cancelled.");
                    }
                });
    }

}
