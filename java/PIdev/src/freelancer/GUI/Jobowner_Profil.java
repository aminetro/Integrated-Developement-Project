/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.GUI;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author sou hm
 */
public class Jobowner_Profil extends javax.swing.JFrame {
String pseudo;
public static String url;
    /**
     * Creates new form Jobowner_Profil
     */

  public Jobowner_Profil(String pseudo) {
      initComponents();
    setTitle("Profil");
    setSize(800,600);
    setResizable(false);
    this.pseudo=pseudo;
    tf_pseudo.setText(pseudo);this.setLocationRelativeTo(null);
    }
  
  public Jobowner_Profil(String pseudo,File Url) {
      initComponents();
    setTitle("Profil");
    setSize(800,600);
    setResizable(false);
    this.pseudo=pseudo;
    tf_pseudo.setText(pseudo);
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

        bt_projet = new javax.swing.JButton();
        bt_Candidature = new javax.swing.JButton();
        bt_aff_freelancer = new javax.swing.JButton();
        bt_msg = new javax.swing.JButton();
        bt_profil = new javax.swing.JButton();
        bt_envoir = new javax.swing.JButton();
        bt_logout = new javax.swing.JButton();
        tf_pseudo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        bt_projet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_projetActionPerformed(evt);
            }
        });
        getContentPane().add(bt_projet);
        bt_projet.setBounds(10, 270, 230, 50);

        bt_Candidature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_CandidatureActionPerformed(evt);
            }
        });
        getContentPane().add(bt_Candidature);
        bt_Candidature.setBounds(260, 270, 250, 50);

        bt_aff_freelancer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_aff_freelancerActionPerformed(evt);
            }
        });
        getContentPane().add(bt_aff_freelancer);
        bt_aff_freelancer.setBounds(540, 260, 230, 50);

        bt_msg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_msgActionPerformed(evt);
            }
        });
        getContentPane().add(bt_msg);
        bt_msg.setBounds(0, 420, 240, 50);

        bt_profil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_profilActionPerformed(evt);
            }
        });
        getContentPane().add(bt_profil);
        bt_profil.setBounds(270, 420, 240, 51);

        bt_envoir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_envoirActionPerformed(evt);
            }
        });
        getContentPane().add(bt_envoir);
        bt_envoir.setBounds(540, 420, 240, 51);

        bt_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_logoutActionPerformed(evt);
            }
        });
        getContentPane().add(bt_logout);
        bt_logout.setBounds(600, 0, 190, 50);

        tf_pseudo.setEditable(false);
        tf_pseudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_pseudoActionPerformed(evt);
            }
        });
        getContentPane().add(tf_pseudo);
        tf_pseudo.setBounds(80, 120, 130, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/freelancer/Images/JobOwner Profil.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_projetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_projetActionPerformed
        
                Jobowner_Affichage_Projets a = new Jobowner_Affichage_Projets(pseudo);
        setVisible(false);
        a.setVisible(true);
        


// TODO add your handling code here:
    }//GEN-LAST:event_bt_projetActionPerformed

    private void bt_CandidatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_CandidatureActionPerformed
   
        
        Jobowner_Affichage_Candidature j = new Jobowner_Affichage_Candidature(pseudo);
        setVisible(false);
        j.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_bt_CandidatureActionPerformed

    private void bt_msgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_msgActionPerformed

        Jobowner_Gestion_Messagerie j = new Jobowner_Gestion_Messagerie(pseudo);
        setVisible(false);
        j.setVisible(true);


// TODO add your handling code here:
    }//GEN-LAST:event_bt_msgActionPerformed

    private void bt_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_logoutActionPerformed
        Jhome a = new Jhome();
        setVisible(false);
        a.setVisible(true);
    }//GEN-LAST:event_bt_logoutActionPerformed

    private void bt_profilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_profilActionPerformed
        Jobowner_Gestion_Profil aa=new Jobowner_Gestion_Profil(pseudo);
        setVisible(false);
        aa.setVisible(true);
    }//GEN-LAST:event_bt_profilActionPerformed

    private void tf_pseudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_pseudoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_pseudoActionPerformed

    private void bt_envoirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_envoirActionPerformed

        Jobowner_Envoi_Reclamation aa=new Jobowner_Envoi_Reclamation(pseudo);
        setVisible(false);
        aa.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_bt_envoirActionPerformed

    private void bt_aff_freelancerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_aff_freelancerActionPerformed
       
        Jobowner_Affichage_Freelancer aa=new Jobowner_Affichage_Freelancer(pseudo);
        setVisible(false);
        aa.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_bt_aff_freelancerActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
 bt_logout.setBorderPainted(false); 
bt_logout.setContentAreaFilled(false); 
bt_logout.setFocusPainted(false); 
bt_logout.setOpaque(false);
        
         bt_Candidature.setBorderPainted(false); 
bt_Candidature.setContentAreaFilled(false); 
bt_Candidature.setFocusPainted(false); 
bt_Candidature.setOpaque(false);

bt_aff_freelancer.setBorderPainted(false); 
bt_aff_freelancer.setContentAreaFilled(false); 
bt_aff_freelancer.setFocusPainted(false); 
bt_aff_freelancer.setOpaque(false);

bt_envoir.setBorderPainted(false); 
bt_envoir.setContentAreaFilled(false); 
bt_envoir.setFocusPainted(false); 
bt_envoir.setOpaque(false);

bt_logout.setBorderPainted(false); 
bt_logout.setContentAreaFilled(false); 
bt_logout.setFocusPainted(false); 
bt_logout.setOpaque(false);

bt_msg.setBorderPainted(false); 
bt_msg.setContentAreaFilled(false); 
bt_msg.setFocusPainted(false); 
bt_msg.setOpaque(false);

bt_profil.setBorderPainted(false); 
bt_profil.setContentAreaFilled(false); 
bt_profil.setFocusPainted(false); 
bt_profil.setOpaque(false);

bt_projet.setBorderPainted(false); 
bt_projet.setContentAreaFilled(false); 
bt_projet.setFocusPainted(false); 
bt_projet.setOpaque(false);

bt_profil.setBorderPainted(false); 
bt_profil.setContentAreaFilled(false); 
bt_profil.setFocusPainted(false); 
bt_profil.setOpaque(false);
    }//GEN-LAST:event_formWindowOpened

    
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jobowner_Profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Candidature;
    private javax.swing.JButton bt_aff_freelancer;
    private javax.swing.JButton bt_envoir;
    private javax.swing.JButton bt_logout;
    private javax.swing.JButton bt_msg;
    private javax.swing.JButton bt_profil;
    private javax.swing.JButton bt_projet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField tf_pseudo;
    // End of variables declaration//GEN-END:variables
}
