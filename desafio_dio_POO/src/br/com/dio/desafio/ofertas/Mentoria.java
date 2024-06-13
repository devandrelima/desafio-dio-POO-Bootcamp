package br.com.dio.desafio.ofertas;

import java.time.LocalDate;

public class Mentoria extends Conteudo {
	
	public Mentoria() {
		super();
	}

	private LocalDate data;
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "Curso [titulo=" + getTitulo() + ", descricao=" + getDescricao() + ", data=" + data + "]";
	}

	@Override
	public double calcularXP() {
		return XP_PADRAO + 20d;
	}
}
