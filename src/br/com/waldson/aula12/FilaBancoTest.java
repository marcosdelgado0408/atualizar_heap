package br.com.waldson.aula12;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FilaBancoTest {

    FilaBanco fila = null;

    @Before
    public void init() {
        fila = new FilaBanco();
    }

    @Test
    public void mustBeOrdered() {
        //Arrange
        Pessoa vovo    = new Pessoa("Vovó", 65);
        Pessoa fulano  = new Pessoa("Fulano", 10);
        Pessoa sicrano = new Pessoa("Sicrano", 25);

        //Act
        fila.addPessoa(fulano);
        fila.addPessoa(vovo);
        fila.addPessoa(sicrano);

        //Assert
        assertSame(vovo, fila.peek());
        fila.remove();
        assertSame(sicrano, fila.peek());
        fila.remove();
        assertSame(fulano, fila.peek());
        fila.remove();
        assertNull(fila.peek());
    }

    @Test
    public void mustReorderWhenPriorityChange() {
        //Arrange
        Pessoa vovo    = new Pessoa("Vovó", 65);
        Pessoa fulano  = new Pessoa("Fulano", 10);
        Pessoa sicrano = new Pessoa("Sicrano", 25);
        fila.addPessoa(fulano);
        fila.addPessoa(vovo);
        fila.addPessoa(sicrano);

        System.out.println(Arrays.toString(fila.getPessoas()));

        //Act
        fulano.setIdade(67,fila); // fulano acaba sendo mais velho, mas não muda a prioridade


        System.out.println(Arrays.toString(fila.getPessoas()));


        //Assert
        assertSame(fulano, fila.peek());
    }

    @Test
    public void peekMustReturnAddedElement() {
        //Arrange
        Pessoa node  = new Pessoa("Fulano", 10);

        //Act
        fila.addPessoa(node);

        //Assert
        assertSame(node, fila.peek());
    }

    @Test
    public void mustBeInitializedEmpty() {
        //Assert
        assertNull(fila.peek());
    }

}