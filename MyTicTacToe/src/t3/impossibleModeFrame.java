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

/*
In this mode, the computer plays optimally and cannot be defeated...true
Algorithm Used : Minimax with some optimization to return the best of all optimum moves
*/

public class impossibleModeFrame extends javax.swing.JFrame {

    private String whoseTurn = "X";
    JButton buttons[] = new JButton[9];
    
    public impossibleModeFrame() {
        initComponents();
        setSize(600,600);
        setLocationRelativeTo(null);
        setButtonReferences();
        
    }
    
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
    }
    
    private int max (int a, int b){
        if (a>b)
            return a;
        return b;
    }
    
    private int min (int a,int b){
        if (a<b)
            return a;
        return b;
    }
    
    
    //this method checks if a winning position is achieved and returns value of board   
    private int evaluate(int depth){
        String o1 = jButton1.getText();
        String o2 = jButton2.getText();
        String o3 = jButton3.getText();
        String o4 = jButton4.getText();
        String o5 = jButton5.getText();
        String o6 = jButton6.getText();
        String o7 = jButton7.getText();
        String o8 = jButton8.getText();
        String o9 = jButton9.getText();
        
        //Winning conditions for X (player)
        if (o1.equalsIgnoreCase("X") && o2.equalsIgnoreCase("X") && o3.equalsIgnoreCase("X"))
            return (10-depth);
        else  if (o4.equalsIgnoreCase("X") && o5.equalsIgnoreCase("X") && o6.equalsIgnoreCase("X"))
            return (10-depth);
        else if (o7.equalsIgnoreCase("X") && o8.equalsIgnoreCase("X") && o9.equalsIgnoreCase("X"))
            return (10-depth);
        else if (o1.equalsIgnoreCase("X") && o4.equalsIgnoreCase("X") && o7.equalsIgnoreCase("X"))
            return (10-depth);
        else if (o2.equalsIgnoreCase("X") && o5.equalsIgnoreCase("X") && o8.equalsIgnoreCase("X"))
            return (10-depth);
        else if (o3.equalsIgnoreCase("X") && o6.equalsIgnoreCase("X") && o9.equalsIgnoreCase("X"))
            return (10-depth);
        else if (o1.equalsIgnoreCase("X") && o5.equalsIgnoreCase("X") && o9.equalsIgnoreCase("X"))
            return (10-depth);
        else if (o3.equalsIgnoreCase("X") && o5.equalsIgnoreCase("X") && o7.equalsIgnoreCase("X"))
            return (10-depth);
        
        //Winning Conditions for O(CPU)
        else if (o1.equalsIgnoreCase("O") && o2.equalsIgnoreCase("O") && o3.equalsIgnoreCase("O"))
            return (-10+depth);
        else  if (o4.equalsIgnoreCase("O") && o5.equalsIgnoreCase("O") && o6.equalsIgnoreCase("O"))
            return (-10+depth);
        else if (o7.equalsIgnoreCase("O") && o8.equalsIgnoreCase("O") && o9.equalsIgnoreCase("O"))
            return (-10+depth);
        else if (o1.equalsIgnoreCase("O") && o4.equalsIgnoreCase("O") && o7.equalsIgnoreCase("O"))
            return (-10+depth);
        else if (o2.equalsIgnoreCase("O") && o5.equalsIgnoreCase("O") && o8.equalsIgnoreCase("O"))
            return (-10+depth);
        else if (o3.equalsIgnoreCase("O") && o6.equalsIgnoreCase("O") && o9.equalsIgnoreCase("O"))
            return (-10+depth);
        else if (o1.equalsIgnoreCase("O") && o5.equalsIgnoreCase("O") && o9.equalsIgnoreCase("O"))
            return (-10+depth);
        else if (o3.equalsIgnoreCase("O") && o5.equalsIgnoreCase("O") && o7.equalsIgnoreCase("O"))
            return (-10+depth);
        else
            return 0;
    }
    
    /*standard Minimax algorithm
      To learn more visit:
       https://en.wikipedia.org/wiki/Minimax
    */
    
    //isMax checks if current move is maximizer's move
    private int minimax(int depth, int isMax) {
        int score = evaluate(depth);
        if (score == (10-depth))
            return score;
        if (score == (-10+depth))
            return score;
        if (isEmptyPosition() == false)
            return 0;
        if (isMax!=0){
            int set;
            int best = -1000;
            int i=0;
            for (i=0;i<9;i++){
                if (buttons[i].getText()==""){
                    buttons[i].setText("X");
                    if (isMax==0)
                        set = 1;
                    else 
                        set=0;
                    
                    best = max(best, minimax(depth+1,set));
                    buttons[i].setText("");
                }
            }
            return best;
        }
        else{
            int set;
            int best = 1000;
            int i = 0;
            for (i=0;i<9;i++){
                if (buttons[i].getText()==""){
                    buttons[i].setText("O");
                    if (isMax==0)
                        set = 1;
                    else 
                        set=0;
                    best = min(best,minimax(depth+1,set));
                    buttons[i].setText("");
                }
            }
            return best;
        }
    }
    
    //this method evaluates the best possible moves of all the moves from a given state of the board
    //returns the best move
    public int bestMove (){
        int i=0,bestVal=1000;
        int pos = -1;
        for (i=0;i<9;i++){
            if (buttons[i].getText()==""){
                buttons[i].setText("O");
                int moveVal = minimax(0,1);
                buttons[i].setText("");
                if (moveVal < bestVal){
                    bestVal = moveVal;
                    pos = i;
                }
            }
        }
        return pos;
    }
    
    private void computersTurn (){
        if (isEmptyPosition()){
            if(whoseTurn.equalsIgnoreCase("O")){
                int mv = bestMove();
                buttons[mv].setText("O");
                buttons[mv].setForeground(Color.green);
                whoseTurn = "X";
                
            }
        }
        determineWin();
        determineTieGame();
    }
    
     private void oWins (){
         JOptionPane.showMessageDialog(this,"Computer Wins","Winner",JOptionPane.INFORMATION_MESSAGE);
         resetGame();
         whoseTurn = "X";
         if (whoseTurn.equalsIgnoreCase("O"))
            computersTurn();
    }
    
    //here i am checking only the winning conditions for CPU, because player cannot win in this mode :)
    public void determineWin(){
        String o1 = jButton1.getText();
        String o2 = jButton2.getText();
        String o3 = jButton3.getText();
        String o4 = jButton4.getText();
        String o5 = jButton5.getText();
        String o6 = jButton6.getText();
        String o7 = jButton7.getText();
        String o8 = jButton8.getText();
        String o9 = jButton9.getText();
        if (o1.equalsIgnoreCase("O") && o2.equalsIgnoreCase("O") && o3.equalsIgnoreCase("O"))
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

        jLabel8 = new javax.swing.JLabel();
        jPanel = new javax.swing.JPanel();
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

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");

        jPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel.setLayout(new java.awt.BorderLayout());

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
                 jButton1.setForeground(Color.cyan);
                 whoseTurn = "O";
                 determineWin();
                 computersTurn();
             }
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jButton2.getText()==""){
             if (whoseTurn.equalsIgnoreCase("X")){
                 jButton2.setText("X");
                 jButton2.setForeground(Color.cyan);
                 whoseTurn = "O";
                 determineWin();
                 computersTurn();
             }
         }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       if (jButton3.getText()==""){
             if (whoseTurn.equalsIgnoreCase("X")){
                 jButton3.setText("X");
                 jButton3.setForeground(Color.cyan);
                 whoseTurn = "O";
                 determineWin();
                 computersTurn();
             }
         }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (jButton4.getText()==""){
             if (whoseTurn.equalsIgnoreCase("X")){
                 jButton4.setText("X");
                 jButton4.setForeground(Color.cyan);
                 whoseTurn = "O";
                 determineWin();
                 computersTurn();
             }
         }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (jButton5.getText()==""){
             if (whoseTurn.equalsIgnoreCase("X")){
                 jButton5.setText("X");
                 jButton5.setForeground(Color.cyan);
                 whoseTurn = "O";
                 determineWin();
                 computersTurn();
             }
         }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       if (jButton6.getText()==""){
             if (whoseTurn.equalsIgnoreCase("X")){
                 jButton6.setText("X");
                 jButton6.setForeground(Color.cyan);
                 whoseTurn = "O";
                 determineWin();
                 computersTurn();
             }
         }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (jButton7.getText()==""){
             if (whoseTurn.equalsIgnoreCase("X")){
                 jButton7.setText("X");
                 jButton7.setForeground(Color.cyan);
                 whoseTurn = "O";
                 determineWin();
                 computersTurn();
             }
         }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       if (jButton8.getText()==""){
             if (whoseTurn.equalsIgnoreCase("X")){
                 jButton8.setText("X");
                 jButton8.setForeground(Color.cyan);
                 whoseTurn = "O";
                 determineWin();
                 computersTurn();
             }
         }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (jButton9.getText()==""){
             if (whoseTurn.equalsIgnoreCase("X")){
                 jButton9.setText("X");
                 jButton9.setForeground(Color.cyan);
                 whoseTurn = "O";
                 determineWin();
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
            java.util.logging.Logger.getLogger(impossibleModeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(impossibleModeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(impossibleModeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(impossibleModeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new impossibleModeFrame().setVisible(true);
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
    private javax.swing.JLabel jLabel8;
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
    // End of variables declaration//GEN-END:variables
}
