package classes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DadosAPI {
    public String ConsultarValorMoeda(String opcao, double quantidade) throws IOException, InterruptedException {
        String url;
        String msgReturn = "";

        switch (opcao) {
            case "1":
                msgReturn = "A conversão de " + quantidade + " reais em dolares é: ";
                url = "https://v6.exchangerate-api.com/v6/1fc4261d69f127638261724b/pair/BRL/USD";
                break;
            case "2":
                msgReturn = "A conversão de " + quantidade + " dolares em reais é: ";
                url = "https://v6.exchangerate-api.com/v6/1fc4261d69f127638261724b/pair/USD/BRL";
                break;
            case "3":
                msgReturn = "A conversão de " + quantidade + " reais em euros é: ";
                url = "https://v6.exchangerate-api.com/v6/1fc4261d69f127638261724b/pair/BRL/EUR";
                break;
            case "4":
                msgReturn = "A conversão de " + quantidade + " euros em reais é: ";
                url = "https://v6.exchangerate-api.com/v6/1fc4261d69f127638261724b/pair/EUR/BRL";
                break;
            case "5":
                msgReturn = "A conversão de " + quantidade + " yens em reais é: ";
                url = "https://v6.exchangerate-api.com/v6/1fc4261d69f127638261724b/pair/JPY/BRL";
                break;
            case "6":
                msgReturn = "A conversão de " + quantidade + " reais em yens é: ";
                url = "https://v6.exchangerate-api.com/v6/1fc4261d69f127638261724b/pair/BRL/JPY";
                break;
            default:
                url = "";
                break;
        };

        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            MoedaConvertida moeda = gson.fromJson(response.body(), MoedaConvertida.class);
            msgReturn = msgReturn.concat(String.valueOf(moeda.conversion_rate() * quantidade));
            return msgReturn;
        } catch (RuntimeException erro) {
            return erro.getMessage();
        }
    }
}
