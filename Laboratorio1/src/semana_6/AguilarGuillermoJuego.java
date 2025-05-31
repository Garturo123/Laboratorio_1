package semana_6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AguilarGuillermoJuego extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JuegoPanel juegoPanel;
    private PalabrasPanel palabrasPanel;
    private ArrayList<String> palabras;

    public AguilarGuillermoJuego() {
        setTitle("Juego Ahorcado Express");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Palabras iniciales
        palabras = new ArrayList<>(Arrays.asList(
                "HONDURAS", "JAVA", "TECNOLOGIA", "LENGUAJE", "COMPUTADORA",
                "SOFTWARE", "HARDWARE", "PROYECTO", "DESARROLLO", "EDUCACION"
        ));

        // Paneles y navegación
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Crear panel de menú principal
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(3, 1, 10, 10));
        JButton jugarBtn = new JButton("Jugar");
        JButton cambiarBtn = new JButton("Cambiar Palabras");
        JButton salirBtn = new JButton("Salir");
        jugarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                juegoPanel.palabraActual = palabras.get(new Random().nextInt(palabras.size()));
                juegoPanel.palabraOculta = "";
                for (int i = 0; i < juegoPanel.palabraActual.length(); i++) {
                    juegoPanel.palabraOculta += " _";
                }
                juegoPanel.oportunidades = 5;
                juegoPanel.palabraLabel.setText(juegoPanel.palabraOculta);
                juegoPanel.oportunidadesLabel.setText("Oportunidades: 5");
                juegoPanel.mensajeLabel.setText("");
                cardLayout.show(mainPanel, "Juego");
            }
        });
        cambiarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                palabrasPanel.modeloLista.clear();
                for (String palabra : palabras) {
                    palabrasPanel.modeloLista.addElement(palabra);
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

        // Crear panel de juego
        juegoPanel = new JuegoPanel();
        juegoPanel.ventana = this;
        juegoPanel.setLayout(new BorderLayout(10, 10));
        juegoPanel.palabraLabel = new JLabel("", SwingConstants.CENTER);
        juegoPanel.oportunidadesLabel = new JLabel("Oportunidades: 5", SwingConstants.CENTER);
        juegoPanel.mensajeLabel = new JLabel("", SwingConstants.CENTER);
        juegoPanel.letraField = new JTextField(1);
        juegoPanel.letraField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String entrada = juegoPanel.letraField.getText().toUpperCase();
                juegoPanel.letraField.setText("");
                if (entrada.length() != 1 || !Character.isLetter(entrada.charAt(0))) {
                    juegoPanel.mensajeLabel.setText("Ingresa una sola letra válida.");
                    return;
                }

                char letra = entrada.charAt(0);
                boolean acierto = false;
                char[] palabraOcultaArray = juegoPanel.palabraOculta.toCharArray();

                for (int i = 0; i < juegoPanel.palabraActual.length(); i++) {
                    if (juegoPanel.palabraActual.charAt(i) == letra && juegoPanel.palabraOculta.charAt(i*2+1) == '_') {
                        palabraOcultaArray[i*2+1] = letra;
                        acierto = true;
                    }
                }

                juegoPanel.palabraOculta = new String(palabraOcultaArray);
                if (!acierto) {
                    juegoPanel.oportunidades--;
                    juegoPanel.mensajeLabel.setText("Fallaste. La letra no está.");
                } else {
                    juegoPanel.mensajeLabel.setText("¡Acertaste una letra!");
                }

                juegoPanel.palabraLabel.setText(juegoPanel.palabraOculta);
                juegoPanel.oportunidadesLabel.setText("Oportunidades: " + juegoPanel.oportunidades);

                if (!juegoPanel.palabraOculta.contains("_")) {
                    JOptionPane.showMessageDialog(juegoPanel, "¡Ganaste! La palabra era: " + juegoPanel.palabraActual);
                    cardLayout.show(mainPanel, "Menu");
                } else if (juegoPanel.oportunidades == 0) {
                    JOptionPane.showMessageDialog(juegoPanel, "¡Perdiste! La palabra era: " + juegoPanel.palabraActual);
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
        centroJuego.add(juegoPanel.palabraLabel);
        centroJuego.add(juegoPanel.oportunidadesLabel);
        centroJuego.add(juegoPanel.letraField);
        centroJuego.add(juegoPanel.mensajeLabel);
        juegoPanel.add(centroJuego, BorderLayout.CENTER);
        juegoPanel.add(volverBtnJuego, BorderLayout.SOUTH);

        // Crear panel de palabras
        palabrasPanel = new PalabrasPanel();
        palabrasPanel.ventana = this;
        palabrasPanel.setLayout(new BorderLayout(10, 10));
        palabrasPanel.modeloLista = new DefaultListModel<>();
        palabrasPanel.listaPalabras = new JList<>(palabrasPanel.modeloLista);
        palabrasPanel.nuevaPalabra = new JTextField();
        JButton agregarBtn = new JButton("Reemplazar palabra seleccionada");
        agregarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = palabrasPanel.listaPalabras.getSelectedIndex();
                String nueva = palabrasPanel.nuevaPalabra.getText().trim().toUpperCase();

                if (index >= 0 && !nueva.isEmpty() && nueva.matches("[A-Z]+")) {
                    palabras.set(index, nueva);
                    palabrasPanel.modeloLista.clear();
                    for (String palabra : palabras) {
                        palabrasPanel.modeloLista.addElement(palabra);
                    }
                    palabrasPanel.nuevaPalabra.setText("");
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
        abajoPalabras.add(palabrasPanel.nuevaPalabra);
        abajoPalabras.add(agregarBtn);
        abajoPalabras.add(volverBtnPalabras);
        palabrasPanel.add(new JScrollPane(palabrasPanel.listaPalabras), BorderLayout.CENTER);
        palabrasPanel.add(abajoPalabras, BorderLayout.SOUTH);

        // Actualizar lista de palabras inicial
        palabrasPanel.modeloLista.clear();
        for (String palabra : palabras) {
            palabrasPanel.modeloLista.addElement(palabra);
        }

        mainPanel.add(menuPanel, "Menu");
        mainPanel.add(juegoPanel, "Juego");
        mainPanel.add(palabrasPanel, "Palabras");

        add(mainPanel);
        setVisible(true);
    }

    public ArrayList<String> getPalabras() {
        return palabras;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AguilarGuillermoJuego();
            }
        });
    }
}

class JuegoPanel extends JPanel {
    public AguilarGuillermoJuego ventana;
    public JLabel palabraLabel, mensajeLabel, oportunidadesLabel;
    public JTextField letraField;
    public String palabraActual;
    public String palabraOculta;
    public int oportunidades;
}

class PalabrasPanel extends JPanel {
    public AguilarGuillermoJuego ventana;
    public DefaultListModel<String> modeloLista;
    public JList<String> listaPalabras;
    public JTextField nuevaPalabra;
}