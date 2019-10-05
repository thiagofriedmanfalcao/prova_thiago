import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Prova{
    public static void main(String[] args) {
        ArrayList<Integer> vet = new ArrayList<Integer>();  //Declaração do Array
        int AntValor = 0;   //Declaração da variável do valor anterior do vetor
        int i = 0;  //declaração do contador

        //Leitura do arquivo desordenado
        try{
            BufferedReader leitura = new BufferedReader(new FileReader("VetorDesordenado.txt"));
            String value = "";
            while (true){
                if(value != null)
                {
                    if(value != "")
                    {
                        int valorInteiro = Integer.parseInt(value); //converte o valor lido no arquivo txt para inteiro
                        vet.add(valorInteiro); //adiciona o valor lido no arquivo txt no vetor                   
                    }
                }else
                    break;
                    
                value = leitura.readLine(); //lê a próxima linha do arquivo txt
            }
            leitura.close();
        } catch (IOException exception){
            System.out.println("Erro de exceção I/O: " + exception.getMessage());
        }

        //Leitura dos valores vindo do arquivo txt desordenado
        for(i = 0; i < vet.size(); i++){
            System.out.println("Valor Desordenado: " + vet.get(i));
        }
        System.out.println(" ");
            
        int PenultValor = vet.size()-1; //atribui a penultima posição/indíce do array para a variavel PenultValor

        //Função para ordenar os números vindo do arquivo txt desordenado
        for(i = 0; i<vet.size(); i++){ //Estrutura de Repetição, no qual vai repetir até o ultimo registro do array
            for(int j = 0; j<PenultValor; j++){ 
                if(vet.get(j) > vet.get(j+1)) //Compara com o ultimo valor com o penultimo valor
                {
                    AntValor = vet.get(j);
                    int ProxValor = vet.get(j+1);
                    vet.set(j, ProxValor);
                    vet.set(j+1, AntValor);
                }
            }
        }

        //Lista os valores ordenados
        for(i = 0; i<vet.size(); i++){
            System.out.println("Valor Ordenado: "+vet.get(i));
        }

        //Gravação do arquivo txt com o array com os números ordenados
        try{
            BufferedWriter escrita = new BufferedWriter(new FileWriter("VetorOrdenado.txt"));
            
            for(i = 0; i<vet.size(); i++){
                int digitadoInt = vet.get(i);

                String digitado = Integer.toString(digitadoInt);

                escrita.append(digitado + "\n");
                escrita.newLine();
            }
            escrita.close();
        } catch (IOException exception){
            System.out.println("Erro de exceção I/O: " + exception.getMessage());
        }        

        System.out.println("");
        System.out.println("Arquivo de texto gerado com os números ordenados! VetorOrdenado.txt");
    }
    
}