/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package online_exam;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Paper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ashraf
 */
public class gui extends javax.swing.JFrame {

    /**
//     * Creates new form gui
     */
   // panel p=new panel();
    
     //  JLabel promptLabel, timerLabel;
   connection c=new connection();
  
    DefaultTableModel model_mcq_question ;
    DefaultTableModel model_tf_question ;
    DefaultTableModel model_mcq_help ;
    DefaultTableModel model_tf_help ;
    
    int counter_mcq=0 ; int counter_tf=0 ;
    
    String id_user="0";
    
    
    int counter ;
    Timer timer ;
    
    String id_exam = "";
    String no_mcq = "";
    String no_tf = "";
    String time = "";
     String range = "";
     String end_time="";
    public gui() {
        initComponents();
        
         model_mcq_question = (DefaultTableModel) jTable_mcq.getModel();
          model_tf_question = (DefaultTableModel) jTable_tf.getModel();
         model_mcq_help = (DefaultTableModel) jTable_mcq_help.getModel();
          model_tf_help = (DefaultTableModel) jTable_tf_help.getModel();
         setSize(1400, 730);

         setLocation(0, 0);
         jLabel_question_mcq.setBackground(null);
          jPanel11.setBackground(new Color(0, 0, 0, 50));
         // jPanel1.setBackground(new Color(0, 0, 0, 20));
          //jPanel3.setBackground(new Color(0, 0, 0, 20));
         //  jPanel_exam.setBackground(new Color(0, 0, 0, 150));
          // jPanel1.setBackground(new Color(0, 0, 0, 200));
         
           
           
       
    }
    double total_degree =0;
    double total_mark=0 ;
    void correct()
    {
        
        
        for (int i=0 ; i<Integer.parseInt(no_mcq) ; i++)
        {
            String degree="0";
            String full_degree=String.valueOf(model_mcq_question.getValueAt(i,8));
            total_degree+=Double.parseDouble(full_degree);
            String choise=String.valueOf(model_mcq_question.getValueAt(i,6));
            if (choise.equals(String.valueOf(model_mcq_question.getValueAt(i,7))))
            {
                degree=full_degree;
                total_mark+=Double.parseDouble(full_degree);
                
            }
            try {
                System.out.println("insert into history values ("+id_user+","+id_exam+","+String.valueOf(model_mcq_question.getValueAt(i, 0))+
                        ","+"0"+","+choise+","+degree+")");
                c.stmt.executeUpdate("insert into history values ("+id_user+","+id_exam+","+String.valueOf(model_mcq_question.getValueAt(i, 0))+
                        ","+"0"+",'"+choise+"',"+degree+")");
            } catch (SQLException ex) {
                Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
         for (int i=0 ; i<Integer.parseInt(no_tf) ; i++)
        {
            String degree="0";
            String full_degree=String.valueOf(model_tf_question.getValueAt(i,4));
            total_degree+=Double.parseDouble(full_degree);
            String choise=String.valueOf(model_tf_question.getValueAt(i,2));
            if (choise.equals(String.valueOf(model_tf_question.getValueAt(i,3))))
            {
                degree=full_degree;
                total_mark+=Double.parseDouble(full_degree);
                
            }
            try {
                System.out.println("insert into history values ("+id_user+","+id_exam+","+String.valueOf(model_mcq_question.getValueAt(i, 0))+
                        ","+"1"+","+choise+","+degree+")");
                c.stmt.executeUpdate("insert into history values ("+id_user+","+id_exam+","+String.valueOf(model_mcq_question.getValueAt(i, 0))+
                        ","+"1"+",'"+choise+"',"+degree+")");
            } catch (SQLException ex) {
                Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            System.out.println("insert into students_degrees values ("+id_user+","+id_exam+","+total_mark+",'"+c.time_now()+"')");
            c.stmt.executeUpdate("insert into students_degrees values ("+id_user+","+id_exam+","+total_mark+",'"+c.time_now()+"')");
            jLabel21.setText(String.valueOf(total_mark));
            jLabel23.setText(String.valueOf(total_degree));
        } catch (SQLException ex) {
            Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
        }
        jPanel_exam.setVisible(false);
        jPanel2.setVisible(true);
    }
    public class TimeClass implements ActionListener {
        int counter;
 
        public TimeClass(int counter) {
            this.counter= counter;
 
   }
        public void actionPerformed(ActionEvent tc) {
            counter--;
 
            if(counter >= 1) {
                System.out.println("Time left: " + (int)counter/60 +" "+(int)counter%60);
              jLabel16.setText("Time left: " + (int)counter/60 +" "+(int)counter%60);
 
            }
            else {
                timer.stop();
                jLabel16.setText("0");
                correct();
                Toolkit.getDefaultToolkit().beep();
 
            }
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

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel_back_login = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jCheckBox_admin = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel_start_exam = new javax.swing.JPanel();
        jButton31 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel_main = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton32 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel_exam = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jCheckBox_ans_3_mcq = new javax.swing.JCheckBox();
        jCheckBox_ans_4_mcq = new javax.swing.JCheckBox();
        jCheckBox_ans_1_mcq = new javax.swing.JCheckBox();
        jButton27 = new javax.swing.JButton();
        jLabel_mcq_ans_3 = new javax.swing.JLabel();
        jCheckBox_ans_2_mcq = new javax.swing.JCheckBox();
        jLabel_mcq_ans_1 = new javax.swing.JLabel();
        jButton28 = new javax.swing.JButton();
        jLabel_mcq_ans_2 = new javax.swing.JLabel();
        jLabel_mcq_ans_4 = new javax.swing.JLabel();
        jLabel_question_mcq = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel_question_tf = new javax.swing.JLabel();
        jCheckBox_t = new javax.swing.JCheckBox();
        jButton29 = new javax.swing.JButton();
        jCheckBox_f = new javax.swing.JCheckBox();
        jLabel22 = new javax.swing.JLabel();
        jButton30 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_tf = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_mcq = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable_tf_help = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable_mcq_help = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel_back_login.setLayout(null);

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("LOGIN");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("password");

        jLabel19.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("user-name");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("X");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jCheckBox_admin.setBackground(new java.awt.Color(0, 0, 0));
        jCheckBox_admin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox_admin.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox_admin.setText("admin");
        jCheckBox_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_adminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(jPasswordField1)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCheckBox_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 55, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addGap(11, 11, 11)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addGap(1, 1, 1)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jCheckBox_admin)
                .addContainerGap())
        );

        jPanel_back_login.add(jPanel11);
        jPanel11.setBounds(490, 250, 280, 310);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/0b0132d558859669ecc6ecbc9e0fc597.png.jpg"))); // NOI18N
        jPanel_back_login.add(jLabel1);
        jLabel1.setBounds(0, 0, 1600, 760);

        getContentPane().add(jPanel_back_login, "card2");

        jPanel_start_exam.setLayout(null);

        jButton31.setBackground(new java.awt.Color(0, 0, 0));
        jButton31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton31.setForeground(new java.awt.Color(255, 255, 255));
        jButton31.setText("Start Exam");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        jPanel_start_exam.add(jButton31);
        jButton31.setBounds(480, 70, 200, 110);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/WIPO banner.JPG"))); // NOI18N
        jPanel_start_exam.add(jLabel15);
        jLabel15.setBounds(20, 0, 1298, 708);

        getContentPane().add(jPanel_start_exam, "card6");

        jPanel_main.setPreferredSize(new java.awt.Dimension(1400, 760));
        jPanel_main.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("m,c,q questions");
        jPanel_main.add(jLabel3);
        jLabel3.setBounds(240, 210, 120, 15);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/update_student.png"))); // NOI18N
        jPanel_main.add(jButton1);
        jButton1.setBounds(40, 430, 180, 90);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/delete_students.png"))); // NOI18N
        jPanel_main.add(jButton2);
        jButton2.setBounds(1110, 530, 180, 90);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/abstract_background_311081.jpg"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel_main.add(jButton3);
        jButton3.setBounds(40, 330, 180, 90);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/insert exam.png"))); // NOI18N
        jPanel_main.add(jButton4);
        jButton4.setBounds(1110, 230, 180, 90);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/create_t_f.png"))); // NOI18N
        jPanel_main.add(jButton5);
        jButton5.setBounds(570, 230, 90, 90);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/search_m_c_Q.png"))); // NOI18N
        jPanel_main.add(jButton7);
        jButton7.setBounds(240, 330, 90, 90);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/update mcq.png"))); // NOI18N
        jPanel_main.add(jButton8);
        jButton8.setBounds(240, 430, 90, 90);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/delete mcq.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel_main.add(jButton9);
        jButton9.setBounds(240, 530, 90, 90);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/search t-f.png"))); // NOI18N
        jPanel_main.add(jButton10);
        jButton10.setBounds(570, 330, 90, 90);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/Untitled2.png"))); // NOI18N
        jPanel_main.add(jButton11);
        jButton11.setBounds(570, 430, 90, 90);

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/delete t-f.png"))); // NOI18N
        jPanel_main.add(jButton12);
        jButton12.setBounds(570, 530, 90, 90);

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/create_m_c_q.png"))); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel_main.add(jButton13);
        jButton13.setBounds(240, 230, 90, 90);

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/search admin.png"))); // NOI18N
        jPanel_main.add(jButton15);
        jButton15.setBounds(1110, 330, 180, 90);

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/update admin.png"))); // NOI18N
        jPanel_main.add(jButton16);
        jButton16.setBounds(1110, 430, 180, 90);

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/delete admin.png"))); // NOI18N
        jPanel_main.add(jButton17);
        jButton17.setBounds(370, 530, 180, 90);

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/insert_student.png"))); // NOI18N
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel_main.add(jButton18);
        jButton18.setBounds(40, 230, 180, 90);

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/search exam.png"))); // NOI18N
        jPanel_main.add(jButton19);
        jButton19.setBounds(700, 330, 180, 90);

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/update exam.png"))); // NOI18N
        jPanel_main.add(jButton20);
        jButton20.setBounds(700, 430, 180, 90);

        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/delete exam.png"))); // NOI18N
        jPanel_main.add(jButton21);
        jButton21.setBounds(700, 530, 180, 90);

        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/insert_admin.png"))); // NOI18N
        jPanel_main.add(jButton22);
        jButton22.setBounds(370, 230, 180, 90);

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/degree history.png"))); // NOI18N
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel_main.add(jButton14);
        jButton14.setBounds(920, 330, 180, 90);

        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/search admin.png"))); // NOI18N
        jPanel_main.add(jButton23);
        jButton23.setBounds(370, 330, 180, 90);

        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/update admin.png"))); // NOI18N
        jPanel_main.add(jButton24);
        jButton24.setBounds(370, 430, 180, 90);

        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/delete_students.png"))); // NOI18N
        jPanel_main.add(jButton25);
        jButton25.setBounds(40, 530, 180, 90);

        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/insert exam.png"))); // NOI18N
        jPanel_main.add(jButton26);
        jButton26.setBounds(700, 230, 180, 90);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("admins");
        jPanel_main.add(jLabel4);
        jLabel4.setBounds(380, 210, 90, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("t,f questions");
        jPanel_main.add(jLabel5);
        jLabel5.setBounds(570, 210, 90, 15);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("exams");
        jPanel_main.add(jLabel6);
        jLabel6.setBounds(700, 210, 90, 15);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("current exam");
        jPanel_main.add(jLabel8);
        jLabel8.setBounds(1120, 210, 90, 15);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("history");
        jPanel_main.add(jLabel9);
        jLabel9.setBounds(930, 210, 90, 15);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("person");
        jPanel_main.add(jLabel10);
        jLabel10.setBounds(160, 80, 90, 15);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("students");
        jPanel_main.add(jLabel11);
        jLabel11.setBounds(50, 210, 90, 15);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/images.jpg"))); // NOI18N
        jPanel_main.add(jLabel12);
        jLabel12.setBounds(60, 40, 90, 100);

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jPanel_main.add(jLabel13);
        jLabel13.setBounds(650, 60, 80, 40);

        jButton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/update exam - Copy.png"))); // NOI18N
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        jPanel_main.add(jButton32);
        jButton32.setBounds(920, 230, 180, 90);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/0b0132d558859669ecc6ecbc9e0fc597.png.jpg"))); // NOI18N
        jPanel_main.add(jLabel2);
        jLabel2.setBounds(0, 0, 1590, 760);

        jScrollPane1.setViewportView(jPanel_main);

        getContentPane().add(jScrollPane1, "card4");

        jPanel_exam.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_exam.setForeground(new java.awt.Color(51, 51, 255));
        jPanel_exam.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jCheckBox_ans_3_mcq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_ans_3_mcqActionPerformed(evt);
            }
        });

        jCheckBox_ans_4_mcq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_ans_4_mcqActionPerformed(evt);
            }
        });

        jCheckBox_ans_1_mcq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_ans_1_mcqActionPerformed(evt);
            }
        });

        jButton27.setBackground(new java.awt.Color(0, 0, 0));
        jButton27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton27.setForeground(new java.awt.Color(255, 255, 255));
        jButton27.setText("next");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jLabel_mcq_ans_3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_mcq_ans_3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_mcq_ans_3.setText("a");

        jCheckBox_ans_2_mcq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_ans_2_mcqActionPerformed(evt);
            }
        });

        jLabel_mcq_ans_1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_mcq_ans_1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_mcq_ans_1.setText("a");

        jButton28.setBackground(new java.awt.Color(0, 0, 0));
        jButton28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton28.setForeground(new java.awt.Color(255, 255, 255));
        jButton28.setText("back");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jLabel_mcq_ans_2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_mcq_ans_2.setText("a");

        jLabel_mcq_ans_4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_mcq_ans_4.setText("a");

        jLabel_question_mcq.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_question_mcq.setFont(new java.awt.Font("Meiryo", 1, 18)); // NOI18N
        jLabel_question_mcq.setText("are you happy ?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jCheckBox_ans_3_mcq)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel_mcq_ans_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jCheckBox_ans_1_mcq)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel_mcq_ans_1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jCheckBox_ans_4_mcq)
                                .addGap(49, 49, 49)
                                .addComponent(jLabel_mcq_ans_4, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jCheckBox_ans_2_mcq)
                                .addGap(49, 49, 49)
                                .addComponent(jLabel_mcq_ans_2, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_question_mcq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel_question_mcq, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox_ans_1_mcq)
                    .addComponent(jLabel_mcq_ans_1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jCheckBox_ans_2_mcq)
                        .addComponent(jLabel_mcq_ans_2)))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jCheckBox_ans_3_mcq)
                        .addComponent(jCheckBox_ans_4_mcq)
                        .addComponent(jLabel_mcq_ans_4, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel_mcq_ans_3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel_exam.add(jPanel1);
        jPanel1.setBounds(180, 150, 1030, 260);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setForeground(new java.awt.Color(102, 102, 102));

        jLabel_question_tf.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_question_tf.setFont(new java.awt.Font("Meiryo", 1, 18)); // NOI18N
        jLabel_question_tf.setText("what is your name ?");

        jCheckBox_t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_tActionPerformed(evt);
            }
        });

        jButton29.setBackground(new java.awt.Color(0, 0, 0));
        jButton29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton29.setForeground(new java.awt.Color(255, 255, 255));
        jButton29.setText("next");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jCheckBox_f.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_fActionPerformed(evt);
            }
        });

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("true");

        jButton30.setBackground(new java.awt.Color(0, 0, 0));
        jButton30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton30.setForeground(new java.awt.Color(255, 255, 255));
        jButton30.setText("back");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("false");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jCheckBox_t)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(350, 350, 350)
                        .addComponent(jCheckBox_f)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_question_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(298, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_question_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox_t)
                        .addComponent(jCheckBox_f))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel25)
                        .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel_exam.add(jPanel3);
        jPanel3.setBounds(180, 420, 1030, 260);

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 153, 153));
        jLabel16.setText("00:01");
        jPanel_exam.add(jLabel16);
        jLabel16.setBounds(930, 60, 190, 40);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/online_exam/photo/OnlineTest_0.jpg"))); // NOI18N
        jPanel_exam.add(jLabel14);
        jLabel14.setBounds(60, 10, 1310, 150);

        getContentPane().add(jPanel_exam, "card4");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTable_tf.setAutoCreateRowSorter(true);
        jTable_tf.setForeground(new java.awt.Color(102, 102, 102));
        jTable_tf.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id_question", "question", "your answer", "answer", "degree"
            }
        ));
        jTable_tf.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable_tf.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jScrollPane2.setViewportView(jTable_tf);

        jTable_mcq.setForeground(new java.awt.Color(153, 153, 153));
        jTable_mcq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id_question", "question", "choise 1", "choise 2", "choise 3", "choise 4", "your choise", "answer", "degree"
            }
        ));
        jScrollPane4.setViewportView(jTable_mcq);

        jTable_tf_help.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ans", "degree"
            }
        ));
        jScrollPane5.setViewportView(jTable_tf_help);

        jTable_mcq_help.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ans", "degree"
            }
        ));
        jScrollPane6.setViewportView(jTable_mcq_help);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("/");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Degree");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("Degree");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(792, 792, 792)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(378, 378, 378)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        getContentPane().add(jPanel2, "card5");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        here : {
            try{
            c.conn("root", "");
            }
            catch (Exception w){
            try {
                c.conn("new_elhyh", "hyh");
                
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "check your name and password");
                Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
                break here ;
            } catch (SQLException ex) {
                Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
                break here ;
            }
               
            
            }
            if (jCheckBox_admin.isSelected())
            {
                ResultSet rs=c.search_admin(jTextField2.getText(), jPasswordField1.getText());
                try {
                    if (rs.next())
                    {
                        jLabel10.setText(rs.getString("name"));
                         jPanel_back_login.setVisible(false);
                         jScrollPane1.setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"please check your user name and password and try again");
                                
                    }
                } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null, "please check your user name and password");
                    Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else 
            {
                 ResultSet rs=c.search_student_login(jTextField2.getText(), jPasswordField1.getText());
                try {
                    if (rs.next())
                    {
                        jLabel10.setText(rs.getString("name_student"));
                        id_user=rs.getString("id_student");
                        jButton1.setEnabled(false);
                        jButton2.setEnabled(false);
                        jButton3.setEnabled(false);
                        jButton4.setEnabled(false);
                        jButton5.setEnabled(false);
                        jButton6.setEnabled(false);
                        jButton7.setEnabled(false);
                        jButton8.setEnabled(false);
                        jButton9.setEnabled(false);
                        jButton10.setEnabled(false);
                        jButton11.setEnabled(false);
                        jButton12.setEnabled(false);
                        jButton13.setEnabled(false);
                        jButton14.setEnabled(false);
                        jButton15.setEnabled(false);
                        jButton16.setEnabled(false);
                        jButton17.setEnabled(false);
                        jButton18.setEnabled(false);
                        jButton19.setEnabled(false);
                        jButton20.setEnabled(false);
                        jButton21.setEnabled(false);
                        jButton22.setEnabled(false);
                        jButton23.setEnabled(false);
                        jButton24.setEnabled(false);
                        jButton25.setEnabled(false);
                        jButton26.setEnabled(false);
                       
                        
                         jPanel_back_login.setVisible(false);
                         jScrollPane1.setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"please check your user name and password and try again");
                                
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
         
//                    if (jCheckBox_admin.isSelected())
//                    { 
//                try {
//                    ResultSet rs=c.stmt.executeQuery("select * from admin where user_name='"+jTextField2.getText()+
//                        "' and password='"+jPasswordField1.getText()+"'");
//                  
//                    
//                    
//                } catch (SQLException ex) {
//                    Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                
//                   }
//                  
//                    else 
//                    {
//                        
//                    }
//                   
                         
                 
                   
                   
                   
        
      
          
        
        }
        

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField2ActionPerformed

   
    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
   
       
          
       
    }//GEN-LAST:event_jButton18ActionPerformed
void tsfer_mcq()
{
     jCheckBox_ans_1_mcq.setSelected(false);
      jCheckBox_ans_4_mcq.setSelected(false);
            
             jCheckBox_ans_3_mcq.setSelected(false);
              jCheckBox_ans_2_mcq.setSelected(false);
}
void sign_mcq()
{
     if (String.valueOf(model_mcq_question.getValueAt(counter_mcq, 6))
           .equals("1"))
       {
           jCheckBox_ans_1_mcq.setSelected(true);
       }
       else   if (String.valueOf(model_mcq_question.getValueAt(counter_mcq, 6))
           .equals("2"))
       {
           jCheckBox_ans_2_mcq.setSelected(true);
       }
        else   if (String.valueOf(model_mcq_question.getValueAt(counter_mcq, 6))
           .equals("3"))
       {
           jCheckBox_ans_3_mcq.setSelected(true);
       }
        else   if (String.valueOf(model_mcq_question.getValueAt(counter_mcq, 6))
           .equals("4"))
       {
           jCheckBox_ans_4_mcq.setSelected(true);
       }
}
void tsfer_tf()
{
     jCheckBox_t.setSelected(false);
      jCheckBox_f.setSelected(false);
           
}
void sign_tf()
{
     if (String.valueOf(model_tf_question.getValueAt(counter_tf, 2))
           .equals("1"))
       {
           jCheckBox_t.setSelected(true);
       }
       else   if (String.valueOf(model_tf_question.getValueAt(counter_tf, 2))
           .equals("0"))
       {
           jCheckBox_f.setSelected(true);
       }
        
}
    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
        tsfer_mcq();
        if ((counter_mcq+1) != Integer.parseInt(no_mcq))
            
        {
            
             jLabel_question_mcq.setText((String) model_mcq_question.getValueAt(++counter_mcq, 1));
        jLabel_mcq_ans_1.setText((String) model_mcq_question.getValueAt(counter_mcq, 2));
        jLabel_mcq_ans_2.setText((String) model_mcq_question.getValueAt(counter_mcq, 3));
         jLabel_mcq_ans_3.setText((String) model_mcq_question.getValueAt(counter_mcq, 4));
          jLabel_mcq_ans_4.setText((String) model_mcq_question.getValueAt(counter_mcq, 5));
        }
      sign_mcq();
           
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
        tsfer_mcq();
         if ((counter_mcq) != 0)
            
        {
            
             jLabel_question_mcq.setText((String) model_mcq_question.getValueAt(--counter_mcq, 1));
        jLabel_mcq_ans_1.setText((String) model_mcq_question.getValueAt(counter_mcq, 2));
        jLabel_mcq_ans_2.setText((String) model_mcq_question.getValueAt(counter_mcq, 3));
         jLabel_mcq_ans_3.setText((String) model_mcq_question.getValueAt(counter_mcq, 4));
          jLabel_mcq_ans_4.setText((String) model_mcq_question.getValueAt(counter_mcq, 5));
        }
       sign_mcq();
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
        tsfer_tf();
        if ((counter_tf+1) != Integer.parseInt(no_tf))
            
        {
            
             jLabel_question_tf.setText((String) model_tf_question.getValueAt(++counter_tf, 1));
      
        }
        sign_tf();
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
        tsfer_tf();
         if (counter_tf != 0)
            
        {
            
             jLabel_question_tf.setText((String) model_tf_question.getValueAt(--counter_tf, 1));
      
        }
         sign_tf();
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jCheckBox_ans_3_mcqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_ans_3_mcqActionPerformed
       if (jCheckBox_ans_3_mcq.isSelected())
        {
            jCheckBox_ans_1_mcq.setSelected(false);
             jCheckBox_ans_2_mcq.setSelected(false);
              jCheckBox_ans_4_mcq.setSelected(false);
             model_mcq_question.setValueAt("3", counter_mcq,6);
        }
        else
        {
            model_mcq_question.setValueAt("", counter_mcq,6); 
        }
    }//GEN-LAST:event_jCheckBox_ans_3_mcqActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
//        jPanel2.setVisible(true);
//        jScrollPane1.setVisible(false);
    }//GEN-LAST:event_jButton13ActionPerformed

    
    void load_questions (int no_mcq , int no_tf , int range)
    {
         model_mcq_help.setRowCount(0);
             model_tf_help.setRowCount(0);
        int  arr_mcq[]=new int [no_mcq];
        int arr_tf[]=new int[no_tf];
        int index=0 ;
       while (index!=no_mcq)
       {
           int x =(int) (Math.random()*range);
           boolean flag=true ;
           for (int g =0 ;g<index ; g++)
           {
               if (x==arr_mcq[g])
               {
                 flag=false ;
                 break ;
               }
           }
          
           if (flag==true&&x<=Integer.parseInt(this.range))
           {
             arr_mcq[index++]= x; 
           }
       }
       index=0 ;
        while (index!=no_tf)
       {
           int x =(int) (Math.random()*range);
            boolean flag=true ;
           for (int g =0 ;g<index ; g++)
           {
               if (x==arr_tf[g])
               {
                 flag=false ;
                 break ;
               }
           }
           if (flag==true&&x<=Integer.parseInt(this.range))
           {
             arr_tf[index++]= x; 
           }
       }
       JOptionPane.showMessageDialog(null,arr_mcq+" "+arr_tf);
        model_mcq_question.setRowCount(0);
        for (int i=0 ; i<no_mcq ; i++)
        {
            try {
                c.stmt=c.conn.createStatement();
                System.out.println("select * from mcq_questions where id_question="+arr_mcq[i]);
                ResultSet rs=c.stmt.executeQuery("select * from mcq_questions where id_question="+arr_mcq[i]);
                rs.next();
                String question=rs.getString("question");
                String choise_1=rs.getString("choise-1");
                String choise_2=rs.getString("choise-2");
                String choise_3=rs.getString("choise-3");
                String choise_4=rs.getString("choise-4");
                String degree=rs.getString("degree");
                String answer=rs.getString("answer");
                 model_mcq_question.addRow(new Object[]{arr_mcq[i], question, choise_1, choise_2, choise_3, choise_4,"",answer,degree});
                // model_mcq_help.addRow(new Object[]{answer , degree});
                
            
                
            } catch (SQLException ex) {
                Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }
         model_tf_question.setRowCount(0);
        for (int i=0 ; i<no_tf ; i++)
        {
            try {
                c.stmt=c.conn.createStatement();
                ResultSet rs=c.stmt.executeQuery("select * from tf_questions where id_question="+arr_tf[i]);
                rs.next();
                String question=rs.getString("question");
                 String answer=rs.getString("answer");
                  String degree=rs.getString("degree");
                
                 model_tf_question.addRow(new Object[]{arr_tf[i], question,"",answer,degree});
              //  model_tf_help.addRow(new Object[]{answer, degree});
            
                
            } catch (SQLException ex) {
                Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }
      jLabel_question_mcq.setText((String) model_mcq_question.getValueAt(0,1)); 
      jLabel_mcq_ans_1.setText((String) model_mcq_question.getValueAt(0,2));
      jLabel_mcq_ans_2.setText((String) model_mcq_question.getValueAt(0,3));
      jLabel_mcq_ans_3.setText((String) model_mcq_question.getValueAt(0,4));
      jLabel_mcq_ans_4.setText((String) model_mcq_question.getValueAt(0,5));
      
        jLabel_question_tf.setText((String) model_tf_question.getValueAt(0,1)); 
        
    }
    
    
    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        // TODO add your handling code here:
        
           
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jCheckBox_ans_1_mcqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_ans_1_mcqActionPerformed
        // TODO add your handling code here:
        if (jCheckBox_ans_1_mcq.isSelected())
        {
            jCheckBox_ans_2_mcq.setSelected(false);
             jCheckBox_ans_3_mcq.setSelected(false);
              jCheckBox_ans_4_mcq.setSelected(false);
             model_mcq_question.setValueAt("1", counter_mcq,6);
        }
        else
        {
            model_mcq_question.setValueAt("", counter_mcq,6); 
        }
    }//GEN-LAST:event_jCheckBox_ans_1_mcqActionPerformed

    private void jCheckBox_ans_2_mcqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_ans_2_mcqActionPerformed
        if (jCheckBox_ans_2_mcq.isSelected())
        {
            jCheckBox_ans_1_mcq.setSelected(false);
             jCheckBox_ans_3_mcq.setSelected(false);
              jCheckBox_ans_4_mcq.setSelected(false);
             model_mcq_question.setValueAt("2", counter_mcq,6);
        }
        else
        {
            model_mcq_question.setValueAt("", counter_mcq,6); 
        }
    }//GEN-LAST:event_jCheckBox_ans_2_mcqActionPerformed

    private void jCheckBox_ans_4_mcqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_ans_4_mcqActionPerformed
       if (jCheckBox_ans_4_mcq.isSelected())
        {
            jCheckBox_ans_1_mcq.setSelected(false);
             jCheckBox_ans_3_mcq.setSelected(false);
              jCheckBox_ans_2_mcq.setSelected(false);
             model_mcq_question.setValueAt("4", counter_mcq,6);
        }
        else
        {
            model_mcq_question.setValueAt("", counter_mcq,6); 
        }
    }//GEN-LAST:event_jCheckBox_ans_4_mcqActionPerformed

    private void jCheckBox_tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_tActionPerformed
        // TODO add your handling code here:
         if (jCheckBox_t.isSelected())
        {
            jCheckBox_f.setSelected(false);
             
             model_tf_question.setValueAt("1", counter_tf,2);
        }
        else
        {
            model_tf_question.setValueAt("", counter_tf,2); 
        }
    }//GEN-LAST:event_jCheckBox_tActionPerformed

    private void jCheckBox_fActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_fActionPerformed
        // TODO add your handling code here:
         if (jCheckBox_f.isSelected())
        {
            jCheckBox_t.setSelected(false);
             
             model_tf_question.setValueAt("0", counter_tf,2);
        }
        else
        {
            model_tf_question.setValueAt("", counter_tf,2); 
        }
    }//GEN-LAST:event_jCheckBox_fActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        jPanel_exam.setVisible(false);
        jPanel2.setVisible(true);
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jCheckBox_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_adminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_adminActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        // TODO add your handling code here:
        


        try {
           
            c.stmt=c.conn.createStatement();
            ResultSet rs=c.stmt.executeQuery("select * from current_exam");
           if(rs.next())
            {
               id_exam=rs.getString("id_exam");
                  no_mcq=rs.getString("no-q-m-c-q");
                  no_tf=rs.getString("no-q-t-f");
                  time=rs.getString("time");
                  range=rs.getString("range");
                  String enable=rs.getString("enable");
                  end_time=rs.getString("end_time");
                  
                  
           if (!enable.equals("0"))    
           { 
               load_questions(Integer.parseInt(no_mcq), Integer.parseInt(no_tf),(int) Math.pow(10, range.length()));
                  
                    TimeClass tc = new TimeClass(Integer.parseInt(time)*60);
            timer = new Timer(1000, tc);
                 timer.start();
        jScrollPane1.setVisible(false);
        jPanel_exam.setVisible(true);
           }
            }
        } catch (SQLException ex) {
            Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
          
        
   

    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new gui().setVisible(true);
            }
        });
    }
 
        
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox_admin;
    private javax.swing.JCheckBox jCheckBox_ans_1_mcq;
    private javax.swing.JCheckBox jCheckBox_ans_2_mcq;
    private javax.swing.JCheckBox jCheckBox_ans_3_mcq;
    private javax.swing.JCheckBox jCheckBox_ans_4_mcq;
    private javax.swing.JCheckBox jCheckBox_f;
    private javax.swing.JCheckBox jCheckBox_t;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_mcq_ans_1;
    private javax.swing.JLabel jLabel_mcq_ans_2;
    private javax.swing.JLabel jLabel_mcq_ans_3;
    private javax.swing.JLabel jLabel_mcq_ans_4;
    private javax.swing.JLabel jLabel_question_mcq;
    private javax.swing.JLabel jLabel_question_tf;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_back_login;
    private javax.swing.JPanel jPanel_exam;
    private javax.swing.JPanel jPanel_main;
    private javax.swing.JPanel jPanel_start_exam;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable_mcq;
    private javax.swing.JTable jTable_mcq_help;
    private javax.swing.JTable jTable_tf;
    private javax.swing.JTable jTable_tf_help;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
