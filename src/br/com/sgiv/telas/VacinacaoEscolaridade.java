package br.com.sgiv.telas;

import br.com.sgiv.dal.ModuloConexao;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class VacinacaoEscolaridade extends javax.swing.JFrame {

    Connection conexao;

    public VacinacaoEscolaridade() throws SQLException {
        initComponents();
        pesquisarVacinaEscolaridade();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblVacinacaoEscolaridade = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tblVacinacaoEscolaridade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vacinas", "En. Fundamental", "En. Médio", "En. Superior", "Pós Graduação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVacinacaoEscolaridade);
        if (tblVacinacaoEscolaridade.getColumnModel().getColumnCount() > 0) {
            tblVacinacaoEscolaridade.getColumnModel().getColumn(0).setResizable(false);
            tblVacinacaoEscolaridade.getColumnModel().getColumn(0).setPreferredWidth(35);
            tblVacinacaoEscolaridade.getColumnModel().getColumn(1).setResizable(false);
            tblVacinacaoEscolaridade.getColumnModel().getColumn(2).setResizable(false);
            tblVacinacaoEscolaridade.getColumnModel().getColumn(3).setResizable(false);
            tblVacinacaoEscolaridade.getColumnModel().getColumn(4).setResizable(false);
        }

        jButton1.setText("VOLTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Os números representam a quantidade de pessoas de cada escolaridade que tomaram cada vacina.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Relatorios relatorios = new Relatorios();
        relatorios.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(VacinacaoEscolaridade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VacinacaoEscolaridade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VacinacaoEscolaridade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VacinacaoEscolaridade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VacinacaoEscolaridade().setVisible(true);
                } catch (SQLException e) {
                }
            }
        });
    }

    private void pesquisarVacinaEscolaridade() throws SQLException {
        String sql = "SELECT v.nome as 'vacina', COUNT(CASE WHEN e.id = 1 THEN 1 ELSE NULL END) AS 'en. fundamental',COUNT(CASE WHEN e.id = 2 THEN 1 ELSE NULL END) AS 'en. medio',COUNT(CASE WHEN e.id = 3 THEN 1 ELSE NULL END) AS 'en. superior',COUNT(CASE WHEN e.id = 4 THEN 1 ELSE NULL END) AS 'pos graduacao' FROM vacina v LEFT JOIN atend_vac av ON v.id = av.fk_id_vacina LEFT JOIN atendimento a ON a.id = av.fk_id_atendimento LEFT JOIN paciente p ON p.id = a.fk_id_paciente LEFT JOIN escolaridade e ON e.id = p.fk_id_escolaridade GROUP BY v.nome;";
        conexao = ModuloConexao.conectar();
        PreparedStatement pst = conexao.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        DefaultTableModel modelo = (DefaultTableModel) tblVacinacaoEscolaridade.getModel();
        while (rs.next()) {
            ArrayList<Object> linha = new ArrayList<>();
            for (int i = 1; i <= 5; i++) {
                linha.add(rs.getObject(i));
            }
            modelo.addRow(linha.toArray());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVacinacaoEscolaridade;
    // End of variables declaration//GEN-END:variables
}
