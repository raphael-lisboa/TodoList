package com.rpl.todolist;

import com.rpl.todolist.modelo.Tarefa;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckedTextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ShortItemClick implements OnItemClickListener {

	
	private Context context;
	private TarefaDao dao;
	
	public ShortItemClick(Context context){
		this.context=context;
		dao = new TarefaDao(context);
	}
	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int posicao, long id) {
		Tarefa tarefa =(Tarefa) adapter.getItemAtPosition(posicao); 
		CheckedTextView check = (CheckedTextView) view;
		check.setChecked(!check.isChecked());

		if (check.isChecked()) {
			tarefa.setConcluida(1);
		}else{
			tarefa.setConcluida(0);
		}
		try{
			dao.update(tarefa);
			Toast.makeText(context,"Tarefa " + adapter.getItemAtPosition(posicao)	+" atualizada",Toast.LENGTH_SHORT).show();
			dao.close();
		}catch(Exception e){
			Toast.makeText(context,"Erro ao atualizar "+ e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
			Log.e("TAG", e.getLocalizedMessage());
		}

	}

}
