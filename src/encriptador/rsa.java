
package encriptador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class rsa extends JFrame implements ActionListener {

    JLabel texto;
    JLabel lblN;
    JLabel lblP;
    JLabel lblQ;
    JTextField numN;
    JTextField numP;
    JTextField numQ;
    JTextField palabra;
    JButton boton;
    JTextArea area;
    JScrollPane barra;

    public rsa() {
        super();                   
        configurarVentana();        
        inicializarComponentes();
    }

    private void configurarVentana() {
        this.setTitle("ENCRIPTA");                  
        this.setSize(800, 600);                                 
        this.setLocationRelativeTo(null);                      
        this.setLayout(null);                                   
        this.setResizable(false);                             
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    }

    private void inicializarComponentes() {
     
        texto = new JLabel();
        lblN= new JLabel();
        lblP= new JLabel();
        lblQ= new JLabel();
        numN = new JTextField();
        numP = new JTextField();
        numQ = new JTextField();
        palabra = new JTextField();
        boton = new JButton();
        area = new JTextArea(180,180);
        barra = new JScrollPane();
        barra.setViewportView(area);
        
        texto.setText("Ingrese palabra a encriptar");  
            texto.setBounds(480, 20, 200, 25);
        lblN.setText("Inserte un número n");           
            lblN.setBounds(20, 20, 115, 25);
        lblP.setText("Inserte un número p");
            lblP.setBounds(160, 20, 115, 25);
        lblQ.setText("Inserte un número q");   
            lblQ.setBounds(300, 20, 115, 25);
            
        numN.setBounds(20, 50, 80, 25);
        numP.setBounds(160, 50, 80, 25); 
        numQ.setBounds(300, 50, 80, 25);
        palabra.setBounds(480, 50, 115, 25);
        area.setBounds(80,250,650,250);
        area.setEditable(false);
        
        
        boton.setText("ENCRIPTAR");   
            boton.setBounds(300, 150, 200, 70);  
            boton.addActionListener(this);
            
        this.add(texto);
        this.add(lblN);
        this.add(lblP);
        this.add(lblQ);
        this.add(numN);
        this.add(numP);
        this.add(numQ);
        this.add(palabra);
        this.add(boton);
        this.add(area);
        this.add(barra);
        
    }
    /*private void vacio(){
        if(numN.getText().equals("")) { 
            JOptionPane.showMessageDialog(this,"El campo no puede estar vacio","Error",JOptionPane.ERROR_MESSAGE); 
        }
    }*/
    @Override
    public void actionPerformed(ActionEvent e) {
        int n = Integer.parseInt(numN.getText());
        int p = Integer.parseInt(numP.getText());
        int q = Integer.parseInt(numQ.getText());
        boolean val = false;
        if(numN.getText().equals("")) { 
            JOptionPane.showMessageDialog(this,"El campo no puede estar vacio","Error",JOptionPane.ERROR_MESSAGE);
        } else { 
        }
        for(int i = 2; i <= n/2; ++i){

            if(n % i == 0){
                val = true;
                break;
            }
        }    
        if (val){
            JOptionPane.showMessageDialog(this,"INTRODUZCA NÚMEROS PRIMOS");
            numN.setText("");
        }
        else{
            for(int i = 2; i <= p/2; ++i){

                if(p % i == 0){
                    val = true;
                    break;
                }
            }
            if (val){
                JOptionPane.showMessageDialog(this,"INTRODUZCA NÚMEROS PRIMOS");
                numP.setText("");
            }
            else{
                for(int i = 2; i <= q/2; ++i){

                    if(q % i == 0){
                        val = true;
                        break;
                    }
                }
                if (val){
                    JOptionPane.showMessageDialog(this,"INTRODUZCA NÚMEROS PRIMOS");
                    numQ.setText("");
                }
            }
        }
    }
    
   
}

