package model.classes;

abstract public class Veiculo {
    private String placa = "";
    private String marca = "";
    private String modelo = "";
    private String cor = "";
    private float velocMax = 0;
    private int qtdRodas = 0;
    private Motor motor = new Motor();

    public Veiculo() {
    }

    public Veiculo(String placa, String marca, String modelo, String cor, float velocMax, int qtdRodas, Motor motor) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.velocMax = velocMax;
        this.qtdRodas = qtdRodas;
        this.motor = motor;
    }

    final public String getPlaca() {
        return placa;
    }

    final public void setPlaca(String placa) {
        this.placa = placa;
    }

    final public String getMarca() {
        return marca;
    }

    final public void setMarca(String marca) {
        this.marca = marca;
    }

    final public String getModelo() {
        return modelo;
    }

    final public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    final public String getCor() {
        return cor;
    }

    final public void setCor(String cor) {
        this.cor = cor;
    }

    final public float getVelocMax() {
        return velocMax;
    }

    final public void setVelocMax(float velocMax) {
        this.velocMax = velocMax;
    }

    final public int getQtdRodas() {
        return qtdRodas;
    }

    final public void setQtdRodas(int qtdRodas) {
        this.qtdRodas = qtdRodas;
    }

    final public Motor getMotor() {
        return motor;
    }

    final public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public abstract float calcVel();

    @Override
    public String toString() {
        return "Marca := " + this.getMarca() +
                "\nModelo := " + this.getModelo() +
                "\nCor := " + this.getCor() +
                "\nPlaca := " + this.getPlaca() +
                "\nQtdRodas := " + this.getQtdRodas() +
                "\nVelocidade Maxima (km/h) := " + this.getVelocMax() + " km/h";
    }
}
