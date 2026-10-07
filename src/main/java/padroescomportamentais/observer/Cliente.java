package padroescomportamentais.observer;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void acompanhar(Embarque embarque) {
        embarque.addObserver(this);
    }

    public void deixarDeAcompanhar(Embarque embarque) {
        embarque.deleteObserver(this);
    }

    public void update(Observable embarque, Object arg1) {
        this.ultimaNotificacao = this.nome + ", carga liberada na alfândega no " + embarque.toString();
    }
}
