package clinica.medico.view;

import clinica.dao.ConsultaDAO;
import clinica.login.SessaoMedico;
import clinica.model.Consulta;
import clinica.model.Medico;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.List;
public class ListarConsultasAgendadas extends javax.swing.JFrame {
    private List<Consulta> consultas;

    public ListarConsultasAgendadas() {
        initComponents();
        setLocationRelativeTo(null);
        configurarEventos(); // ← IMPORTANTE
        carregarConsultas();
        
    }

    private void configurarEventos() {
      
        btnFechar.addActionListener(e -> dispose());
       
        

    }

    private void carregarConsultas() {
        Medico medico = SessaoMedico.getMedicoLogado();

        if (medico == null) {
            JOptionPane.showMessageDialog(this, "Nenhum médico logado.");
            dispose();
            return;
        }

        ConsultaDAO dao = new ConsultaDAO();
        consultas = dao.buscarPorMedicoFuturas(medico.getId());

        DefaultTableModel modelo = (DefaultTableModel) tabelaConsultas.getModel();
        modelo.setRowCount(0); // limpa

        for (Consulta c : consultas) {
            modelo.addRow(new Object[]{
                c.getId(),
                c.getPaciente() != null ? c.getPaciente().getNomeCompleto() : "Paciente nulo",
                c.getData() != null ? c.getData().toString() : "",
                c.getHorario() != null ? c.getHorario().toString() : "",
                c.getTipo() != null ? c.getTipo() : ""
            });
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaConsultas = new javax.swing.JTable();
        btnAtender = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        btnAtender.setBackground(new java.awt.Color(255, 255, 254));
        btnAtender.setText("Atender ");
        btnAtender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAtender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtenderActionPerformed(evt);
            }
        });

        btnFechar.setBackground(new java.awt.Color(255, 255, 254));
        btnFechar.setText("Sair");
        btnFechar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(btnAtender, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtender)
                    .addComponent(btnFechar))
                .addGap(72, 72, 72))
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

        setSize(new java.awt.Dimension(800, 500));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
       dispose(); // TODO add your handling code here:
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnAtenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtenderActionPerformed
 int linha = tabelaConsultas.getSelectedRow();
        if (linha >= 0) {
            Consulta consultaSelecionada = consultas.get(linha);
            new AtenderConsulta(consultaSelecionada).setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma consulta para atender.");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnAtenderActionPerformed
public static void main(String[] args) {
    // Simula um médico logado para teste
    clinica.model.Medico medicoTeste = new clinica.model.Medico();
    medicoTeste.setId(6); // Substitua com um ID válido no seu banco
    medicoTeste.setNome("Dr. Teste");

    // Registra na sessão
    clinica.login.SessaoMedico.setMedicoLogado(medicoTeste);

    // Inicia a tela
    javax.swing.SwingUtilities.invokeLater(() -> {
        new ListarConsultasAgendadas().setVisible(true);
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtender;
    private javax.swing.JButton btnFechar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaConsultas;
    // End of variables declaration//GEN-END:variables
}
