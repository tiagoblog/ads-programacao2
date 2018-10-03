package aula6swing;

import java.io.IOException;
import java.util.Scanner;

import aula6swing.questoes.Questao1;
import aula6swing.questoes.Questao2;

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
		case 2:
			Questao2 questao2 = new Questao2();
			break;
		default:
			break;
		}

	}
}
