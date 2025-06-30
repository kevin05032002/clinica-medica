package clinica.atendente.view;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import clinica.dao.PacienteDAO;
import clinica.model.Paciente;

public class CadastrarPaciente extends javax.swing.JFrame {

    private Paciente pacienteEdicao = null;

    // Construtor para cadastro novo
    public CadastrarPaciente() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Cadastro de Paciente");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        carregarEstados();
    }

    // Construtor para edição - recebe o paciente a ser editado
    public CadastrarPaciente(Paciente paciente) {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Edição de Paciente");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pacienteEdicao = paciente;
        carregarEstados();
        preencherCampos(paciente);
    }

    private void carregarEstados() {
        comboEstado.removeAllItems();
        String[] estados = {
            "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO",
            "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI",
            "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"
        };
        for (String estado : estados) {
            comboEstado.addItem(estado);
        }
    }

    private void preencherCampos(Paciente p) {
        txtNomeCompleto.setText(p.getNomeCompleto());
        txtRg.setText(p.getRg());
        txtCpf.setText(p.getCpf());
        txtDataNascimento.setText(p.getDataNascimento());
        txtTelefone.setText(p.getTelefone());
        txtEmail.setText(p.getEmail());
        txtRua.setText(p.getRua());
        txtNumero.setText(p.getNumero());
        txtComplemento.setText(p.getComplemento());
        txtBairro.setText(p.getBairro());
        txtCidade.setText(p.getCidade());
        comboEstado.setSelectedItem(p.getEstado());
        txtCep.setText(p.getCep());
    }

    private Paciente obterDadosFormulario() {
        Paciente p = new Paciente();
        if (pacienteEdicao != null) {
            p.setId(pacienteEdicao.getId());
        }
        p.setNomeCompleto(txtNomeCompleto.getText());
        p.setRg(txtRg.getText());
        p.setCpf(txtCpf.getText());
        p.setDataNascimento(txtDataNascimento.getText());
        p.setTelefone(txtTelefone.getText());
        p.setEmail(txtEmail.getText());
        p.setRua(txtRua.getText());
        p.setNumero(txtNumero.getText());
        p.setComplemento(txtComplemento.getText());
        p.setBairro(txtBairro.getText());
        p.setCidade(txtCidade.getText());
        p.setEstado(comboEstado.getSelectedItem().toString());
        p.setCep(txtCep.getText());
        return p;
    }
    private void limparCampos() {
        txtNomeCompleto.setText("");
        txtRg.setText("");
        txtCpf.setText("");
        txtDataNascimento.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
        txtRua.setText("");
        txtNumero.setText("");
        txtComplemento.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        comboEstado.setSelectedIndex(0);
        txtCep.setText("");
    }

   
 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNomeCompleto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRg = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        txtDataNascimento = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtCep = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        txtRua = new javax.swing.JTextField();
        txtComplemento = new javax.swing.JTextField();
        comboEstado = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 650));

        jLabel1.setText("Nome Completo");

        jLabel2.setText("Rg");

        txtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidadeActionPerformed(evt);
            }
        });

        comboEstado.setBackground(new java.awt.Color(255, 255, 254));
        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Cpf");

        jLabel4.setText("Data Nascimento");

        jLabel5.setText("Telefone");

        jLabel6.setText("Email");

        jLabel7.setText("Estado");

        jLabel8.setText("Cidade");

        jLabel9.setText("Bairro");

        jLabel10.setText("Numero");

        jLabel11.setText("Rua");

        jLabel12.setText("Complemento");

        jLabel13.setText("Cep");

        btnSalvar.setBackground(new java.awt.Color(255, 255, 254));
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnLimpar.setBackground(new java.awt.Color(255, 255, 254));
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 255, 254));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 292, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLimpar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(153, 153, 153)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnLimpar)
                    .addComponent(btnCancelar))
                .addGap(67, 67, 67))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 901, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(731, 650));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidadeActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
   if (txtNomeCompleto.getText().trim().isEmpty() ||
        txtCpf.getText().trim().isEmpty() ||
        txtDataNascimento.getText().trim().isEmpty()) {
        
        JOptionPane.showMessageDialog(this, 
            "Por favor, preencha todos os campos obrigatórios:\n- Nome completo\n- CPF\n- Data de nascimento", 
            "Campos obrigatórios", JOptionPane.WARNING_MESSAGE);
        return;
    }
        try {
            String dataTexto = txtDataNascimento.getText();

            // Validação da data
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            sdf.parse(dataTexto); // lança ParseException se for inválida

            Paciente paciente = new Paciente();
            paciente.setNomeCompleto(txtNomeCompleto.getText());
            paciente.setRg(txtRg.getText());
            paciente.setCpf(txtCpf.getText());
            paciente.setDataNascimento(dataTexto); // salvar como String válida
            paciente.setTelefone(txtTelefone.getText());
            paciente.setEmail(txtEmail.getText());
            paciente.setRua(txtRua.getText());
            paciente.setNumero(txtNumero.getText());
            paciente.setComplemento(txtComplemento.getText());
            paciente.setBairro(txtBairro.getText());
            paciente.setCidade(txtCidade.getText());
            paciente.setEstado(comboEstado.getSelectedItem().toString());
            paciente.setCep(txtCep.getText());

            // DAO
            PacienteDAO dao = new PacienteDAO();
            dao.inserir(paciente);

          if (pacienteEdicao == null) {
                dao.inserir(paciente);
                JOptionPane.showMessageDialog(this, "Paciente cadastrado com sucesso!");
            } else {
                dao.atualizar(paciente);
                JOptionPane.showMessageDialog(this, "Paciente atualizado com sucesso!");
            }

            limparCampos();
            dispose();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Data de nascimento inválida. Use o formato dd/MM/yyyy.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar paciente: " + ex.getMessage());
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
      limparCampos();  // TODO add your handling code here:
    }//GEN-LAST:event_btnLimparActionPerformed
 public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarPaciente().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtDataNascimento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNomeCompleto;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRg;
    private javax.swing.JTextField txtRua;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
