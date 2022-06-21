/*
 * 4) Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:
 *
 *	SP – R$67.836,43
 *	RJ – R$36.678,66
 *	MG – R$29.229,88
 *	ES – R$27.165,48
 *	Outros – R$19.849,53
 *
 * Escreva um programa na linguagem que desejar onde calcule o percentual de representação que cada estado teve dentro do valor total 
 * mensal da distribuidora.
 */

package gupy;

public class ExercicioDistribuidora {

	public static void main(String[] args) {
		double sp = 67836.43;
		double rj = 36678.66;
		double mg = 29229.88;
		double es = 27165.48;
		double outros = 19849.53;
		
		double total = sp + rj + mg + es + outros;
		
		double sp_porcentagem = (67836.43 / total) * 100;
		double rj_porcentagem = (36678.66 / total) * 100;
		double mg_porcentagem = (29229.88 / total) * 100;
		double es_porcentagem = (27165.48 / total) * 100;
		double outros_porcentagem = (19849.53 / total) * 100;
		
		System.out.println("Percentual de representação que cada estado teve dentro do valor total mensal da distribuidora:");
		System.out.println("SP: " + String.format("%.2f", sp_porcentagem) + "%");
		System.out.println("RJ: " + String.format("%.2f", rj_porcentagem) + "%");
		System.out.println("MG: " + String.format("%.2f", mg_porcentagem) + "%");
		System.out.println("ES: " + String.format("%.2f", es_porcentagem) + "%");
		System.out.println("Outros: " + String.format("%.2f", outros_porcentagem) + "%");
	}

}
