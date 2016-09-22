/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.GUI;

import freelancer.GUI.ModelCandidature;
import freelancer.dao.classes.CandidatureDAO;
import freelancer.dao.classes.MembreDAO;
import freelancer.dao.classes.ProjetDAO;
import freelancer.entities.Membre;
import freelancer.entities.Projet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sou hm
 */
public class Jobowner_Affichage_Candidature extends javax.swing.JFrame {
String pseudo;
    /**
     * Creates new form Jobowner_Affichage_Candidature
     */
    public Jobowner_Affichage_Candidature(String pseudo) {
        initComponents();
        setTitle("Gestion Des Condidatures");
    setSize(800,600);
    setResizable(false);
        this.pseudo=pseudo;
        tf_logged.setText(pseudo);
        ModelCandidaturejob mc=new ModelCandidaturejob(pseudo);
        jTable1.setModel(mc);
        this.setLocationRelativeTo(null);
    }

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_retour = new javax.swing.JButton();
        bt_rejeter = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tf_logged = new javax.swing.JTextField();
        bt_logout = new javax.swing.JButton();
        bt_accepter = new javax.swing.JButton();
        bt_mail = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        bt_retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_retourActionPerformed(evt);
            }
        });
        getContentPane().add(bt_retour);
        bt_retour.setBounds(600, 0, 50, 50);

        bt_rejeter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_rejeterActionPerformed(evt);
            }
        });
        getContentPane().add(bt_rejeter);
        bt_rejeter.setBounds(530, 500, 220, 50);

        jTable1.setModel(new ModelCandidaturejob(pseudo));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 220, 700, 238);

        tf_logged.setEditable(false);
        getContentPane().add(tf_logged);
        tf_logged.setBounds(110, 120, 103, 20);

        bt_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_logoutActionPerformed(evt);
            }
        });
        getContentPane().add(bt_logout);
        bt_logout.setBounds(660, 0, 130, 50);

        bt_accepter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_accepterActionPerformed(evt);
            }
        });
        getContentPane().add(bt_accepter);
        bt_accepter.setBounds(20, 490, 220, 50);

        bt_mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_mailActionPerformed(evt);
            }
        });
        getContentPane().add(bt_mail);
        bt_mail.setBounds(280, 500, 220, 50);

        jLabel2.setText("Interface Jobowner");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 100, 110, 14);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/freelancer/Images/JobOwner_AffichageCandidature_1.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_retourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_retourActionPerformed
        Jobowner_Profil j = new  Jobowner_Profil(pseudo);
        setVisible(false);
        j.setVisible(true);
    }//GEN-LAST:event_bt_retourActionPerformed

    private void bt_rejeterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_rejeterActionPerformed
        CandidatureDAO can = new CandidatureDAO();

        int id=(int)jTable1.getValueAt(jTable1.getSelectedRow(),0);
        can.deleteCandidature(id);
        Jobowner_Affichage_Candidature j = new Jobowner_Affichage_Candidature(pseudo);
        setVisible(false);
        j.setVisible(true);
    }//GEN-LAST:event_bt_rejeterActionPerformed

    private void bt_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_logoutActionPerformed
        Jhome j = new Jhome();
        setVisible(false);
        j.setVisible(true);
    }//GEN-LAST:event_bt_logoutActionPerformed

    private void bt_accepterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_accepterActionPerformed
       String pseu = (String) jTable1.getValueAt(jTable1.getSelectedRow(),2);
       int i = (int) Float.parseFloat(jTable1.getValueAt(jTable1.getSelectedRow(),1).toString());
        ProjetDAO job=new ProjetDAO();
     
        job.updatProjet(i,pseu);
         JOptionPane.showMessageDialog(null, "Projet affectué","Message",JOptionPane.INFORMATION_MESSAGE);
        Jobowner_Affichage_Projets jj = new Jobowner_Affichage_Projets (pseudo);
        setVisible(false);
        jj.setVisible(true);
        
        


// TODO add your handling code here:
    }//GEN-LAST:event_bt_accepterActionPerformed

    private void bt_mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_mailActionPerformed
        String pseufree=(String)jTable1.getValueAt(jTable1.getSelectedRow(),2);
        MembreDAO m=new MembreDAO();
        
        int i=0;
        int j =0;
        i = m.getId(pseudo);
    j = m.getId(pseufree);
        Membre mb=new Membre();
        mb=m.findMembreById(i);
        String Mailexp=mb.getMail();
        mb=m.findMembreById(j);
        String maildest=mb.getMail();
        EnvoyerMail en=new EnvoyerMail(pseudo, Mailexp, maildest, "jobowner");
        setVisible(false);
        en.setVisible(true);
    }//GEN-LAST:event_bt_mailActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        bt_logout.setBorderPainted(false); 
bt_logout.setContentAreaFilled(false); 
bt_logout.setFocusPainted(false); 
bt_logout.setOpaque(false);
        
        bt_accepter.setBorderPainted(false); 
bt_accepter.setContentAreaFilled(false); 
bt_accepter.setFocusPainted(false); 
bt_accepter.setOpaque(false);

bt_retour.setBorderPainted(false); 
bt_retour.setContentAreaFilled(false); 
bt_retour.setFocusPainted(false); 
bt_retour.setOpaque(false);

bt_rejeter.setBorderPainted(false); 
bt_rejeter.setContentAreaFilled(false); 
bt_rejeter.setFocusPainted(false); 
bt_rejeter.setOpaque(false);

bt_mail.setBorderPainted(false); 
bt_mail.setContentAreaFilled(false); 
bt_mail.setFocusPainted(false); 
bt_mail.setOpaque(false);
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(Jobowner_Affichage_Candidature.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jobowner_Affichage_Candidature.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jobowner_Affichage_Candidature.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jobowner_Affichage_Candidature.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_accepter;
    private javax.swing.JButton bt_logout;
    private javax.swing.JButton bt_mail;
    private javax.swing.JButton bt_rejeter;
    private javax.swing.JButton bt_retour;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tf_logged;
    // End of variables declaration//GEN-END:variables
}
