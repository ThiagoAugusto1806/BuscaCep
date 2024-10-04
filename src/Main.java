import Http.ConsultaCep;
import Http.GeraArquivo;
import Http.ViaCep;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String cep = "";
        ViaCep endereco;
        Scanner entrada = new Scanner(System.in);
        ConsultaCep buscaCep = new ConsultaCep();
        while (!cep.equals("sair")){
            System.out.println("Digite o CEP ou 'sair' para encerrar o programa: ");
            cep = entrada.nextLine();
            if (cep.equalsIgnoreCase("sair")){
                break;
            } else{
              try{
                  endereco = buscaCep.BuscaEndereco(cep);

                  System.out.println(endereco);
                  endereco = buscaCep.complementaEndereco(endereco);
                  GeraArquivo arquivo = new GeraArquivo();
                  arquivo.salvaJson(endereco);
              }catch (Exception e){
                  System.out.println("Não foi possivel converter um endereço a partir desse CEP");
              }

            }
        }
        System.out.println("Busca de CEP finalizada!");
    }
}