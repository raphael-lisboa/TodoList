package com.rpl.todolist.active;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.rpl.todolist.R;
import com.rpl.todolist.TarefaDao;
import com.rpl.todolist.modelo.Tarefa;
import com.rpl.todolist.modelo.builder.TarefaBuilder;

public class Formulario extends Activity {

	private TarefaDao dao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_formulario);
		dao = new TarefaDao(this);
		Button btSalvar = (Button) findViewById(R.id.salvar);

		btSalvar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Tarefa tarefa = new TarefaBuilder().titulo(stringViewValue(R.id.titulo)).decricao(stringViewValue(R.id.descricao)).
						local(stringViewValue(R.id.local)).
						data(stringViewValue(R.id.data)).build();

				dao.save(tarefa);
				dao.close();

			}

			private String stringViewValue(int id) {
				EditText edit = (EditText) findViewById(id);

				return edit.getText().toString();
			}

			
		});
	}

}
