package com.CarlosMestas.Swaps;

import java.awt.Dimension;
import java.lang.reflect.Field;
import java.util.Random;
import java.util.Stack;

/**
 * @author Carlos Alberto Mestas Escarcena
 */
public class BurbujaFrm extends javax.swing.JFrame {
    
    public static int maxRandom     =   360;
    public static int minRandom     =   1;
    public static int cantNumbers   =   315;
    
    public BurbujaFrm() {
        initComponents();
        setTitle("Sortings with swaps");
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        burbujaPanelB1 = new com.CarlosMestas.Swaps.BurbujaPanelB();
        jLabel2 = new javax.swing.JLabel();
        burbujaPanelA1 = new com.CarlosMestas.Swaps.BurbujaPanelA();
        jLabel1 = new javax.swing.JLabel();
        burbujaPanelC1 = new com.CarlosMestas.Swaps.BurbujaPanelC();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(357, 20));
        jPanel1.setLayout(new java.awt.GridLayout(1, 2, 6, 6));

        jButton2.setText("Random numbers with repetition");
        jButton2.setPreferredSize(new java.awt.Dimension(115, 30));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        jButton4.setText("Generate random numbers without repetition");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);

        jButton3.setText("Generate numbers in decreasing order");
        jButton3.setPreferredSize(new java.awt.Dimension(115, 42));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        jButton1.setText("Sort");
        jButton1.setPreferredSize(new java.awt.Dimension(50, 42));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setPreferredSize(new java.awt.Dimension(1170, 762));

        jLabel2.setText("COCKTAIL SORT");

        javax.swing.GroupLayout burbujaPanelB1Layout = new javax.swing.GroupLayout(burbujaPanelB1);
        burbujaPanelB1.setLayout(burbujaPanelB1Layout);
        burbujaPanelB1Layout.setHorizontalGroup(
            burbujaPanelB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(burbujaPanelB1Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jLabel2)
                .addContainerGap(158, Short.MAX_VALUE))
        );
        burbujaPanelB1Layout.setVerticalGroup(
            burbujaPanelB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, burbujaPanelB1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setText("BUBBLE SORT");

        javax.swing.GroupLayout burbujaPanelA1Layout = new javax.swing.GroupLayout(burbujaPanelA1);
        burbujaPanelA1.setLayout(burbujaPanelA1Layout);
        burbujaPanelA1Layout.setHorizontalGroup(
            burbujaPanelA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(burbujaPanelA1Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jLabel1)
                .addContainerGap(172, Short.MAX_VALUE))
        );
        burbujaPanelA1Layout.setVerticalGroup(
            burbujaPanelA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, burbujaPanelA1Layout.createSequentialGroup()
                .addGap(0, 650, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel3.setText("COMB SORT");

        javax.swing.GroupLayout burbujaPanelC1Layout = new javax.swing.GroupLayout(burbujaPanelC1);
        burbujaPanelC1.setLayout(burbujaPanelC1Layout);
        burbujaPanelC1Layout.setHorizontalGroup(
            burbujaPanelC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, burbujaPanelC1Layout.createSequentialGroup()
                .addContainerGap(172, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(148, 148, 148))
        );
        burbujaPanelC1Layout.setVerticalGroup(
            burbujaPanelC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, burbujaPanelC1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(burbujaPanelA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(burbujaPanelB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(burbujaPanelC1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(burbujaPanelA1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(burbujaPanelB1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(burbujaPanelC1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton1.setEnabled(false);
        
        burbujaPanelA1.run();
        burbujaPanelB1.run();
        burbujaPanelC1.run();

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        BoxNumber[] bNumber1, bNumber2, bNumber3;
        bNumber1 = new BoxNumber[cantNumbers];
        bNumber2 = new BoxNumber[cantNumbers];
        bNumber3 = new BoxNumber[cantNumbers];            
        Random rn = new Random();
        for(int i = 0 ; i < cantNumbers ; i++){
            int num = rn.nextInt(maxRandom - 1) + (minRandom - 1) + 1;
            bNumber1[i] = new BoxNumber(num);
            bNumber2[i] = new BoxNumber(num);
            bNumber3[i] = new BoxNumber(num);            
        }
        burbujaPanelA1.generar3(bNumber1);
        burbujaPanelB1.generar3(bNumber2);
        burbujaPanelC1.generar3(bNumber3);      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        BoxNumber[] bNumber1, bNumber2, bNumber3;
        bNumber1 = new BoxNumber[cantNumbers];
        bNumber2 = new BoxNumber[cantNumbers];
        bNumber3 = new BoxNumber[cantNumbers];                   
        for(int i = 0 ; i < cantNumbers ; i++){
            bNumber1[i] = new BoxNumber(cantNumbers - i);
            bNumber2[i] = new BoxNumber(cantNumbers - i);
            bNumber3[i] = new BoxNumber(cantNumbers - i);            
        }
        burbujaPanelA1.generar3(bNumber1);
        burbujaPanelB1.generar3(bNumber2);
        burbujaPanelC1.generar3(bNumber3);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        BoxNumber[] bNumber1, bNumber2, bNumber3;
        bNumber1 = new BoxNumber[cantNumbers];
        bNumber2 = new BoxNumber[cantNumbers];
        bNumber3 = new BoxNumber[cantNumbers];  
        int pos;
        Stack < Integer > numbers = new Stack < Integer > ();
        for (int i = 0; i < cantNumbers ; i++) {
            pos = (int) Math.floor(Math.random() * maxRandom ) + 1;
            while (numbers.contains(pos)) {
                pos = (int) Math.floor(Math.random() * maxRandom )+ 1;
            }
                numbers.push(pos);
        }     
        for(int i = 0 ; i < numbers.size() ; i++){
            System.out.print(numbers.get(i)+"-");
            bNumber1[i] = new BoxNumber(numbers.get(i));
            bNumber2[i] = new BoxNumber(numbers.get(i));
            bNumber3[i] = new BoxNumber(numbers.get(i));          
        }
        burbujaPanelA1.generar3(bNumber1);
        burbujaPanelB1.generar3(bNumber2);
        burbujaPanelC1.generar3(bNumber3);

    }//GEN-LAST:event_jButton4ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BurbujaFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BurbujaFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BurbujaFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BurbujaFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BurbujaFrm().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.CarlosMestas.Swaps.BurbujaPanelA burbujaPanelA1;
    private com.CarlosMestas.Swaps.BurbujaPanelB burbujaPanelB1;
    private com.CarlosMestas.Swaps.BurbujaPanelC burbujaPanelC1;
    public static javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton2;
    public static javax.swing.JButton jButton3;
    public static javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
