package siga;

public class ComandoMySQL implements Comando {

    @Override
    public void executar(String sql) {
        System.out.println("[MySQL] executando: " + sql);
    }
}
