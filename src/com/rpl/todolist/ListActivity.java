package com.rpl.todolist;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.rpl.todolist.listener.LongItemClick;
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
		list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
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

		list.setOnItemLongClickListener(new LongItemClick(this));

		list.setOnItemClickListener(new ShortItemClick(this));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();

		menuInflater.inflate(R.menu.menu_principal, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case R.id.novo: {
			Intent intent = new Intent(ListActivity.this, Formulario.class);
			startActivity(intent);
		}break;
		case R.id.sobre: {
			// nada por enquanto
		}

		default:
			break;
		}

		return true;
	}

	private void carrgaTarefas() {
		List<Tarefa> tarefas = dao.listAll();
		dao.close();

		int layout = android.R.layout.simple_list_item_checked;
		ArrayAdapter<Tarefa> adapter = new ArrayAdapter<Tarefa>(this, layout, tarefas);

		list.setAdapter(adapter);

		// marcar os ja selecionados
		for (int i = 0; i < tarefas.size(); i++) {
			if (tarefas.get(i).getConcluida() == 1) {

				list.setItemChecked(i, true);
			}

		}

	}

}
