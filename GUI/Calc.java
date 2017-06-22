import javax.swing.*;
public class Calc extends javax.swing.JFrame 
{
    int fresh=1;
    char c='0';
    
    public Calc() 
    {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        txtEnter = new javax.swing.JTextField();
        txtDisplay = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnadd = new javax.swing.JButton();
        btnsub = new javax.swing.JButton();
        btnmul = new javax.swing.JButton();
        btndiv = new javax.swing.JButton();
        btndel = new javax.swing.JButton();
        btncan = new javax.swing.JButton();
        btnpow = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btn3 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btnequ = new javax.swing.JButton();
        btn10 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtOp = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 255));

        txtEnter.setEditable(false);
        txtEnter.setBackground(new java.awt.Color(204, 255, 204));
        txtEnter.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtEnter.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtEnter.setText("0");
        txtEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnterActionPerformed(evt);
            }
        });

        txtDisplay.setEditable(false);
        txtDisplay.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDisplay.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDisplay.setText("0");
        txtDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDisplayActionPerformed(evt);
            }
        });

        btnadd.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnadd.setText("+");
        btnadd.setMaximumSize(new java.awt.Dimension(50, 31));
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnsub.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnsub.setText("-");
        btnsub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsubActionPerformed(evt);
            }
        });

        btnmul.setFont(new java.awt.Font("MV Boli", 0, 18)); // NOI18N
        btnmul.setText("x");
        btnmul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmulActionPerformed(evt);
            }
        });

        btndiv.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btndiv.setText("/");
        btndiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndivActionPerformed(evt);
            }
        });

        btndel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndel.setText("D");
        btndel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelActionPerformed(evt);
            }
        });

        btncan.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        btncan.setForeground(new java.awt.Color(255, 0, 0));
        btncan.setText("C");
        btncan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncanActionPerformed(evt);
            }
        });

        btnpow.setFont(new java.awt.Font("AR BERKLEY", 0, 18)); // NOI18N
        btnpow.setText("y^x");
        btnpow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btndel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnadd, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(btnmul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btndiv, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnsub, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btnpow)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsub))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnmul, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndiv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btndel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnpow))
        );

        btn3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn3.setText("3");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn6.setText("6");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn9.setText("9");
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        btnequ.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnequ.setText("=");
        btnequ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnequActionPerformed(evt);
            }
        });

        btn10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn10.setText("0");
        btn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn10ActionPerformed(evt);
            }
        });

        btn8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn8.setText("8");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        btn5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn5.setText("5");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn2.setText("2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn4.setText("4");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn7.setText("7");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("AR CENA", 0, 12)); // NOI18N
        jButton1.setText("N");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn1)
                    .addComponent(btn7)
                    .addComponent(btn4)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btn10, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnequ))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btn5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btn8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn9)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn3)
                    .addComponent(btn2)
                    .addComponent(btn1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn6)
                    .addComponent(btn5)
                    .addComponent(btn4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn9)
                    .addComponent(btn8)
                    .addComponent(btn7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnequ)
                            .addComponent(btn10))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        txtOp.setEditable(false);
        txtOp.setText(" ");
        txtOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtOp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>                        

    private void txtEnterActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void txtDisplayActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here
        if (fresh==0)
            txtEnter.setText(txtEnter.getText()+"1");
        else
        {
            txtEnter.setText("1");
            fresh=0;
        }
    }                                    

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {                                     
 
        if (fresh==0)
            txtEnter.setText(txtEnter.getText()+"2");
        else
        {
            txtEnter.setText("2");
            fresh=0;
        }
    }                                    

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        if (fresh==0)
            txtEnter.setText(txtEnter.getText()+"3");
        else
        {
            txtEnter.setText("3");
            fresh=0;
        }
    }                                    

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       if (fresh==0)
            txtEnter.setText(txtEnter.getText()+"4");
        else
        {
            txtEnter.setText("4");
            fresh=0;
        }
    }                                    

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        if (fresh==0)
            txtEnter.setText(txtEnter.getText()+"5");
        else
        {
            txtEnter.setText("5");
            fresh=0;
        }
    }                                    

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        if (fresh==0)
            txtEnter.setText(txtEnter.getText()+"6");
        else
        {
            txtEnter.setText("6");
            fresh=0;
        }
    }                                    

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        if (fresh==0)
            txtEnter.setText(txtEnter.getText()+"7");
        else
        {
            txtEnter.setText("7");
            fresh=0;
        }
    }                                    

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       if (fresh==0)
            txtEnter.setText(txtEnter.getText()+"8");
        else
        {
            txtEnter.setText("8");
            fresh=0;
        }
    }                                    

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        if (fresh==0)
            txtEnter.setText(txtEnter.getText()+"9");
        else
        {
            txtEnter.setText("9");
            fresh=0;
        }
    }                                    

    private void btn10ActionPerformed(java.awt.event.ActionEvent evt) {                                      
        if (fresh==0)
            txtEnter.setText(txtEnter.getText()+"0");
        else
        {
            txtEnter.setText("0");
           
        }
    }                                     

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {                                       
        equals((txtOp.getText()).charAt(0));
        txtOp.setText("+");
        fresh=1;
    }                                      

    private void btnsubActionPerformed(java.awt.event.ActionEvent evt) {                                       
        equals((txtOp.getText()).charAt(0));
        txtOp.setText("-");
        fresh=1;
    }                                      

    private void btnmulActionPerformed(java.awt.event.ActionEvent evt) {                                       
        equals((txtOp.getText()).charAt(0));
        txtOp.setText("*");
        fresh=1;
    }                                      

    private void btndivActionPerformed(java.awt.event.ActionEvent evt) {                                       
       equals((txtOp.getText()).charAt(0));
        txtOp.setText("/");
        fresh=1;
    }                                      

    private void btnequActionPerformed(java.awt.event.ActionEvent evt) {                                       
      equals((txtOp.getText()).charAt(0));
      txtEnter.setText(txtDisplay.getText());
      txtDisplay.setText("0");
      txtOp.setText(" ");
    }                                      

    private void btncanActionPerformed(java.awt.event.ActionEvent evt) {                                       
        txtDisplay.setText("0");
        txtEnter.setText("0");
        fresh=1;
        txtOp.setText(" ");
    }                                      

    private void txtOpActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }                                     

    private void btndelActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        txtEnter.setText((txtEnter.getText()).substring(0,(txtEnter.getText()).length()-1));
        if (txtEnter.getText().length()==0)
        {
            txtEnter.setText("0");
            fresh=1;
        }
    }                                      

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       
        txtEnter.setText(Long.valueOf(txtEnter.getText())*(-1)+"");
    }                                        

    private void btnpowActionPerformed(java.awt.event.ActionEvent evt) {                                       
         equals((txtOp.getText()).charAt(0));
        txtOp.setText("^");
        fresh=1;
    }                                      
    
    private void equals(char x)
    {
        try
        {
            switch (x)
            {
                case '+':
                {
                    txtDisplay.setText(Long.valueOf(txtDisplay.getText())+Long.valueOf(txtEnter.getText())+"");
                    break;
                }
                case '-':
                {
                    txtDisplay.setText(Long.valueOf(txtDisplay.getText())-Long.valueOf(txtEnter.getText())+"");
                     break;
                 }
                 case '*':
                 {
                     if (Long.valueOf(txtDisplay.getText())==0)
                     {
                         txtDisplay.setText(Long.valueOf(txtEnter.getText())+"");
                         break;
                     }  
                     txtDisplay.setText(Long.valueOf(txtDisplay.getText())*Long.valueOf(txtEnter.getText())+"");
                     break;
                 }
                 case '/':
                 {
                     txtDisplay.setText(Long.valueOf(txtDisplay.getText())/Long.valueOf(txtEnter.getText())+"");
                     break;
                 }
                 case '^':
                 {
                     txtDisplay.setText((long)Math.pow((double)Long.valueOf(txtDisplay.getText()),(double)Long.valueOf(txtEnter.getText()))+"");
                     break;
                 }
                 default:
                 {
                     txtDisplay.setText(txtEnter.getText());
                 }
            }//switch
        }//try
        catch(Exception e)
        {
            txtEnter.setText("0");
            txtDisplay.setText("0");
            txtOp.setText(" ");
            fresh=1;
            JOptionPane.showMessageDialog (null,"Math Error");
        }//catch
    }
   
   
    public static void main(String args[]) 
    {
        try 
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) 
        {
            java.util.logging.Logger.getLogger(Calc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                new Calc().setVisible(true);
            }
        }
        );
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btncan;
    private javax.swing.JButton btndel;
    private javax.swing.JButton btndiv;
    private javax.swing.JButton btnequ;
    private javax.swing.JButton btnmul;
    private javax.swing.JButton btnpow;
    private javax.swing.JButton btnsub;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtDisplay;
    private javax.swing.JTextField txtEnter;
    private javax.swing.JTextField txtOp;
    // End of variables declaration                   
}
