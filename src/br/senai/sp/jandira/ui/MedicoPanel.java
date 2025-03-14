
package br.senai.sp.jandira.ui;

import br.senai.sp.jandira.dao.MedicoDAO;
import br.senai.sp.jandira.model.Medico;
import br.senai.sp.jandira.model.TipoOperacao;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class MedicoPanel extends javax.swing.JPanel {

   int linha;
    
    public MedicoPanel() {
        initComponents();
        criarTabelaMedico();
        
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        buttonAdicionarMedico = new javax.swing.JButton();
        buttonAlterarMedico = new javax.swing.JButton();
        scrollTableMedico = new javax.swing.JScrollPane();
        tableMedico = new javax.swing.JTable();
        buttonExcluirMedico = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 0, 0));
        setLayout(null);

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 0));
        jLabel3.setText("♡❤Medicos❤♡");
        add(jLabel3);
        jLabel3.setBounds(20, 10, 230, 20);

        buttonAdicionarMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/imagens/7847520_hospital_clinic_covid_icon.png"))); // NOI18N
        buttonAdicionarMedico.setToolTipText("Adicionar plano de saúde");
        buttonAdicionarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdicionarMedicoActionPerformed(evt);
            }
        });
        add(buttonAdicionarMedico);
        buttonAdicionarMedico.setBounds(860, 294, 70, 60);

        buttonAlterarMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/imagens/edit32.png"))); // NOI18N
        buttonAlterarMedico.setToolTipText("Editar plano de saúde selecionado");
        buttonAlterarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAlterarMedicoActionPerformed(evt);
            }
        });
        add(buttonAlterarMedico);
        buttonAlterarMedico.setBounds(780, 294, 70, 60);

        tableMedico.setBackground(new java.awt.Color(204, 204, 204));
        tableMedico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        scrollTableMedico.setViewportView(tableMedico);

        add(scrollTableMedico);
        scrollTableMedico.setBounds(20, 40, 905, 240);

        buttonExcluirMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/imagens/delete32-2.png"))); // NOI18N
        buttonExcluirMedico.setToolTipText("Excluir plano de saúde selecionado");
        buttonExcluirMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirMedicoActionPerformed(evt);
            }
        });
        add(buttonExcluirMedico);
        buttonExcluirMedico.setBounds(700, 294, 70, 60);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAdicionarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdicionarMedicoActionPerformed

        //RESOLVER DEPOIS AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
        
        
       MedicosDialog medicosDialog =
        new MedicosDialog(
                            null,
                            true,
                            TipoOperacao.ADICIONAR,
                             null);

        medicosDialog.setVisible(true);

        criarTabelaMedico();
        
        //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA

    }//GEN-LAST:event_buttonAdicionarMedicoActionPerformed

    private void buttonAlterarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAlterarMedicoActionPerformed

        linha = tableMedico.getSelectedRow();
        if (linha != -1) {
            editar();
        } else {

            JOptionPane.showMessageDialog(
                this,
                "Por favor, selecione medico que você deseja alterar!",
                "Equipe medica",
                JOptionPane.WARNING_MESSAGE);

        }

    }//GEN-LAST:event_buttonAlterarMedicoActionPerformed

    private void buttonExcluirMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirMedicoActionPerformed

        //obetnhamos linha selecionada na tabela
        linha = tableMedico.getSelectedRow();

        if (linha != -1 ){
            // Excluir o plano de saúde
            excluir();

        } else {
            JOptionPane.showMessageDialog(
                this,
                "Por favor, selecione o medico deseja excluir!",
                "Equipe medica",
                JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_buttonExcluirMedicoActionPerformed
  private void excluir(){
        
        int resposta = JOptionPane.showConfirmDialog(
                this,
                "Voce,confirma a exclusao do medico selecionado?", 
                "Medico", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE);
        
        if (resposta ==0){
            String codigoStr = tableMedico.getValueAt(linha, 0).toString();
            Integer codigo = Integer.valueOf(codigoStr);
            MedicoDAO.excluir(codigo);
            criarTabelaMedico();
        }
        
    
    }

   //----------------------------------------------------------------------------- 
    private Integer getCodigo() {
        String codigoStr = tableMedico.getValueAt(linha, 0).toString();
        return Integer.valueOf(codigoStr);
    }

    
    private Integer retornarCodigoSelecionado(){
     return null;
    }
    //--------------------------------------------------------------------------
    
     private void editar() {
        
        Medico medico = MedicoDAO.getMedico(getCodigo());
        
        MedicosDialog medicosDialog = 
                new MedicosDialog(
                        null, 
                        true, 
                        TipoOperacao.ALTERAR, 
                        medico);
        
        medicosDialog.setVisible(true);
        
        criarTabelaMedico();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdicionarMedico;
    private javax.swing.JButton buttonAlterarMedico;
    private javax.swing.JButton buttonExcluirMedico;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane scrollTableMedico;
    private javax.swing.JTable tableMedico;
    // End of variables declaration//GEN-END:variables

 private void criarTabelaMedico() {

        tableMedico.setModel(MedicoDAO.getTableModel());

        // Desativar o redimensionamento da JTable
        tableMedico.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // Definir a largura de cada coluna
        tableMedico.getColumnModel().getColumn(0).setPreferredWidth(100);
        tableMedico.getColumnModel().getColumn(1).setPreferredWidth(100);
        tableMedico.getColumnModel().getColumn(2).setPreferredWidth(220);
        tableMedico.getColumnModel().getColumn(3).setPreferredWidth(220);
        tableMedico.getColumnModel().getColumn(4).setPreferredWidth(130);
         
        // Impedir/bloquear a movimentação das colunas
        tableMedico.getTableHeader().setReorderingAllowed(false);

        // Bloquear edição das células
        tableMedico.setDefaultEditor(Object.class, null);


 }

 
}