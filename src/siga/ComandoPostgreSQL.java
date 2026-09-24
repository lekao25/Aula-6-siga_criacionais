package siga;

public class ComandoPostgreSQL implements Comando {

    @Override
    public void executar(String sql) {
        System.out.println("[PostgreSQL] executando: " + sql);
    }
}
