package br.com.mmaciel.clouduino;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author marcomaciel
 */
class LeituraThread extends Thread {

    String mensagemJSON = null;
    String mensagem = null;

    public void run() {

        while (true) {
            try {
                mensagemJSON = LerServlet.leUrl();
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                }
                System.out.print("json= " + mensagemJSON + " ");
                
                mensagem = parseJSONData(mensagemJSON);
                System.out.println("msg = " + mensagem);
                
                if (!mensagem.equals("")||mensagem==null){
                    EnviaParaArduino.enviar(mensagem.getBytes());
                }
                
            } catch (Exception ex) {
                Logger.getLogger(LeituraThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public String parseJSONData(String mensagemJSON) throws JSONException {

        String jsonData = mensagemJSON;
        JSONObject jObj = new JSONObject(jsonData);
        if (!jObj.getString("mensagem").equals("")) {
            this.mensagemJSON = jObj.getString("mensagem");
        } else {
            this.mensagemJSON = "";
        }
        return this.mensagemJSON;

    }
}