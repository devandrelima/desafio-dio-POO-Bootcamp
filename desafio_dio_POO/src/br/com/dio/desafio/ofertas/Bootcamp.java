package br.com.dio.desafio.ofertas;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import br.com.dio.desafio.dominio.Dev;

public class Bootcamp extends Conteudo{

	private final LocalDate dataInicio = LocalDate.now();
	private final LocalDate dataFim = dataInicio.plusDays(45);
	private Set<Dev> devsInscritos = new HashSet<>();
	private Set<Conteudo> conteudos = new LinkedHashSet<>();
	
	public Set<Dev> getDevsInscritos() {
		return devsInscritos;
	}

	public void setDevsInscritos(Set<Dev> devsInscritos) {
		this.devsInscritos = devsInscritos;
	}

	public Set<Conteudo> getConteudos() {
		return conteudos;
	}

	public void setConteudos(Set<Conteudo> conteudos) {
		this.conteudos = conteudos;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}
	
	public void gerarRelatorio(int numRelatorio) {
		System.out.println("\n\n	Relatório " + numRelatorio);
		for(Dev desenvolvedor: this.getDevsInscritos()) {
			System.out.println("\n-------- " + desenvolvedor.getNome() + " --------");
			
			System.out.println("XP: " + desenvolvedor.calcularTotalXp());
			
			System.out.println("\nCursos Inscritos: ");
			desenvolvedor.getConteudoInscritos()
				.stream()
				.forEach(curso->System.out.println("- " + curso.getTitulo()));
			System.out.println("\nCursos Concluídos: ");
			if(desenvolvedor.getConteudosConcluidos().isEmpty()) {
				System.out.println("[Vazio]");
			} else {
				desenvolvedor.getConteudosConcluidos()
					.stream()
					.forEach(curso-> System.out.println("- " + curso.getTitulo()));
			}
		}
	}
	@Override
	public double calcularXP() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conteudos, dataFim, dataInicio, devsInscritos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bootcamp other = (Bootcamp) obj;
		return Objects.equals(conteudos, other.conteudos) && Objects.equals(dataFim, other.dataFim)
				&& Objects.equals(dataInicio, other.dataInicio) && Objects.equals(devsInscritos, other.devsInscritos);
	}
}
