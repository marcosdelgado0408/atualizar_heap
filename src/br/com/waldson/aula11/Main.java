package br.com.waldson.aula11;

import br.com.waldson.aula12.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //Heap / Priority Queue
        FilaBanco fila = new FilaBanco();
        fila.addPessoa("Fulano", 20);
        fila.addPessoa("Sicrano", 10);
        fila.addPessoa("Vovó", 64);
        fila.addPessoa("Tio", 50);
        fila.addPessoa(new Pessoa("Beltrano", 5));

        fila.getPessoas();


        while (fila.getSize() > 0) {
            System.out.println(Arrays.toString(fila.getPessoas()));

            Pessoa p = fila.peek();
            System.out.println(p.getNome() + " está sendo atendido.");
            fila.remove();
        }



    }
}
