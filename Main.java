import classes.DadosAPI;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner dado = new Scanner(System.in);
        String resp = "0";
        double valor = 0;

        while (!resp.equals("7")) {
            String menu = """
                    *********************************
                    Menu de converções
                    
                    1.Real  --> Dolar
                    2.Dolar --> Real
                    3.Real  --> Euro
                    4.Euro  --> Real
                    5.Yen   --> Real
                    6.Real  --> Yen
                    7.Sair
                    *********************************
                    """;

            System.out.println(menu);
            System.out.println("Escolha a opção: ");
            resp = dado.next();

            if (!resp.equals("7")) {
                DadosAPI retorno = new DadosAPI();
                System.out.println("Digite o valor a ser convertido: ");
                valor = dado.nextDouble();

                System.out.println(retorno.ConsultarValorMoeda(resp, valor));
            }
        }
        System.out.println("Fim do programa");
    }
}
