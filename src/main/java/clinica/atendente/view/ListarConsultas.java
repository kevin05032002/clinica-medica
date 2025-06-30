package clinica.atendente.view;

import clinica.dao.ConsultaDAO;
import clinica.model.Consulta;
import clinica.model.Paciente;
import clinica.model.Medico;
import clinica.model.Convenio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

public class ListarConsultas extends JFrame {

    private DefaultTableModel modeloTabela;
    
   public ListarConsultas() {
    initComponents();       // chama primeiro para garantir inicialização dos componentes
    setTitle("Listar Consultas");
    setSize(900, 600);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    configurarTabela();
    configurarEventos();
    carregarTodasConsultas();
}

    private void configurarTabela() {
        String[] colunas = {
                "ID", "Paciente", "Médico", "Data Consulta", "Hora",
                "Tipo", "Convênio", "Observações"
        };

        modeloTabela = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabelaConsultas.setModel(modeloTabela);
    }

    private void configurarEventos() {
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarPorData();
            }
        });

        btnListarTodos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                carregarTodasConsultas();
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editarConsulta();
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                excluirConsulta();
            }
        });

        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void carregarTodasConsultas() {
        try {
            ConsultaDAO dao = new ConsultaDAO();
            List<Consulta> consultas = dao.buscarTodos();
            preencherTabela(consultas);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar consultas: " + e.getMessage());
        }
    }

    private void buscarPorData() {
        String dataStr = txtDataFiltro.getText().trim();
        if (dataStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe uma data para buscar.");
            return;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            sdf.parse(dataStr);

            ConsultaDAO dao = new ConsultaDAO();
            List<Consulta> consultas = dao.buscarPorData(dataStr);
            preencherTabela(consultas);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Data inválida ou erro na busca: " + e.getMessage());
        }
    }

    private void preencherTabela(List<Consulta> consultas) {
        modeloTabela.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (Consulta c : consultas) {
            Paciente paciente = c.getPaciente();
            Medico medico = c.getMedico();
            Convenio convenio = c.getConvenio();

            modeloTabela.addRow(new Object[]{
                    c.getId(),
                    paciente != null ? paciente.getNomeCompleto() : "N/A",
                    medico != null ? medico.getNome() : "N/A",
                    c.getData() != null ? sdf.format(java.sql.Date.valueOf(c.getData())) : "",
                    c.getHorario(),
                    c.getTipo(),
                    convenio != null ? convenio.getNomeEmpresa() : "Particular",
                    c.getObservacoes()
            });
        }
    }

    private void editarConsulta() {
        int linha = tabelaConsultas.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma consulta para editar.");
            return;
        }

        int idConsulta = (int) modeloTabela.getValueAt(linha, 0);
        try {
            ConsultaDAO dao = new ConsultaDAO();
            Consulta consulta = dao.buscarPorId(idConsulta);
            if (consulta != null) {
                AgendarConsulta tela = new AgendarConsulta(consulta);
                tela.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Consulta não encontrada.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar consulta para edição: " + e.getMessage());
        }
    }

    private void excluirConsulta() {
        int linha = tabelaConsultas.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma consulta para excluir.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Confirma exclusão da consulta?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        int idConsulta = (int) modeloTabela.getValueAt(linha, 0);
        try {
            ConsultaDAO dao = new ConsultaDAO();
            dao.excluir(idConsulta);
            JOptionPane.showMessageDialog(this, "Consulta excluída com sucesso!");
            carregarTodasConsultas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao excluir consulta: " + e.getMessage());
        }
    }    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaConsultas = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnListarTodos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtDataFiltro = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tabelaConsultas.setBackground(java.awt.SystemColor.textHighlight);
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

        btnEditar.setBackground(new java.awt.Color(255, 255, 254));
        btnEditar.setText("Editar");

        btnExcluir.setBackground(new java.awt.Color(255, 255, 254));
        btnExcluir.setText("Excluir");

        btnSair.setBackground(new java.awt.Color(255, 255, 254));
        btnSair.setText("Sair");

        btnListarTodos.setBackground(new java.awt.Color(255, 255, 254));
        btnListarTodos.setText("Listar Todas");

        jLabel1.setText("Data da Consulta");

        btnBuscar.setBackground(new java.awt.Color(255, 255, 254));
        btnBuscar.setText("Buscar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDataFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnListarTodos)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListarTodos)
                    .addComponent(jLabel1)
                    .addComponent(txtDataFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSair)
                .addGap(22, 22, 22))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
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

        setSize(new java.awt.Dimension(1165, 500));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ListarConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarConsultas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnListarTodos;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaConsultas;
    private javax.swing.JTextField txtDataFiltro;
    // End of variables declaration//GEN-END:variables
}
