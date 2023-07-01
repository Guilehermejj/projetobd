package com.example.projetobd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button cadasbt;
    AcessoBD acessoBD;
    Button bAtualizarUsuario;

    ListView lvUsuarios;

    ArrayAdapter usuarioArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cadasbt = findViewById(R.id.button);
        bAtualizarUsuario = findViewById(R.id.button2);
        lvUsuarios = findViewById(R.id.listview);
        EditText nametxt = (EditText) findViewById(R.id.ntxt);
        EditText emailtxt = (EditText) findViewById(R.id.etxt);
        EditText numbertxt = (EditText) findViewById(R.id.number);;

        acessoBD = new AcessoBD(MainActivity.this);
        mostrarUsuariosNaListView(acessoBD);

        cadasbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = null;

    try {
        usuario = new Usuario(-1,
                nametxt.getText().toString(),
            emailtxt.getText().toString(),
        Integer.parseInt(numbertxt.getText().toString()));

        boolean sucesso = acessoBD.adicionarUsuario(usuario);
        mostrarUsuariosNaListView(acessoBD);
        Toast.makeText(MainActivity.this, "Sucesso:" + sucesso, Toast.LENGTH_SHORT).show();

    } catch (NumberFormatException e) {
        Toast.makeText(MainActivity.this, "Erro na conversão de uma String para int: Idade não corresponde a número!", Toast.LENGTH_LONG).show();
    } catch (Exception e) {
        Toast.makeText(MainActivity.this, "Erro na criação do usuário!", Toast.LENGTH_LONG).show();
        //usuario=new Usuario(-1,"erro", 0);
    }


            }
        });
        /*bListaUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aqui acontece a ação

                   /* //AcessoBD acessoBD = new AcessoBD(MainActivity.this);
                    List<Usuario> todosUsuarios = acessoBD.getListaUsuarios();//Dentro de <> está o tipo de usuário a ser inserido na lista

                    usuarioArrayAdapter = new ArrayAdapter<Usuario>(MainActivity.this, android.R.layout.simple_list_item_1, acessoBD.getListaUsuarios());//Dentro de <> está o tipo de objeto que será adicionado na lista


                    //Para o próximo passo, adicionar n
                    o content_main.xml o objeto da pallete que encontra-se em Legacy/ListView. É só arrastar o ListView para a tela. Fazer os ajustes de ancoragem.
                    //Também adicionar a variável aqui em MainActivity e associar ela ao componente com findViewById.
                    lvUsuarios.setAdapter(usuarioArrayAdapter);*/

                /*mostrarUsuariosNaListView(acessoBD);

                Toast.makeText(MainActivity.this, "Lista de usuários preenchida com sucesso", Toast.LENGTH_SHORT).show();


            }
        });*/


        /**
         * Evento de click na lista de usuários na intenção de excluir o usuário clicado.
         */
        lvUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                System.out.println("Captou click na lista!");
                Usuario usuarioClicado = (Usuario) parent.getItemAtPosition(position);
                boolean excluiu = acessoBD.excluirUsuario(usuarioClicado);

                mostrarUsuariosNaListView(acessoBD);

                Toast.makeText(MainActivity.this, "Usuário excluído(" + excluiu + "):" + usuarioClicado.toString(), Toast.LENGTH_SHORT).show();

                /*Usuario usuarioClicado = (Usuario) parent.getItemAtPosition(position);
                boolean excluiu = acessoBD.excluirUsuario(usuarioClicado);

                if (excluiu) {
                    Toast.makeText(MainActivity.this, "Usuário excluído: " + usuarioClicado.toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Falha ao excluir usuário", Toast.LENGTH_SHORT).show();
                }

                mostrarUsuariosNaListView(acessoBD);*/

            }
        });

        bAtualizarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aqui acontece a ação


                //Declaração de um objeto usuário da (nossa) classe Usuário
                Usuario usuario = null;//null para inicializar

                //Bloco try para "tentar" executar as ações esperadas. O catch é para "remediar" ou "avisar" algo que não foi realizado no bloco try como esperado.
                try {
                    usuario = new Usuario (nametxt.getText().toString(), emailtxt.getText().toString(), Integer.parseInt(numbertxt.getText().toString()));

                    boolean sucesso = acessoBD.atualizarUsuario(usuario);

                    mostrarUsuariosNaListView(acessoBD);
                    Toast.makeText(MainActivity.this, "Sucesso:" + sucesso, Toast.LENGTH_SHORT).show();

                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Erro na conversão de uma String para int: numero não corresponde a número!", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Erro na criação do usuário!", Toast.LENGTH_LONG).show();
                    usuario = new Usuario("erro", "erro", 0);
                }

            }
        });


    }

        private void mostrarUsuariosNaListView(AcessoBD acessoBD) {
            usuarioArrayAdapter = new ArrayAdapter<Usuario>(MainActivity.this,
                    android.R.layout.simple_list_item_1, acessoBD.getListaUsuarios());//Dentro de <> está o tipo de objeto que será adicionado na lista
            lvUsuarios.setAdapter(usuarioArrayAdapter);
        }

            }

