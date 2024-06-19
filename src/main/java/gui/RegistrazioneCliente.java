package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import com.fasterxml.jackson.databind.ObjectMapper;
public class RegistrazioneCliente extends JFrame {

    private JPanel RegistrazionePanel;
    private JButton avantiButton;
    private JTextField cfField;
    private JTextField nomeField;
    private JTextField cognomeField;
    private JTextField emailField;
    private JTextField passwordField;
    private JLabel campiVuoti;

    public RegistrazioneCliente(){
        setContentPane(RegistrazionePanel);
        setTitle("Aeroporto Lamezia Terme");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 700);
        setLocationRelativeTo(null);
        campiVuoti.setVisible(false);
        setVisible(true);
        getContentPane().setBackground(new Color(173, 216, 230));
        avantiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO inserire il controllo dei dati
                String CF = cfField.getText();
                String nome = nomeField.getText();
                String cognome = cognomeField.getText();
                String email = emailField.getText();
                String password = passwordField.getText();
                if(CF.isEmpty()||nome.isEmpty()||cognome.isEmpty()||email.isEmpty()||password.isEmpty()){
                    campiVuoti.setVisible(true);
                }
                else {
                    Cliente cliente = new Cliente(CF, nome, cognome, email, password);
                    boolean success = sendPostRequest(cliente);
                    if (success) {
                        RegistrazioneMetodoDiPagamento regM = new RegistrazioneMetodoDiPagamento(CF,nome,cognome,email,password);
                        regM.setVisible(true);
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Registrazione fallita. Riprova.");
                    }
                }
            }
        });


    }
    private boolean sendPostRequest(Cliente cliente) {
        try {
            URL url = new URL("http://localhost:8080/passeggeri"); // Cambia l'URL se necessario
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonInputString = objectMapper.writeValueAsString(cliente);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) {
                return true;
            } else {
                System.out.println("POST request failed: " + responseCode);
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void main(String... args){
        new RegistrazioneCliente();
    }
}
