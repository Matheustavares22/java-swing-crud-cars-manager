package model.gui.consulta;

import model.classes.Carga;
import model.classes.Passeio;
import model.classes.Veiculo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static model.Teste.bdVeiculos;
import static model.gui.menu.GestaoVeiculos.CARGA;

public class ConsultarExcluirPelaPlaca extends JFrame {
    public ConsultarExcluirPelaPlaca(String tipoDeVeiculo) {
        configuraJFrame();

        JLabel jLabelInformeAPlaca = new JLabel("Informe a Placa: ");
        jLabelInformeAPlaca.setForeground(Color.RED);

        JLabel jLabelTara = new JLabel("Tara: ");
        JLabel jLabelCargaMax = new JLabel("Carga Máx.: ");
        JLabel jLabelQuantidadePassageiros = new JLabel("Qtd. Passageiros: ");
        JLabel jLabelMarca = new JLabel("Marca: ");
        JLabel jLabelModelo = new JLabel("Modelo: ");
        JLabel jLabelCor = new JLabel("Cor: ");
        JLabel jLabelQtdRodas = new JLabel("Qtd. Rodas: ");
        JLabel jLabelVelocidadeMax = new JLabel("Velocidade Máx: ");
        JLabel jLabelQtdPistoes = new JLabel("Qtd.Pistões: ");
        JLabel jLabelPotencia = new JLabel("Potência: ");

        JTextField jTextInformeAPlaca = new JTextField();
        JTextField jTextTara = new JTextField();
        JTextField jTextCargaMax = new JTextField();
        JTextField jTextQuantidadePassageiros = new JTextField();
        JTextField jTextMarca = new JTextField();
        JTextField jTextModelo = new JTextField();
        JTextField jTextCor = new JTextField();
        JTextField jTextQtdRodas = new JTextField();
        JTextField jTextVelocidadeMax = new JTextField();
        JTextField jTextQtdPistoes = new JTextField();
        JTextField jTextPotencia = new JTextField();

        jTextTara.setEditable(false);
        jTextCargaMax.setEditable(false);
        jTextQuantidadePassageiros.setEditable(false);
        jTextMarca.setEditable(false);
        jTextModelo.setEditable(false);
        jTextCor.setEditable(false);
        jTextQtdRodas.setEditable(false);
        jTextVelocidadeMax.setEditable(false);
        jTextQtdPistoes.setEditable(false);
        jTextPotencia.setEditable(false);

        if (!tipoDeVeiculo.equals(CARGA)) {
            jLabelTara.setVisible(false);
            jTextTara.setVisible(false);
            jLabelCargaMax.setVisible(false);
            jTextCargaMax.setVisible(false);
        } else {
            jLabelQuantidadePassageiros.setVisible(false);
            jTextQuantidadePassageiros.setVisible(false);
        }

        JButton jButtonConsultar = new JButton("Consultar");
        jButtonConsultar.setBackground(Color.YELLOW);
        jButtonConsultar.setForeground(Color.RED);

        JButton jButtonExcluir = new JButton("Excluir");
        jButtonExcluir.setBackground(Color.YELLOW);
        jButtonExcluir.setForeground(Color.RED);

        JButton jButtonSair = new JButton("Sair");

        setLayout(new GridLayout(15, 1));

        add(jLabelInformeAPlaca);
        jTextInformeAPlaca.setForeground(Color.blue);
        add(jTextInformeAPlaca);

        add(jLabelQuantidadePassageiros);
        add(jTextQuantidadePassageiros);

        add(jLabelTara);
        add(jTextTara);

        add(jLabelCargaMax);
        add(jTextCargaMax);

        add(jLabelMarca);
        add(jTextMarca);

        add(jLabelModelo);
        add(jTextModelo);

        add(jLabelCor);
        add(jTextCor);

        add(jLabelQtdRodas);
        add(jTextQtdRodas);

        add(jLabelVelocidadeMax);
        add(jTextVelocidadeMax);

        add(jLabelQtdPistoes);
        add(jTextQtdPistoes);

        add(jLabelPotencia);
        add(jTextPotencia);

        add(jButtonConsultar, BorderLayout.PAGE_END);
        add(jButtonExcluir, BorderLayout.PAGE_END);
        add(jButtonSair, BorderLayout.PAGE_END);

        jButtonConsultar.addActionListener(e -> consultaPelaPlaca(tipoDeVeiculo, jTextInformeAPlaca, jTextTara, jTextCargaMax, jTextQuantidadePassageiros, jTextMarca, jTextModelo, jTextCor, jTextQtdRodas, jTextVelocidadeMax, jTextQtdPistoes, jTextPotencia));
        jButtonExcluir.addActionListener(e -> {
            excluirPelaPlaca(tipoDeVeiculo, jTextInformeAPlaca);
            limpaCampos(jTextInformeAPlaca, jTextTara, jTextCargaMax, jTextQuantidadePassageiros, jTextMarca, jTextModelo, jTextCor, jTextQtdRodas, jTextVelocidadeMax, jTextQtdPistoes, jTextPotencia);
        });
        jButtonSair.addActionListener(e -> dispose());
    }

    private static void limpaCampos(JTextField jTextInformeAPlaca, JTextField jTextTara, JTextField jTextCargaMax, JTextField jTextQuantidadePassageiros, JTextField jTextMarca, JTextField jTextModelo, JTextField jTextCor, JTextField jTextQtdRodas, JTextField jTextVelocidadeMax, JTextField jTextQtdPistoes, JTextField jTextPotencia) {
        jTextInformeAPlaca.setText("");
        jTextTara.setText("");
        jTextCargaMax.setText("");
        jTextQuantidadePassageiros.setText("");
        jTextMarca.setText("");
        jTextModelo.setText("");
        jTextCor.setText("");
        jTextQtdRodas.setText("");
        jTextVelocidadeMax.setText("");
        jTextQtdPistoes.setText("");
        jTextPotencia.setText("");
    }

    private static void consultaPelaPlaca(String tipoDeVeiculo, JTextField jTextInformeAPlaca, JTextField jTextTara, JTextField jTextCargaMax, JTextField jTextQuantidadePassageiros, JTextField jTextMarca, JTextField jTextModelo, JTextField jTextCor, JTextField jTextQtdRodas, JTextField jTextVelocidadeMax, JTextField jTextQtdPistoes, JTextField jTextPotencia) {
        Veiculo veiculoEncontrado = null;
        ArrayList<? extends Veiculo> listaVeiculos;

        if (tipoDeVeiculo.equals(CARGA)) {
            listaVeiculos = bdVeiculos.getListaCarga();
        } else {
            listaVeiculos = bdVeiculos.getListaPasseio();
        }

        String placaBuscada = jTextInformeAPlaca.getText();
        System.out.println(placaBuscada);

        for (Veiculo veiculo : listaVeiculos) {
            if (veiculo.getPlaca().equals(placaBuscada)) {
                veiculoEncontrado = veiculo;
                break;
            }
        }

        if (veiculoEncontrado != null) {
            if (veiculoEncontrado instanceof Carga) {
                Carga carga = (Carga) veiculoEncontrado;
                jTextTara.setText(String.valueOf(carga.getTara()));
                jTextCargaMax.setText(String.valueOf(carga.getCargaMax()));
            } else if (veiculoEncontrado instanceof Passeio) {
                Passeio passeio = (Passeio) veiculoEncontrado;
                jTextQuantidadePassageiros.setText(String.valueOf(passeio.getQtdPassageiros()));
            }

            jTextMarca.setText(veiculoEncontrado.getMarca());
            jTextModelo.setText(veiculoEncontrado.getModelo());
            jTextCor.setText(veiculoEncontrado.getCor());
            jTextQtdRodas.setText(String.valueOf(veiculoEncontrado.getQtdRodas()));
            jTextVelocidadeMax.setText(String.valueOf(veiculoEncontrado.getVelocMax()));
            jTextQtdPistoes.setText(String.valueOf(veiculoEncontrado.getMotor().getQtdPist()));
            jTextPotencia.setText(String.valueOf(veiculoEncontrado.getMotor().getPotencia()));
        } else {
            JOptionPane.showMessageDialog(null, "Veículo não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void excluirPelaPlaca(String tipoDeVeiculo, JTextField jTextInformeAPlaca) {
        String placaBuscada = jTextInformeAPlaca.getText();
        ArrayList<? extends Veiculo> listaVeiculos;

        if (tipoDeVeiculo.equals(CARGA)) {
            listaVeiculos = bdVeiculos.getListaCarga();
        } else {
            listaVeiculos = bdVeiculos.getListaPasseio();
        }

        Veiculo veiculoEncontrado = null;

        for (Veiculo veiculo : listaVeiculos) {
            if (veiculo.getPlaca().equals(placaBuscada)) {
                veiculoEncontrado = veiculo;
                break;
            }
        }

        if (veiculoEncontrado != null) {
            listaVeiculos.remove(veiculoEncontrado);
            JOptionPane.showMessageDialog(null, "Veículo excluído com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Veículo não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void configuraJFrame() {
        setTitle("Consutlar e Excluir pela Placa");
        setSize(500, 450);

        Icon iconInformation = UIManager.getIcon("OptionPane.informationIcon");
        setIconImage(((ImageIcon) iconInformation).getImage());

        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
    }

}
