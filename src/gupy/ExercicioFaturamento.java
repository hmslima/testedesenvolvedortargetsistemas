/*
 * 3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, na linguagem que desejar, que 
 * calcule e retorne:
 *	• O menor valor de faturamento ocorrido em um dia do mês;
 *	• O maior valor de faturamento ocorrido em um dia do mês;
 *	• Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.
 *
 * IMPORTANTE:
 *	a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
 *	b) Podem existir dias sem faturamento, como nos finais de semana e feriados. Estes dias devem ser ignorados no cálculo da média;
 */

package gupy;

import java.io.FileReader;

// Adicionei a biblioteca json-simple manualmente, NÃO usei Maven
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ExercicioFaturamento {

	public static void main(String[] args) {
		
		JSONParser parser = new JSONParser();
		JSONArray jsonArray = null;
		JSONObject jsonObject = null;
		
		try {
			Object obj = parser.parse(new FileReader("src/gupy/dados.json"));
			
			jsonArray = (JSONArray) obj;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		jsonObject = (JSONObject) jsonArray.get(0); // Apenas para pegar uns valores iniciais
		
		
		double menorNumero = (double) jsonObject.get("valor");
		long diaMenor = (long) 0;
		double maiorNumero = (double) jsonObject.get("valor");
		long diaMaior = (long) 0;
		double valorTotal = 0;
		int numeroDeDiasUteis = 0;
		double mediaMensal = 0;
		int diasMaiorQueAMedia = 0;
		
		for (int i = 0; i < jsonArray.size(); i++) {
			
			jsonObject = (JSONObject) jsonArray.get(i);
			
			if (((double) jsonObject.get("valor")) == 0.0) {
				continue; // Se trata de uma dia não-útil, pula
			}
			else if (((double) jsonObject.get("valor")) < menorNumero) {
				menorNumero = (double) jsonObject.get("valor");
				diaMenor = (long) jsonObject.get("dia");
			}
			else if (((double) jsonObject.get("valor")) > maiorNumero) {
				maiorNumero = (double) jsonObject.get("valor");
				diaMaior = (long) jsonObject.get("dia");
			}
			
			numeroDeDiasUteis++;
			valorTotal += (double) jsonObject.get("valor");
			
		}
		
		mediaMensal = valorTotal / numeroDeDiasUteis;
		
		for (int i = 0; i < jsonArray.size(); i++) {
			
			jsonObject = (JSONObject) jsonArray.get(i);
			
			if (((double) jsonObject.get("valor")) > mediaMensal) {
				diasMaiorQueAMedia++;
			}
			
		}
		
		System.out.println("O menor valor de faturamento ocorrido em um dia do mês:");
		System.out.println("R$" + String.format("%.2f", menorNumero) + " no dia " + diaMenor + "\n");
		
		System.out.println("O maior valor de faturamento ocorrido em um dia do mês:");
		System.out.println("R$" + String.format("%.2f", maiorNumero) + " no dia " + diaMaior + "\n");
		
		System.out.println("Número de dias no mês em que o valor de faturamento diário foi superior à média mensal");
		System.out.println(diasMaiorQueAMedia + " dias tiveram faturamento diário superior à média de R$" + String.format("%.2f", mediaMensal));
	}

}
