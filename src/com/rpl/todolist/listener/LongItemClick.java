package com.rpl.todolist.listener;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;

import com.rpl.todolist.TarefaDao;
import com.rpl.todolist.modelo.Tarefa;

public class LongItemClick implements OnItemLongClickListener {
	private Context context;
	private TarefaDao dao;
	private Boolean hasDelete = false;

	public LongItemClick(Context context) {
		this.context = context;
		dao = new TarefaDao(context);
	}

	public boolean onItemLongClick( AdapterView<?> adapter, View view,
			final int posicao, long id) {

		final Tarefa tarefa = (Tarefa) adapter.getItemAtPosition(posicao);

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);
		alertDialogBuilder
				.setTitle("Excluir tarefa")
				.setMessage("Você deseja realmente excluir o registro ?")
				.setPositiveButton("Sim",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dao.delete(tarefa);
								dao.close();
								dialog.cancel();
								hasDelete = true;
							}
						})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

						dialog.cancel();
					}
				});
		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();
		if (hasDelete) {
			adapter.removeViewAt(posicao);
		}

		return true;
	}

}
