package com.rpl.todolist;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.rpl.todolist.modelo.Tarefa;

public class TarefaDao extends SQLiteOpenHelper {

	private static final String NOME_DO_BANCO = "TODO";
	private static final int VERSAO = 4;
	private static String DDL_CREATE = "CREATE TABLE TAREFA  ( ID INTEGER PRIMARY KEY, TEXTO Text, CONCLUIDA INTEGER );";
	public long save(Tarefa tarefa) {

		ContentValues content = new ContentValues();
		content.put("TEXTO", tarefa.getTexto());
		content.put("CONCLUIDA", 0);

		long id =	getWritableDatabase().insert("TAREFA", null, content);
		return id;
	}

	public List<Tarefa> listAll() {
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		String[] colunas = { "ID,TEXTO,CONCLUIDA"};
		Cursor cursor = null;
		try {
			cursor = getWritableDatabase().query("TAREFA", colunas, null, null,	null, null, null);
		} catch (Exception ex) {
			Log.d("TAG", "ERRO " +ex.getLocalizedMessage());
			return tarefas;
		}
		while (cursor.moveToNext()) {
			Tarefa tarefa = new Tarefa();
			tarefa.setId(cursor.getLong(0));
			tarefa.setTexto(cursor.getString(1));
			tarefa.setConcluida(cursor.getInt(2));
			tarefas.add(tarefa);
		}

		return tarefas;
	}
	
	public Long update(Tarefa tarefa){
		ContentValues content = new ContentValues();
		content.put("TEXTO", tarefa.getTexto());
		content.put("CONCLUIDA", tarefa.getConcluida());
		 
		return	(long) getWritableDatabase().update("TAREFA", content, "ID "+"="+tarefa.getId(), null);
		
		
	}

	public TarefaDao(Context context) {
		super(context, NOME_DO_BANCO, null, VERSAO);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		

		db.execSQL(DDL_CREATE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		String drop = "DROP TABLE IF EXISTS TAREFA ;";

		db.execSQL(drop);
		db.execSQL(DDL_CREATE);
	}

	public void delete(Tarefa tarefa) {
		String whereClause= "id= "+tarefa.getId();
		getWritableDatabase().delete("TAREFA", whereClause,null);
	}

}
