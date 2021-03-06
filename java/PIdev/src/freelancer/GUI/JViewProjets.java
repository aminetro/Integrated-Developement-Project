/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.GUI;

/**
 *
 * @author Amine
 */
public class JViewProjets extends javax.swing.JFrame {
String pseudo;
    /**
     * Creates new form JViewJobowners
     */
    public JViewProjets(String pseudo) {
        initComponents();
        this.pseudo=pseudo;
        tf_logged.setText(pseudo);
         setTitle("Menu Des Projets");
setSize(800,600);
setResizable(false);
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

        jLabel1 = new javax.swing.JLabel();
        tf_logged = new javax.swing.JTextField();
        bt_logout = new javax.swing.JButton();
        bt_liste = new javax.swing.JButton();
        bt_listfavori = new javax.swing.JButton();
        bt_retour = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setText("Interface Freelancer");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 100, 99, 14);
        getContentPane().add(tf_logged);
        tf_logged.setBounds(140, 100, 103, 20);

        bt_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_logoutActionPerformed(evt);
            }
        });
        getContentPane().add(bt_logout);
        bt_logout.setBounds(670, 10, 120, 30);

        bt_liste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_listeActionPerformed(evt);
            }
        });
        getContentPane().add(bt_liste);
        bt_liste.setBounds(430, 390, 290, 60);

        bt_listfavori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_listfavoriActionPerformed(evt);
            }
        });
        getContentPane().add(bt_listfavori);
        bt_listfavori.setBounds(40, 380, 300, 70);

        bt_retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_retourActionPerformed(evt);
            }
        });
        getContentPane().add(bt_retour);
        bt_retour.setBounds(610, 0, 40, 50);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(240, 220, 310, 80);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/freelancer/Images/Freelancer_ViewProjet_2.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_logoutActionPerformed
        Jhome j = new Jhome();
        setVisible(false);
        j.setVisible(true);
    }//GEN-LAST:event_bt_logoutActionPerformed

    private void bt_listeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_listeActionPerformed
        JListeProjet j = new JListeProjet(pseudo);
        setVisible(false);
        j.setVisible(true);
    }//GEN-LAST:event_bt_listeActionPerformed

    private void bt_listfavoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_listfavoriActionPerformed
        JListeFavoris j = new JListeFavoris(pseudo);
        setVisible(false);
        j.setVisible(true);
    }//GEN-LAST:event_bt_listfavoriActionPerformed

    private void bt_retourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_retourActionPerformed
        JFreelancerProfile j = new JFreelancerProfile(pseudo);
        setVisible(false);
        j.setVisible(true);
    }//GEN-LAST:event_bt_retourActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        bt_liste.setBorderPainted(false); 
bt_liste.setContentAreaFilled(false); 
bt_liste.setFocusPainted(false); 
bt_liste.setOpaque(false);
 
bt_listfavori.setBorderPainted(false); 
bt_listfavori.setContentAreaFilled(false); 
bt_listfavori.setFocusPainted(false); 
bt_listfavori.setOpaque(false);

bt_logout.setBorderPainted(false); 
bt_logout.setContentAreaFilled(false); 
bt_logout.setFocusPainted(false); 
bt_logout.setOpaque(false);

bt_retour.setBorderPainted(false); 
bt_retour.setContentAreaFilled(false); 
bt_retour.setFocusPainted(false); 
bt_retour.setOpaque(false);

jButton1.setBorderPainted(false); 
jButton1.setContentAreaFilled(false); 
jButton1.setFocusPainted(false); 
jButton1.setOpaque(false);

    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JMesProjet j=new JMesProjet(pseudo);
        setVisible(false);
        j.setVisible(true);
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
            java.util.logging.Logger.getLogger(JViewProjets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JViewProjets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JViewProjets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JViewProjets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_liste;
    private javax.swing.JButton bt_listfavori;
    private javax.swing.JButton bt_logout;
    private javax.swing.JButton bt_retour;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField tf_logged;
    // End of variables declaration//GEN-END:variables
}
