package model.repository;

import model.classes.Carga;
import model.classes.Passeio;

import java.util.ArrayList;
import java.util.List;

import static model.gui.menu.GestaoVeiculos.PASSEIO;

public class BDVeiculos {
    private final List<Passeio> listaPasseio = new ArrayList<>(5);
    private final List<Carga> listaCarga = new ArrayList<>(5);

    public BDVeiculos() {
    }

    public ArrayList<Passeio> getListaPasseio() {
        return (ArrayList<Passeio>) listaPasseio;
    }

    public void setListaPasseio(Passeio passeio) {
        this.listaPasseio.add(passeio);
    }

    public ArrayList<Carga> getListaCarga() {
        return (ArrayList<Carga>) listaCarga;
    }

    public void setListaCarga(Carga carga) {
        this.listaCarga.add(carga);
    }

    public void removerTodosVeiculos(String tipoDeVeiculo){
        if(tipoDeVeiculo.equals(PASSEIO)){
            listaPasseio.clear();
        } else {
            listaCarga.clear();
        }
    }


    public void removerVeiculo(String placa, String tipoDeVeiculo) {
        if ("CARGA".equalsIgnoreCase(tipoDeVeiculo)) {
            listaCarga.removeIf(v -> v.getPlaca().equals(placa));
        } else {
            listaPasseio.removeIf(v -> v.getPlaca().equals(placa));
        }
    }
}
