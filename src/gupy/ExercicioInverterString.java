/*
 * 5) Escreva um programa que inverta os caracteres de um string.
 *
 * IMPORTANTE:
 *	a) Essa string pode ser informada através de qualquer entrada de sua preferência ou pode ser previamente definida no código;
 *	b) Evite usar funções prontas, como, por exemplo, reverse;
 */

package gupy;

import java.util.Scanner;

public class ExercicioInverterString {

	public static void main(String[] args) {
		System.out.println("Escreva um texto qualquer:");
		System.out.print("> ");
		
		Scanner sc = new Scanner(System.in);
		
		String texto = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		
		for (int i = (texto.length() - 1); i >= 0; i--) {
			sb.append(texto.charAt(i));
		}
		
		String textoInvertido = sb.toString();
		
		System.out.println("\n" + textoInvertido);
		
		sc.close();
	}

}
