package siga;

public class ConexaoMySQL implements Conexao {

    @Override
    public void abrir() {
        System.out.println("[MySQL] conexão aberta");
    }
}
