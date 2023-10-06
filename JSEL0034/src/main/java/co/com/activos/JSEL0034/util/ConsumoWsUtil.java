package co.com.activos.JSEL0034.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsumoWsUtil {

    public String consumirWebService(String endPoint, String xmlInput) {
        String responseString = "";
        if ((endPoint != null) && (xmlInput != null)) {
            try {
                URL URLForSOAP = new URL(endPoint);
                URLConnection URLConnectionForSOAP = URLForSOAP.openConnection();
                HttpURLConnection Connection = (HttpURLConnection) URLConnectionForSOAP;
                Connection.setDoOutput(true);
                Connection.setDoInput(true);
                Connection.setRequestMethod("POST");
                Connection.setRequestProperty("Host", getHostNameFromUrl(endPoint));
                Connection.setRequestProperty("Content-Type", "application/soap+xml; charset=utf-8");
                OutputStreamWriter soapRequestWriter = new OutputStreamWriter(Connection.getOutputStream());
                soapRequestWriter.write(xmlInput);
                soapRequestWriter.flush();
                BufferedReader soapRequestReader = new BufferedReader(new InputStreamReader(Connection.getInputStream()));
                String line;
                while ((line = soapRequestReader.readLine()) != null) {
                    responseString = responseString.concat(line);
                }
                soapRequestWriter.close();
                soapRequestReader.close();
                Connection.disconnect();
            } catch (MalformedURLException ex) {
                Logger.getLogger(ConsumoWsUtil.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("JSEL0034 - ConsumoWsUtil.consumirWebService : " + ex.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(ConsumoWsUtil.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("JSEL0034 - ConsumoWsUtil.consumirWebService : " + ex.getMessage());
            }
        }
        return responseString;
    }

    public static String getHostNameFromUrl(String urlString) {
        return urlString.substring(7, urlString.indexOf("/", 7));
    }
}
