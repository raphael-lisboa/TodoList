package com.rpl.todolist.modelo.builder;

import com.rpl.todolist.modelo.Tarefa;

public class TarefaBuilderTest  {

	public static void main(String[] argss){
		TarefaBuilder  builder = new TarefaBuilder();
		Tarefa tarefa = builder.titulo("Titulo").decricao("Esse teste é legal").build();
		
		if(tarefa==null){
			System.err.println("Nao construiu");
			return;
			
		}
		if(!"Titulo".equals(tarefa.getTitulo())){
			System.err.println("Não é o titulo");
		}
		
	}
	
}
