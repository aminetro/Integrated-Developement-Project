/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freelancer.GUI;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import freelancer.connection.DataSource;
import freelancer.dao.classes.FreelancerDAO;
import freelancer.dao.classes.ProjetDAO;
import freelancer.entities.Projet;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Mariem
 */
public class Jobowner_Ajouter_Projet extends javax.swing.JFrame {
    String pseudo;
    private Object jTable1;
     public final Connection connection;
    /**
     * Creates new form Jobowner_AjouterProjet
     */
  

    Jobowner_Ajouter_Projet(String pseudo) {
        initComponents();
        setTitle("Ajout D'un Projet");
         setSize(800,600);
         setResizable(false);
        this.pseudo=pseudo;
         tf_logged.setText(pseudo);
         connection = DataSource.getInstance().getConnection();
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
        bt_deconnect = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tf_titre = new javax.swing.JTextField();
        tf_categorie = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_duree = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_desc = new javax.swing.JTextArea();
        bt_valider = new javax.swing.JButton();
        bt_importer = new javax.swing.JButton();
        Path = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Interface Jobowner");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 100, 111, 14);

        tf_logged.setEditable(false);
        getContentPane().add(tf_logged);
        tf_logged.setBounds(90, 120, 129, 20);

        bt_deconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_deconnectActionPerformed(evt);
            }
        });
        getContentPane().add(bt_deconnect);
        bt_deconnect.setBounds(660, 0, 130, 50);

        jLabel3.setText("Titre");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 61, 52, 14);
        getContentPane().add(tf_titre);
        tf_titre.setBounds(250, 350, 160, 40);
        getContentPane().add(tf_categorie);
        tf_categorie.setBounds(250, 420, 170, 40);

        jLabel6.setText("Description");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 162, 53, 14);
        getContentPane().add(tf_duree);
        tf_duree.setBounds(590, 360, 190, 30);

        ta_desc.setColumns(20);
        ta_desc.setRows(5);
        jScrollPane1.setViewportView(ta_desc);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(590, 420, 190, 80);

        bt_valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_validerActionPerformed(evt);
            }
        });
        getContentPane().add(bt_valider);
        bt_valider.setBounds(120, 520, 220, 40);

        bt_importer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_importerActionPerformed(evt);
            }
        });
        getContentPane().add(bt_importer);
        bt_importer.setBounds(430, 520, 200, 45);
        getContentPane().add(Path);
        Path.setBounds(650, 530, 130, 40);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(600, 0, 50, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/freelancer/Images/JobOwner_ajouterProjet.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_deconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deconnectActionPerformed
        // TODO add your handling code here:
         Jhome a = new Jhome();
        setVisible(false);
        a.setVisible(true);
    }//GEN-LAST:event_bt_deconnectActionPerformed

    private void bt_validerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_validerActionPerformed
        // TODO add your handling code here:
        Date d =new Date();
        java.sql.Date date=new java.sql.Date(d.getTime());
        Projet pro = new Projet(0,date,tf_titre.getText(),tf_categorie.getText(),tf_duree.getText(),ta_desc.getText(),pseudo);
        ProjetDAO proj = new ProjetDAO();
         proj.insertProjet(pro);
         
         
         
              try { 
                  int i=proj.getIdProjet(tf_titre.getText(), tf_categorie.getText(), tf_duree.getText(), 
                          ta_desc.getText(), pseudo);
           String requete2="UPDATE projet SET `photo_p`=? WHERE id='"+i+"'";
                  
       PreparedStatement ps = connection.prepareStatement(requete2);
       ps.setBytes(1,image_person);
           ps.executeUpdate();
           
       
   
    } catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
                              System.out.println("********************!!**********exxxx************************************");

    }

        Jobowner_Affichage_Projets a1 = new Jobowner_Affichage_Projets(pseudo);
        setVisible(false);//Masquer la JFrame actuelle
        a1.setVisible(true);
        
    }//GEN-LAST:event_bt_validerActionPerformed

    private void bt_importerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_importerActionPerformed
        // TODO add your handling code here:
         JFileChooser chooser = new JFileChooser();
        
        chooser.showOpenDialog(null);
       File f =chooser.getSelectedFile();
        String filename=f.getAbsolutePath();
        Path.setText(filename);
        try
        {
        File image=new File (filename);
        FileInputStream fis=new FileInputStream(image);
            ByteArrayOutputStream bos= new ByteArrayOutputStream();
        byte[] buf =new byte[1024];
        for (int readNum;(readNum=fis.read(buf))!=-1;)
            
        {
        bos.write(buf,0,readNum);
        }
        image_person=bos.toByteArray();
        
        }
        catch(Exception e )
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_bt_importerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Jobowner_Profil j = new Jobowner_Profil(pseudo);
        setVisible(false);
        j.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      jButton1.setBorderPainted(false); 
jButton1.setContentAreaFilled(false); 
jButton1.setFocusPainted(false); 
jButton1.setOpaque(false);

bt_deconnect.setBorderPainted(false); 
bt_deconnect.setContentAreaFilled(false); 
bt_deconnect.setFocusPainted(false); 
bt_deconnect.setOpaque(false);

bt_valider.setBorderPainted(false); 
bt_valider.setContentAreaFilled(false); 
bt_valider.setFocusPainted(false); 
bt_valider.setOpaque(false);

bt_importer.setBorderPainted(false); 
bt_importer.setContentAreaFilled(false); 
bt_importer.setFocusPainted(false); 
bt_importer.setOpaque(false);
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
            java.util.logging.Logger.getLogger(Jobowner_Ajouter_Projet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jobowner_Ajouter_Projet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jobowner_Ajouter_Projet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jobowner_Ajouter_Projet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Path;
    private javax.swing.JButton bt_deconnect;
    private javax.swing.JButton bt_importer;
    private javax.swing.JButton bt_valider;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea ta_desc;
    private javax.swing.JTextField tf_categorie;
    private javax.swing.JTextField tf_duree;
    private javax.swing.JTextField tf_logged;
    private javax.swing.JTextField tf_titre;
    // End of variables declaration//GEN-END:variables
public ImageIcon format =null;
String filename=null;
byte[] image_person=null;
}
