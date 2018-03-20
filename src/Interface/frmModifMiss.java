/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import projet.Competence;
import projet.Mission;
import projet.Personnel;

/**
 *
 * @author Choutzi
 */
public class frmModifMiss extends javax.swing.JFrame {

    private Mission mi;

    /**
     * Creates new form frmModifMiss
     */
    public frmModifMiss(int i) {
        initComponents();
        this.mi = frmStart.e.getMission().get(i);
        fillcomp();
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

        jLabelId = new javax.swing.JLabel();
        jTextFieldDesc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSpinnerDatedeb = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListComp = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jButtonComp = new javax.swing.JButton();
        jButtonSuppComp = new javax.swing.JButton();
        jComboBoxComp = new javax.swing.JComboBox<>();
        jButtonAnn = new javax.swing.JButton();
        jButtonVal = new javax.swing.JButton();
        jSpinnerDuree = new javax.swing.JSpinner();
        jLabelStat = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListEq = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelId.setText("TitreIci");

        jLabel2.setText("Description :");

        jSpinnerDatedeb.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1521466297642L), new java.util.Date(1521466297642L), null, java.util.Calendar.DAY_OF_MONTH));

        jLabel3.setText("Durée");

        jListComp.setModel(new DefaultListModel ());
        jScrollPane2.setViewportView(jListComp);

        jLabel5.setText("Compétences :");

        jButtonComp.setText("Ajouter");
        jButtonComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCompActionPerformed(evt);
            }
        });

        jButtonSuppComp.setText("Supprimer");
        jButtonSuppComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuppCompActionPerformed(evt);
            }
        });

        jComboBoxComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCompActionPerformed(evt);
            }
        });

        jButtonAnn.setText("Annuler");
        jButtonAnn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnActionPerformed(evt);
            }
        });

        jButtonVal.setText("Valider");
        jButtonVal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValActionPerformed(evt);
            }
        });

        jSpinnerDuree.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabelStat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelStat.setText("Statut");

        jLabel1.setText("Equipe :");

        jListEq.setModel(new DefaultListModel ());
        jScrollPane1.setViewportView(jListEq);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelId)
                        .addGap(160, 160, 160)
                        .addComponent(jLabelStat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinnerDuree, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinnerDatedeb, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButtonSuppComp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonComp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addComponent(jButtonAnn)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextFieldDesc)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
                                        .addComponent(jComboBoxComp, 0, 613, Short.MAX_VALUE))
                                    .addComponent(jButtonVal))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelId)
                    .addComponent(jSpinnerDatedeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jSpinnerDuree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelStat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxComp, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonComp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSuppComp))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAnn)
                    .addComponent(jButtonVal))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCompActionPerformed

        //Si la copétence n'est pas déjà dans la liste de compétences de la mission on l'ajoute
        if (!((DefaultListModel) jListComp.getModel()).contains(jComboBoxComp.getSelectedItem().toString())) {
            ((DefaultListModel) jListComp.getModel()).addElement(jComboBoxComp.getSelectedItem().toString());
        } else {
            //message warning si l'utilisateur veut ajouter une compétence étant déjà dans la liste de la mission
            JOptionPane jop = new JOptionPane();
            jop.showMessageDialog(null, "Vous avez déjà ajouté cette compétence", "Attention", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCompActionPerformed

    private void jButtonSuppCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuppCompActionPerformed
        //on récupère l'index de la sélection et on vérifie si l'utilisateur a bien sélectionné une compétence
        int i = jListComp.getSelectedIndex();
        if (i != -1) {
            //on met a jour le model en supprimant la compétence sélectionnée
            ((DefaultListModel) jListComp.getModel()).remove(i);
        } else {
            //message warning si aucune sélection
            JOptionPane jop = new JOptionPane();
            jop.showMessageDialog(null, "Veuillez sélectionner une compétence à supprimer", "Attention", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonSuppCompActionPerformed

    private void jComboBoxCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCompActionPerformed

    }//GEN-LAST:event_jComboBoxCompActionPerformed

    private void jButtonAnnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonAnnActionPerformed

    /**
     * Méthode permettant, à la validation de modification, de modifier une mission existante en appuyant sur le bouton valider
     * @param evt 
     */
    private void jButtonValActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValActionPerformed
        //si les champs sont remplis 
        if ((this.jListComp.getModel().getSize() != 0) && ((int) this.jSpinnerDuree.getValue() != 0) && (!this.jTextFieldDesc.getText().isEmpty())) {
            int miss = frmStart.e.getMission().indexOf(mi);
            int com = 0;
            boolean compdeja = false;
            String[] contlist = this.jListComp.getModel().toString().split(",");
            //création de l'arraylist contenant chaque ligne du tableau
            ArrayList<String[]> contenuList = new ArrayList<>();
            //on récupère chaque ligne de la jList des copétences requises
            
            String[] comp;
            //chaque ligne est coupée en colonnes que l'on met dans l'arraylist
            for (int i = 0; i < contlist.length; i++) {
                comp = contlist[i].split(";");
                contenuList.add(comp);
            }
            
            frmStart.e.getMission().get(miss).setDateDeb((Date) this.jSpinnerDatedeb.getValue());
            frmStart.e.getMission().get(miss).setDescriptif(this.jTextFieldDesc.getText());
            frmStart.e.getMission().get(miss).setDuree((int) this.jSpinnerDuree.getValue());
           // pour chaque compétence de la mission à mettre à jours on vérifie si elle existe dans la liste de l'user
            for (Competence c : frmStart.e.getMission().get(miss).getCompetences()) {
                for (String[] s : contenuList) {
                    if (c == frmStart.e.existCompetence(s[0].substring(1)) && !compdeja) {
                        compdeja = true;
                    }
                }
                //si la compétence n'est plus dans la liste choisie par l'user alors on supprime le personnel associé de l'équipe
                if (!compdeja) {
                        if(!frmStart.e.getMission().get(miss).getPersonnels().isEmpty()){
                        frmStart.e.getMission().get(miss).getPersonnels().remove(frmStart.e.getMission().get(miss).getCompetences().indexOf(c)-com);
                        com++;
                        }
                }
                compdeja = false;
            }
            //on vide la liste de compétence de la mission puis on la met à jour
            frmStart.e.getMission().get(miss).getCompetences().clear();
            frmStart.e.getMission().get(miss).modifComp(contenuList, frmStart.e);
            frmStart.f.majMission();
            dispose();
        } else {
            //message warning si aucune sélection
            JOptionPane jop = new JOptionPane();
            jop.showMessageDialog(null, "Veuillez remplir tous les champs (au moins une compétence et au moins 1 jour de durée).", "Attention", JOptionPane.WARNING_MESSAGE);
        }     
    }//GEN-LAST:event_jButtonValActionPerformed

    public void fillcomp() {
        this.jLabelId.setText(this.mi.getNom());
        this.jLabelStat.setText(this.mi.getStat());
        this.jSpinnerDuree.setValue(this.mi.getDuree());
        this.jTextFieldDesc.setText(this.mi.getDesc());
        this.jSpinnerDatedeb.setValue(this.mi.getDatedeb());
        for (Competence c : this.mi.getCompetences()) {
            ((DefaultListModel) jListComp.getModel()).addElement(c.toString());
        }
        //maj de la combobox
        for (int i = 0; i < frmStart.e.getCompetence().size(); i++) {
            jComboBoxComp.addItem(frmStart.e.getCompetence().get(i).toString());
        }
        
        //maj equipe
        for (Personnel p : this.mi.getPersonnels()) {
            if (p.getId()!=-1)
                ((DefaultListModel) jListEq.getModel()).addElement(p.toString());
        }
        
        if (!this.mi.getStat().equals("Préparation") && !this.mi.getStat().equals("Planifiée")) {
            this.jButtonComp.setEnabled(false);
            this.jButtonSuppComp.setEnabled(false);
            this.jComboBoxComp.setEnabled(false);
            this.jListComp.setEnabled(false);
            this.jSpinnerDatedeb.setEnabled(false);
            this.jSpinnerDuree.setEnabled(false);
            this.jTextFieldDesc.setEnabled(false);
            this.jButtonVal.setEnabled(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnn;
    private javax.swing.JButton jButtonComp;
    private javax.swing.JButton jButtonSuppComp;
    private javax.swing.JButton jButtonVal;
    private javax.swing.JComboBox<String> jComboBoxComp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelStat;
    private javax.swing.JList<String> jListComp;
    private javax.swing.JList<String> jListEq;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinnerDatedeb;
    private javax.swing.JSpinner jSpinnerDuree;
    private javax.swing.JTextField jTextFieldDesc;
    // End of variables declaration//GEN-END:variables
}
