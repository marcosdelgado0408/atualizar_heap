package br.com.waldson.aula12;

import java.util.Arrays;

public class FilaBanco{

    private Pessoa[] pessoas;
    private int size;//quantos elementos tem
    private int capacity; //quantos elementos pode ter


    public Pessoa[] getPessoas() { return pessoas; }

    public FilaBanco() {
        this(10);
    }

    public FilaBanco(int capacity) {

        pessoas = new Pessoa[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public void addPessoa(String nome, int idade) {
        addPessoa(new Pessoa(nome, idade));
    }

    public void addPessoa(Pessoa pessoa) {
        this.ensureCapacity();
        this.pessoas[getSize()] = pessoa;
        heapifyUp(getSize());
        size++;
    }

    private void heapifyUp(int index) {
        if (!hasParent(index)) {
            return;
        }
        int parentIndex = getParentIndex(index);

        Pessoa node = pessoas[index];
        Pessoa pai  = pessoas[parentIndex];

        if (node.getIdade() > pai.getIdade()) {
            pessoas[index] = pai;
            pessoas[parentIndex] = node;
            heapifyUp(parentIndex);
        }
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0 && getParentIndex(index) < size;
    }

    private int getParentIndex(int index) {
        return (int) Math.floor((index - 1) / 2);
    }

    private void ensureCapacity() {
        if (getSize() == capacity) {
            this.pessoas = Arrays.copyOf(this.pessoas, getSize() * 2);
            capacity     = getSize() * 2;
        }
    }

    public int getSize() {
        return size;
    }

    public Pessoa peek() {
        if (getSize() == 0)  {
            return null;
        }

        return pessoas[0];
    }

    public void remove() {
        pessoas[0] = pessoas[getSize() - 1];
        pessoas[getSize() - 1] = null;
        size--;
        manutencaoPrioriade(0);
        heapifyDown(0);
   }

    private void heapifyDown(int index) {
        int leftChild  = index * 2 + 1;
        int rightChild = index * 2 + 2;

        int childIndex = -1;

        if (leftChild < getSize()) {
            childIndex = leftChild;
        }

        if (childIndex < 0) {
            return;
        }

        if (rightChild < getSize()) {
            if (pessoas[rightChild].getIdade() > pessoas[leftChild].getIdade()) {
                childIndex = rightChild;
            }
        }

        if (pessoas[index].getIdade() < pessoas[childIndex].getIdade()) {
            Pessoa tmp          = pessoas[index];
            pessoas[index]      = pessoas[childIndex];
            pessoas[childIndex] = tmp;
            heapifyDown(childIndex);
        }
    }





    public void swap(int posicao1, int posicao2){
        Pessoa temp =  pessoas[posicao1];
        pessoas[posicao1] = pessoas[posicao2];
        pessoas[posicao2] = temp;
    }


    public boolean isLeaf(int pos){
        return (pos >= (size/2) && pos <= size); // retorna True se satisfazet essa condição
    }


    public int leftChild(int pos){
        return (2 * pos);
    }


    public int rightChild(int pos){
        return (2 * pos) + 1;
    }


    public void manutencaoPrioriade(int posicao){ // A->vetor , m -> tamanho do vetor, i-> índice
        if(this.isLeaf(posicao)){
            return;
        }

        if(pessoas[posicao].getIdade() < pessoas[leftChild(posicao)].getIdade() || pessoas[posicao].getIdade() < pessoas[rightChild(posicao)].getIdade()){

            if(pessoas[leftChild(posicao)].getIdade() > pessoas[rightChild(posicao)].getIdade()){
                swap(posicao,leftChild(posicao));
                manutencaoPrioriade(leftChild(posicao));
            }
            else {
                swap(posicao,rightChild(posicao));
                manutencaoPrioriade(rightChild(posicao));
            }

        }

    }


}
