/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.GUI;

import freelancer.dao.classes.MessagerieDAO;
import freelancer.entities.Messagerie;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author sou hm
 */
public class Jobowner_Envoi_Message extends javax.swing.JFrame {
String pseudo;
    /**
     * Creates new form Jobowner_Envoi_Message
     */
    public Jobowner_Envoi_Message() {
        initComponents();this.setLocationRelativeTo(null);
    }

     public Jobowner_Envoi_Message(String pseudo) {
        initComponents();
        setTitle("Envoyer un message");
         setSize(800,600);
         setResizable(false);
        this.pseudo=pseudo;
        tf_pseudo.setText(pseudo);this.setLocationRelativeTo(null);
        
    }
     public Jobowner_Envoi_Message(String pseudo,String destina) {
        initComponents();
        this.pseudo=pseudo;
        tf_pseudo.setText(pseudo);
        tf_destinatair.setText(destina);
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

        tf_destinatair = new javax.swing.JTextField();
        tf_sujet = new javax.swing.JTextField();
        bt_logout = new javax.swing.JButton();
        bt_retour = new javax.swing.JButton();
        bt_envoyer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf_message = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        tf_pseudo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(tf_destinatair);
        tf_destinatair.setBounds(210, 200, 300, 40);
        getContentPane().add(tf_sujet);
        tf_sujet.setBounds(210, 300, 300, 40);

        bt_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_logoutActionPerformed(evt);
            }
        });
        getContentPane().add(bt_logout);
        bt_logout.setBounds(630, 0, 150, 60);

        bt_retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_retourActionPerformed(evt);
            }
        });
        getContentPane().add(bt_retour);
        bt_retour.setBounds(550, 0, 50, 60);

        bt_envoyer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_envoyerActionPerformed(evt);
            }
        });
        getContentPane().add(bt_envoyer);
        bt_envoyer.setBounds(550, 430, 230, 50);

        tf_message.setColumns(20);
        tf_message.setRows(5);
        jScrollPane1.setViewportView(tf_message);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(210, 390, 300, 110);

        jLabel1.setText("Interface Jobowner");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 110, 100, 14);
        getContentPane().add(tf_pseudo);
        tf_pseudo.setBounds(170, 130, 80, 20);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/freelancer/Images/EnvoyerMessage.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_envoyerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_envoyerActionPerformed
        Date d = new Date();
        java.sql.Date sqlDate = new java.sql.Date(d.getTime());
        Messagerie msg=new Messagerie(pseudo,tf_destinatair.getText(), sqlDate, tf_sujet.getText(), tf_message.getText());
        MessagerieDAO m = new MessagerieDAO();
        m.envoyerMessage(msg);
        JOptionPane.showMessageDialog(null, "Message envoié avec succé !!","Message",JOptionPane.INFORMATION_MESSAGE);
        Jobowner_Profil j = new Jobowner_Profil(pseudo);
        setVisible(false);
        j.setVisible(true);
        
// TODO add your handling code here:
    }//GEN-LAST:event_bt_envoyerActionPerformed

    private void bt_retourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_retourActionPerformed
       Jobowner_Gestion_Messagerie a = new Jobowner_Gestion_Messagerie(pseudo);
        setVisible(false);
        a.setVisible(true);
        
// TODO add your handling code here:
    }//GEN-LAST:event_bt_retourActionPerformed

    private void bt_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_logoutActionPerformed
Jhome a = new Jhome();
        setVisible(false);
        a.setVisible(true);       
        
// TODO add your handling code here:
    }//GEN-LAST:event_bt_logoutActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      bt_retour.setBorderPainted(false); 
bt_retour.setContentAreaFilled(false); 
bt_retour.setFocusPainted(false); 
bt_retour.setOpaque(false);

bt_logout.setBorderPainted(false); 
bt_logout.setContentAreaFilled(false); 
bt_logout.setFocusPainted(false); 
bt_logout.setOpaque(false);

bt_envoyer.setBorderPainted(false); 
bt_envoyer.setContentAreaFilled(false); 
bt_envoyer.setFocusPainted(false); 
bt_envoyer.setOpaque(false);
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
            java.util.logging.Logger.getLogger(Jobowner_Envoi_Message.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jobowner_Envoi_Message.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jobowner_Envoi_Message.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jobowner_Envoi_Message.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_envoyer;
    private javax.swing.JButton bt_logout;
    private javax.swing.JButton bt_retour;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tf_destinatair;
    private javax.swing.JTextArea tf_message;
    private javax.swing.JTextField tf_pseudo;
    private javax.swing.JTextField tf_sujet;
    // End of variables declaration//GEN-END:variables
}