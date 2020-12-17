package client;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ChatHistory {
    private static Writer out;

    private static String getFileName(String login) {
        return "history/" + login + ".txt";
    }

    public static void createWriter(String login) {
        try {
            out = new OutputStreamWriter (new FileOutputStream (getFileName (login), true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void stopWriting() {
        try {
            out.close ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public static void writeText(String msg) {
        try {
            out.write (msg);
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public static String getLastLines(String login) {
        if (!Files.notExists (Paths.get (getFileName (login)))) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            List<String> historyLines = Files.readAllLines(Paths.get(getFileName (login)));
            sb.append(historyLines).append(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
