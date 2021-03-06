/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.GUI;

import freelancer.dao.classes.CandidatureDAO;
import freelancer.dao.classes.MembreDAO;
import freelancer.entities.Candidature;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amine
 */
public class JAjouterCandidature extends javax.swing.JFrame {
String pseudo;
int id_p=0;
    /**
     * Creates new form JAjouterCandidature
     */
    public JAjouterCandidature(String pseudo,int id_p) {
        initComponents();
        setTitle("Envoye D'une Candidature");
    setSize(800,600);
    setResizable(false);
        this.id_p=id_p;
        this.pseudo=pseudo;
        tf_logged.setText(pseudo);this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tf_logged = new javax.swing.JTextField();
        bt_logout = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        tf_estima = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_lettre = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_quest = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Interface Freelancer");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 90, 99, 14);

        tf_logged.setEditable(false);
        getContentPane().add(tf_logged);
        tf_logged.setBounds(120, 90, 90, 20);

        bt_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_logoutActionPerformed(evt);
            }
        });
        getContentPane().add(bt_logout);
        bt_logout.setBounds(660, 10, 140, 30);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(600, 10, 50, 40);

        tf_estima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_estimaActionPerformed(evt);
            }
        });
        getContentPane().add(tf_estima);
        tf_estima.setBounds(370, 190, 227, 40);

        ta_lettre.setColumns(20);
        ta_lettre.setRows(5);
        jScrollPane1.setViewportView(ta_lettre);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(370, 280, 227, 100);

        ta_quest.setColumns(20);
        ta_quest.setRows(5);
        jScrollPane2.setViewportView(ta_quest);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(370, 390, 227, 96);

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(270, 500, 210, 50);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/freelancer/Images/AjouterCandidature.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, -10, 880, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_logoutActionPerformed
        Jhome j = new Jhome();
        setVisible(false);
        j.setVisible(true);
    }//GEN-LAST:event_bt_logoutActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JListeProjet j = new JListeProjet(pseudo);
        setVisible(false);
        j.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf_estimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_estimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_estimaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CandidatureDAO cand=new CandidatureDAO();
        MembreDAO m=new MembreDAO();

        Candidature can=new Candidature(id_p,tf_estima.getText(), ta_lettre.getText(), ta_quest.getText(), pseudo);
        cand.insertCandidature(can);
        JFreelancerProfile j = new JFreelancerProfile(pseudo);
        setVisible(false);
        j.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(JAjouterCandidature.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JAjouterCandidature.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JAjouterCandidature.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JAjouterCandidature.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_logout;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea ta_lettre;
    private javax.swing.JTextArea ta_quest;
    private javax.swing.JTextField tf_estima;
    private javax.swing.JTextField tf_logged;
    // End of variables declaration//GEN-END:variables
}
