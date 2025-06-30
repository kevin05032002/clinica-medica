package clinica.medico.view;

import clinica.dao.ProntuarioDAO;
import clinica.model.Prontuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

public class BuscarPorPaciente extends JFrame {

    private ProntuarioDAO prontuarioDAO;

    public BuscarPorPaciente() {
        prontuarioDAO = new ProntuarioDAO();
        initComponents();
        configurarTabela();

        // Ações dos botões
        btnBuscar.addActionListener(e -> buscarProntuarios());
        btnVisualizar.addActionListener(e -> visualizarProntuario());
        btnSair.addActionListener(e -> dispose());
    }

    private void configurarTabela() {
        String[] colunas = {"ID", "Paciente", "Consulta ID", "Queixa Principal", "Data Registro"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabelaProntuarios.setModel(model);
    }

    private void buscarProntuarios() {
        String nomePaciente = txtNomePaciente.getText().trim();
        if (nomePaciente.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o nome do paciente para buscar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            List<Prontuario> lista = prontuarioDAO.buscarPorNomePaciente(nomePaciente);

            DefaultTableModel model = (DefaultTableModel) tabelaProntuarios.getModel();
            model.setRowCount(0); // limpa tabela

            for (Prontuario p : lista) {
                model.addRow(new Object[]{
                    p.getId(),
                    p.getNomePaciente(), // novo campo
                    p.getConsultaId(),
                    p.getQueixaPrincipal(),
                    p.getDataRegistro()
                });
            }

            lblTotal.setText("Total de prontuários encontrados: " + lista.size());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar prontuários: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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
                String mensagem = "Paciente: " + prontuario.getNomePaciente() + "\n" +
                        "Prontuário ID: " + prontuario.getId() + "\n" +
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProntuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNomePaciente = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnVisualizar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();

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

        jLabel1.setText("Nome do Paciente");

        btnBuscar.setBackground(new java.awt.Color(255, 255, 254));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnVisualizar.setBackground(new java.awt.Color(255, 255, 254));
        btnVisualizar.setText("Visualizar");
        btnVisualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });

        btnSair.setBackground(new java.awt.Color(255, 255, 254));
        btnSair.setText("Sair");
        btnSair.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        lblTotal.setText("Total Prontuarios:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(242, 242, 242))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnVisualizar))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
          // TODO add your handling code here:
    }//GEN-LAST:event_btnVisualizarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSairActionPerformed

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BuscarPorPaciente tela = new BuscarPorPaciente();
            tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            tela.setLocationRelativeTo(null);
            tela.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tabelaProntuarios;
    private javax.swing.JTextField txtNomePaciente;
    // End of variables declaration//GEN-END:variables
}
