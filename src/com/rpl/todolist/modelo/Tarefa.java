package com.rpl.todolist.modelo;


public class Tarefa {
	private Long id;
	private String titulo;
	private String descricao;
	private String local;
	private String data;
	private int concluida;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return titulo;
	}

	public int getConcluida() {
		return concluida;
	}

	public void setConcluida(int concluida) {
		this.concluida = concluida;
	}
}
