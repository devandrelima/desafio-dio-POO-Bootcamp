package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import br.com.dio.desafio.ofertas.Bootcamp;
import br.com.dio.desafio.ofertas.Conteudo;

public class Dev {
	private String nome;
	private Set<Conteudo> conteudoInscritos = new LinkedHashSet<>();
	private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
	
	public Dev(String nome) {
		super();
		this.nome = nome;
	}

	public void inscreverBootcamp(Bootcamp bootcamp) {
		this.conteudoInscritos.addAll(bootcamp.getConteudos());
		bootcamp.getDevsInscritos().add(this);
	}
	
	public void progredir() {
		Optional<Conteudo> conteudo = this.conteudoInscritos.stream().findFirst();
		
		if(conteudo.isPresent()) {
			this.conteudosConcluidos.add(conteudo.get());
			this.conteudoInscritos.remove(conteudo.get());
		} else {
			System.err.println("Você não está matriculado em nenhum conteúdo!");
		}
	}
	
	public double calcularTotalXp() {
		return this.conteudosConcluidos
				.stream()
				.mapToDouble(conteudo->conteudo.calcularXP())
				.sum();
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Set<Conteudo> getConteudoInscritos() {
		return conteudoInscritos;
	}
	
	public void setConteudoInscritos(Set<Conteudo> conteudoInscritos) {
		this.conteudoInscritos = conteudoInscritos;
	}
	
	public Set<Conteudo> getConteudosConcluidos() {
		return conteudosConcluidos;
	}
	
	public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
		this.conteudosConcluidos = conteudosConcluidos;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(conteudoInscritos, conteudosConcluidos, nome);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dev other = (Dev) obj;
		return Objects.equals(conteudoInscritos, other.conteudoInscritos)
				&& Objects.equals(conteudosConcluidos, other.conteudosConcluidos) && Objects.equals(nome, other.nome);
	}
}
