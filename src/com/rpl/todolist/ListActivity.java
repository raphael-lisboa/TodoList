package com.rpl.todolist;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

import com.rpl.todolist.modelo.Tarefa;

public class ListActivity extends Activity {

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        
        List<Tarefa> tarefas = carrgaTarefas();
        int layout = android.R.layout.simple_list_item_checked;
        ArrayAdapter<Tarefa> adapter= new ArrayAdapter<Tarefa>(this,layout,tarefas);
        
        ListView list= (ListView)findViewById(R.id.listagem);
        list.setAdapter(adapter);
        
        
        
        list.setOnItemLongClickListener(new OnItemLongClickListener() {
        	
			public boolean onItemLongClick(AdapterView<?> adapter, View view,int posicao, long id) {
				
				
				String strConcluida ="";

			     CheckedTextView check = (CheckedTextView)view;
			     check.setChecked(!check.isChecked());
				
				if(!check.isChecked()){
					strConcluida=" ainda não "; 
				}
				
				Toast.makeText(ListActivity.this, "Tarefa "+adapter.getItemAtPosition(posicao)+ strConcluida +" concluida", Toast.LENGTH_SHORT).show();
				
				return true;
			}

						
		});
    }
    



    private List<Tarefa> carrgaTarefas() {
    	List<Tarefa> tarefas = new ArrayList<Tarefa>();
    	Tarefa t1= new Tarefa();
    	t1.setId(1l);
    	t1.setTexto("Aparecer na tela");
    
    	Tarefa t2= new Tarefa();
    	t2.setId(1l);
    	t2.setTexto("Marcar como concluida");
    	
    	
    	tarefas.add(t1);
    	tarefas.add(t2);
    	return tarefas;
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list, menu);
        return true;
    }
    
}
