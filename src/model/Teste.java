package model;

import model.classes.Carga;
import model.classes.Passeio;
import model.classes.Veiculo;
import model.gui.menu.GestaoVeiculos;
import model.repository.BDVeiculos;

import java.util.List;


@SuppressWarnings("SpellCheckingInspection")
public class Teste {

    public static BDVeiculos bdVeiculos = new BDVeiculos();

    public static void main(String[] args) {
        cadastraVeiculosDaBaseInicial();
        GestaoVeiculos telaInicial = new GestaoVeiculos();
    }
    private static void cadastraVeiculosDaBaseInicial() {
        Passeio onix = new Passeio();
        Passeio fox = new Passeio();
        Passeio corsa = new Passeio();
        Passeio huracan = new Passeio();
        Passeio sonic = new Passeio();
        Carga CaminhaoVolvo = new Carga();
        Carga CaminhaoMercedes = new Carga();
        Carga CaminhaoFord = new Carga();
        Carga CaminhaoVolkswagen = new Carga();
        Carga CaminhaoMAN = new Carga();

        onix.setCor("Preto");
        onix.setModelo("Onix");
        onix.setVelocMax(167);
        onix.setPlaca("ggf2314");
        onix.setMarca("Chevrolet");
        onix.setQtdRodas(4);
        onix.setQtdPassageiros(5);
        onix.getMotor().setPotencia(80);
        onix.getMotor().setQtdPist(4);


        fox.setCor("Prata");
        fox.setModelo("Fox");
        fox.setVelocMax(198);
        fox.setPlaca("fgk2134");
        fox.setMarca("Volkswagen");
        fox.setQtdRodas(4);
        fox.setQtdPassageiros(5);
        fox.getMotor().setPotencia(100);
        fox.getMotor().setQtdPist(4);

        corsa.setCor("Verde");
        corsa.setModelo("Corsa");
        corsa.setVelocMax(150);
        corsa.setPlaca("gyj5613");
        corsa.setMarca("Chevrolet");
        corsa.setQtdRodas(4);
        corsa.setQtdPassageiros(5);
        corsa.getMotor().setPotencia(75);
        corsa.getMotor().setQtdPist(4);

        huracan.setCor("Azul italy");
        huracan.setModelo("huracan");
        huracan.setVelocMax(378);
        huracan.setPlaca("hjj2345");
        huracan.setMarca("Lamborghini");
        huracan.setQtdRodas(4);
        huracan.setQtdPassageiros(2);
        huracan.getMotor().setPotencia(800);
        huracan.getMotor().setQtdPist(12);

        sonic.setCor("Vermelho");
        sonic.setModelo("sonic");
        sonic.setVelocMax(140);
        sonic.setPlaca("hjk2135");
        sonic.setMarca("Chevrolet");
        sonic.setQtdRodas(4);
        sonic.setQtdPassageiros(5);
        sonic.getMotor().setPotencia(123);
        sonic.getMotor().setQtdPist(4);
        //carga---------------------------------------------------------------------------------------------------------
        CaminhaoMercedes.setCor("Amarelo");
        CaminhaoMercedes.setModelo("Caminhao Mercedes");
        CaminhaoMercedes.setVelocMax(135);
        CaminhaoMercedes.setPlaca("huj2645");
        CaminhaoMercedes.setMarca("Mercedes");
        CaminhaoMercedes.setQtdRodas(10);
        CaminhaoMercedes.setTara(12);
        CaminhaoMercedes.setCargaMax(23);
        CaminhaoMercedes.getMotor().setPotencia(560);
        CaminhaoMercedes.getMotor().setQtdPist(8);

        CaminhaoVolvo.setCor("Cinza");
        CaminhaoVolvo.setModelo("Caminhao Volvo");
        CaminhaoVolvo.setVelocMax(140);
        CaminhaoVolvo.setPlaca("yzk2245");
        CaminhaoVolvo.setMarca("Volvo");
        CaminhaoVolvo.setQtdRodas(10);
        CaminhaoVolvo.setTara(17);
        CaminhaoVolvo.setCargaMax(28);
        CaminhaoVolvo.getMotor().setPotencia(700);
        CaminhaoVolvo.getMotor().setQtdPist(8);

        CaminhaoFord.setCor("Vermelho");
        CaminhaoFord.setModelo("Caminhao Ford");
        CaminhaoFord.setVelocMax(120);
        CaminhaoFord.setPlaca("zjk1135");
        CaminhaoFord.setMarca("Ford");
        CaminhaoFord.setQtdRodas(10);
        CaminhaoFord.setTara(15);
        CaminhaoFord.setCargaMax(25);
        CaminhaoFord.getMotor().setPotencia(450);
        CaminhaoFord.getMotor().setQtdPist(6);

        CaminhaoVolkswagen.setCor("branco");
        CaminhaoVolkswagen.setModelo("Caminhao Volkswagen");
        CaminhaoVolkswagen.setVelocMax(120);
        CaminhaoVolkswagen.setPlaca("lka2275");
        CaminhaoVolkswagen.setMarca("Volkswagen");
        CaminhaoVolkswagen.setQtdRodas(10);
        CaminhaoVolkswagen.setTara(12);
        CaminhaoVolkswagen.setCargaMax(15);
        CaminhaoVolkswagen.getMotor().setPotencia(520);
        CaminhaoVolkswagen.getMotor().setQtdPist(8);

        CaminhaoMAN.setCor("laranja");
        CaminhaoMAN.setModelo("Caminhao MAN");
        CaminhaoMAN.setVelocMax(140);
        CaminhaoMAN.setPlaca("ahz2365");
        CaminhaoMAN.setMarca("MAN");
        CaminhaoMAN.setQtdRodas(10);
        CaminhaoMAN.setTara(34);
        CaminhaoMAN.setCargaMax(40);
        CaminhaoMAN.getMotor().setPotencia(1000);
        CaminhaoMAN.getMotor().setQtdPist(10);

        bdVeiculos.setListaPasseio(onix);
        bdVeiculos.setListaPasseio(fox);
        bdVeiculos.setListaPasseio(huracan);
        bdVeiculos.setListaPasseio(corsa);
        bdVeiculos.setListaPasseio(sonic);

        bdVeiculos.setListaCarga(CaminhaoVolvo);
        bdVeiculos.setListaCarga(CaminhaoMercedes);
        bdVeiculos.setListaCarga(CaminhaoFord);
        bdVeiculos.setListaCarga(CaminhaoVolkswagen);
        bdVeiculos.setListaCarga(CaminhaoMAN);
    }

}