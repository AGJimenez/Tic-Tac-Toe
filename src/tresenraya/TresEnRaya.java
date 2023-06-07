/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tresenraya;

/**
 *
 * @author alexg
 */
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
public class TresEnRaya {
    static String jugar;
    static ArrayList<Integer> posicionJugador = new ArrayList<Integer>();
    static ArrayList<Integer> posicionCPU = new ArrayList<Integer>();
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        //Imprimir tablero
        do{
        char[][]tableroJuego = {{' ','|',' ','|',' '},{'-','+','-','+','-'},
            {' ','|',' ','|',' '},{'-','+','-','+','-'},{' ','|',' ','|',' '}};
        imprimirTablero(tableroJuego);
            
        Scanner scan = new Scanner(System.in);
        
        while(true){
         System.out.println("Introduce posición del 1 al 9");
        int posicionJugado=scan.nextInt();
        while(posicionJugador.contains(posicionJugado)|| posicionCPU.contains(posicionJugado)){
            System.out.println("Posicion ya usada, introduce otra");
            posicionJugado = scan.nextInt();
        }
        ponerPieza(tableroJuego, posicionJugado, "jugador");
        
        String ganador = comprobarVictoria();
            if(ganador.length()>0){
                System.out.println(ganador);
                imprimirTablero(tableroJuego);
                    System.out.println("Jugar otra vez? si/no");
        jugar=scan.nextLine();
        if(jugar.equals("no")){
            break;
        }
                }
            
        Random rand= new Random();
        int posicionCPUU = rand.nextInt(9)+1;
        while(posicionJugador.contains(posicionCPUU)|| posicionCPU.contains(posicionCPUU)){
            posicionCPUU = rand.nextInt(9)+1;
        }
        ponerPieza(tableroJuego, posicionCPUU, "CPU");
          if(ganador.length()>0){
              System.out.println(ganador);
              imprimirTablero(tableroJuego);
                   break;
                }
              imprimirTablero(tableroJuego);
              
        }
        }while(jugar.equals("si"));
        }
        
        public static void imprimirTablero(char[][]tableroJuego){
            for(char[]fila:tableroJuego){
                for(char c:fila){
                    System.out.print(c);
                }
                    System.out.println();
            }
        }
        
        public static void ponerPieza(char[][]tableroJuego, int posicion, String usuario){
            char symbol = ' ';
            if(usuario.equals("jugador")){
                symbol = 'X';
                posicionJugador.add(posicion);
            }else if(usuario.equals("CPU")){
                symbol = 'O';
                posicionCPU.add(posicion);
            }
            
            switch(posicion){
                case 1:
                   tableroJuego[0][0] = symbol;
                   break;
                case 2:
                   tableroJuego[0][2] = symbol;
                   break;
                case 3:
                   tableroJuego[0][4] = symbol;
                   break;
                case 4:
                   tableroJuego[2][0] = symbol;
                   break;
                case 5:
                   tableroJuego[2][2] = symbol;
                   break;
                case 6:
                   tableroJuego[2][4] = symbol;
                   break;
                case 7:
                   tableroJuego[4][0] = symbol;
                   break;
                case 8:
                   tableroJuego[4][2] = symbol;
                   break;
                case 9:
                   tableroJuego[4][4] = symbol;
                   break;
                default:
                    break;
            }
        }
        
        public static String comprobarVictoria(){
            
            List filaArriba = Arrays.asList(1,2,3);
            List filaMedio = Arrays.asList(4,5,6);
            List filaAbajo = Arrays.asList(7,8,9);
            
            List colIzq = Arrays.asList(1,4,7);
            List colMedio = Arrays.asList(2,5,8);
            List colDer = Arrays.asList(3,6,9);
            
            List cruzando1 = Arrays.asList(1,5,9);
            List cruzando2 = Arrays.asList(7,5,3);
            
            List<List> condicionGanar = new ArrayList<List>();
            condicionGanar.add(filaArriba);
            condicionGanar.add(filaMedio);
            condicionGanar.add(filaAbajo);
            condicionGanar.add(colIzq);
            condicionGanar.add(colMedio);
            condicionGanar.add(colDer);
            condicionGanar.add(cruzando1);
            condicionGanar.add(cruzando2);
            
            for(List l: condicionGanar){
                if(posicionJugador.containsAll(l)){
                    return "Felicidades, has ganado";
                }else if(posicionCPU.containsAll(l)){
                    return "Gana la CPU";
                }else if(posicionJugador.size()+posicionCPU.size()== 9){
                    return "Empate";
                }
            }
            return "";
        }
        
        
    }
    

