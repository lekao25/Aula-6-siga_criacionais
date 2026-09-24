package siga;

public class ConexaoPostgreSQL implements Conexao {

    @Override
    public void abrir() {
        System.out.println("[PostgreSQL] conexão aberta");
    }
}
