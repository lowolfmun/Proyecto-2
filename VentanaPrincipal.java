import javax.swing.*; // Importa componentes de Swing para crear la interfaz gráfica.
import java.awt.*; // Importa clases relacionadas con diseño y gráficos.
import java.awt.event.ActionEvent; // Importa eventos para manejar acciones de usuario.
import java.awt.event.ActionListener; // Importa la interfaz para manejar eventos de acción.

/**
 * Clase VentanaPrincipal
 * Representa la ventana principal de la aplicación gráfica.
 * Permite al usuario seleccionar entre funcionalidades relacionadas con
 * un árbol binario y una pila, abriendo ventanas específicas para cada una.
 */
public class VentanaPrincipal extends JFrame {
    // Atributos
    private VentanaArbol ventanaArbol; // Ventana secundaria para la funcionalidad del árbol binario.
    private VentanaPila ventanaPila; // Ventana secundaria para la funcionalidad de la pila.

    /**
     * Constructor VentanaPrincipal
     * Configura la ventana principal de la aplicación.
     * Incluye título, tamaño, comportamiento de cierre y disposición de componentes.
     */
    public VentanaPrincipal() {
        setTitle("Proyecto 2: Pila y Árbol Binario"); // Establece el título de la ventana.
        setSize(500, 400); // Define el tamaño de la ventana (ancho x alto en píxeles).
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura la acción de cierre de la ventana.
        setLayout(new BorderLayout()); // Usa un diseño de bordes para organizar los componentes.

        // Panel superior para contener los botones.
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout()); // Diseño de flujo para organizar los botones en línea.

        // Botones para acceder a funcionalidades específicas.
        JButton botonArbol = new JButton("Arbol"); // Botón que abre la ventana del árbol.
        JButton botonPila = new JButton("Pila"); // Botón que abre la ventana de la pila.

        // Agrega los botones al panel superior.
        panelSuperior.add(botonArbol);
        panelSuperior.add(botonPila);

        // Agrega el panel superior a la parte superior de la ventana principal.
        add(panelSuperior, BorderLayout.NORTH);

        // Asigna un manejador de eventos al botón "Arbol".
        botonArbol.addActionListener(new ActionListener() {
            /**
             * Método que maneja la acción del botón "Arbol".
             * Abre la ventana secundaria para funcionalidades del árbol.
             *
             * @param e Evento de acción generado al hacer clic.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                manejarArbol(); // Llama al método para manejar la funcionalidad del árbol.
            }
        });

        // Asigna un manejador de eventos al botón "Pila".
        botonPila.addActionListener(new ActionListener() {
            /**
             * Método que maneja la acción del botón "Pila".
             * Abre la ventana secundaria para funcionalidades de la pila.
             *
             * @param e Evento de acción generado al hacer clic.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                manejarPila(); // Llama al método para manejar la funcionalidad de la pila.
            }
        });
    }

    /**
     * Método manejarArbol
     * Crea y muestra la ventana secundaria para funcionalidades del árbol.
     */
    private void manejarArbol() {
        ventanaArbol = new VentanaArbol(); // Instancia la ventana del árbol.
        ventanaArbol.setVisible(true); // Hace visible la ventana del árbol.
    }

    /**
     * Método manejarPila
     * Crea y muestra la ventana secundaria para funcionalidades de la pila.
     */
    private void manejarPila() {
        ventanaPila = new VentanaPila(); // Instancia la ventana de la pila.
        ventanaPila.setVisible(true); // Hace visible la ventana de la pila.
    }
}
