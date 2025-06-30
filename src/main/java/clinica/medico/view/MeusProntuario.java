package clinica.medico.view;


import clinica.dao.ProntuarioDAO;
import clinica.model.Prontuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.List;

public class MeusProntuario extends JFrame {

    private int medicoId; // deve ser inicializado com o médico logado
    private ProntuarioDAO prontuarioDAO;

    public MeusProntuario(int medicoId) {
        this.medicoId = medicoId;
        prontuarioDAO = new ProntuarioDAO();
initComponents();
 String[] colunas = {"ID", "Consulta ID", "Queixa Principal", "Data Registro"};
    DefaultTableModel model = new DefaultTableModel(colunas, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    tabelaProntuarios.setModel(model);

    carregarProntuarios();

    btnVisualizar.addActionListener(e -> visualizarProntuario());
    btnSair.addActionListener(e -> sair());

        // initComponents é gerado pelo NetBeans, então não incluo aqui
        // initComponents();

        carregarProntuarios();

        btnVisualizar.addActionListener(e -> visualizarProntuario());
        btnSair.addActionListener(e -> sair());
    }

    private void carregarProntuarios() {
        try {
            List<Prontuario> lista = prontuarioDAO.buscarPorMedicoId(medicoId);

            DefaultTableModel model = (DefaultTableModel) tabelaProntuarios.getModel();
            model.setRowCount(0); // limpa tabela

            for (Prontuario p : lista) {
                model.addRow(new Object[]{
                    p.getId(),
                    p.getConsultaId(),
                    p.getQueixaPrincipal(),
                    p.getDataRegistro()
                });
            }

            lblTotalProntuarios.setText("Total de prontuários: " + lista.size());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar prontuários: " + ex.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void visualizarProntuario() {
        int linhaSelecionada = tabelaProntuarios.getSelectedRow();
        if (linhaSelecionada < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um prontuário para visualizar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int prontuarioId = (int) tabelaProntuarios.getValueAt(linhaSelecionada, 0);

        try {
            Prontuario prontuario = prontuarioDAO.buscarPorId(prontuarioId);
            if (prontuario != null) {
                // Aqui você pode abrir uma nova janela para mostrar os detalhes do prontuário
                // Exemplo simples só mostrando os dados num JOptionPane
                String mensagem = "Prontuário ID: " + prontuario.getId() + "\n" +
                        "Consulta ID: " + prontuario.getConsultaId() + "\n" +
                        "Queixa Principal: " + prontuario.getQueixaPrincipal() + "\n" +
                        "Histórico da Doença: " + prontuario.getHistoricoDoenca() + "\n" +
                        "Exame Físico: " + prontuario.getExameFisico() + "\n" +
                        "Diagnóstico: " + prontuario.getDiagnostico() + "\n" +
                        "Conduta: " + prontuario.getConduta() + "\n" +
                        "Data Registro: " + prontuario.getDataRegistro();

                JOptionPane.showMessageDialog(this, mensagem, "Detalhes do Prontuário", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this, "Prontuário não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar prontuário: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void sair() {
        this.dispose();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProntuarios = new javax.swing.JTable();
        btnVisualizar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        lblTotalProntuarios = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tabelaProntuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaProntuarios);

        btnVisualizar.setBackground(new java.awt.Color(255, 255, 254));
        btnVisualizar.setText("Visualizar");
        btnVisualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSair.setBackground(new java.awt.Color(255, 255, 254));
        btnSair.setText("Sair");
        btnSair.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblTotalProntuarios.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblTotalProntuarios.setText("Total de Prontuario");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnSair, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVisualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                    .addComponent(lblTotalProntuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(lblTotalProntuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnVisualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
      public static void main(String[] args) {
        // Simulando que o médico logado tem ID 1
        int medicoId = 6;

        javax.swing.SwingUtilities.invokeLater(() -> {
            MeusProntuario tela = new MeusProntuario(medicoId);
            tela.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);{
            tela.setVisible(true);
            }
        });
      }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotalProntuarios;
    private javax.swing.JTable tabelaProntuarios;
    // End of variables declaration//GEN-END:variables
}
