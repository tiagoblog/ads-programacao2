package aula6swing;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		System.out.println("(1) - Questão 1");

		Scanner reader = new Scanner(System.in);
		System.out.println("> ");
		int opcao = reader.nextInt(); 
		reader.close();

		switch (opcao) {
		case 1:
			Questao1 questao1 = new Questao1();
			break;
		default:
			break;
		}

	}
}
