package padroescomportamentais.observer;

import java.util.Observable;

public class Embarque extends Observable {

    private Integer ano;
    private Integer mes;
    private String paisOrigem;
    private String numeroConteiner;

    public Embarque(Integer ano, Integer mes, String paisOrigem, String numeroConteiner) {
        this.ano = ano;
        this.mes = mes;
        this.paisOrigem = paisOrigem;
        this.numeroConteiner = numeroConteiner;
    }

    public void liberarNaAlfandega() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Embarque{" +
                "ano=" + ano +
                ", mes=" + mes +
                ", paisOrigem='" + paisOrigem + '\'' +
                ", numeroConteiner='" + numeroConteiner + '\'' +
                '}';
    }
}
