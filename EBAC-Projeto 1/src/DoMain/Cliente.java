package DoMain;


import java.util.Objects;

public class Cliente {




    private String nome ;
    private String ende;
    private String cidade;
    private String estado ;
    private Long cpf;
    private Long telefone;
    private Integer numero ;


            public Cliente (String nome, String ende, String cidade, String estado, String cpf, String telefone, String numero){

                this.nome =  nome;
                this.cpf =Long.valueOf(cpf.trim());
                this.ende = ende;
                this.cidade =  cidade;
                this.estado = estado;
                this.telefone =Long.valueOf(telefone.trim());
                this.numero = Integer.valueOf(numero.trim());

            }


    public String getNome() {
                return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEnde() {
        return ende;
    }

    public void setEnde(String ende) {
        this.ende = ende;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                '}';
    }
}