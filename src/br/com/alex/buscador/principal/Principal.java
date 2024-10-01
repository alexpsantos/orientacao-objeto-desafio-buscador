package br.com.alex.buscador.principal;

import br.com.alex.buscador.modelo.ConsultaCep;
import br.com.alex.buscador.modelo.Endereco;
import br.com.alex.buscador.modelo.GeradorDeArquivo;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);

        ConsultaCep consultaCep = new ConsultaCep();
        System.out.println("Digite um cep para consulta");
        var cep = leitura.nextLine();
        try{
            Endereco endereco = consultaCep.buscaEndereco(cep);
            System.out.println(endereco);
            GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();
            geradorDeArquivo.salvaJson(endereco);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando aplicação");
        }




    }
}
