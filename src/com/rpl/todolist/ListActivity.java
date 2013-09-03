package com.rpl.todolist;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.rpl.todolist.modelo.Tarefa;

public class ListActivity extends Activity {

	private EditText edit;
	private TarefaDao dao;
	private ListView list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);

		dao = new TarefaDao(this);

		

		list = (ListView) findViewById(R.id.listagem);

		edit = (EditText) findViewById(R.id.input);

		carrgaTarefas();
		Button botao = (Button) findViewById(R.id.botao);

		botao.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Tarefa tarefa = new Tarefa();
				tarefa.setTexto(edit.getText().toString());

				dao.save(tarefa);
				dao.close();
				carrgaTarefas();
				edit.setText("");
			}
		});

		list.setOnItemLongClickListener(new OnItemLongClickListener() {

			public boolean onItemLongClick(AdapterView<?> adapter, View view,
					int posicao, long id) {

				String strConcluida = "";

				CheckedTextView check = (CheckedTextView) view;
				check.setChecked(!check.isChecked());

				if (!check.isChecked()) {
					strConcluida = " ainda não ";
				}

				Toast.makeText(
						ListActivity.this,
						"Tarefa " + adapter.getItemAtPosition(posicao)
								+ strConcluida + " concluida",
						Toast.LENGTH_SHORT).show();

				return true;
			}

		});
	}

	
	
	private void carrgaTarefas() {
		List<Tarefa> tarefas = dao.listAll();
		dao.close();
		
		int layout = android.R.layout.simple_list_item_checked;
		ArrayAdapter<Tarefa> adapter = new ArrayAdapter<Tarefa>(this, layout,tarefas);
		list.setAdapter(adapter);
	}

}
