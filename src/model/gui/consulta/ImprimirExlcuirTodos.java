package model.gui.consulta;
import model.classes.Carga;
import model.classes.Passeio;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

import static model.Teste.bdVeiculos;
import static model.gui.menu.GestaoVeiculos.PASSEIO;

public class ImprimirExlcuirTodos extends JFrame {
    public ImprimirExlcuirTodos(String tipoDeVeiculo) {
        String[] tableHeaderPasseio = {"Placa", "Marca", "Modelo", "Cor", "Qtd. Rodas", "Velocidade Max.", "Qtd. Pistoes", "Potencia", "Qtd. de Passageiros"};
        String[] tableHeaderCarga = {"Placa", "Marca", "Modelo", "Cor", "QtdRodas", "VelocidadeMax", "QtdPistoes", "Potencia", "Tara", "CargaMax"};

        configuraJframe();

        DefaultTableModel tableModel = getDefaultTableModel(tipoDeVeiculo, tableHeaderPasseio, tableHeaderCarga);

        configuraBotoes(tipoDeVeiculo, tableHeaderPasseio, tableHeaderCarga, tableModel);
    }

    private void configuraBotoes(String tipoDeVeiculo, String[] tableHeaderPasseio, String[] tableHeaderCarga, DefaultTableModel tableModel) {
        JButton jButtonImprimirTodos = new JButton("Imprimir todos");
        jButtonImprimirTodos.setBackground(Color.YELLOW);
        jButtonImprimirTodos.setForeground(Color.RED);

        JButton jButtonExcluirTodos = new JButton("Excluir todos");
        jButtonExcluirTodos.setBackground(Color.YELLOW);
        jButtonExcluirTodos.setForeground(Color.RED);

        JButton jButtonSair = new JButton("Sair");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(jButtonImprimirTodos);
        buttonPanel.add(jButtonExcluirTodos);
        buttonPanel.add(jButtonSair);
        add(buttonPanel, BorderLayout.SOUTH);

        jButtonImprimirTodos.addActionListener(e -> adicionaDadosATabela(tipoDeVeiculo, tableHeaderPasseio, tableHeaderCarga, tableModel));
        jButtonExcluirTodos.addActionListener(e -> excluirEImprimir(tipoDeVeiculo, tableHeaderPasseio, tableHeaderCarga, tableModel));
        jButtonSair.addActionListener(e -> dispose());
    }

    private DefaultTableModel getDefaultTableModel(String tipoDeVeiculo, String[] tableHeaderPasseio, String[] tableHeaderCarga) {
        String[][] data = new String[0][];
        String[] headers = tipoDeVeiculo.equals(PASSEIO) ? tableHeaderPasseio : tableHeaderCarga;

        DefaultTableModel tableModel = new DefaultTableModel(data, headers);
        JTable jTableVeiculos = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(jTableVeiculos);
        add(scrollPane, BorderLayout.CENTER);
        return tableModel;
    }

    private void excluirEImprimir(String tipoDeVeiculo, String[] tableHeaderPasseio, String[] tableHeaderCarga, DefaultTableModel tableModel) {
        bdVeiculos.removerTodosVeiculos(tipoDeVeiculo);
        tableModel.setRowCount(0);
        adicionaDadosATabela(tipoDeVeiculo, tableHeaderPasseio, tableHeaderCarga, tableModel);
    }

    private void configuraJframe() {
        setTitle("Imprimir / Excluir todos");
        setSize(1200, 500);

        Icon iconInformation = UIManager.getIcon("OptionPane.informationIcon");
        setIconImage(((ImageIcon) iconInformation).getImage());

        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    private static void adicionaDadosATabela(String tipoDeVeiculo, String[] tableHeaderPasseio, String[] tableHeaderCarga, DefaultTableModel tableModel) {
        String[][] data;
        if (tipoDeVeiculo.equals(PASSEIO)) {
            ArrayList<Passeio> listaPasseio = bdVeiculos.getListaPasseio();
            data = new String[listaPasseio.size()][tableHeaderPasseio.length];
            for (int i = 0; i < listaPasseio.size(); i++) {
                Passeio passeio = listaPasseio.get(i);
                data[i] = new String[]{
                        passeio.getPlaca(),
                        passeio.getMarca(),
                        passeio.getModelo(),
                        passeio.getCor(),
                        String.valueOf(passeio.getQtdRodas()),
                        String.valueOf(passeio.getVelocMax()),
                        String.valueOf(passeio.getMotor().getQtdPist()),
                        String.valueOf(passeio.getMotor().getPotencia()),
                        String.valueOf(passeio.getQtdPassageiros())
                };
            }
        } else {
            ArrayList<Carga> listaCarga = bdVeiculos.getListaCarga();
            data = new String[listaCarga.size()][tableHeaderCarga.length];
            for (int i = 0; i < listaCarga.size(); i++) {
                Carga carga = listaCarga.get(i);
                data[i] = new String[]{
                        carga.getPlaca(),
                        carga.getMarca(),
                        carga.getModelo(),
                        carga.getCor(),
                        String.valueOf(carga.getQtdRodas()),
                        String.valueOf(carga.getVelocMax()),
                        String.valueOf(carga.getMotor().getQtdPist()),
                        String.valueOf(carga.getMotor().getPotencia()),
                        String.valueOf(carga.getTara()),
                        String.valueOf(carga.getCargaMax())
                };
            }
        }

        for (String[] row : data) {
            tableModel.addRow(row);
        }
    }
}
