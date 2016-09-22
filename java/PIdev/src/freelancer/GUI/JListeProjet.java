/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.GUI;

import freelancer.connection.DataSource;
import freelancer.dao.classes.FavorisDAO;
import freelancer.dao.classes.FreelancerDAO;
import freelancer.dao.classes.MembreDAO;
import freelancer.entities.Favoris;
import freelancer.entities.Membre;
import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author Amine
 */
public class JListeProjet extends javax.swing.JFrame {
String pseudo;
    /**
     * Creates new form JListeProjet
     */
    public JListeProjet(String pseudo) {
        initComponents();
        this.pseudo=pseudo;
        tf_logged.setText(pseudo);
         setTitle("Liste Des Projets");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tf_logged = new javax.swing.JTextField();
        bt_logout = new javax.swing.JButton();
        bt_retour = new javax.swing.JButton();
        bt_favoriser = new javax.swing.JButton();
        bt_candidater = new javax.swing.JButton();
        bt_reclamation = new javax.swing.JButton();
        bt_mail = new javax.swing.JButton();
        tf_rech = new javax.swing.JTextField();
        bt_rechercher = new javax.swing.JButton();
        bt_pdf = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jTable1.setModel(new ModelProjet());
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(90, 250, 663, 200);

        jLabel1.setText("Interface Freelancer");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 100, 99, 14);

        tf_logged.setEditable(false);
        getContentPane().add(tf_logged);
        tf_logged.setBounds(120, 100, 100, 20);

        bt_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_logoutActionPerformed(evt);
            }
        });
        getContentPane().add(bt_logout);
        bt_logout.setBounds(660, 0, 140, 50);

        bt_retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_retourActionPerformed(evt);
            }
        });
        getContentPane().add(bt_retour);
        bt_retour.setBounds(600, 0, 50, 50);

        bt_favoriser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_favoriserActionPerformed(evt);
            }
        });
        getContentPane().add(bt_favoriser);
        bt_favoriser.setBounds(20, 510, 160, 40);

        bt_candidater.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_candidaterActionPerformed(evt);
            }
        });
        getContentPane().add(bt_candidater);
        bt_candidater.setBounds(200, 510, 180, 40);

        bt_reclamation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_reclamationActionPerformed(evt);
            }
        });
        getContentPane().add(bt_reclamation);
        bt_reclamation.setBounds(610, 510, 180, 40);

        bt_mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_mailActionPerformed(evt);
            }
        });
        getContentPane().add(bt_mail);
        bt_mail.setBounds(410, 510, 170, 40);
        getContentPane().add(tf_rech);
        tf_rech.setBounds(380, 180, 100, 30);

        bt_rechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_rechercherActionPerformed(evt);
            }
        });
        getContentPane().add(bt_rechercher);
        bt_rechercher.setBounds(520, 170, 210, 40);

        bt_pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pdfActionPerformed(evt);
            }
        });
        getContentPane().add(bt_pdf);
        bt_pdf.setBounds(630, 80, 140, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/freelancer/Images/Freelancer_ListeProjet2.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 810, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_logoutActionPerformed
        Jhome j = new Jhome();
        setVisible(false);
        j.setVisible(true);
    }//GEN-LAST:event_bt_logoutActionPerformed

    private void bt_retourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_retourActionPerformed
        JViewProjets j = new JViewProjets(pseudo);
        setVisible(false);
        j.setVisible(true);
    }//GEN-LAST:event_bt_retourActionPerformed

    private void bt_favoriserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_favoriserActionPerformed
       FavorisDAO fav = new FavorisDAO();
        MembreDAO mb=new MembreDAO();
       int id_f=0;
       id_f = mb.getId(pseudo);
       int if_p=(int)jTable1.getValueAt(jTable1.getSelectedRow(),0);
       Favoris f = new Favoris(id_f, if_p);
       fav.insertFavorit(f);
    }//GEN-LAST:event_bt_favoriserActionPerformed

    private void bt_candidaterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_candidaterActionPerformed
        JAjouterCandidature j = new JAjouterCandidature(pseudo,(int)jTable1.getValueAt(jTable1.getSelectedRow(),0));
        setVisible(false);
        j.setVisible(true);
    }//GEN-LAST:event_bt_candidaterActionPerformed

    private void bt_reclamationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_reclamationActionPerformed
        JEnvoyReclamation j = new JEnvoyReclamation(pseudo,"PROJET : "+(String)jTable1.getValueAt(jTable1.getSelectedRow(),1)
                ,(int)jTable1.getValueAt(jTable1.getSelectedRow(),0));
        setVisible(false);
        j.setVisible(true);
    }//GEN-LAST:event_bt_reclamationActionPerformed

    private void bt_mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_mailActionPerformed
        String pseuowner=(String)jTable1.getValueAt(jTable1.getSelectedRow(),5);
        MembreDAO m=new MembreDAO();
        
        int i=0;
        int j =0;
        i = m.getId(pseudo);
    j = m.getId(pseuowner);
        Membre mb=new Membre();
        mb=m.findMembreById(i);
        String Mailexp=mb.getMail();
        mb=m.findMembreById(j);
        String maildest=mb.getMail();
        EnvoyerMail en=new EnvoyerMail(pseudo, Mailexp, maildest, "freelancer");
        setVisible(false);
        en.setVisible(true);
    }//GEN-LAST:event_bt_mailActionPerformed

    private void bt_rechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_rechercherActionPerformed
        ModelProjet mj = new ModelProjet(tf_rech.getText(),0);

        jTable1.setModel(mj);
    }//GEN-LAST:event_bt_rechercherActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
                
         bt_rechercher.setBorderPainted(false); 
bt_rechercher.setContentAreaFilled(false); 
bt_rechercher.setFocusPainted(false); 
bt_rechercher.setOpaque(false);

bt_favoriser.setBorderPainted(false); 
bt_favoriser.setContentAreaFilled(false); 
bt_favoriser.setFocusPainted(false); 
bt_favoriser.setOpaque(false);

bt_candidater.setBorderPainted(false); 
bt_candidater.setContentAreaFilled(false); 
bt_candidater.setFocusPainted(false); 
bt_candidater.setOpaque(false);

bt_mail.setBorderPainted(false); 
bt_mail.setContentAreaFilled(false); 
bt_mail.setFocusPainted(false); 
bt_mail.setOpaque(false);

bt_reclamation.setBorderPainted(false); 
bt_reclamation.setContentAreaFilled(false); 
bt_reclamation.setFocusPainted(false); 
bt_reclamation.setOpaque(false);

bt_retour.setBorderPainted(false); 
bt_retour.setContentAreaFilled(false); 
bt_retour.setFocusPainted(false); 
bt_retour.setOpaque(false);

bt_pdf.setBorderPainted(false); 
bt_pdf.setContentAreaFilled(false); 
bt_pdf.setFocusPainted(false); 
bt_pdf.setOpaque(false);

bt_logout.setBorderPainted(false); 
bt_logout.setContentAreaFilled(false); 
bt_logout.setFocusPainted(false); 
bt_logout.setOpaque(false);



    }//GEN-LAST:event_formWindowOpened

    private void bt_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pdfActionPerformed
          try{
        Connection connection;
            connection =DataSource.getInstance().getConnection();
            System.out.println("1");
            JasperDesign Jasperdesign = JRXmlLoader.load("classic\\classic4.jrxml");
            
            
            System.out.println("2");
            JasperReport Jasperreport = JasperCompileManager.compileReport(Jasperdesign);
            System.out.println("3");
            Map parameters = new HashMap();
            parameters.put("Titre","Titre");
            System.out.println("4");
            JasperPrint jasperPrint = JasperFillManager.fillReport(Jasperreport,null,connection);
            System.out.println("5");
            JasperExportManager.exportReportToPdfFile(jasperPrint,"C:\\Users\\Amine\\Desktop\\PIdev\\ListeProjets.pdf" );
                    System.out.println("pdf généré");
        } catch (JRException ex) {
            Logger.getLogger(Superadmin_gereradministrateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_pdfActionPerformed

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
            java.util.logging.Logger.getLogger(JListeProjet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JListeProjet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JListeProjet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JListeProjet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_candidater;
    private javax.swing.JButton bt_favoriser;
    private javax.swing.JButton bt_logout;
    private javax.swing.JButton bt_mail;
    private javax.swing.JButton bt_pdf;
    private javax.swing.JButton bt_rechercher;
    private javax.swing.JButton bt_reclamation;
    private javax.swing.JButton bt_retour;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tf_logged;
    private javax.swing.JTextField tf_rech;
    // End of variables declaration//GEN-END:variables
}
