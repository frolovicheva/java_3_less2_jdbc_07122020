package client;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ChatHistory {
    private static OutputStreamWriter out;

    private static String getFileName(String login) {
        return "history/history_" + login + ".txt";
    }

    public static void createWriter(String login) {
        try {
            out = new OutputStreamWriter (new FileOutputStream(getFileName (login), true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void stop() {
        if (out != null) {
            try {
                out.close ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }
    }

    public static void writeText(String msg) {
        try {
            out.write (msg + System.lineSeparator ());
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public static String getLastHistory(String login) {
        if (!Files.exists(Paths.get(getFileName (login)))) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            List<String> historyLines = Files.readAllLines(Paths.get(getFileName (login)));
            for (String historyLine : historyLines) {
                sb.append (historyLine).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}