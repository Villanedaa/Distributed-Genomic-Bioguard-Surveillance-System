package org.breaze;

import org.breaze.network.*;
import org.breaze.common.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inicialización de tu infraestructura de red
        IConfigReader reader = new PropertiesManager("application.properties");
        ITCPConfig tcpConfig = new TCPConfig(reader);
        IMessageService client = new TCPClient(tcpConfig);

        Scanner sc = new Scanner(System.in);

        System.out.println("--- SISTEMA DE PACIENTES ---");
        System.out.println("1. Registrar | 2. Consultar");
        String op = sc.nextLine();

        switch (op) {
            case "1":
                System.out.print("DocumentoId: "); String id = sc.nextLine();
                System.out.print("Nombre: "); String nom = sc.nextLine();
                System.out.print("Apellido: "); String ape = sc.nextLine();
                System.out.print("Edad: "); String ed = sc.nextLine();
                System.out.print("Correo: "); String cor = sc.nextLine();
                System.out.print("Género: "); String gen = sc.nextLine();
                System.out.print("Ciudad: "); String ciu = sc.nextLine();
                System.out.print("País: "); String pa = sc.nextLine();

                // Empaquetamos todo para el servidor
                String msgReg = String.format("REGISTRAR:%s:%s:%s:%s:%s:%s:%s:%s",
                        id, nom, ape, ed, cor, gen, ciu, pa);

                // Enviamos vía IMessageService
                String resReg = client.sendMessage(msgReg);
                System.out.println("Servidor respondió: " + resReg);
                break;

            case "2":
                System.out.print("Ingrese DocumentoId: ");
                String idBusqueda = sc.nextLine();
                String resCon = client.sendMessage("CONSULTAR:" + idBusqueda);
                System.out.println("Resultado: " + resCon);
                break;
        }
    }
}