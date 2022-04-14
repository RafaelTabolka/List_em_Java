package aplications;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dados.entities;

public class principal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("CADASTRO DE FUNCION�RIO");
		System.out.println();

		System.out.println("Digite a quantidade de funcion�rios: ");
		int n = sc.nextInt();

		while (n <= 0) {
			System.out.println("Quantidade inv�lida. Digite alguma valor maior que 0: ");
			n = sc.nextInt();
			System.out.println();
		}

		List<entities> principal = new ArrayList<>();

		char alteracao;

		do {
			for (int i = 0; i < n; i++) {
				System.out.println();
				System.out.println("Funcion�rio #" + (i + 1));

				System.out.println("Id: ");
				Integer id = sc.nextInt();

				while (confId(principal, id)) {
					System.out.println("Id existente. Digite outro: ");
					id = sc.nextInt();
				}

				sc.nextLine();

				System.out.println("Nome: ");
				String nome = sc.nextLine();

				System.out.println("Sal�rio: ");
				Float salario = sc.nextFloat();

				entities dados = new entities(id, nome, salario);

				principal.add(dados);
			}

			System.out.println("               DADOS ATUAIS ");
			System.out.println();

			for (int i = 0; i < n; i++) {
				System.out.println("Funcion�rio #" + (i + 1) + " " + principal.get(i).toString());
			}
			System.out.println();

			System.out.println("Deseja altera-los? 's' (sim) 'n' (n�o)");
			alteracao = sc.next().charAt(0);

			while (alteracao != 's' && alteracao != 'n') {
				System.out.println("Opera��o inv�lida. Escolha uma op��o: ");
				alteracao = sc.next().charAt(0);
			}

			if (alteracao == 's') {
				principal.clear();
			}

		} while (alteracao == 's');

		System.out.println();

		char id2;
		do {
			System.out.print("Digite o Id do funcion�rio que haver� altera��o no sal�rio: ");
			int id = sc.nextInt();
			System.out.println();

			entities filtroId = principal.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

			if (filtroId == null) {
				System.out.println("Id inexistente.");
				System.out.println();
				System.out.println("               DADOS ATUAIS ");
				for (int i = 0; i < n; i++) {
					System.out.println("Funcion�rio #" + (i + 1) + " " + principal.get(i).toString());
				}
			}

			else {
				System.out.println("Digite a pocentagem de acr�scimo ao sal�rio: ");
				System.out.println();
				float porcentagem = sc.nextFloat();
				filtroId.aumentoSalario(porcentagem);

				System.out.println("               DADOS ATUAIS ");
				for (int i = 0; i < n; i++) {
					System.out.println("Funcion�rio #" + (i + 1) + " " + principal.get(i).toString());
				}
			}

			System.out.println();
			System.out.println("Deseja alterar o sal�rio de outro funcion�rio? 's' (sim)  'n' (n�o) ");
			id2 = sc.next().charAt(0);

			while (id2 != 's' && id2 != 'n') {
				System.out.println("Operação inválida. Escolha uma opçãoo: ");
				id2 = sc.next().charAt(0);
			}

		} while (id2 == 's');

		System.out.println("Operação encerrada!");

		sc.close();

	}

	public static boolean confId(List<entities> list, int id) {
		entities idInvalido = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return idInvalido != null;
	}

}