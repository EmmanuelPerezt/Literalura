package com.biblioteca;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Httprequestcontroller {

    public String sendRequest(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
             .uri(URI.create(url))
             .GET()
             .header("accept", "application/json")
             .header("user-agent", "Java HttpClient")
             .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body()+"\n"+response.statusCode();
        return responseBody;
    }
}
