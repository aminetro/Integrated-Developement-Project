/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.GUI;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import freelancer.dao.classes.CvFreeLancerDAO;
import freelancer.dao.classes.FreelancerDAO;
import freelancer.entities.CvFreelancer;
import freelancer.connection.DataSource;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.opencv.core.Core;

/**
 *
 * @author hp
 */
public class freelancer_ajoutercv extends javax.swing.JFrame {
String pseudo;
public String PathImage;
 public final Connection connection;
   private Icon icon;
 

    /**
     * Creates new form ajoutercv
     */
    public freelancer_ajoutercv(String pseudo) {
        initComponents();
        setTitle("Ajout D'une CV");
setSize(800,600);
setResizable(false);
connection = DataSource.getInstance().getConnection();
  this.pseudo=pseudo;
        tf_pseudo.setText(pseudo);this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jB_ajouter = new javax.swing.JButton();
        tf_exp = new javax.swing.JTextField();
        tf_formation = new javax.swing.JTextField();
        tf_lang = new javax.swing.JTextField();
        tf_certif = new javax.swing.JTextField();
        jb_importer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Path = new javax.swing.JTextField();
        jb_capturer = new javax.swing.JButton();
        tf_pseudo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        bt_retour = new javax.swing.JButton();
        bt_quitter = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jB_ajouter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jB_ajouterMouseClicked(evt);
            }
        });
        jB_ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_ajouterActionPerformed(evt);
            }
        });
        getContentPane().add(jB_ajouter);
        jB_ajouter.setBounds(600, 490, 180, 50);
        getContentPane().add(tf_exp);
        tf_exp.setBounds(260, 190, 230, 40);
        getContentPane().add(tf_formation);
        tf_formation.setBounds(260, 280, 230, 40);

        tf_lang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_langActionPerformed(evt);
            }
        });
        getContentPane().add(tf_lang);
        tf_lang.setBounds(260, 370, 230, 40);
        getContentPane().add(tf_certif);
        tf_certif.setBounds(260, 450, 230, 40);

        jb_importer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_importerActionPerformed(evt);
            }
        });
        getContentPane().add(jb_importer);
        jb_importer.setBounds(600, 350, 180, 40);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(580, 60, 200, 200);
        getContentPane().add(Path);
        Path.setBounds(590, 420, 200, 40);

        jb_capturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_capturerActionPerformed(evt);
            }
        });
        getContentPane().add(jb_capturer);
        jb_capturer.setBounds(600, 260, 170, 40);
        getContentPane().add(tf_pseudo);
        tf_pseudo.setBounds(130, 100, 90, 20);

        jLabel3.setText("Interface freelancer");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 100, 110, 20);

        bt_retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_retourActionPerformed(evt);
            }
        });
        getContentPane().add(bt_retour);
        bt_retour.setBounds(590, 0, 60, 50);

        bt_quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_quitterActionPerformed(evt);
            }
        });
        getContentPane().add(bt_quitter);
        bt_quitter.setBounds(670, 0, 130, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/freelancer/Images/Freelancer_AjouterCV.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_ajouterActionPerformed
 
        Date d = new Date();
        java.sql.Date sqlDate = new java.sql.Date(d.getTime());
        //sqlDate,tf_exp.getText(),tf_lang.getText(),tf_certif.getText()
        
              if(tf_exp.getText().length() ==0)  {
   JOptionPane.showMessageDialog(null, "Veuillez remplir le champ Experience !! ","Message",JOptionPane.ERROR_MESSAGE);
   }else 
 if(tf_lang.getText().length() ==0)  {
   JOptionPane.showMessageDialog(null, "Veuillez remplir le champ Langue !!","Message",JOptionPane.ERROR_MESSAGE);
  }else
 if(tf_certif.getText().length() ==0)  {
   JOptionPane.showMessageDialog(null, "Veuillez remplir le champ Certification !!","Message",JOptionPane.ERROR_MESSAGE);
  }else

if(tf_formation.getText().length() ==0)  {
   JOptionPane.showMessageDialog(null, "Veuillez remplir le champ Formation !!","Message",JOptionPane.ERROR_MESSAGE);
  }else
{
        CvFreelancer  ad = new CvFreelancer();
        ad.setCertification_cv(tf_certif.getText());
        ad.setExperience_cv(tf_exp.getText());
        ad.setLangue_cv(tf_lang.getText());
        ad.setDernier_maj_cv(sqlDate);
        ad.setFormation_cv(tf_formation.getText());
        
        
        
    CvFreeLancerDAO adDAO = new CvFreeLancerDAO();
    
      //adDAO.insertCvFreelancer(ad,tf_pseudo.getText(),PathImage);
            adDAO.insertCvFreelancer(ad,tf_pseudo.getText());

}       
              try { 
           String requete2="UPDATE cvfreelancer cv , membre m SET `photo_cv`=? WHERE cv.id_cv = m.id and m.pseudo='"+pseudo+"'";
                  
       PreparedStatement ps = connection.prepareStatement(requete2);
       ps.setBytes(1,image_person);
           ps.executeUpdate();
           
       
   
    } catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
                              System.out.println("********************!!**********exxxx************************************");

    }
      
   
        JGestionCv a1 = new JGestionCv(pseudo);
        setVisible(false);//Masquer la JFrame actuelle
        a1.setVisible(true);        // TODO add your handling code here:

    }//GEN-LAST:event_jB_ajouterActionPerformed

    private void jB_ajouterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_ajouterMouseClicked
      
    }//GEN-LAST:event_jB_ajouterMouseClicked

    private void tf_langActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_langActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_langActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
        jb_importer.setBorderPainted(false); 
jb_importer.setContentAreaFilled(false); 
jb_importer.setFocusPainted(false); 
jb_importer.setOpaque(false);

 bt_quitter.setBorderPainted(false); 
bt_quitter.setContentAreaFilled(false); 
bt_quitter.setFocusPainted(false); 
bt_quitter.setOpaque(false);

 bt_retour.setBorderPainted(false); 
bt_retour.setContentAreaFilled(false); 
bt_retour.setFocusPainted(false); 
bt_retour.setOpaque(false);


   jb_capturer.setBorderPainted(false); 
jb_capturer.setContentAreaFilled(false); 
jb_capturer.setFocusPainted(false); 
jb_capturer.setOpaque(false);


         jB_ajouter.setBorderPainted(false); 
jB_ajouter.setContentAreaFilled(false); 
jB_ajouter.setFocusPainted(false); 
jB_ajouter.setOpaque(false);
    }//GEN-LAST:event_formWindowOpened

    private void jb_importerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_importerActionPerformed
    
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
        
        
        
        
    }//GEN-LAST:event_jb_importerActionPerformed

    private void jb_capturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_capturerActionPerformed
        SnaPshot2 p= new SnaPshot2();
        p.setVisible(true);
    }//GEN-LAST:event_jb_capturerActionPerformed

    private void bt_retourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_retourActionPerformed
        JGestionCv j = new JGestionCv(pseudo);
        setVisible(false);
        j.setVisible(true);
    }//GEN-LAST:event_bt_retourActionPerformed

    private void bt_quitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_quitterActionPerformed
       Jhome j = new Jhome();
        setVisible(false);
        j.setVisible(true);
    }//GEN-LAST:event_bt_quitterActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
  // int returnVal = jFileChooser1.showSaveDialog(this);       
System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
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
            java.util.logging.Logger.getLogger(freelancer_ajoutercv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(freelancer_ajoutercv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(freelancer_ajoutercv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(freelancer_ajoutercv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            /*  freelancer_ajoutercv f = new freelancer_ajoutercv("test");
              f.setVisible(true);*/
                //new freelancer_ajoutercv().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Path;
    private javax.swing.JButton bt_quitter;
    private javax.swing.JButton bt_retour;
    private javax.swing.JButton jB_ajouter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jb_capturer;
    private javax.swing.JButton jb_importer;
    private javax.swing.JTextField tf_certif;
    private javax.swing.JTextField tf_exp;
    private javax.swing.JTextField tf_formation;
    private javax.swing.JTextField tf_lang;
    private javax.swing.JTextField tf_pseudo;
    // End of variables declaration//GEN-END:variables


public ImageIcon format =null;
String filename=null;
byte[] image_person=null;

}
