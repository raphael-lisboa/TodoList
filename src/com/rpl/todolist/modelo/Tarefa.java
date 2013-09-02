package com.rpl.todolist.modelo;

public class Tarefa {
	private Long id;
	private String texto;
	private int concluida;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getConcluida() {
		return concluida;
	}

	public void setConcluida(int concluida) {
		this.concluida = concluida;
	}

	@Override
	public String toString() {
		return texto;
	}

}
