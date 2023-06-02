package model.gui.cadastro;

import model.classes.Carga;
import model.classes.Passeio;
import model.classes.Veiculo;
import model.exceptions.VeicExistException;
import model.exceptions.VelocException;

import javax.swing.*;
import java.awt.*;

import static model.Teste.bdVeiculos;
import static model.gui.menu.GestaoVeiculos.CARGA;
import static model.gui.menu.GestaoVeiculos.PASSEIO;

public class CadastroVeiculos extends JFrame {

    public CadastroVeiculos(String tipoDeVeiculo) {
        configuraJFrame(tipoDeVeiculo);

        JLabel jLabelTara = new JLabel("Tara: ");
        JLabel jLabelCargaMax = new JLabel("Carga Máx.: ");
        JLabel jLabelQuantidadePassageiros = new JLabel("Qtd. Passageiros: ");
        JLabel jLabelPlaca = new JLabel("Placa: ");
        JLabel jLabelMarca = new JLabel("Marca: ");
        JLabel jLabelModelo = new JLabel("Modelo: ");
        JLabel jLabelCor = new JLabel("Cor: ");
        JLabel jLabelQtdRodas = new JLabel("Qtd. Rodas: ");
        JLabel jLabelVelocidadeMax = new JLabel("Velocidade Máx: ");
        JLabel jLabelQtdPistoes = new JLabel("Qtd.Pistões: ");
        JLabel jLabelPotencia = new JLabel("Potência: ");

        JTextField jTextTara = new JTextField();
        JTextField jTextCargaMax = new JTextField();
        JTextField jTextQuantidadePassageiros = new JTextField();
        JTextField jTextPlaca = new JTextField();
        JTextField jTextMarca = new JTextField();
        JTextField jTextModelo = new JTextField();
        JTextField jTextCor = new JTextField();
        JTextField jTextQtdRodas = new JTextField();
        JTextField jTextVelocidadeMax = new JTextField();
        JTextField jTextQtdPistoes = new JTextField();
        JTextField jTextPotencia = new JTextField();

        JButton jButtonCadastrar = new JButton("Cadastrar");
        JButton jButtonLimpar = new JButton("Limpar");
        JButton jButtonNovo = new JButton("Novo");
        JButton jButtonSair = new JButton("Sair");

        setLayout(new GridLayout(15, 1));

        adicionaComponentesAUI(jLabelTara, jLabelCargaMax, jLabelQuantidadePassageiros, jLabelPlaca, jLabelMarca, jLabelModelo, jLabelCor, jLabelQtdRodas, jLabelVelocidadeMax, jLabelQtdPistoes, jLabelPotencia, jTextTara, jTextCargaMax, jTextQuantidadePassageiros, jTextPlaca, jTextMarca, jTextModelo, jTextCor, jTextQtdRodas, jTextVelocidadeMax, jTextQtdPistoes, jTextPotencia);

        if (!tipoDeVeiculo.equals(CARGA)) {
            jLabelTara.setVisible(false);
            jTextTara.setVisible(false);
            jLabelCargaMax.setVisible(false);
            jTextCargaMax.setVisible(false);
        } else {
            jLabelQuantidadePassageiros.setVisible(false);
            jTextQuantidadePassageiros.setVisible(false);
        }

        add(jButtonCadastrar, BorderLayout.PAGE_END);
        add(jButtonLimpar, BorderLayout.PAGE_END);
        add(jButtonNovo, BorderLayout.PAGE_END);
        add(jButtonSair, BorderLayout.PAGE_END);

        jButtonCadastrar.addActionListener(e -> cadastraVeiculo(tipoDeVeiculo, jTextTara, jTextCargaMax, jTextQuantidadePassageiros, jTextPlaca, jTextMarca, jTextModelo, jTextCor, jTextQtdRodas, jTextVelocidadeMax, jTextQtdPistoes, jTextPotencia));
        jButtonLimpar.addActionListener(e -> limpaCampos(jTextTara, jTextCargaMax, jTextQuantidadePassageiros, jTextPlaca, jTextMarca, jTextModelo, jTextCor, jTextQtdRodas, jTextVelocidadeMax, jTextQtdPistoes, jTextPotencia));
        jButtonNovo.addActionListener(e -> limpaCampos(jTextTara, jTextCargaMax, jTextQuantidadePassageiros, jTextPlaca, jTextMarca, jTextModelo, jTextCor, jTextQtdRodas, jTextVelocidadeMax, jTextQtdPistoes, jTextPotencia));
        jButtonSair.addActionListener(e -> dispose());
    }

    private void adicionaComponentesAUI(JLabel jLabelTara, JLabel jLabelCargaMax, JLabel jLabelQuantidadePassageiros, JLabel jLabelPlaca, JLabel jLabelMarca, JLabel jLabelModelo, JLabel jLabelCor, JLabel jLabelQtdRodas, JLabel jLabelVelocidadeMax, JLabel jLabelQtdPistoes, JLabel jLabelPotencia, JTextField jTextTara, JTextField jTextCargaMax, JTextField jTextQuantidadePassageiros, JTextField jTextPlaca, JTextField jTextMarca, JTextField jTextModelo, JTextField jTextCor, JTextField jTextQtdRodas, JTextField jTextVelocidadeMax, JTextField jTextQtdPistoes, JTextField jTextPotencia) {
        add(jLabelPlaca);
        add(jTextPlaca);

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

        add(jLabelQuantidadePassageiros);
        add(jTextQuantidadePassageiros);

        add(jLabelTara);
        add(jTextTara);

        add(jLabelCargaMax);
        add(jTextCargaMax);
    }

    private static void limpaCampos(JTextField jTextTara, JTextField jTextCargaMax, JTextField jTextQuantidadePassageiros, JTextField jTextPlaca, JTextField jTextMarca, JTextField jTextModelo, JTextField jTextCor, JTextField jTextQtdRodas, JTextField jTextVelocidadeMax, JTextField jTextQtdPistoes, JTextField jTextPotencia) {
        jTextTara.setText("");
        jTextCargaMax.setText("");
        jTextQuantidadePassageiros.setText("");
        jTextPlaca.setText("");
        jTextMarca.setText("");
        jTextModelo.setText("");
        jTextCor.setText("");
        jTextQtdRodas.setText("");
        jTextVelocidadeMax.setText("");
        jTextQtdPistoes.setText("");
        jTextPotencia.setText("");
    }

    private void configuraJFrame(String tipoDeVeiculo) {
        setTitle("Cadastro de Veiculos de " + tipoDeVeiculo);
        setSize(350, 400);

        Icon iconInformation = UIManager.getIcon("OptionPane.informationIcon");
        setIconImage(((ImageIcon) iconInformation).getImage());

        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
    }
    private static boolean camposVazios(String tipoDeVeiculo, JTextField jTextTara, JTextField jTextCargaMax, JTextField jTextQuantidadePassageiros, JTextField jTextPlaca, JTextField jTextMarca, JTextField jTextModelo, JTextField jTextCor, JTextField jTextQtdRodas, JTextField jTextVelocidadeMax, JTextField jTextQtdPistoes, JTextField jTextPotencia) {
        if (tipoDeVeiculo.equals(CARGA)) {
            if (jTextTara.getText().isEmpty() || jTextCargaMax.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Existem campos vazios", "Erro", JOptionPane.ERROR_MESSAGE);
                return true;
            }
        } else if (tipoDeVeiculo.equals(PASSEIO)) {
            if (jTextQuantidadePassageiros.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Existem campos vazios", "Erro", JOptionPane.ERROR_MESSAGE);
                return true;
            }
        }

        if (jTextPlaca.getText().isEmpty() ||
                jTextMarca.getText().isEmpty() ||
                jTextModelo.getText().isEmpty() ||
                jTextCor.getText().isEmpty() ||
                jTextQtdRodas.getText().isEmpty() ||
                jTextVelocidadeMax.getText().isEmpty() ||
                jTextQtdPistoes.getText().isEmpty() ||
                jTextPotencia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Existem campos vazios", "Erro", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        //campos preenchidos
        return false;
    }
    private static void cadastraVeiculo(String tipoDeVeiculo, JTextField jTextTara, JTextField jTextCargaMax, JTextField jTextQuantidadePassageiros, JTextField jTextPlaca, JTextField jTextMarca, JTextField jTextModelo, JTextField jTextCor, JTextField jTextQtdRodas, JTextField jTextVelocidadeMax, JTextField jTextQtdPistoes, JTextField jTextPotencia) {
        if(camposVazios(tipoDeVeiculo, jTextTara, jTextCargaMax, jTextQuantidadePassageiros, jTextPlaca, jTextMarca, jTextModelo, jTextCor, jTextQtdRodas, jTextVelocidadeMax, jTextQtdPistoes, jTextPotencia)) return;
        Veiculo veiculo;

        if (verificaVeiculoExiste(jTextPlaca.getText(), tipoDeVeiculo)) return;

        if (tipoDeVeiculo.equals(CARGA)) {
            veiculo = new Carga();
            Carga carga = (Carga) veiculo;
            carga.setCargaMax(Integer.parseInt(jTextCargaMax.getText()));
            carga.setTara(Integer.parseInt(jTextTara.getText()));
        } else {
            veiculo = new Passeio();
            Passeio passeio = (Passeio) veiculo;
            passeio.setQtdPassageiros(Integer.parseInt(jTextQuantidadePassageiros.getText()));
        }

        veiculo.setPlaca(jTextPlaca.getText());
        veiculo.setMarca(jTextMarca.getText());
        veiculo.setModelo(jTextModelo.getText());
        veiculo.setCor(jTextCor.getText());
        veiculo.setQtdRodas(Integer.parseInt(jTextQtdRodas.getText()));

        int velocidadeMax = Integer.parseInt(jTextVelocidadeMax.getText());
        try {
            if (velocidadeMax < 80 || velocidadeMax > 110) {
                throw new VelocException("A velocidade máxima está fora dos limites brasileiros");
            }
            veiculo.setVelocMax(velocidadeMax);
        } catch (Exception e) {
            veiculo.setVelocMax(tipoDeVeiculo.equals(CARGA) ? 90 : 100);
        }

        veiculo.getMotor().setPotencia(Integer.parseInt(jTextPotencia.getText()));
        veiculo.getMotor().setQtdPist(Integer.parseInt(jTextQtdPistoes.getText()));

        if (tipoDeVeiculo.equals(CARGA)) {
            bdVeiculos.setListaCarga(((Carga) veiculo));
        } else {
            bdVeiculos.setListaPasseio((Passeio) veiculo);
        }
        limpaCampos(jTextTara, jTextCargaMax, jTextQuantidadePassageiros, jTextPlaca, jTextMarca, jTextModelo, jTextCor, jTextQtdRodas, jTextVelocidadeMax, jTextQtdPistoes, jTextPotencia);
        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Êxito", JOptionPane.INFORMATION_MESSAGE);
    }


    private static boolean verificaVeiculoExiste(String placa, String tipoDeVeiculo) {
        try {
            if (bdVeiculos.getListaCarga().stream()
                    .anyMatch(item -> item.getPlaca().equals(placa))) {
                throw new VeicExistException("Já existe um veículo (" + tipoDeVeiculo + ") com esta placa");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
            return true;
        }

        try {
            if (bdVeiculos.getListaPasseio().stream()
                    .anyMatch(item -> item.getPlaca().equals(placa))) {
                throw new VeicExistException("Já existe um veículo (" + tipoDeVeiculo + ") com esta placa");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }
}

