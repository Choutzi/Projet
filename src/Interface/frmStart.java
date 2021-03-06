/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import projet.Entreprise;
import projet.Mission;
import projet.Personnel;
import javax.swing.table.DefaultTableModel;
import projet.Competence;
import projet.exceptions.affecterPersException;

/**
 *
 * @author efgde
 */
public class frmStart extends javax.swing.JFrame {

    /**
     * Creates new form frmStart
     */
    protected static Entreprise e = new Entreprise();
    protected static frmStart f;

    public frmStart() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.majMission();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonAjout = new javax.swing.JButton();
        jButtonSupp = new javax.swing.JButton();
        jButtonGestionEquipe = new javax.swing.JButton();
        jButtonConge = new javax.swing.JButton();
        jButtonModifPers = new javax.swing.JButton();
        jButtonModifMission = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jSpinner1 = new javax.swing.JSpinner();
        jMenuBar1 = new javax.swing.JMenuBar();
        Enregistrer = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion Entrerpise");

        jLabel1.setText("Jour");

        jButtonAjout.setText("Ajouter");
        jButtonAjout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjoutActionPerformed(evt);
            }
        });

        jButtonSupp.setText("Supprimer");
        jButtonSupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuppActionPerformed(evt);
            }
        });

        jButtonGestionEquipe.setText("Gestion de l'équipe Mission");
        jButtonGestionEquipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestionEquipeActionPerformed(evt);
            }
        });

        jButtonConge.setText("Ajouter Congé");
        jButtonConge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCongeActionPerformed(evt);
            }
        });

        jButtonModifPers.setText("Modifier");
        jButtonModifPers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifPersActionPerformed(evt);
            }
        });

        jButtonModifMission.setText("Modifier");
        jButtonModifMission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifMissionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAjout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonModifPers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonModifMission)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSupp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonGestionEquipe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonConge)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(jButtonAjout)
                .addComponent(jButtonSupp)
                .addComponent(jButtonGestionEquipe)
                .addComponent(jButtonConge)
                .addComponent(jButtonModifPers)
                .addComponent(jButtonModifMission))
        );

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jScrollPane2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jScrollPane2PropertyChange(evt);
            }
        });

        DefaultTableModel model2 = new DefaultTableModel();
        model2.addColumn("Titre");
        model2.addColumn("Description");
        model2.addColumn("Date début");
        model2.addColumn("Durée");
        model2.addColumn("Statut");
        model2.addColumn("Nombre personnel");
        jTable2.setModel(model2);
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jTable2);

        jTabbedPane1.addTab("Mission", jScrollPane2);

        DefaultTableModel model1 = new DefaultTableModel();
        model1.addColumn("Prenom");
        model1.addColumn("Nom");
        model1.addColumn("Date Entrée");
        model1.addColumn("ID");
        for (Personnel p : e.getPersonnel()) {
            String[] line = p.toString().split(";");
            model1.addRow(line);
        }
        jTable1.setModel(model1);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane1.addTab("Personnel", jScrollPane1);

        DefaultTableModel model3 = new DefaultTableModel();
        model3.addColumn("ID");
        model3.addColumn("Description Anglaise");
        model3.addColumn("Description Française");
        for (Competence c : e.getCompetence()) {
            String[] line = c.toString().split(";");
            model3.addRow(line);
        }
        jTable3.setModel(model3);
        jTable3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(jTable3);

        jTabbedPane1.addTab("Compétence", jScrollPane3);

        jSpinner1.setModel(new javax.swing.SpinnerDateModel());
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 113, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        Enregistrer.setText("Enregistrer");
        Enregistrer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EnregistrerMouseClicked(evt);
            }
        });
        jMenuBar1.add(Enregistrer);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    private void EnregistrerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EnregistrerMouseClicked
        e.sauvegarde();
        JOptionPane.showMessageDialog(null, "Les modification ont bien été enregistrées", "Enregistrer", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_EnregistrerMouseClicked

    
    /**
     * Méthode mettant à jour le statut des mission suivant le jour courant (spinner) la méthode fait aussi la gestion des équipes de la mission suivant les compétences et les occupation du personnel
     * @param evt 
     */
    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        Date day = new Date();
        Date spinner = (Date) jSpinner1.getValue();
        boolean estPris = false;
        if (spinner.before(day)) {
            jSpinner1.setValue(day);
        }
        for (Mission m : e.getMission()){
            for (Personnel p : m.getPersonnels()){
                if(p.etreOccupe(m.getDatedeb(), m.getFin()))
                    try {
                        m.getPersonnels().set(m.getPersonnels().indexOf(p), new Personnel(new String[]{"Vide", "Vide", "00/00/00", "-1"}));
                } catch (ParseException ex) {
                    Logger.getLogger(frmStart.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(m.getFin().before(spinner)){
                m.setStat("Terminée");
            }else if(m.getDatedeb().before(spinner)){
                if(m.getSizeEquipe()==m.getTaille()){ 
                    m.setStat("EnCours");
                }else{
                    for(int i=0;i<m.getPersonnels().size();i++){
                        if (m.getPersonnels().get(i).getId()==-1){
                            for(Personnel p : frmStart.e.getPersonnel()){
                                if(p.avoirComp(m.getCompetences().get(i)) && !p.etreOccupe(m.getDatedeb(), m.getFin()) && !estPris){
                                    m.getPersonnels().set(i, p);
                                    estPris=true;
                                    try {
                                        m.getPersonnels().get(i).ajouterMission(m);
                                    } catch (affecterPersException ex) {
                                        Logger.getLogger(frmStart.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
                            estPris=false;
                        }
                    }
                    m.setStat("EnCours");
                }
            }
        }
        this.majMission();
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jButtonCongeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCongeActionPerformed
        frmAddConge frm = new frmAddConge();
        frm.setVisible(true);
    }//GEN-LAST:event_jButtonCongeActionPerformed

    private void jButtonGestionEquipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGestionEquipeActionPerformed
        int i=jTable2.getSelectedRow();
        if (i!=-1){
            //on lance la gestion d'équipe si l'utilisateur a bien sélectionné une mission dans la liste
            new frmEquipeMission(i).setVisible(true);
        }else{
            //message warning si aucune sélection
            JOptionPane jop = new JOptionPane();
            jop.showMessageDialog(null, "Veuillez sélectionner une mission pour gérer son équipe", "Attention", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonGestionEquipeActionPerformed

    private void jButtonSuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuppActionPerformed
        //on récupère l'index de la sélection et on vérifie si l'utilisateur a bien sélectionné une compétence
        int i=jTable2.getSelectedRow();
        if (i!=-1){
            for(Personnel p : e.getMission().get(i).getPersonnels()){
                p.removeMission(e.getMission().get(i));
            }
            //on met a jour la liste des mission en supprimant la mission sélectionnée
            e.getMission().remove(i);
            majMission();
        }else{
            //message warning si aucune sélection
            JOptionPane jop = new JOptionPane();
            jop.showMessageDialog(null, "Veuillez sélectionner une mission à supprimer", "Attention", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonSuppActionPerformed

    private void jButtonAjoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjoutActionPerformed
        new frmAddMission().setVisible(true);
    }//GEN-LAST:event_jButtonAjoutActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        int select = this.jTabbedPane1.getSelectedIndex();
        switch(select){
            case 1 : 
                this.jPanel5.setVisible(true);
                this.jButtonAjout.setVisible(false);
                this.jButtonModifPers.setVisible(true);
                this.jButtonModifMission.setVisible(false);
                this.jButtonConge.setVisible(true);
                this.jButtonSupp.setVisible(false);
                this.jButtonGestionEquipe.setVisible(false);
                break;
            case 0 :
                this.jPanel5.setVisible(true);
                this.jButtonAjout.setVisible(true);
                this.jButtonModifPers.setVisible(false);
                this.jButtonModifMission.setVisible(true);
                this.jButtonConge.setVisible(false);
                this.jButtonSupp.setVisible(true);
                this.jButtonGestionEquipe.setVisible(true);
                break;
            case 2 :
                this.jPanel5.setVisible(false);
                break;
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jButtonModifPersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifPersActionPerformed
        int idPerso = jTable1.getSelectedRow();
        System.out.println(idPerso);
        if (idPerso!=-1){
            //on lance la gestion d'équipe si l'utilisateur a bien sélectionné une mission dans la liste
            new frmModifPers(idPerso).setVisible(true);
        }else{
            //message warning si aucune sélection
            JOptionPane jop = new JOptionPane();
            jop.showMessageDialog(null, "Veuillez sélectionner une mission pour gérer son équipe", "Attention", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonModifPersActionPerformed

    private void jButtonModifMissActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifMissActionPerformed
        
    }//GEN-LAST:event_jButtonModifMissActionPerformed

    private void jScrollPane2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jScrollPane2PropertyChange

    }//GEN-LAST:event_jScrollPane2PropertyChange

    private void jButtonModifMissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifMissionActionPerformed
        int i=jTable2.getSelectedRow();
        if (i!=-1){
            //on lance la modification de la mission si l'utilisateur a bien sélectionné une mission dans la liste
            new frmModifMiss(i).setVisible(true);
        }else{
            //message warning si aucune sélection
            JOptionPane jop = new JOptionPane();
            jop.showMessageDialog(null, "Veuillez sélectionner une mission à modifier", "Attention", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonModifMissionActionPerformed


    public frmStart getFrm() {
        return f;
    }

    /**
     * mise à jour de la table mission : on vide la table puis on relit la liste des mission de l'entreprise
     */
    public void majMission() {
        if (((DefaultTableModel) jTable2.getModel()).getRowCount() > 0) {
            for (int i = ((DefaultTableModel) jTable2.getModel()).getRowCount() - 1; i > -1; i--) {
                ((DefaultTableModel) jTable2.getModel()).removeRow(i);
            }
        }
        for (Mission m : e.getMission()) {
            String[] line = m.toString().split(";");
            ((DefaultTableModel) jTable2.getModel()).addRow(line);
            ((DefaultTableModel) jTable2.getModel()).setValueAt(m.getSizeEquipe()+"/"+m.getTaille(), ((DefaultTableModel) jTable2.getModel()).getRowCount() - 1, 5);
        }
    }
    
    /**
     * mise à jour de la table personnel : on vide la table puis on relit la liste du personnel de l'entreprise
     */
    public void majPersonnel() {
        if (((DefaultTableModel) jTable2.getModel()).getRowCount() > 0) {
            for (int i = ((DefaultTableModel) jTable2.getModel()).getRowCount() - 1; i > -1; i--) {
                ((DefaultTableModel) jTable2.getModel()).removeRow(i);
            }
        }
        for (Mission m : e.getMission()) {
            String[] line = m.toString().split(";");
            ((DefaultTableModel) jTable2.getModel()).addRow(line);
            ((DefaultTableModel) jTable2.getModel()).setValueAt(m.getTaille(), ((DefaultTableModel) jTable2.getModel()).getRowCount() - 1, 5);
        }
    }
    
    /**
     * Méthode permettant d'obtenir la date courante du frmStart
     * @return Date
     */
    public Date getDate(){
        return (Date)this.jSpinner1.getValue();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ParseException {
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
            java.util.logging.Logger.getLogger(frmStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        e.initEntrprise();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                f = new frmStart();
                f.setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Enregistrer;
    private javax.swing.JButton jButtonAjout;
    private javax.swing.JButton jButtonConge;
    private javax.swing.JButton jButtonGestionEquipe;
    private javax.swing.JButton jButtonModifMission;
    private javax.swing.JButton jButtonModifPers;
    private javax.swing.JButton jButtonSupp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
