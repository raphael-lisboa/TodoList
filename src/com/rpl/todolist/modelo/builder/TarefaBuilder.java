package com.rpl.todolist.modelo.builder;

import java.util.Date;

import com.rpl.todolist.modelo.Tarefa;

public class TarefaBuilder {

	private String titulo;
	private String descricao;
	private String local;
	private String data;

	public TarefaBuilder titulo(String titulo) {
		this.titulo = titulo;
		return this;
	}

	public TarefaBuilder decricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	public TarefaBuilder local(String local) {
		this.local = local;
		return this;
	}

	public TarefaBuilder data(String date) {
		this.data = date;
		return this;
	}

	public Tarefa build() {
		Tarefa tarefa = new Tarefa();
		tarefa.setTitulo(titulo);
		tarefa.setDescricao(descricao);
		tarefa.setData(data);
		tarefa.setLocal(local);
		return tarefa;
	}

}
