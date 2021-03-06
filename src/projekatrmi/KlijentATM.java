/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekatrmi;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Asija
 */
public class KlijentATM extends javax.swing.JFrame {

    /**
     * Creates new form KlijentATM
     */
    Interfejs rmiServer;
    Korisnik k;
    public final static int port=1190;   
    public void connect() throws NotBoundException{
     System.out.println("kod klijenta sam");
     String hostname = "localhost";
       
        try{
            Registry r = LocateRegistry.getRegistry(2000);
             rmiServer = (Interfejs)r.lookup("BankomatMetode");
             k = rmiServer.getKorisnik();
             this.sendingData();
        }
        // end try
        catch(IOException ex){
                System.err.println(ex);
                System.exit(0);
        } catch(NotBoundException ex){
                System.err.println(ex);
        }
    }
     private void sendingData()
    {
        try
        {
            this.lblIme.setText(k.getIme());
            this.lblPrezime.setText(k.getPrezime());
            this.lblBrojRacuna.setText(k.getBrRacuna());
            String s=(String.valueOf(k.getStanje()));
            this.lblStanje.setText(s);
          } 
        catch(Exception e)
        {
            System.out.println(e.getMessage());
           
        }
    }
     public void uplata() throws RemoteException
     {
        int pare=(Integer.parseInt(this.txtUplati.getText()));
        k.setStanje(rmiServer.Uplati(k, pare));
        this.lblStanje.setText((String.valueOf(k.getStanje())));
        this.pnlUplata.setVisible(false);
     }
     public void isplata() throws RemoteException
     {
        int p=(Integer.parseInt(this.txtIsplati.getText()));
        k.setStanje(rmiServer.Isplati(k, p));
        this.lblStanje.setText((String.valueOf(k.getStanje())));
        this.pnlIsplata.setVisible(false);
     }
     
    
    public KlijentATM() throws NotBoundException {
        initComponents();
        this.pnlIsplata.setVisible(false);
        this.pnlUplata.setVisible(false);
        this.connect();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblKorisnik = new javax.swing.JLabel();
        lblBrR = new javax.swing.JLabel();
        lblS = new javax.swing.JLabel();
        lblIme = new javax.swing.JLabel();
        lblPrezime = new javax.swing.JLabel();
        lblBrojRacuna = new javax.swing.JLabel();
        lblStanje = new javax.swing.JLabel();
        btnUplati = new javax.swing.JButton();
        btnIsplati = new javax.swing.JButton();
        lblPoruka = new javax.swing.JLabel();
        pnlUplata = new javax.swing.JPanel();
        txtUplati = new javax.swing.JTextField();
        btnUplatiSave = new javax.swing.JButton();
        pnlIsplata = new javax.swing.JPanel();
        txtIsplati = new javax.swing.JTextField();
        btnIsplatiSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblKorisnik.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblKorisnik.setText("Korisnik:");
        getContentPane().add(lblKorisnik, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        lblBrR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblBrR.setText("Broj racuna:");
        getContentPane().add(lblBrR, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        lblS.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblS.setText("Stanje:");
        getContentPane().add(lblS, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        lblIme.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(lblIme, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, -1));

        lblPrezime.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(lblPrezime, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, -1));

        lblBrojRacuna.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(lblBrojRacuna, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, -1));

        lblStanje.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(lblStanje, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        btnUplati.setText("Uplati");
        btnUplati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUplatiActionPerformed(evt);
            }
        });
        getContentPane().add(btnUplati, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        btnIsplati.setText("Isplati");
        btnIsplati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIsplatiActionPerformed(evt);
            }
        });
        getContentPane().add(btnIsplati, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));

        lblPoruka.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(lblPoruka, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        pnlUplata.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlUplata.add(txtUplati, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, -1));

        btnUplatiSave.setText("Sacuvaj");
        btnUplatiSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUplatiSaveActionPerformed(evt);
            }
        });
        pnlUplata.add(btnUplatiSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        getContentPane().add(pnlUplata, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 130, 120));

        pnlIsplata.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlIsplata.add(txtIsplati, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 13, 90, -1));

        btnIsplatiSave.setText("Sacuvaj");
        btnIsplatiSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIsplatiSaveActionPerformed(evt);
            }
        });
        pnlIsplata.add(btnIsplatiSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        getContentPane().add(pnlIsplata, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 110, 110));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUplatiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUplatiActionPerformed
        this.pnlUplata.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUplatiActionPerformed

    private void btnUplatiSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUplatiSaveActionPerformed
        try {
            this.uplata();
            // TODO add your handling code here:
        } catch (RemoteException ex) {
            Logger.getLogger(KlijentATM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUplatiSaveActionPerformed

    private void btnIsplatiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIsplatiActionPerformed
        this.pnlIsplata.setVisible(true);
    }//GEN-LAST:event_btnIsplatiActionPerformed

    private void btnIsplatiSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIsplatiSaveActionPerformed
        try {
            this.isplata();
            // TODO add your handling code here:
        } catch (RemoteException ex) {
            Logger.getLogger(KlijentATM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIsplatiSaveActionPerformed

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
            java.util.logging.Logger.getLogger(KlijentATM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KlijentATM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KlijentATM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KlijentATM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new KlijentATM().setVisible(true);
                } catch (NotBoundException ex) {
                    Logger.getLogger(KlijentATM.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIsplati;
    private javax.swing.JButton btnIsplatiSave;
    private javax.swing.JButton btnUplati;
    private javax.swing.JButton btnUplatiSave;
    private javax.swing.JLabel lblBrR;
    private javax.swing.JLabel lblBrojRacuna;
    private javax.swing.JLabel lblIme;
    private javax.swing.JLabel lblKorisnik;
    private javax.swing.JLabel lblPoruka;
    private javax.swing.JLabel lblPrezime;
    private javax.swing.JLabel lblS;
    private javax.swing.JLabel lblStanje;
    private javax.swing.JPanel pnlIsplata;
    private javax.swing.JPanel pnlUplata;
    private javax.swing.JTextField txtIsplati;
    private javax.swing.JTextField txtUplati;
    // End of variables declaration//GEN-END:variables
}
