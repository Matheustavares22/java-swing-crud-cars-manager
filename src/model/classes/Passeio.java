package model.classes;

import model.classes.interfaces.Calcular;

final public class Passeio extends Veiculo implements Calcular {
    private int qtdPassageiros = 0;

    public Passeio() {
    }

    public Passeio(int qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }

    final public void setQtdPassageiros(int qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }

    public int getQtdPassageiros() {
        return qtdPassageiros;
    }

    @Override
    final public float calcVel() {
        return super.getVelocMax() * 1000;
    }

    @Override
    public int calcular() {
        return calculateLength(this.getPlaca())
                + calculateLength(this.getMarca())
                + calculateLength(this.getModelo())
                + calculateLength(this.getCor());
    }

    private int calculateLength(String string) {
        return string.length();
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nVelocidade Maxima (m/h) := " + this.calcVel() + " m/h" +
                "\nQtd Passageiros := " + this.getQtdPassageiros() +
                this.getMotor().toString() +
                "\nValor calculado Interface := " + this.calcular();
    }
}
