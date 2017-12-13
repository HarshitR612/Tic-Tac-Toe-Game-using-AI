/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t3;

import java.awt.Color;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Harshit
 */
public class singlePlayFrame extends javax.swing.JFrame {

    private String whoseTurn = "X";
    JButton buttons[] = new JButton[9];
    private String playerOne = "Player 1";
    private String playerTwo = "CPU";
    private int playerWinCount = 0;
    private int computerWinCount = 0;
    private String playersTurn = "";
    
    
    public singlePlayFrame() {
        initComponents();
        setSize(600,600);
        setLocationRelativeTo(null);
        setButtonReferences();
        getPlayerName();
        setPlayerName();
        setScore(); 
    }
    
    //method to store references of all the 9 JButtons where moves are shown
    private void setButtonReferences (){
        buttons[0] = jButton1;
        buttons[1] = jButton2;
        buttons[2] = jButton3;
        buttons[3] = jButton4;
        buttons[4] = jButton5;               
        buttons[5] = jButton6;
        buttons[6] = jButton7;
        buttons[7] = jButton8;
        buttons[8] = jButton9;       
    }
    
    /*
    For description of methods commmon to all frames, please see source code of gamePlayPanel frame
    */
    
    private void setScore(){
        scoresLabel.setText(playerOne+"'s Score:"+String.valueOf(playerWinCount)+"   "+"Your Turn"+
                "   "+playerTwo+"'s Score:"+String.valueOf(computerWinCount));
    }
    
    private void setPlayerName (){
        scoresLabel.setText(playerOne+"'s Score:"+String.valueOf(playerWinCount)+"   "+"Your Turn"+ 
                "   "+playerTwo+"'s Score:"+String.valueOf(computerWinCount));
        
    }
    
    private void getPlayerName (){
        playerOne = JOptionPane.showInputDialog(this,"Player Name","Player Name",JOptionPane.INFORMATION_MESSAGE);
        if (playerOne.equals(""))
             playerOne = "Player 1"; 
    }
    
    //this method checks if any empty position is available
    private boolean isEmptyPosition(){
        String o1 = jButton1.getText();
        String o2 = jButton2.getText();
        String o3 = jButton3.getText();
        String o4 = jButton4.getText();
        String o5 = jButton5.getText();
        String o6 = jButton6.getText();
        String o7 = jButton7.getText();
        String o8 = jButton8.getText();
        String o9 = jButton9.getText();
        if (o1!="" && o2!="" && o3!="" && o4!="" && o5!="" && o6!="" && o7!="" && o8!="" && o9!="")
            return false;
        return true;
    }
    
    //method to play computer's turn
    private void computersTurn (){
        if (isEmptyPosition()){
            if(whoseTurn.equalsIgnoreCase("O")){
        //in normal gameplay mode, computer selects a random move among all empty positions
        Random rand = new Random();
        int index = rand.nextInt(9);
        while (buttons[index].getText() != ""){
            index = rand.nextInt(9);
        }
        buttons[index].setText(whoseTurn);
        buttons[index].setForeground(Color.green);
        whoseTurn = "X";
        determineWhoWins();
        determineTieGame();
        setPlayerName();
        }
    }
   }
    
    private void determineTieGame (){
        String o1 = jButton1.getText();
        String o2 = jButton2.getText();
        String o3 = jButton3.getText();
        String o4 = jButton4.getText();
        String o5 = jButton5.getText();
        String o6 = jButton6.getText();
        String o7 = jButton7.getText();
        String o8 = jButton8.getText();
        String o9 = jButton9.getText();
        if (o1!="" && o2!="" && o3!="" && o4!="" && o5!="" && o6!="" && o7!="" && o8!="" && o9!=""){
             JOptionPane.showMessageDialog(this,"Draw","Tie Game",JOptionPane.INFORMATION_MESSAGE); 
             resetGame();
             if (whoseTurn.equalsIgnoreCase("O"))
                computersTurn();
        }
    }
    
    private void xWins (){
        JOptionPane.showMessageDialog(this,playerOne+" Wins","Winner",JOptionPane.INFORMATION_MESSAGE);
        playerWinCount++;
        resetGame();
        whoseTurn = "O";
        if (whoseTurn.equalsIgnoreCase("O"))
            computersTurn();
            
    }
    
    private void oWins (){
         JOptionPane.showMessageDialog(this,playerTwo+" Wins","Winner",JOptionPane.INFORMATION_MESSAGE);
         computerWinCount++;
         resetGame();
         whoseTurn = "X";
         if (whoseTurn.equalsIgnoreCase("O"))
            computersTurn();
    }
    
    private void resetGame (){
        jButton1.setText("");
        jButton2.setText("");
        jButton3.setText("");
        jButton4.setText("");
        jButton5.setText("");
        jButton6.setText("");
        jButton7.setText("");
        jButton8.setText("");
        jButton9.setText("");
        setScore();
    }
    
    private void determineWhoWins (){
        String o1 = jButton1.getText();
        String o2 = jButton2.getText();
        String o3 = jButton3.getText();
        String o4 = jButton4.getText();
        String o5 = jButton5.getText();
        String o6 = jButton6.getText();
        String o7 = jButton7.getText();
        String o8 = jButton8.getText();
        String o9 = jButton9.getText();
        
        //Winning Conditions for X
        if (o1.equalsIgnoreCase("X") && o2.equalsIgnoreCase("X") && o3.equalsIgnoreCase("X"))
            xWins();
        else if (o4.equalsIgnoreCase("X") && o5.equalsIgnoreCase("X") && o6.equalsIgnoreCase("X"))
            xWins();
        else if (o7.equalsIgnoreCase("X") && o8.equalsIgnoreCase("X") && o9.equalsIgnoreCase("X"))
            xWins();
        else if (o1.equalsIgnoreCase("X") && o4.equalsIgnoreCase("X") && o7.equalsIgnoreCase("X"))
            xWins();
        else if (o2.equalsIgnoreCase("X") && o5.equalsIgnoreCase("X") && o8.equalsIgnoreCase("X"))
            xWins();
        else if (o3.equalsIgnoreCase("X") && o6.equalsIgnoreCase("X") && o9.equalsIgnoreCase("X"))
            xWins();
        else if (o1.equalsIgnoreCase("X") && o5.equalsIgnoreCase("X") && o9.equalsIgnoreCase("X"))
            xWins();
        else if (o3.equalsIgnoreCase("X") && o5.equalsIgnoreCase("X") && o7.equalsIgnoreCase("X"))
            xWins();
        
        //Winning Conditions for O
        else if (o1.equalsIgnoreCase("O") && o2.equalsIgnoreCase("O") && o3.equalsIgnoreCase("O"))
            oWins();
        else if (o4.equalsIgnoreCase("O") && o5.equalsIgnoreCase("O") && o6.equalsIgnoreCase("O"))
            oWins();
        else if (o7.equalsIgnoreCase("O") && o8.equalsIgnoreCase("O") && o9.equalsIgnoreCase("O"))
            oWins();
        else if (o1.equalsIgnoreCase("O") && o4.equalsIgnoreCase("O") && o7.equalsIgnoreCase("O"))
            oWins();
        else if (o2.equalsIgnoreCase("O") && o5.equalsIgnoreCase("O") && o8.equalsIgnoreCase("O"))
            oWins();
        else if (o3.equalsIgnoreCase("O") && o6.equalsIgnoreCase("O") && o9.equalsIgnoreCase("O"))
            oWins();
        else if (o1.equalsIgnoreCase("O") && o5.equalsIgnoreCase("O") && o9.equalsIgnoreCase("O"))
            oWins();
        else if (o3.equalsIgnoreCase("O") && o5.equalsIgnoreCase("O") && o7.equalsIgnoreCase("O"))
            oWins();
    }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        scoresLabel = new javax.swing.JLabel();
        gridPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");

        jPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel.setLayout(new java.awt.BorderLayout());

        scoresLabel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        scoresLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoresLabel.setText("Scores");
        jPanel.add(scoresLabel, java.awt.BorderLayout.PAGE_END);

        gridPanel.setLayout(new java.awt.GridLayout(3, 3, 1, 1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 100)); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, java.awt.BorderLayout.CENTER);

        gridPanel.add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Verdana", 1, 100)); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, java.awt.BorderLayout.CENTER);

        gridPanel.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Verdana", 1, 100)); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, java.awt.BorderLayout.CENTER);

        gridPanel.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Verdana", 1, 100)); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, java.awt.BorderLayout.CENTER);

        gridPanel.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setFont(new java.awt.Font("Verdana", 1, 100)); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton5, java.awt.BorderLayout.CENTER);

        gridPanel.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setFont(new java.awt.Font("Verdana", 1, 100)); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton6, java.awt.BorderLayout.CENTER);

        gridPanel.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jButton7.setBackground(new java.awt.Color(0, 0, 0));
        jButton7.setFont(new java.awt.Font("Verdana", 1, 100)); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton7, java.awt.BorderLayout.CENTER);

        gridPanel.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jButton8.setBackground(new java.awt.Color(0, 0, 0));
        jButton8.setFont(new java.awt.Font("Verdana", 1, 100)); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton8, java.awt.BorderLayout.CENTER);

        gridPanel.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jButton9.setBackground(new java.awt.Color(0, 0, 0));
        jButton9.setFont(new java.awt.Font("Verdana", 1, 100)); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton9, java.awt.BorderLayout.CENTER);

        gridPanel.add(jPanel9);

        jPanel.add(gridPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         if (jButton1.getText()==""){
             if (whoseTurn.equalsIgnoreCase("X")){
                 jButton1.setText("X");
                 jButton1.setForeground(Color.orange);
                 whoseTurn = "O";
                 determineWhoWins();
                 determineTieGame();
                 setPlayerName();
                 computersTurn();
             }
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       if (jButton2.getText()==""){
             if (whoseTurn.equalsIgnoreCase("X")){
                 jButton2.setText("X");
                 jButton2.setForeground(Color.orange);
                 whoseTurn = "O";
                 determineWhoWins();
                 determineTieGame();
                 setPlayerName();
                 computersTurn();
             }
         }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (jButton3.getText()==""){
             if (whoseTurn.equalsIgnoreCase("X")){
                 jButton3.setText("X");
                 jButton3.setForeground(Color.orange);
                 whoseTurn = "O";
                 determineWhoWins();
                 determineTieGame();
                 setPlayerName();
                 computersTurn();
             }
         }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      if (jButton4.getText()==""){
             if (whoseTurn.equalsIgnoreCase("X")){
                 jButton4.setText("X");
                 jButton4.setForeground(Color.orange);
                 whoseTurn = "O";
                 determineWhoWins();
                 determineTieGame();
                 setPlayerName();
                 computersTurn();
             }
         }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (jButton5.getText()==""){
             if (whoseTurn.equalsIgnoreCase("X")){
                 jButton5.setText("X");
                 jButton5.setForeground(Color.orange);
                 whoseTurn = "O";
                 determineWhoWins();
                 determineTieGame();
                 setPlayerName();
                 computersTurn();
             }
         }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       if (jButton6.getText()==""){
             if (whoseTurn.equalsIgnoreCase("X")){
                 jButton6.setText("X");
                 jButton6.setForeground(Color.orange);
                 whoseTurn = "O";
                 determineWhoWins();
                 determineTieGame();
                 setPlayerName();
                 computersTurn();
             }
         }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (jButton7.getText()==""){
             if (whoseTurn.equalsIgnoreCase("X")){
                 jButton7.setText("X");
                 jButton7.setForeground(Color.orange);
                 whoseTurn = "O";
                 determineWhoWins();
                 determineTieGame();
                 setPlayerName();
                 computersTurn();
             }
         }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (jButton8.getText()==""){
             if (whoseTurn.equalsIgnoreCase("X")){
                 jButton8.setText("X");
                 jButton8.setForeground(Color.orange);
                 whoseTurn = "O";
                 determineWhoWins();
                 determineTieGame();
                 setPlayerName();
                 computersTurn();
             }
         }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (jButton9.getText()==""){
             if (whoseTurn.equalsIgnoreCase("X")){
                 jButton9.setText("X");
                 jButton9.setForeground(Color.orange);
                 whoseTurn = "O";
                 determineWhoWins();
                 determineTieGame();
                 setPlayerName();
                 computersTurn();
             }
         }
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(singlePlayFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(singlePlayFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(singlePlayFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(singlePlayFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new singlePlayFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gridPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel scoresLabel;
    // End of variables declaration//GEN-END:variables
}
