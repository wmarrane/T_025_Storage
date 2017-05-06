package br.com.energy.t_025_storage.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by addmn.cassio on 06/05/2017.
 */

public class Util {

    public static void writeFile(String mensagem, String path, String fileName) {

        File diretorio = new File(path);
        if (!diretorio.exists()) {
            diretorio.mkdir();
        }
        FileWriter f;
        try {
            f = new FileWriter(
                    path + "/" + fileName,
                    true
            );
            f.append(mensagem);
            f.flush();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String readFile(String path, String fileName) {
        StringBuilder conteudo = new StringBuilder();
        File diretorio = new File(path);

        if (!diretorio.exists()) {
            return "";
        }
        File arquivo = new File(path + "/" + fileName);

        if (!arquivo.exists()) {
            return "";
        }
        //
        try {
            BufferedReader input = new BufferedReader(new FileReader(arquivo));
            String linha = null;

            //processo de leitura e acumulacao
            while ((linha = input.readLine()) != null) {
                conteudo.append(linha);
            }
            input.close();
        } catch (Exception e) {
            conteudo.append(e.toString());
        }
        return conteudo.toString();

    }

    public static void deleteFile(String path, String fileName) {

        File diretorio = new File(path);

        if (!diretorio.exists()) {
            return;
        }
        File arquivo = new File(path + "/" + fileName);

        if (arquivo.exists()) {
           arquivo.delete();
        }

    }

}
