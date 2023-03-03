package br.unitins.topicos1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.event.internal.EntityState;

@Entity
public class Arsenal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    private String nomeArma;

    
    private String paisFabricacao;
    private String numeroSerie;
    private int anoFabricacao;
    public EntityState State;

    public String getNomeArma() {
        return nomeArma;
    }
    public void setNomeArma(String nomeArma) {
        this.nomeArma = nomeArma;
    }
    public String getPaisFabricacao() {
        return paisFabricacao;
    }
    public void setPaisFabricacao(String paisFabricacao) {
        this.paisFabricacao = paisFabricacao;
    }
    public String getNumeroSerie() {
        return numeroSerie;
    }
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
    public int getAnoFabricacao() {
        return anoFabricacao;
    }
    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

}
