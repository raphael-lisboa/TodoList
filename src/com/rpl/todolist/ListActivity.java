package com.rpl.todolist;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.rpl.todolist.modelo.Tarefa;

public class ListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        
        List<Tarefa> tarefas = carrgaTarefas();
        int layout = android.R.layout.simple_list_item_1;
        ListAdapter adapter= new ArrayAdapter(this,layout,tarefas);
        
        ListView list= (ListView)findViewById(R.id.listagem);
        list.setAdapter(adapter);
    }


    private List<Tarefa> carrgaTarefas() {
    	List<Tarefa> tarefas = new ArrayList<Tarefa>();
    	Tarefa t1= new Tarefa();
    	t1.setId(1l);
    	t1.setTexto("Aparecer na tela");
    	
    	tarefas.add(t1);
    	
    	return tarefas;
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list, menu);
        return true;
    }
    
}
