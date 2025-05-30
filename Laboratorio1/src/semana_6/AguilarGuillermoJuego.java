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

        // Crear paneles
        JPanel menuPanel = crearMenuPrincipal();
        juegoPanel = new JuegoPanel(this);
        palabrasPanel = new PalabrasPanel(this);

        mainPanel.add(menuPanel, "Menu");
        mainPanel.add(juegoPanel, "Juego");
        mainPanel.add(palabrasPanel, "Palabras");

        add(mainPanel);
        setVisible(true);
    }

    private JPanel crearMenuPrincipal() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));

        JButton jugarBtn = new JButton("Jugar");
        JButton cambiarBtn = new JButton("Cambiar Palabras");
        JButton salirBtn = new JButton("Salir");

        jugarBtn.addActionListener(e -> {
            juegoPanel.iniciarJuego();
            cardLayout.show(mainPanel, "Juego");
        });

        cambiarBtn.addActionListener(e -> {
            palabrasPanel.actualizarLista();
            cardLayout.show(mainPanel, "Palabras");
        });

        salirBtn.addActionListener(e -> System.exit(0));

        panel.add(jugarBtn);
        panel.add(cambiarBtn);
        panel.add(salirBtn);

        return panel;
    }

    public ArrayList<String> getPalabras() {
        return palabras;
    }

    public void volverAlMenu() {
        cardLayout.show(mainPanel, "Menu");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AguilarGuillermoJuego());
    }
}

// Panel del juego
class JuegoPanel extends JPanel {
    private AguilarGuillermoJuego ventana;
    private JLabel palabraLabel, mensajeLabel, oportunidadesLabel;
    private JTextField letraField;
    private String palabraActual;
    private String palabraOculta;
    private int oportunidades;

    public JuegoPanel(AguilarGuillermoJuego ventana) {
        this.ventana = ventana;
        setLayout(new BorderLayout(10, 10));

        palabraLabel = new JLabel("", SwingConstants.CENTER);
       
        oportunidadesLabel = new JLabel("Oportunidades: 5", SwingConstants.CENTER);
        mensajeLabel = new JLabel("", SwingConstants.CENTER);

        letraField = new JTextField(1);
        letraField.addActionListener(e -> verificarLetra());

        JButton volverBtn = new JButton("Volver al Menú");
        volverBtn.addActionListener(e -> ventana.volverAlMenu());

        JPanel centro = new JPanel(new GridLayout(4, 1));
        centro.add(palabraLabel);
        centro.add(oportunidadesLabel);
        centro.add(letraField);
        centro.add(mensajeLabel);

        add(centro, BorderLayout.CENTER);
        add(volverBtn, BorderLayout.SOUTH);
    }

    public void iniciarJuego() {
        Random rand = new Random();
        palabraActual = ventana.getPalabras().get(rand.nextInt(ventana.getPalabras().size()));
        
        for (i =0; palabraActual.length() > i;i++){
            palabraOculta += " _";
        }
        Arrays.fill(palabraOculta, '_');
        oportunidades = 5;
        actualizarVista();
    }

    private void verificarLetra() {
        String entrada = letraField.getText().toUpperCase();
        letraField.setText("");
        if (entrada.length() != 1 || !Character.isLetter(entrada.charAt(0))) {
            mensajeLabel.setText("Ingresa una sola letra válida.");
            return;
        }

        char letra = entrada.charAt(0);
        boolean acierto = false;

        for (int i = 0; i < palabraActual.length(); i++) {
            if (palabraActual.charAt(i) == letra && palabraOculta.charAt(i+1) == '_') {
                palabraOculta.charAt(i) = letra;
                acierto = true;
            }
        }

        if (!acierto) {
            oportunidades--;
            mensajeLabel.setText("Fallaste. La letra no está.");
        } else {
            mensajeLabel.setText("¡Acertaste una letra!");
        }

        actualizarVista();

        if (String.valueOf(palabraOculta).equals(palabraActual)) {
            JOptionPane.showMessageDialog(this, "¡Ganaste! La palabra era: " + palabraActual);
            ventana.volverAlMenu();
        } else if (oportunidades == 0) {
            JOptionPane.showMessageDialog(this, "¡Perdiste! La palabra era: " + palabraActual);
            ventana.volverAlMenu();
        }
    }

    private void actualizarVista() {
        palabraLabel.setText(String.valueOf(palabraOculta));
        oportunidadesLabel.setText("Oportunidades: " + oportunidades);
    }
}

// Panel para cambiar palabras
class PalabrasPanel extends JPanel {
    private AguilarGuillermoJuego ventana;
    private DefaultListModel<String> modeloLista;
    private JList<String> listaPalabras;
    private JTextField nuevaPalabra;

    public PalabrasPanel(AguilarGuillermoJuego ventana) {
        this.ventana = ventana;
        setLayout(new BorderLayout(10, 10));

        modeloLista = new DefaultListModel<>();
        listaPalabras = new JList<>(modeloLista);
        nuevaPalabra = new JTextField();

        JButton agregarBtn = new JButton("Reemplazar palabra seleccionada");
        agregarBtn.addActionListener(e -> reemplazarPalabra());

        JButton volverBtn = new JButton("Volver al Menú");
        volverBtn.addActionListener(e -> ventana.volverAlMenu());

        JPanel abajo = new JPanel(new GridLayout(3, 1));
        abajo.add(nuevaPalabra);
        abajo.add(agregarBtn);
        abajo.add(volverBtn);

        add(new JScrollPane(listaPalabras), BorderLayout.CENTER);
        add(abajo, BorderLayout.SOUTH);
    }

    public void actualizarLista() {
        modeloLista.clear();
        for (String palabra : ventana.getPalabras()) {
            modeloLista.addElement(palabra);
        }
    }

    private void reemplazarPalabra() {
        int index = listaPalabras.getSelectedIndex();
        String nueva = nuevaPalabra.getText().trim().toUpperCase();

        if (index >= 0 && !nueva.isEmpty() && nueva.matches("[A-Z]+")) {
            ventana.getPalabras().set(index, nueva);
            actualizarLista();
            nuevaPalabra.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una palabra y escribe una nueva válida.");
        }
    }
}
