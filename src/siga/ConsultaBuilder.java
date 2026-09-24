package siga;

public class ConsultaBuilder {

    private final String tabela;
    private String filtro;
    private String ordenacao;
    private int limite;
    private int offset;
    private int timeoutSegundos;
    private boolean somenteAtivos;

    public ConsultaBuilder(String tabela) {
        if (tabela == null || tabela.isBlank()) {
            throw new IllegalArgumentException("A tabela deve ser informada.");
        }

        this.tabela = tabela;
    }

    public ConsultaBuilder comFiltro(String filtro) {
        this.filtro = filtro;
        return this;
    }

    public ConsultaBuilder comOrdenacao(String ordenacao) {
        this.ordenacao = ordenacao;
        return this;
    }

    public ConsultaBuilder comLimite(int limite) {
        if (limite < 0) {
            throw new IllegalArgumentException("O limite não pode ser negativo.");
        }

        this.limite = limite;
        return this;
    }

    public ConsultaBuilder comOffset(int offset) {
        if (offset < 0) {
            throw new IllegalArgumentException("O offset não pode ser negativo.");
        }

        this.offset = offset;
        return this;
    }

    public ConsultaBuilder comTimeout(int timeoutSegundos) {
        if (timeoutSegundos < 0) {
            throw new IllegalArgumentException(
                    "O timeout não pode ser negativo."
            );
        }

        this.timeoutSegundos = timeoutSegundos;
        return this;
    }

    public ConsultaBuilder somenteAtivos() {
        this.somenteAtivos = true;
        return this;
    }

    public String construir() {
        StringBuilder consulta = new StringBuilder();

        consulta.append("SELECT * FROM ").append(tabela);

        if (filtro != null && !filtro.isBlank()) {
            consulta.append(" WHERE ").append(filtro);
        }

        if (somenteAtivos) {
            if (filtro != null && !filtro.isBlank()) {
                consulta.append(" AND ativo = 1");
            } else {
                consulta.append(" WHERE ativo = 1");
            }
        }

        if (ordenacao != null && !ordenacao.isBlank()) {
            consulta.append(" ORDER BY ").append(ordenacao);
        }

        if (limite > 0) {
            consulta.append(" LIMIT ").append(limite);
        }

        if (offset > 0) {
            consulta.append(" OFFSET ").append(offset);
        }

        return consulta.toString();
    }

    public int getTimeoutSegundos() {
        return timeoutSegundos;
    }
}
