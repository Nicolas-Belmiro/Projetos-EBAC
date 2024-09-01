package main.java.dao;

/**
 * @author Nicolas
 * Classe que representa todas as entidades ou objetos da aplicação
 * que seram salvas no banco de dados
 */
public interface Persistente {
    //public Long getCodigo();

    Long getId();

    void setId(Long id);
}