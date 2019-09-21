/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rock_sissor_paper;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Hkobir
 */
public class Gamefield extends javax.swing.JFrame {

    /**
     * Creates new form Gamefield
     */
  

    /**
     * Creates new form Gamefield
     */
    private Path filePath;
       int uscore=0, cscore=0;   //gather wining score
      int highscore=0;
      int roc=1,sissor=2,paper=3;
      int user=0;
      int computer;
      String uselect=null;              //get the user selected name
      String cselect=null;
      Random rand=new Random();
      void computer(){
      computer=rand.nextInt(3)+1;
        switch (computer) {
            case 1:
                cselect="Rock";
                break;
            case 2:
                cselect="Sissor";
                break;
            default:
                cselect="Paper";
                break;
        }
      }
      
      void highscore(){
           Scanner s1 = null;
           filePath =Paths.get("highscore.txt");
 // score=Integer.parseInt(jTextField1.getText());
 
 
 
 
 //open a text file and retrive content from its
 if(Files.exists(filePath)){
        try {
            FileInputStream ob= new FileInputStream("highscore.txt");
            s1=new Scanner(ob);
            //s1=new Scanner(new FileInputStream("d:\\log.txt"));
        } catch (FileNotFoundException ex) {
           System.out.print(ex);
        }
         while(s1.hasNext()) {
          highscore=Integer.parseInt(s1.next());
         }
         if(uscore<=highscore){
         
         
            jTextField7.setText(""+highscore);
         }
                if(uscore>highscore){
          try {
                 
			String content = Integer.toString(uscore);
                        
                        
                        
            //open a text file and set content text to its            

          try (FileWriter fw = new FileWriter("highscore.txt")) {
              BufferedWriter bw = new BufferedWriter(fw);
              bw.write(content);
              bw.close();
          }
		} catch (IOException e) {

			 System.out.println(e);

		}
          
          //JOptionPane.showMessageDialog(null, "New high Score.."+uscore);
             jTextField7.setText(""+uscore);
             jLabel13.setText("new");
          }
         
         
      }
 else{
       try (FileWriter fw = new FileWriter("highscore.txt")) {
              BufferedWriter bw = new BufferedWriter(fw);
              bw.write("10");
              bw.close();
          }
     catch (IOException e) {

			 System.out.println(e);

		}
     
     
 }
          
          
      }
      
      
      
      void decide() throws IOException{
          
          
          
           if(user==1&&computer==1){
               
              // ImageIcon uicon = new ImageIcon(new ImageIcon("user_rock.png").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
 jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_image/user_rock.png"))); //set image into jlabel manualy by code;
//ImageIcon comicon = new ImageIcon(new ImageIcon("computer_rock.png").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
  jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_image/computer_rock.png"))); //set image into jlabel manualy by code;

               
            jTextField3.setText(uselect);
            jTextField6.setText(cselect);
           jTextField4.setText("Match Tied..");
          jTextField1.setText(""+uscore);
          jTextField2.setText(""+cscore);
       }
           
                    else  if(user==2&&computer==2){
                        
                        //ImageIcon uicon = new ImageIcon(new ImageIcon("user_sissor.png").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
 jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_image/user_sissor.png"))); //set image into jlabel manualy by code;

//ImageIcon comicon = new ImageIcon(new ImageIcon("computer_sissor.png").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
  jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_image/computer_sissor.png"))); //set image into jlabel manualy by code;

                        
            jTextField3.setText(uselect);
            jTextField6.setText(cselect);
           jTextField4.setText("Match Tied..");
          jTextField1.setText(""+uscore);
          jTextField2.setText(""+cscore);
       }
                    
                    else  if(user==3&&computer==3){
                        
                       // ImageIcon uicon = new ImageIcon(new ImageIcon("user_paper.png").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
 jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_image/user_paper.png"))); //set image into jlabel manualy by code;

//ImageIcon comicon = new ImageIcon(new ImageIcon("computer_paper.png").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
  jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_image/computer_paper.png"))); //set image into jlabel manualy by code;

                        
                        
            jTextField3.setText(uselect);
            jTextField6.setText(cselect);
           jTextField4.setText("Match Tied..");
          jTextField1.setText(""+uscore);
          jTextField2.setText(""+cscore);
       }
           
           
       else if(user==1&&computer==2){
           
 //ImageIcon uicon = new ImageIcon(new ImageIcon("user_rock.png").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
 jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_image/user_rock.png"))); //set image into jlabel manualy by code;

//ImageIcon comicon = new ImageIcon(new ImageIcon("computer_sissor.png").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
  jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_image/computer_sissor.png"))); //set image into jlabel manualy by code;

  
        jTextField3.setText(uselect);
            jTextField6.setText(cselect);
             jTextField4.setText("You win..");
              uscore++;
              jTextField1.setText(""+uscore);
          jTextField2.setText(""+cscore);
       }
       else if(user==1&&computer==3){
           
     // ImageIcon uicon = new ImageIcon(new ImageIcon("user_rock.png").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
 jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_image/user_rock.png"))); //set image into jlabel manualy by code;

//ImageIcon comicon = new ImageIcon(new ImageIcon("computer_paper.png").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
  jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_image/computer_paper.png"))); //set image into jlabel manualy by code;

     
         jTextField3.setText(uselect);
            jTextField6.setText(cselect);
             jTextField4.setText("Opponent win..");
              cscore++;
              jTextField1.setText(""+uscore);
          jTextField2.setText(""+cscore);
       }
       else if(user==2&&computer==1){
           
           //ImageIcon uicon = new ImageIcon(new ImageIcon("user_sissor.png").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
 jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_image/user_sissor.png"))); //set image into jlabel manualy by code;

//ImageIcon comicon = new ImageIcon(new ImageIcon("computer_rock.png").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
  jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_image/computer_rock.png"))); //set image into jlabel manualy by code;

           
           
           
             jTextField3.setText(uselect);
            jTextField6.setText(cselect);
             jTextField4.setText("Opponent win..");
              cscore++;
              jTextField1.setText(""+uscore);
          jTextField2.setText(""+cscore);
       }
       else if(user==2&&computer==3){
           
     // ImageIcon uicon = new ImageIcon(new ImageIcon("user_sissor.png").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
 jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_image/user_sissor.png"))); //set image into jlabel manualy by code;

//ImageIcon comicon = new ImageIcon(new ImageIcon("computer_paper.png").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
  jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_image/computer_paper.png"))); //set image into jlabel manualy by code;

           
                     jTextField3.setText(uselect);
            jTextField6.setText(cselect);
             jTextField4.setText("You win..");
              uscore++;
              jTextField1.setText(""+uscore);
          jTextField2.setText(""+cscore);
       }
       else if(user==3&&computer==1){
           
          //ImageIcon uicon = new ImageIcon(new ImageIcon("user_paper.png").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
 jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_image/user_paper.png"))); //set image into jlabel manualy by code;

//ImageIcon comicon = new ImageIcon(new ImageIcon("computer_rock.png").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
  jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_image/computer_rock.png"))); //set image into jlabel manualy by code;

           
           
        jTextField3.setText(uselect);
            jTextField6.setText(cselect);
             jTextField4.setText("You win..");
              uscore++;
              jTextField1.setText(""+uscore);
          jTextField2.setText(""+cscore);
       }
                       else{
           
          // ImageIcon uicon = new ImageIcon(new ImageIcon("user_paper.png").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
 jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_image/user_paper.png"))); //set image into jlabel manualy by code;

//ImageIcon comicon = new ImageIcon(new ImageIcon("computer_sissor.png").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
  jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_image/computer_sissor.png"))); //set image into jlabel manualy by code;

           
                  jTextField3.setText(uselect);
            jTextField6.setText(cselect);
             jTextField4.setText("Opponent win..");
              cscore++;
              jTextField1.setText(""+uscore);
          jTextField2.setText(""+cscore);
       }
      }
      
    public Gamefield() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rock-Sissor-Paper");

        jPanel3.setBackground(new java.awt.Color(51, 0, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel4.setFont(new java.awt.Font("Maiandra GD", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 255));
        jLabel4.setText("You:");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(0, 0, 153));
        jTextField1.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(0, 0, 153));
        jTextField2.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("Score:");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_image/user_score.png"))); // NOI18N
        jLabel8.setText("jLabel8");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_image/com_score.png"))); // NOI18N
        jLabel9.setText("jLabel9");

        jLabel5.setFont(new java.awt.Font("Maiandra GD", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 255));
        jLabel5.setText(":Opponent");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(255, 255, 204));
        jTextField6.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 51, 51));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("You Selected:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(":Opponent Selected");

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(255, 255, 204));
        jTextField3.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 51, 51));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(102, 102, 255));
        jTextField4.setFont(new java.awt.Font("Lucida Calligraphy", 1, 16)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 153));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setBorder(new javax.swing.border.MatteBorder(null));

        jButton1.setBackground(new java.awt.Color(51, 51, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_image/Rock_Button.png"))); // NOI18N
        jButton1.setText("Rock");
        jButton1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 51, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_image/sissor_Button.png"))); // NOI18N
        jButton2.setText("Sissor");
        jButton2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 51, 255));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_image/paper_Button.png"))); // NOI18N
        jButton3.setText("Paper");
        jButton3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setText("Opponent");

        jLabel7.setText("User");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_image/user_score.png"))); // NOI18N
        jLabel11.setText("jLabel8");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_image/com_score.png"))); // NOI18N
        jLabel12.setText("jLabel9");

        jButton4.setBackground(new java.awt.Color(255, 255, 204));
        jButton4.setFont(new java.awt.Font("Lucida Calligraphy", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 0, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_image/exitbutton.png"))); // NOI18N
        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2)
                                        .addGap(219, 219, 219)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(44, 44, 44)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(231, 231, 231)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(65, 65, 65)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(235, 235, 235)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jButton1)
                .addGap(30, 30, 30)
                .addComponent(jButton2)
                .addGap(25, 25, 25)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(7, 7, 7)
                .addComponent(jButton4)
                .addContainerGap())
        );

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(0, 51, 51));
        jTextField5.setFont(new java.awt.Font("Lucida Handwriting", 1, 18)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.setText("ROCK-SISSOR-PAPER( GAME)");
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 0, 102));
        jLabel10.setText("High Score:");

        jTextField7.setEditable(false);
        jTextField7.setBackground(new java.awt.Color(51, 51, 0));
        jTextField7.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         user=1;
         uselect="Rock";
         computer();
          try {
              decide();
              highscore();
          } catch (IOException ex) {
              Logger.getLogger(Gamefield.class.getName()).log(Level.SEVERE, null, ex);
          }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        user=2;
        uselect="Sissor";
        computer();
          try {
              decide();
               highscore();
          } catch (IOException ex) {
              Logger.getLogger(Gamefield.class.getName()).log(Level.SEVERE, null, ex);
          }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         user=3;
         uselect="Paper";
         computer();
          try {
              decide();
               highscore();
          } catch (IOException ex) {
              Logger.getLogger(Gamefield.class.getName()).log(Level.SEVERE, null, ex);
          }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
   
          
             
         
        this.hide();
        new Final_result(uscore,cscore,highscore).setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Gamefield.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gamefield.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gamefield.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gamefield.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Gamefield ob =new Gamefield();
                 ob.highscore();
                 ob.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
