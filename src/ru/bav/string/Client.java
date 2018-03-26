package ru.bav.string;

/**
 * @author Barinov 15IT18
 */

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try (Socket socket = new Socket("localhost", 8079);
             InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {

            while (true){
                String string;
                System.out.println("Введите строку для отправки на сервер: ");
                string = scan.nextLine();
                writer.write(string);
                System.out.println("Отправил клиент: " + string);
                System.out.println("Сервер прислал: " + string);
                if (string.equals("Конец")){
                    break;
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

