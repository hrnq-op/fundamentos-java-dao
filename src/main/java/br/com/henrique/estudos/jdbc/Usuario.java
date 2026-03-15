package br.com.henrique.estudos.jdbc;

import java.time.LocalDate;

public class Usuario{
	private int id;
	private String nome;
	private int ano_nasc;
	private String sexo;
	
	public Usuario (String nome, int ano_nasc, String sexo) {
		this.setNome(nome);
		this.setAno_nasc(ano_nasc);
		this.setSexo(sexo);
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAno_nasc() {
		return ano_nasc;
	}

	public void setAno_nasc(int ano_nasc) {
		this.ano_nasc = ano_nasc;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public void Info() {
		System.out.println("Id " + this.getId());
		System.out.println("Nome: " + this.getNome());
		System.out.println("Sexo: " + this.getSexo());
		System.out.println("Idade: " + (LocalDate.now().getYear() - getAno_nasc()));
		System.out.println("\n");
	}
	
}