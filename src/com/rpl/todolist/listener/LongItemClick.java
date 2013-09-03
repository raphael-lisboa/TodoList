package com.rpl.todolist.listener;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.CheckedTextView;
import android.widget.Toast;

import com.rpl.todolist.TarefaDao;
import com.rpl.todolist.modelo.Tarefa;

public class LongItemClick implements OnItemLongClickListener {
	private Context context;
	private TarefaDao dao;
	
	public LongItemClick(Context context){
		this.context=context;
		dao = new TarefaDao(context);
	}
	
	public boolean onItemLongClick(AdapterView<?> adapter, View view,int posicao, long id) {
		Tarefa tarefa =(Tarefa) adapter.getItemAtPosition(posicao); 
		CheckedTextView check = (CheckedTextView) view;
		check.setChecked(!check.isChecked());

		if (!check.isChecked()) {
			tarefa.setConcluida(1);
		}else{
			tarefa.setConcluida(0);
		}
		try{
			dao.update(tarefa);
			Toast.makeText(context,"Tarefa " + adapter.getItemAtPosition(posicao)	+" atualizada",Toast.LENGTH_SHORT).show();
		}catch(Exception e){
			Toast.makeText(context,"Erro ao atualizar "+ e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
			Log.e("TAG", e.getLocalizedMessage());
		}
		return true;
	}




}
