/*
 * 2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores anteriores 
 * (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que desejar onde, informado um número, ele calcule 
 * a sequência de Fibonacci e retorne uma mensagem avisando se o número informado pertence ou não a sequência.
 *
 * IMPORTANTE: 
 *	Esse número pode ser informado através de qualquer entrada de sua preferência ou pode ser previamente definido no código;
 */

package gupy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExercicioFibbo {

	public static void main(String[] args) {
		System.out.println("### Meu número faz parte da sequência de Fibonacci? ###");
		
		int numero = 0;
		Scanner sc = new Scanner (System.in);
		
		while (true) {
			System.out.print("Insira o número inteiro: ");
			
			try {
				numero = sc.nextInt();
			}
			catch(Exception e) {
				System.out.println("Você não inseriu um válido válido, por favor insira um número inteiro\n");
				sc.next(); // Para limpar o buffer do Scanner
				continue;
			}
			
			break;
		}
		
		sc.close();
		
		List<Integer> fibbo = new ArrayList<Integer>();
		fibbo.add(0);
		fibbo.add(0);
		
		boolean eFibbo = false;
		
		System.out.println("");
		
		while (fibbo.get(1) <= numero) {
			if (numero == fibbo.get(1)) {
				System.out.println(numero + " é um número de Fibonacci");
				eFibbo = true;
				break;
			}
			
			if (fibbo.get(1) == 0) {
				fibbo.add(1);
				fibbo.remove(0);
			}
			else {
				fibbo.add(fibbo.get(1) + fibbo.get(0));
				fibbo.remove(0);
			}
			
		}
		
		if (!eFibbo) {
			System.out.println(numero + " NÃO é um número de Fibonacci");
		}

	}

}
