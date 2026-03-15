package br.com.henrique.estudos.jdbc;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main{
	public static void main (String[] args) throws SQLException {
		IUsuarioDAO dao = new UsuarioDAOMySQL();
			
		try (Scanner teclado = new Scanner(System.in)){
			int decisao = 0;
			while (decisao != 6) {
				System.out.println("---- Menu de opções ----");
				System.out.println("1 - Inserir");
				System.out.println("2 - Listar");
				System.out.println("3 - Pesquisar");
				System.out.println("4 - Alterar");
				System.out.println("5 - Excluir");
				System.out.println("6 - Sair");
				System.out.println("------------------------");
				System.out.print("Digite a opção: ");
				decisao = teclado.nextInt();
				teclado.nextLine();
				
				
				switch (decisao) {
				case 1:
					System.out.println("\n------- CADASTRO -------");
					System.out.print("Nome: ");
					String nome = teclado.nextLine();
					System.out.print("Sexo: ");
					String sexo = teclado.nextLine();
					System.out.print("Ano Nascimento: ");
					int ano_nasc = teclado.nextInt();
					System.out.println("Usuário Inserido com Sucesso !!");
					System.out.println("------- CADASTRO -------\n");
					Usuario u = new Usuario(nome, ano_nasc, sexo);
					dao.inserir(u);
					break;
				case 2:
					System.out.println("\n---- Lista de Usuário Cadastrados ----");
					List<Usuario> listaUsuarios = dao.listar();
					for (Usuario us : listaUsuarios) {
						us.Info();
					}
					System.out.println("--------------------------------------\n");
					break;
				case 3:
					System.out.print("Digite o ID a ser pesquisado: ");
					int id = teclado.nextInt();
					Usuario encontrado = dao.pesquisar(id);
					if (encontrado != null) {
						
						System.out.println("\n-------- PESQUISA ---------");
						System.out.println("Usuário Encontrado !!\n");
						encontrado.Info();
						System.out.println("-------- PESQUISA ---------\n");
					} else System.out.println("Usuário não encontrado ...\n");
					break;
				case 4:
					System.out.print("Digite o ID do Usuário a ser Alterado: ");
					int id1 = teclado.nextInt();
					teclado.nextLine();
					Usuario encontrado1 = dao.pesquisar(id1);
					if (encontrado1 != null) {
						System.out.println("\n------- ALTERAÇÃO -------");
						encontrado1.Info();			
						System.out.print("Novo Nome: ");
						String nome1 = teclado.nextLine();
						System.out.print("Sexo: ");
						String sexo1 = teclado.nextLine();
						System.out.print("Ano de Nascimento: ");
						int ano_nasc1 = teclado.nextInt();
						dao.alterar(id1, nome1, sexo1, ano_nasc1);
						System.out.println("\nUsuário Alterado com Sucesso !!");
						System.out.println("------- ALTERAÇÃO -------\n");
					}else System.out.println("Usuário não encontrado ...\n");
					break;
				case 5:
					System.out.print("Digite o ID do Usuário a ser Exlcuído: ");
					int id2 = teclado.nextInt();
					teclado.nextLine();
					Usuario encontrado2 = dao.pesquisar(id2);
					if (encontrado2 != null) {
						System.out.println("------- EXCLUIR -------");
						encontrado2.Info();
						System.out.print("Confirmar (S/N): ");
						String confirmacao = teclado.nextLine();
						if (confirmacao.equals("S") || confirmacao.equals("s")) {
							System.out.println("\nUsuário Excluído com Sucesso !!");
							dao.excluir(id2);
						}else break;
						
						System.out.println("------- EXCLUIR -------");
					}else System.out.println("\nUsuário não encontrado ...\n");
					break;
				case 6:
					System.out.println("\n---- Fim do Programa ----");
				}
				
			}
	}
	catch (Exception e) {
        System.err.println("Erro na operação: " + e.getMessage());
        e.printStackTrace();
	}
}
}