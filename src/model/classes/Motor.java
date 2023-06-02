package model.classes;

public class Motor {
    private int qtdPist = 0;
    private int potencia = 0;

    public Motor(int qtdPist, int potencia) {
        this.qtdPist = qtdPist;
        this.potencia = potencia;
    }

    public Motor() {

    }

    public int getQtdPist() {
        return qtdPist;
    }

    public void setQtdPist(int qtdPist) {
        this.qtdPist = qtdPist;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return   "\nPotencia do Motor := " + this.getPotencia() +
                "\nQtd Pistoes Motor := " + this.getQtdPist();
    }
}
