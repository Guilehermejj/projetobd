package com.example.projetobd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AcessoBD extends SQLiteOpenHelper {
    protected static final String TABELA_USUARIO = "TABELA_USUARIO";

    protected static final String USUARIO_ID = "ID";
    protected static final String USUARIO_NOME = "USUARIO_NOME";
    protected static final String USUARIO_EMAIL = "USUARIO_EMAIL";

    public AcessoBD(@Nullable Context context) {
        super(context, "ClienteBD", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String statement = "CREATE TABLE " + TABELA_USUARIO +
                " (" + USUARIO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USUARIO_NOME + " TEXT, " + USUARIO_EMAIL + " TEXT)";


        db.execSQL(statement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean adicionarUsuario(Usuario usuario) {
        //getWritableDatabase() permite a gravação em um banco de dados
        SQLiteDatabase db = this.getWritableDatabase();

        //ContentValues é uma classe que permite armazenar dados agrupados aos pares. Exemplo contentValues.put("nome", value); contentValues.getString("name"). É uma associative array em PHP ou hashmap em outras linguagens.
        ContentValues contentValues = new ContentValues();
        contentValues.put(USUARIO_NOME, usuario.getNomeUsuario());//coluna nome e valor
        contentValues.put(USUARIO_EMAIL, usuario.getEmailUsuario());//coluna email e valor
        //Por quê não tem o ID aqui? Porque o ID é tem incremento automático (AUTOINCREMENT). Veja a linha "CREATE TABLE..." dentro do método onCreate.

        //nullColumnHack é null quando deseja-se adicionar uma linha não nula. Quando intencionalmente deseja inserir uma linha vazia, é necessário informar o valor de uma coluna da tabela usada. No caso da tabela usuário, pode ser nome ou idade.
        long inserirSucedido = db.insert(TABELA_USUARIO, null, contentValues);
        db.close();//Sempre fechar o banco de dados após uso.

        //-1 indica que nenhuma linha foi inserida na referida tabela
        return inserirSucedido != -1;


    }

    //Para adicionar um usuário
    public boolean atualizarUsuario(Usuario usuario) {
        SQLiteDatabase db = this.getWritableDatabase(); //getWritableDatabase() permite a gravação em um banco de dados

        ContentValues contentValues = new ContentValues();//ContentValues é uma classe que permite armazenar dados agrupados aos pares. Exemplo contentValues.put("nome", value); contentValues.getString("name"). É uma associative array em PHP ou hashmap em outras linguagens.
        contentValues.put(USUARIO_NOME, usuario.getNomeUsuario());
        contentValues.put(USUARIO_EMAIL, usuario.getEmailUsuario());
        contentValues.put(USUARIO_ID, usuario.getIdUsuario());
        //Por quê não tem o ID aqui? Porque o ID é tem incremento automático (AUTOINCREMENT). Veja a linha "CREATE TABLE..." dentro do método onCreate.

        long atualizarSucedido = db.update(TABELA_USUARIO, contentValues, USUARIO_ID + "=" + usuario.getIdUsuario(), null);//nullColumnHack é null quando deseja-se adicionar uma linha não nula. Quando intencionalmente deseja inserir uma linha vazia, é necessário informar o valor de uma coluna da tabela usada. No caso da tabela usuário, pode ser nome ou idade.
        db.close();//Sempre fechar o banco de dados após uso.

        //-1 indica que nenhuma linha foi inserida na referida tabela
        return atualizarSucedido != -1;
    }

    public List<Usuario> getListaUsuarios() {//Para importar List, pode ser usado o atalho com Alt+Enter (para escolher a ação) ou Shift+Alt+Enter (para pegar o pacote sugerido pela ferramenta Android Studio). Tem que ser do pacote "java.util.List"

        List<Usuario> listaUsuarios = new ArrayList<>();

        //String queryStatement = "SELECT * FROM TABELA_USUARIO";
        String queryStatement = "SELECT * FROM " + TABELA_USUARIO;//Considere a linha acima para visualizar a sentença como ela é na prática.

        SQLiteDatabase db = this.getReadableDatabase();
    }
}

