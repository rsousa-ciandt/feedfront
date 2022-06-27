package com.ciandt.feedfront.employee;

import com.ciandt.feedfront.excecoes.ArquivoException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListaEmployee {
    private List<Employee> employees = new ArrayList<>();
    String arquivoCriado = "";

    public void criarArquivoRepositorio(String nomeDoArquivo){
        arquivoCriado += nomeDoArquivo+".txt";
        File arquivo = new File(arquivoCriado);
        try {
            if (!arquivo.createNewFile()) {
                System.out.println("Arquivo já existe!");
            } else {

            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void criarEmployee(Employee employee) throws ArquivoException {
        if (arquivoCriado == "") {
            throw new ArquivoException("Arquivo repositório ainda não foi inicializado!");
        } else {
            employees.add(employee);
            try {
                FileWriter fileWriter = new FileWriter(arquivoCriado);
                fileWriter.write(employee.toString());
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Houve um erro :(. Tente novamente!");
                e.getMessage();
            }
        }
    }

    public void criarEmployee(int indice, Employee employee) throws ArquivoException {
        if (arquivoCriado == "") {
            throw new ArquivoException("Arquivo repositório ainda não foi inicializado!");
        } else {
            employees.add(indice, employee);
            try {
                FileWriter fileWriter = new FileWriter(arquivoCriado);
                fileWriter.write(employee.toString());
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Houve um erro :(. Tente novamente!");
                e.getMessage();
            }
        }
    }

}
