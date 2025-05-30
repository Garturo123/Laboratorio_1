package semana_6;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * @author gaat1
 */
public class AguilarGuillermoJuegoPalabras {
    public static void main(String[] args) {
        // Crear la ventana
        JFrame ventana = new JFrame("Mi primera ventana Swing");
        ventana.setLayout(new BorderLayout());
        JButton Palabras_Alazar = new JButton("Palabras alazar");
        JButton Cadena = new JButton("Ingresar lista de palabras");

        Palabras_Alazar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame nuevaVentana = new JFrame("Nueva Página");
                
                nuevaVentana.setLayout(new FlowLayout());
                JLabel etiqueta = new JLabel("Palabra alazar: ");
                JTextField campoTexto = new JTextField(20); 
                JButton mostrar = new JButton("Mostrar texto");
                mostrar.addActionListener(i -> {
                    String textoIngresado = campoTexto.getText();
                    etiqueta.setText("Ingresaste: " + textoIngresado);
                });

                nuevaVentana.add(etiqueta);
                nuevaVentana.add(campoTexto);
                nuevaVentana.setSize(300, 150);
                nuevaVentana.setVisible(true);
            }
        });
        

        Cadena.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ventana, "¡Hola desde Swing!");
            }
        });
        

        JPanel panelCentral = new JPanel(new GridLayout(1, 2));
        panelCentral.add(Palabras_Alazar);
        panelCentral.add(Cadena);

        JPanel panelInferior = new JPanel(new FlowLayout());
        panelInferior.add(new JButton("Salir"));
        
        ventana.add(panelCentral, BorderLayout.CENTER);
        ventana.add(panelInferior, BorderLayout.SOUTH);

        ventana.setSize(700, 500); 
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
