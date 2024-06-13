package br.com.dio.desafio.dominio;

import br.com.dio.desafio.ofertas.Bootcamp;
import br.com.dio.desafio.ofertas.Curso;

public class Main {
	/*
	 * Testa as classes criadas para a criação de Bootcamps, registrando
	 * os cursos e desenvolvedores inscritos
	 * */
	public static void main(String[] args) {
		Bootcamp bootcampJava = new Bootcamp();
		Curso curso1 = new Curso("Introdução a Lógica");
		Curso curso2 = new Curso("Banco de Dados");
		Curso curso3 = new Curso("Laços de Repetição");
		Dev devAndre = new Dev("André");
		Dev devLucas = new Dev("Lucas");
		int numeroRelatorio = 0;
		
		// Registrando cursos no bootcamp
		bootcampJava.getConteudos().add(curso1);
		bootcampJava.getConteudos().add(curso2);
		bootcampJava.getConteudos().add(curso3);
		
		// Registrando desenvolvedores no bootcamp
		// Automaticamente são inscritos nos cursos do bootcamp
		devAndre.inscreverBootcamp(bootcampJava);
		devLucas.inscreverBootcamp(bootcampJava);
		
		System.out.println("Desenvolvedores Inscritos:");
		bootcampJava.getDevsInscritos() // O stream é responsável por pegar cada elemento do set
				.stream()
				.forEach(nomeDev -> System.out.println("- " + nomeDev.getNome()));
		
		bootcampJava.gerarRelatorio(++numeroRelatorio); // Cada relatório gerado tem uma numeração
		
		devAndre.progredir(); // Faz o curso ir do estado de 'inscrito' para 'concluido' e aumenta o XP
		devAndre.progredir();
		
		bootcampJava.gerarRelatorio(++numeroRelatorio);
	}
}