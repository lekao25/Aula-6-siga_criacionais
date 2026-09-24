package siga;

public class Main {

    public static void main(String[] args) {
        System.out.println(
                "=== SIGA - Padrões Criacionais ===\n"
        );

        AcessoDados acesso = AcessoDados.obterInstancia();

        System.out.println("--- Teste com MySQL ---");

        FabricaBanco fabricaMySQL = new FabricaMySQL();
        acesso.conectar(fabricaMySQL);

        System.out.println();

        System.out.println("--- Teste com PostgreSQL ---");

        FabricaBanco fabricaPostgreSQL = new FabricaPostgreSQL();
        acesso.conectar(fabricaPostgreSQL);

        System.out.println();

        System.out.println("--- Teste do Builder ---");

        ConsultaBuilder consultaBuilder = new ConsultaBuilder("aluno")
                .comFiltro("curso = 'DSM'")
                .comOrdenacao("nome")
                .comLimite(50)
                .comOffset(0)
                .comTimeout(30)
                .somenteAtivos();

        String consulta = acesso.montarConsulta(consultaBuilder);

        System.out.println("Consulta montada: " + consulta);

        System.out.println();

        System.out.println("--- Teste do Singleton ---");

        AcessoDados outraReferencia = AcessoDados.obterInstancia();

        System.out.println(
                "As duas referências apontam para o mesmo objeto? "
                        + (acesso == outraReferencia)
        );
    }
}
