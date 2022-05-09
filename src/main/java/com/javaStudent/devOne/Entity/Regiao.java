package com.javaStudent.devOne.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Regiao {
    @Id
    @GeneratedValue //GeneratedValue - falar
    // que o campo mapeado será gerado automaticamente pelo BD
    @Column (nullable = false) // informação não pode ser nula
    private Long id;

    private String registro;
    private Long qtd_exames;

    public Regiao(String registro, Long qtd_exames) {
        this.registro = registro;
        this.qtd_exames = qtd_exames;
    }

    public Regiao(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public Long getQtd_exames() {
        return qtd_exames;
    }

    public void setQtd_exames(Long qtd_exames) {
        this.qtd_exames = qtd_exames;
    }
}
