/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.GUI;

import freelancer.dao.classes.CvFreeLancerDAO;
import freelancer.dao.classes.FreelancerDAO;
import freelancer.entities.CvFreelancer;
import freelancer.connection.DataSource;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


/**
 *
 * @author hp
 * 
 */


public class freelancer_mon_cv extends javax.swing.JFrame {
String pseudo;
    /**
     * Creates new form freelancer_mon_cv
     */
 public final Connection connection;
 //connection = DataSource.getInstance().getConnection();
 
public Image ScaledImage (Image img,int w,int h)
{
    BufferedImage resizedIamge = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
  Graphics2D g2=resizedIamge.createGraphics();
  g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
  g2.drawImage(img,0,0,w,h,null);
  g2.dispose();
return resizedIamge;
}


    public freelancer_mon_cv(String pseudo) {
        initComponents();
        setTitle("Mon CV");
setSize(800,600);
setResizable(false);this.setLocationRelativeTo(null);
 connection = DataSource.getInstance().getConnection();
Format formatter = new SimpleDateFormat("yyyy-MM-dd");


        this.pseudo=pseudo;
        tf_pseudo.setText(pseudo);
        CvFreeLancerDAO cvDAO = new CvFreeLancerDAO();
        CvFreelancer a=new CvFreelancer();
        a=cvDAO.DisplayCvFreelancer(pseudo);
        jl_certif.setText(a.getCertification_cv());
        jl_exp.setText(a.getExperience_cv());
        jl_lang.setText(a.getLangue_cv());
       jl_formation.setText(a.getFormation_cv());
        if (a.getDernier_maj_cv()!=null)
        {
        String s = formatter.format(a.getDernier_maj_cv());
        
        jl_dernier_maj.setText(s);
        }
        
        
        

             try {String sql="SELECT photo_cv FROM cvfreelancer cv, membre m WHERE cv.id_cv = m.id and m.pseudo='"+pseudo+"'";
            Statement statement = connection
                    .createStatement();
             ResultSet rs = statement.executeQuery(sql);
               while (rs.next()){
                   System.out.println(rs);
                   
              byte[] imagedata=rs.getBytes("photo_cv");
                format=new ImageIcon(imagedata);
                jl_photo.setIcon(format);
                jl_photo.setSize(200,200);
                
               jl_photo.setHorizontalAlignment(jl_photo.CENTER);
                jl_photo.setVerticalAlignment(jl_photo.CENTER);
                }
            
             }

        
        catch(Exception e)
        {  e.printStackTrace();  }
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcv1 = new javax.swing.JPanel();
        jl_dernier_maj = new javax.swing.JLabel();
        jl_exp = new javax.swing.JLabel();
        jl_lang = new javax.swing.JLabel();
        jl_certif = new javax.swing.JLabel();
        jl_formation = new javax.swing.JLabel();
        jl_photo = new javax.swing.JLabel();
        j_retour = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tf_pseudo = new javax.swing.JTextField();
        jl_langue = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        jcv1.setLayout(null);
        jcv1.add(jl_dernier_maj);
        jl_dernier_maj.setBounds(230, 510, 210, 35);
        jcv1.add(jl_exp);
        jl_exp.setBounds(230, 190, 210, 35);
        jcv1.add(jl_lang);
        jl_lang.setBounds(230, 350, 210, 40);
        jcv1.add(jl_certif);
        jl_certif.setBounds(230, 430, 210, 30);
        jcv1.add(jl_formation);
        jl_formation.setBounds(230, 270, 210, 40);
        jcv1.add(jl_photo);
        jl_photo.setBounds(570, 120, 200, 200);

        j_retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_retourActionPerformed(evt);
            }
        });
        jcv1.add(j_retour);
        j_retour.setBounds(590, 0, 50, 50);

        jLabel2.setText("Interface freelancer");
        jcv1.add(jLabel2);
        jLabel2.setBounds(20, 100, 100, 14);
        jcv1.add(tf_pseudo);
        tf_pseudo.setBounds(120, 100, 80, 20);

        jl_langue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/freelancer/Images/Freelancer_AfficherCV.png"))); // NOI18N
        jl_langue.setText("jLabel6");
        jcv1.add(jl_langue);
        jl_langue.setBounds(-10, 0, 820, 600);

        getContentPane().add(jcv1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
  j_retour.setContentAreaFilled(false);

    }//GEN-LAST:event_formWindowOpened

    private void j_retourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_retourActionPerformed
        JGestionCv j = new JGestionCv(pseudo);
        setVisible(false);
        j.setVisible(true);
    }//GEN-LAST:event_j_retourActionPerformed

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
            java.util.logging.Logger.getLogger(freelancer_mon_cv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(freelancer_mon_cv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(freelancer_mon_cv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(freelancer_mon_cv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              //  new freelancer_mon_cv().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton j_retour;
    private javax.swing.JPanel jcv1;
    private javax.swing.JLabel jl_certif;
    private javax.swing.JLabel jl_dernier_maj;
    private javax.swing.JLabel jl_exp;
    private javax.swing.JLabel jl_formation;
    private javax.swing.JLabel jl_lang;
    private javax.swing.JLabel jl_langue;
    private javax.swing.JLabel jl_photo;
    private javax.swing.JTextField tf_pseudo;
    // End of variables declaration//GEN-END:variables
public ImageIcon format =null;

byte[] image_person=null;

}