package siga;

public class AcessoDados {

    private static final AcessoDados INSTANCIA = new AcessoDados();

    private AcessoDados() {
    }

    public static AcessoDados obterInstancia() {
        return INSTANCIA;
    }

    public void conectar(FabricaBanco fabricaBanco) {
        if (fabricaBanco == null) {
            throw new IllegalArgumentException(
                    "A fábrica do banco deve ser informada."
            );
        }

        Conexao conexao = fabricaBanco.criarConexao();
        Comando comando = fabricaBanco.criarComando();

        conexao.abrir();
        comando.executar("SELECT * FROM aluno");
    }

    public String montarConsulta(ConsultaBuilder consultaBuilder) {
        if (consultaBuilder == null) {
            throw new IllegalArgumentException(
                    "O builder da consulta deve ser informado."
            );
        }

        return consultaBuilder.construir();
    }
}
