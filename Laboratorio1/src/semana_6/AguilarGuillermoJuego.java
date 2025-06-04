package semana_6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AguilarGuillermoJuego extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Crear la ventana principal
                JFrame frame = new JFrame("Juego Ahorcado Express");
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.setSize(600, 400);
                frame.setLocationRelativeTo(null);

                ArrayList<String> palabras = new ArrayList<>(Arrays.asList(
                        "SANDIA", "MANZANA", "TECNOLOGIA", "CLASE", "ESTRES",
                        "SOFTWARE", "TAREA", "PROYECTO", "CARRO", "HAMBRE"
                ));

                CardLayout cardLayout = new CardLayout();
                JPanel mainPanel = new JPanel(cardLayout);

                final String[] palabraActual = {""};
                final String[] palabraOculta = {""};
                final int[] oportunidades = {5};

                JLabel palabraLabel = new JLabel("", SwingConstants.CENTER);
                JLabel oportunidadesLabel = new JLabel("Oportunidades: 5", SwingConstants.CENTER);
                JLabel mensajeLabel = new JLabel("", SwingConstants.CENTER);
                JTextField letraField = new JTextField(1);

                JPanel menuPanel = new JPanel();
                menuPanel.setLayout(new GridLayout(3, 1, 10, 10));
                JButton jugarBtn = new JButton("Jugar");
                JButton cambiarBtn = new JButton("Cambiar Palabras");
                JButton salirBtn = new JButton("Salir");
                
                jugarBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        palabraActual[0] = palabras.get(new Random().nextInt(palabras.size()));
                        palabraOculta[0] = "";
                        for (int i = 0; i < palabraActual[0].length(); i++) {
                            palabraOculta[0] += " _";
                        }
                        oportunidades[0] = 5;
                        palabraLabel.setText(palabraOculta[0]);
                        oportunidadesLabel.setText("Oportunidades: 5");
                        mensajeLabel.setText("");
                        cardLayout.show(mainPanel, "Juego");
                    }
                });
                
                cambiarBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        DefaultListModel<String> modeloLista = (DefaultListModel<String>) ((JList<String>)((JScrollPane)((JPanel)mainPanel.getComponent(2)).getComponent(0)).getViewport().getView()).getModel();
                        modeloLista.clear();
                        for (String palabra : palabras) {
                            modeloLista.addElement(palabra);
                        }
                        cardLayout.show(mainPanel, "Palabras");
                    }
                });
                
                salirBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
                
                menuPanel.add(jugarBtn);
                menuPanel.add(cambiarBtn);
                menuPanel.add(salirBtn);

                // Panel de juego
                JPanel juegoPanel = new JPanel();
                juegoPanel.setLayout(new BorderLayout(10, 10));
                
                letraField.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String entrada = letraField.getText().toUpperCase();
                        letraField.setText("");
                        if (entrada.length() != 1 || !Character.isLetter(entrada.charAt(0))) {
                            mensajeLabel.setText("Ingresa una sola letra válida.");
                            return;
                        }

                        char letra = entrada.charAt(0);
                        boolean acierto = false;
                        char[] palabraOcultaArray = palabraOculta[0].toCharArray();

                        for (int i = 0; i < palabraActual[0].length(); i++) {
                            if (palabraActual[0].charAt(i) == letra && palabraOculta[0].charAt(i*2+1) == '_') {
                                palabraOcultaArray[i*2+1] = letra;
                                acierto = true;
                            }
                        }

                        palabraOculta[0] = new String(palabraOcultaArray);
                        if (!acierto) {
                            oportunidades[0]--;
                            mensajeLabel.setText("Fallaste. La letra no está.");
                        } else {
                            mensajeLabel.setText("¡Acertaste una letra!");
                        }

                        palabraLabel.setText(palabraOculta[0]);
                        oportunidadesLabel.setText("Oportunidades: " + oportunidades[0]);

                        if (!palabraOculta[0].contains("_")) {
                            JOptionPane.showMessageDialog(juegoPanel, "¡Ganaste! La palabra era: " + palabraActual[0]);
                            cardLayout.show(mainPanel, "Menu");
                        } else if (oportunidades[0] == 0) {
                            JOptionPane.showMessageDialog(juegoPanel, "¡Perdiste! La palabra era: " + palabraActual[0]);
                            cardLayout.show(mainPanel, "Menu");
                        }
                    }
                });
                
                JButton volverBtnJuego = new JButton("Volver al Menú");
                volverBtnJuego.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        cardLayout.show(mainPanel, "Menu");
                    }
                });
                
                JPanel centroJuego = new JPanel(new GridLayout(4, 1));
                centroJuego.add(palabraLabel);
                centroJuego.add(oportunidadesLabel);
                centroJuego.add(letraField);
                centroJuego.add(mensajeLabel);
                juegoPanel.add(centroJuego, BorderLayout.CENTER);
                juegoPanel.add(volverBtnJuego, BorderLayout.SOUTH);

                // Panel de palabras
                JPanel palabrasPanel = new JPanel();
                palabrasPanel.setLayout(new BorderLayout(10, 10));
                
                DefaultListModel<String> modeloLista = new DefaultListModel<>();
                JList<String> listaPalabras = new JList<>(modeloLista);
                JTextField nuevaPalabra = new JTextField();
                
                JButton agregarBtn = new JButton("Reemplazar palabra seleccionada");
                agregarBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int index = listaPalabras.getSelectedIndex();
                        String nueva = nuevaPalabra.getText().trim().toUpperCase();

                        if (index >= 0 && !nueva.isEmpty() && nueva.matches("[A-Z]+")) {
                            palabras.set(index, nueva);
                            modeloLista.clear();
                            for (String palabra : palabras) {
                                modeloLista.addElement(palabra);
                            }
                            nuevaPalabra.setText("");
                        } else {
                            JOptionPane.showMessageDialog(palabrasPanel, "Selecciona una palabra y escribe una nueva válida.");
                        }
                    }
                });
                
                JButton volverBtnPalabras = new JButton("Volver al Menú");
                volverBtnPalabras.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        cardLayout.show(mainPanel, "Menu");
                    }
                });
                
                JPanel abajoPalabras = new JPanel(new GridLayout(3, 1));
                abajoPalabras.add(nuevaPalabra);
                abajoPalabras.add(agregarBtn);
                abajoPalabras.add(volverBtnPalabras);
                palabrasPanel.add(new JScrollPane(listaPalabras), BorderLayout.CENTER);
                palabrasPanel.add(abajoPalabras, BorderLayout.SOUTH);

                // Actualizar lista de palabras inicial
                modeloLista.clear();
                for (String palabra : palabras) {
                    modeloLista.addElement(palabra);
                }

                mainPanel.add(menuPanel, "Menu");
                mainPanel.add(juegoPanel, "Juego");
                mainPanel.add(palabrasPanel, "Palabras");

                frame.add(mainPanel);
                frame.setVisible(true);
            }
        });
    }
}