package au.com.workingmouse.challenge.libs;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import lombok.Data;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Data
public class HttpClient {
	private String url;

	private java.net.http.HttpClient httpClient;
	private JsonParser jsonParser;

	public HttpClient(String url) {
		this.url = url;
		httpClient = java.net.http.HttpClient.newHttpClient();
		jsonParser = new JsonParser();
	}

	/**
	 * Synchronous post, expects response as JSON and does not handle auth
	 * Example:
	 *
	 * 	<code>
	 * 	    HttpClient client = new HttpClient("http://httpbin.org/post");
	 * 		JsonObject body  = new JsonObject();
	 * 		body.addProperty("test", "test value");
	 * 		JsonElement response = client.post(body);
	 * 	</code>
	 *
	 * See <a href="https://www.javadoc.io/doc/com.google.code.gson/gson/2.8.5</a>
	 * @return response as a json element, members can be accessed with ``...get("member name")``
	 * */
	public JsonElement post(JsonElement payload) throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(this.url))
				.POST(HttpRequest.BodyPublishers.ofString(payload.toString()))
				.build();

		HttpResponse<String> response =
				httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		return jsonParser.parse(response.body());
	}

	/**
	 * Synchronous get, expects response as JSON and does not handle auth
	 *
	 *  Example:
	 * 	<code>
	 * 	    HttpClient client = new HttpClient("http://httpbin.org/get");
	 * 		JsonElement response = client.get();
	 * 	</code>
	 *
	 * See <a href="https://www.javadoc.io/doc/com.google.code.gson/gson/2.8.5</a>
	 * @return response as a json element, members can be accessed with ``...get("member name")``
	 * */
	public JsonElement get() throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(this.url))
				.build();

		HttpResponse<String> response =
				httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		return jsonParser.parse(response.body());
	}
}
