package java_quiz;


import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
class quiz extends JFrame implements ActionListener  
{  
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    quiz(String s)  
    {  
        super(s);  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Next");  
        b2=new JButton("Bookmark");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        add(b1);add(b2);  
        set();  
        l.setBounds(30,40,450,20);  
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);  
    }  
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Bookmark"))  
        {  
            JButton bk=new JButton("Bookmark"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
                b2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Bookmark"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            //System.out.println("correct ans="+count);  
            JOptionPane.showMessageDialog(this,"CORRECT ANSWERS ARE ="+count);  
            //System.exit(0); 
            /*JOptionPane.showMessageDialog(this,"THANK YOU FOR ATTENDING QUIZ"); 
            System.exit(0);*/
            JOptionPane.showMessageDialog(this,"WRONG ANSWERS ARE ="+(10-count)); 
            if(count<=4)
            {
            	JOptionPane.showMessageDialog(this,"FAIL"); 
            	
            }
            if(count>=6)
            {
            	JOptionPane.showMessageDialog(this,"PASS"); 
            }
            
            else if(count>=7)
            {
            	JOptionPane.showMessageDialog(this,"EXCELLENT"); 
            }
            JOptionPane.showMessageDialog(this,"THANK YOU FOR ATTENDING QUIZ!"); 
            System.exit(0);
        }  
    }  
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Que1: Which one among these is not a primitive datatype?");  
            jb[0].setText("int");jb[1].setText("Float");jb[2].setText("boolean");jb[3].setText("char");   
        }  
        if(current==1)  
        {  
            l.setText("Que2:  What is the size of boolean in java?");  
            jb[0].setText("8bit");jb[1].setText("1bit");jb[2].setText("32bit");jb[3].setText("not precisely defined");  
        }  
        if(current==2)  
        {  
            l.setText("Que3: Which of the following is not an OOPS concept in Java?");  
            jb[0].setText("Polymorphism");jb[1].setText("Inheritance");jb[2].setText("Encapsulation");jb[3].setText("Compilation");  
        }  
        if(current==3)  
        {  
            l.setText("Que4:  Which of the following is a superclass of every class in Java?");  
            jb[0].setText("object class");jb[1].setText("Array list");jb[2].setText("Abstract class");jb[3].setText("String");  
        }  
        if(current==4)  
        {  
            l.setText("Que5: Which one of the following is not an access modifier?");  
            jb[0].setText("public");jb[1].setText("private");jb[2].setText("void");jb[3].setText("protected");  
        }  
        if(current==5)  
        {  
            l.setText("Que6: Which one among these is not a keyword?");  
            jb[0].setText("class");jb[1].setText("int");jb[2].setText("get");jb[3].setText("if");  
        }  
        if(current==6)  
        {  
            l.setText("Que7:  What is the return type of the hashCode() method in the Object class? ");  
            jb[0].setText("long");jb[1].setText("int");jb[2].setText("object");  
                        jb[3].setText("object");  
        }  
        if(current==7)  
        {  
            l.setText("Que8: In which memory a String is stored, when we create a string using new operator?");  
            jb[0].setText("heap");jb[1].setText("static");jb[2].setText("random strorage memory");  
                        jb[3].setText("string memory");         
        }  
        if(current==8)  
        {  
            l.setText("Que9: Which of these operators is used to allocate memory to array variable in Java?");  
            jb[0].setText("calloc");jb[1].setText("malloc");jb[2].setText("new");jb[3].setText("none");  
        }  
        if(current==9)  
        {  
            l.setText("Que10: Which one among these is not a valid component?");  
            jb[0].setText("JButton");jb[1].setText("JList");jb[2].setText("JButtonGroup");  
                        jb[3].setText("JTextArea");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[1].isSelected());  
        if(current==1)  
            return(jb[1].isSelected());  
        if(current==2)  
            return(jb[3].isSelected());  
        if(current==3)  
            return(jb[0].isSelected());  
        if(current==4)  
            return(jb[2].isSelected());  
        if(current==5)  
            return(jb[2].isSelected());  
        if(current==6)  
            return(jb[1].isSelected());  
        if(current==7)  
            return(jb[0].isSelected());  
        if(current==8)  
            return(jb[2].isSelected());  
        if(current==9)  
            return(jb[2].isSelected());  
        return false;  
    }  
    public static void main(String s[])  
    {  
        new quiz("Online Test Of Java");  
    }  
}  





