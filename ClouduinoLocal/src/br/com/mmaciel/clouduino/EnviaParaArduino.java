package br.com.mmaciel.clouduino;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.io.OutputStream;
import java.util.Enumeration;

/**
 *
 * @author marcomaciel
 */
public class EnviaParaArduino {

    static boolean init = false;
    static Enumeration portList;
    static CommPortIdentifier portId;
    static String messageString = "10";
    static SerialPort serialPort;
    static OutputStream outputStream;
    static boolean outputBufferEmptyFlag = false;
    // Essa eh a porta serial no mac osx. Mude para o nome correto
    // se for usar Linux ou Windows. 
    static String defaultPort = "/dev/tty.usbserial-A600bWE7";

    public static void delay(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException ex) {
        }

    }

    public static void init() {
        init = true;
        portList = CommPortIdentifier.getPortIdentifiers();

        System.out.println("Iniciando");
        while (portList.hasMoreElements()) {
            portId = (CommPortIdentifier) portList.nextElement();
            System.out.println(portId.getName());
            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                if (portId.getName().equals(defaultPort)) {
                    System.out.println("Found port " + defaultPort);
                    try {
                        serialPort = (SerialPort) portId.open(defaultPort, 9600);
                    } catch (Exception e) {
                        System.out.println("Porta serial em uso.");
                        continue;
                    }
                    try {

                        outputStream = serialPort.getOutputStream();

                        serialPort.setSerialPortParams(9600,
                                SerialPort.DATABITS_8,
                                SerialPort.STOPBITS_1,
                                SerialPort.PARITY_NONE);

                        serialPort.notifyOnOutputEmpty(true);

                    } catch (Exception e) {
                        System.out.println("Erro...");
                        System.out.println(e.toString());
                    }
                }
            }
        }
    }

    public static void enviar(byte bytes[]) throws Exception {
        if (!init) {
            init();
        }

        System.out.println("Enviando comando para o Arduino...");
        outputStream.write(bytes);

    }
}
