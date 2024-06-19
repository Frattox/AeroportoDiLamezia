package gui;


import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class RegistrazioneMetodoDiPagamento extends JFrame{
    private JButton registraButton;
    private JPanel regMpanel;
    private JTextField numeroCartaField;
    private JTextField tipologiaField;
    private JTextField limiteTransazioneField;
    private JLabel campiVuoti;


    public RegistrazioneMetodoDiPagamento(Passeggero passeggero){
        setContentPane(regMpanel);
        setTitle("Aeroporto Lamezia Terme");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 700);
        setLocationRelativeTo(null);
        campiVuoti.setVisible(false);
        setVisible(true);

        getContentPane().setBackground(new Color(173, 216, 230));
        registraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String numero =  numeroCartaField.getText();
                String tipo = tipologiaField.getText();
                String limite = limiteTransazioneField.getText();
                int numeroI =0, limiteI=0;
                if(numero.isEmpty() || tipo.isEmpty()||limite.isEmpty() ){
                    campiVuoti.setVisible(true);
                }
                else {

                    try{
                    numeroI = Integer.parseInt(numero);
                    limiteI = Integer.parseInt(limite);}
                    catch(Exception ex){
                        campiVuoti.setVisible(true);
                    }


                    LoginCliente logC = new LoginCliente();
                    logC.setVisible(true);
                    setVisible(false);
                }
                MetodoDiPagamento metodo = new MetodoDiPagamento(numeroI, tipo, limiteI, passeggero);
                boolean success = sendPostRequest(metodo);
                if (success) {
                    LoginCliente logC = new LoginCliente();
                    logC.setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Registrazione fallita. Riprova.");
                }
           }
        });

    }
    private boolean sendPostRequest(MetodoDiPagamento metodo) {
        try {
            URL url = new URL("http://localhost:8080/metodoPagamento"); // Cambia l'URL se necessario
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonInputString = objectMapper.writeValueAsString(metodo);

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

}
