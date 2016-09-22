/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.GUI;

import freelancer.connection.DataSource;
import freelancer.dao.classes.FreelancerDAO;
import freelancer.dao.classes.MembreDAO;
import freelancer.entities.Freelancer;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class freelancer_mon_profil extends javax.swing.JFrame {
String pseudo;
    public final Connection connection;

    /**
     * Creates new form freelancer_mon_profil
     */
    public freelancer_mon_profil(String pseudo) {
        initComponents();
         connection = DataSource.getInstance().getConnection();

           setTitle("Mon Profil");
setSize(800,600);
setResizable(false);this.setLocationRelativeTo(null);
        this.pseudo=pseudo;
        tf_pseudo.setText(pseudo);    
        FreelancerDAO cvDAO = new FreelancerDAO();
        Freelancer a =new Freelancer();
        a=cvDAO.DisplaypseudoFreelancer(pseudo);
        
       
         m_nom.setText(a.getNom());
        m_prenom.setText(a.getPrenom());
         m_pays.setText(a.getPays());
        m_ville.setText(a.getVille());
         m_pseudo.setText(a.getPseudo());
         m_password.setText(a.getPassword());
         m_mail.setText(a.getMail());
        m_dispo.setSelectedItem(a.getDisponibilite());
        /*************************
        File file = new File("C:\\profile.jpg");
        
        String filename=file.getAbsolutePath();
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
            format=new ImageIcon(buf);
                
                
                
                jl_photo.setIcon(format);
                jl_photo.setSize(200,200);
                
                
               jl_photo.setHorizontalAlignment(jl_photo.CENTER);
         
               
                jl_photo.setVerticalAlignment(jl_photo.CENTER);
              
        }
        catch(Exception e )
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        *************************/
        
        
        
        
        
        try {
            MembreDAO m=new MembreDAO();
            String sql="SELECT photo FROM membre WHERE id="+a.getId();
            
           Statement statement = connection
                    .createStatement();
             ResultSet rs = statement.executeQuery(sql);
             System.out.println("sd");
               while (rs.next()){
 
                   System.out.println(rs+"popopopopo");
                   
              byte[] imagedata=rs.getBytes("photo");
                format=new ImageIcon(imagedata);
                
                
                
                jl_photo.setIcon(format);
                jl_photo.setSize(200,200);
                
                
               jl_photo.setHorizontalAlignment(jl_photo.CENTER);
         
               
                jl_photo.setVerticalAlignment(jl_photo.CENTER);
              
                }
        } 
        catch(Exception e)
        {  e.printStackTrace();  }
        
        
        
        if(m_nom.getText().length() ==0)  {
   JOptionPane.showMessageDialog(null, "Veuillez remplir le champ Nom !!","Message",JOptionPane.ERROR_MESSAGE);
   }else 
 if(m_prenom.getText().length() ==0)  {
   JOptionPane.showMessageDialog(null, "Veuillez remplir le champ Prenom !!","Message",JOptionPane.ERROR_MESSAGE);
  }else
 if(m_pays.getText().length() ==0)  {
   JOptionPane.showMessageDialog(null, "Veuillez remplir le champ Pays !!","Message",JOptionPane.ERROR_MESSAGE);
  }else

if(m_ville.getText().length() ==0)  {
   JOptionPane.showMessageDialog(null, "Veuillez remplir le champ Ville !!","Message",JOptionPane.ERROR_MESSAGE);
  }else

if(tf_pseudo.getText().length() ==0)  {
   JOptionPane.showMessageDialog(null, "Veuillez remplir le champ Pseudo !!","Message",JOptionPane.ERROR_MESSAGE);
 }else
if(m_mail.getText().length() ==0)  {
   JOptionPane.showMessageDialog(null, "Veuillez remplir le champ Mail !!","Message",JOptionPane.ERROR_MESSAGE);
}else 

if(m_password.getText().length() ==0)  {
   JOptionPane.showMessageDialog(null, "Veuillez remplir le champ Mot de passe !!","Message",JOptionPane.ERROR_MESSAGE);
  
}else
 if(m_mail.getText().matches("(?:\\w|[\\-_])+(?:\\.(?:\\w|[\\-_])+)*\\@(?:\\w|[\\-_])+(?:\\.(?:\\w|[\\-_])+)+" )) 
 {
       
 }
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_photo = new javax.swing.JLabel();
        a_nom = new javax.swing.JLabel();
        a_ville = new javax.swing.JLabel();
        a_pseudo = new javax.swing.JLabel();
        a_password = new javax.swing.JLabel();
        m_pseudo = new javax.swing.JTextField();
        m_nom = new javax.swing.JTextField();
        m_prenom = new javax.swing.JTextField();
        m_pays = new javax.swing.JTextField();
        m_ville = new javax.swing.JTextField();
        m_password = new javax.swing.JTextField();
        m_mail = new javax.swing.JTextField();
        Path = new javax.swing.JTextField();
        bt_importer = new javax.swing.JButton();
        j_retour = new javax.swing.JButton();
        bt_modifier1 = new javax.swing.JButton();
        jb_capturer = new javax.swing.JButton();
        m_dispo = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tf_pseudo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jl_photo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/freelancer/Images/profileDefault.jpg"))); // NOI18N
        getContentPane().add(jl_photo);
        jl_photo.setBounds(580, 120, 190, 190);
        getContentPane().add(a_nom);
        a_nom.setBounds(170, 140, 100, 20);
        getContentPane().add(a_ville);
        a_ville.setBounds(172, 280, 90, 26);
        getContentPane().add(a_pseudo);
        a_pseudo.setBounds(420, 140, 90, 20);
        getContentPane().add(a_password);
        a_password.setBounds(420, 180, 100, 27);
        getContentPane().add(m_pseudo);
        m_pseudo.setBounds(410, 210, 131, 30);
        getContentPane().add(m_nom);
        m_nom.setBounds(140, 210, 131, 30);
        getContentPane().add(m_prenom);
        m_prenom.setBounds(140, 310, 131, 30);
        getContentPane().add(m_pays);
        m_pays.setBounds(140, 400, 131, 30);
        getContentPane().add(m_ville);
        m_ville.setBounds(140, 490, 131, 30);
        getContentPane().add(m_password);
        m_password.setBounds(410, 310, 130, 30);
        getContentPane().add(m_mail);
        m_mail.setBounds(410, 400, 130, 30);
        getContentPane().add(Path);
        Path.setBounds(630, 320, 110, 30);

        bt_importer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_importerActionPerformed(evt);
            }
        });
        getContentPane().add(bt_importer);
        bt_importer.setBounds(610, 350, 160, 30);

        j_retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_retourActionPerformed(evt);
            }
        });
        getContentPane().add(j_retour);
        j_retour.setBounds(590, 10, 50, 40);

        bt_modifier1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_modifier1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt_modifier1);
        bt_modifier1.setBounds(600, 500, 160, 30);

        jb_capturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_capturerActionPerformed(evt);
            }
        });
        getContentPane().add(jb_capturer);
        jb_capturer.setBounds(610, 420, 160, 40);

        m_dispo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "disponible", "indisponible", "occupe" }));
        m_dispo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_dispoActionPerformed(evt);
            }
        });
        getContentPane().add(m_dispo);
        m_dispo.setBounds(420, 490, 130, 30);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(660, 10, 120, 40);

        jLabel1.setText("Interface freelancer");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 100, 110, 14);

        tf_pseudo.setEditable(false);
        getContentPane().add(tf_pseudo);
        tf_pseudo.setBounds(140, 100, 70, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/freelancer/Images/Freelancer_MonProfil.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-10, 0, 820, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_modifier1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_modifier1ActionPerformed
       
        Freelancer  ad = new Freelancer(m_nom.getText(),m_prenom.getText(), m_pays.getText(),m_ville.getText(),
                m_pseudo.getText(),m_password.getText(),m_mail.getText(),(String)m_dispo.getSelectedItem());

        FreelancerDAO fl=new FreelancerDAO();
        fl.updateFreelancer(ad, tf_pseudo.getText());
        try {                   
           String requete2="UPDATE membre SET `photo`=? WHERE pseudo='"+m_pseudo.getText()+"'";
             System.out.println(tf_pseudo.getText());     
       PreparedStatement ps = connection.prepareStatement(requete2);
       ps.setBytes(1,image_person);
           ps.executeUpdate();   
    } catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
    }
        freelancer_mon_profil jj= new freelancer_mon_profil(m_pseudo.getText());
        setVisible(false);
        jj.setVisible(true);

    }//GEN-LAST:event_bt_modifier1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

jButton1.setBorderPainted(false); 
jButton1.setContentAreaFilled(false); 
jButton1.setFocusPainted(false); 
jButton1.setOpaque(false);
         
          bt_importer.setBorderPainted(false); 
bt_importer.setContentAreaFilled(false); 
bt_importer.setFocusPainted(false); 
bt_importer.setOpaque(false);
         


bt_modifier1.setBorderPainted(false); 
bt_modifier1.setContentAreaFilled(false); 
bt_modifier1.setFocusPainted(false); 
bt_modifier1.setOpaque(false);
         

j_retour.setBorderPainted(false); 
j_retour.setContentAreaFilled(false); 
j_retour.setFocusPainted(false); 
j_retour.setOpaque(false);

jb_capturer.setBorderPainted(false); 
jb_capturer.setContentAreaFilled(false); 
jb_capturer.setFocusPainted(false); 
jb_capturer.setOpaque(false);
    }//GEN-LAST:event_formWindowOpened

    private void j_retourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_retourActionPerformed
        JFreelancerProfile j = new JFreelancerProfile(pseudo);
        setVisible(false);
        j.setVisible(true);
    }//GEN-LAST:event_j_retourActionPerformed

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

    private void jb_capturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_capturerActionPerformed
        SnaPshot2 p= new SnaPshot2();
        p.setVisible(true);
    }//GEN-LAST:event_jb_capturerActionPerformed

    private void m_dispoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_dispoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_m_dispoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Jhome j = new Jhome();
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
            java.util.logging.Logger.getLogger(freelancer_mon_profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(freelancer_mon_profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(freelancer_mon_profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(freelancer_mon_profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new freelancer_mon_profil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Path;
    private javax.swing.JLabel a_nom;
    private javax.swing.JLabel a_password;
    private javax.swing.JLabel a_pseudo;
    private javax.swing.JLabel a_ville;
    private javax.swing.JButton bt_importer;
    private javax.swing.JButton bt_modifier1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton j_retour;
    private javax.swing.JButton jb_capturer;
    private javax.swing.JLabel jl_photo;
    private javax.swing.JComboBox m_dispo;
    private javax.swing.JTextField m_mail;
    private javax.swing.JTextField m_nom;
    private javax.swing.JTextField m_password;
    private javax.swing.JTextField m_pays;
    private javax.swing.JTextField m_prenom;
    private javax.swing.JTextField m_pseudo;
    private javax.swing.JTextField m_ville;
    private javax.swing.JTextField tf_pseudo;
    // End of variables declaration//GEN-END:variables

public ImageIcon format =null;

byte[] image_person=null;

}
