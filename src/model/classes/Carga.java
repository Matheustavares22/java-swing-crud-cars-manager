package model.classes;

import model.classes.interfaces.Calcular;

final public class Carga extends Veiculo implements Calcular {
    private int cargaMax= 0;
    private int tara = 0;

    public Carga(int cargaMax, int tara) {
        this.cargaMax = cargaMax;
        this.tara = tara;
    }

    public Carga() {
    }

    public int getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    public int getTara() {
        return tara;
    }

    public void setTara(int tara) {
        this.tara = tara;
    }

    @Override
    public float calcVel() {
        return super.getVelocMax() * 100000;
    }

    @Override
    public int calcular() {
        return (int)
            this.getVelocMax() +
            this.getQtdRodas() +
            this.getMotor().getQtdPist() +
            this.getMotor().getPotencia() +
            this.getCargaMax() +
            this.getTara();
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nVelocidade Maxima (Cm/h) := " + this.calcVel() + " Cm/h" +
                "\nCarga máxima := " + this.getCargaMax()+
                "\nTara := " + this.getTara() +
                this.getMotor().toString() +
                "\nValor calculado Interface := " + this.calcular();

    }
}
