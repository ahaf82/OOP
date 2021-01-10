package KE7.ClientServerCommunication;

import java.io.*;
import java.net.Socket;

import static java.lang.Integer.parseInt;


public class ClientServerCommunication {

    public final static int SERVER_PORT = 7896;

    public static void main (String args[]) throws IOException {
        try {
            String host = "mpaap.mooo.com";
            Socket so = new Socket(host, SERVER_PORT);
            BufferedWriter toServer = new BufferedWriter(new OutputStreamWriter(so.getOutputStream(), "UTF-8"));
            BufferedReader fromServer = new BufferedReader((new InputStreamReader(so.getInputStream(), "UTF-8")));
            String line = fromServer.readLine();

            while ((line = fromServer.readLine()) != null) {
                int result;
                System.out.println(line);
                if (line.equals("ENDE")==false) {
                    if(line.substring(0,7).equals("AUFGABE")) {
                        String string = line.substring(7);
                        String[] parts = string.split(" ");
                        System.out.println(parts[0] + " " + parts[1] + " " + parts[2]);
                        int firstNumber = parseInt(parts[0]);
                        int secondNumber = parseInt(parts[2]);
                        switch (parts[1]) {
                            case "+":
                                result = firstNumber + secondNumber;
                                System.out.println(result);
                                toServer.write(result + "\r\n");
                                toServer.flush();
                                break;
                            case "-":
                                result = firstNumber - secondNumber;
                                System.out.println(result);
                                toServer.write(result + "\r\n");
                                toServer.flush();
                                break;
                            case "*":
                                result = firstNumber * secondNumber;
                                System.out.println(result);
                                toServer.write(result + "\r\n");
                                toServer.flush();
                                break;
                            case "/":
                                result = firstNumber / secondNumber;
                                System.out.println(result);
                                toServer.write(result + "\r\n");
                                toServer.flush();
                                break;
                        }
                    }
                }
            }
        }catch (IOException e) {
            System.out.println(e);
        }
    }
}
