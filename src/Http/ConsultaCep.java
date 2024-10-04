package Http;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsultaCep {
    Scanner entrada = new Scanner(System.in);

    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

    public ViaCep BuscaEndereco(String cep) {
        URI endereco = URI.create("https://viacep.com.br/ws/" + cep.replace("-", "") + "/json/");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ViaCep.class);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possivel converter um endereço a partir desse CEP");
        }

    }
    public ViaCep complementaEndereco(ViaCep endereco) throws IOException {
        String logradouro = endereco.logradouro();
        String complemento = endereco.complemento();
        String bairro = endereco.Bairro();
        String localidade = endereco.localidade();
        if (endereco.logradouro() == null || endereco.logradouro().isEmpty()){
            System.out.println("Complemente com logradouro: ");
            logradouro = entrada.nextLine();
        }if (endereco.complemento() == null || endereco.complemento().isEmpty()){
            System.out.println("Complemente com complemento: ");
            complemento = entrada.nextLine();
        }if (endereco.Bairro() == null || endereco.Bairro().isEmpty()){
            System.out.println("Complemente com Bairro: ");
            bairro = entrada.nextLine();
        }if (endereco.localidade() == null || endereco.localidade().isEmpty()){
            System.out.println("Complemente com Cidade: ");
            localidade = entrada.nextLine();
        }
        return new ViaCep(endereco.cep(), logradouro, complemento, bairro, localidade, endereco.uf());
    }
}
