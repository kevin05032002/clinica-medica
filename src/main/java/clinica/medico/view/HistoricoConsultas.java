package clinica.medico.view;

import clinica.dao.ConsultaDAO;
import clinica.model.Consulta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class HistoricoConsultas extends JFrame {

    private List<Consulta> consultas;
    private DefaultTableModel modeloTabela;
    public HistoricoConsultas() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());           
    }

    private void listarTodasConsultas() {
        ConsultaDAO dao = new ConsultaDAO();
        consultas = dao.buscarTodos(); // Este método já deve existir
        preencherTabela();
    }

    private void buscarConsultaPorNome() {
        String nome = txtNomePaciente.getText().trim();
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite o nome do paciente.");
            return;
        }

        ConsultaDAO dao = new ConsultaDAO();
        consultas = dao.buscarPorNomePaciente(nome);
        preencherTabela();
    }

   private void preencherTabela() {
    String[] colunas = {"ID", "Paciente", "Médico", "Data", "Hora", "Tipo", "Convênio"};
    modeloTabela = new DefaultTableModel(colunas, 0);
    tabelaConsultas.setModel(modeloTabela);

    if (consultas != null) {
        for (Consulta c : consultas) {
            modeloTabela.addRow(new Object[]{
                c.getId(),
                c.getPaciente().getNomeCompleto(),
                c.getMedico().getNome(),
                c.getData(),
                c.getHorario(),
                c.getTipo(),
                (c.getConvenio() != null ? c.getConvenio().getNomeEmpresa() : "Particular")
            });
        }
    }
}

    private void visualizarConsulta() {
        int linha = tabelaConsultas.getSelectedRow();
        if (linha >= 0) {
            Consulta selecionada = consultas.get(linha);
            JOptionPane.showMessageDialog(this,
                "Consulta ID: " + selecionada.getId() + "\n" +
                "Paciente: " + selecionada.getPaciente().getNomeCompleto() + "\n" +
                "Médico: " + selecionada.getMedico().getNome() + "\n" +
                "Data: " + selecionada.getData() + "\n" +
                "Horário: " + selecionada.getHorario() + "\n" +
                "Tipo: " + selecionada.getTipo() + "\n" +
                "Convênio: " + (selecionada.getConvenio() != null ? selecionada.getConvenio().getNomeEmpresa() : "Particular"),
                "Detalhes da Consulta", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma consulta para visualizar.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaConsultas = new javax.swing.JTable();
        txtNomePaciente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnVisualizar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnListarTodos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.SystemColor.textHighlight, null, java.awt.SystemColor.textHighlight));

        tabelaConsultas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaConsultas);

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

        btnListarTodos.setBackground(new java.awt.Color(255, 255, 254));
        btnListarTodos.setText("Listar Todos");
        btnListarTodos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnListarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnListarTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(394, 394, 394)
                .addComponent(btnVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(377, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnBuscar)
                    .addComponent(btnListarTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVisualizar)
                    .addComponent(btnSair))
                .addGap(116, 116, 116))
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

    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
 visualizarConsulta();       // TODO add your handling code here:
    }//GEN-LAST:event_btnVisualizarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
buscarConsultaPorNome();        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnListarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarTodosActionPerformed
      listarTodasConsultas();  // TODO add your handling code here:
    }//GEN-LAST:event_btnListarTodosActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSairActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HistoricoConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoricoConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoricoConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoricoConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistoricoConsultas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnListarTodos;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaConsultas;
    private javax.swing.JTextField txtNomePaciente;
    // End of variables declaration//GEN-END:variables
}
