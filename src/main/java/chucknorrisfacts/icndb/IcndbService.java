package chucknorrisfacts.icndb;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.DefaultHttpClient;
import io.micronaut.http.client.HttpClient;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

public class IcndbService {

    private static final String API_URL = "http://api.icndb.com";

    @SuppressWarnings("unchecked")
    public static Optional<Fact> getRandomFact() {
        HttpClient client = getClient();

        if (client == null) {
            return Optional.empty();
        }

        HttpRequest request = HttpRequest.GET("/jokes/random/?limitTo=[nerdy]");
        HttpResponse<Fact> response = client.toBlocking().exchange(request, Fact.class);

        return response.getBody();
    }

    private static HttpClient getClient() {
        HttpClient client;
        try {
            client = new DefaultHttpClient(new URL(API_URL));
        } catch (MalformedURLException e) {
            return null;
        }
        return client;
    }
}
