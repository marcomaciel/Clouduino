package br.com.mmaciel.clouduino;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author marcomaciel
 */
public class LerServlet {

    public static String leUrl() {
        StringBuilder resultado = new StringBuilder();
        try {
            URL url = new URL("http://clouduino.appspot.com/ObtemDadosServlet");
            // para ler na aplicacao local
            //URL url = new URL("http://localhost:8888/ObtemDadosServlet");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                resultado.append(line);
            }
            reader.close();

        } catch (Exception e) {
        }
        return resultado.toString();
    }
}