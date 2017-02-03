package pilaslistas;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Raul Humberto Juliao
 */
public class PilasListas {

    public static Scanner in = new Scanner(System.in);
    public static Nodo PTRp = null;

    public static void main(String[] args) {
        // TODO code application logic here
        int op;
        do {
            System.out.println("Opciones menú listas pilas: \n"
                    + "1. Agregar datos a la lista en forma de pila\n"
                    + "2. Ver datos en la lista\n"
                    + "3. Intercambiar dos posiciones en la lista\n"
                    + "0. Salir");
            op = in.nextInt();
            switch (op) {
                case 1:
                    inPilaLista();
                    break;
                case 2:
                    showAll();
                    break;
                case 3:

                    intercambiarPos();
                    break;
                default:
                    op = 0;
                    break;
            }
            System.out.println(" ");
        } while (op != 0);

    }

    public static void inPilaLista() {
        boolean sw;
        int op;
        Nodo q;
        do {
            System.out.println("Digite info del nodo: ");
            int num = in.nextInt();
            q = new Nodo(num);
            q.link = PTRp;
            PTRp = q;
            System.out.println("Desea insertar mas nodos? 1 -> Si. 0 -> No");
            op = in.nextInt();

            sw = (op == 1);
        } while (sw);
    }

    public static int canPilaLista() {

        Nodo q = PTRp;

        PTRp = q.link;
        q.link = null;
        return q.dato;
    }

    public static void showAll() {
        Nodo q = PTRp;

        while (q.link != null) {
            System.out.print("| " + q.dato);
            q = q.link;
        }
    }

    public static void intercambiarPos() {
        System.out.println("Ingrese la posición 1:");
        int pos1 = in.nextInt();
        System.out.println("Ingrese la posición 2:");
        int pos2 = in.nextInt();

        if (pos1 < comprobarPosicion() && pos2 < comprobarPosicion()) {

            if (pos1 < pos2) {

                sacarMeter(pos1, pos2);

            } else {
                sacarMeter(pos2, pos1);
            }

        } else {
            JOptionPane.showMessageDialog(null, "¡Posiciones incorrectas!",
                    "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
            
        }
    }

    //Devuelve el valor del tamaño de la lista
    public static int comprobarPosicion() {

        if (PTRp != null) {
            Nodo q = PTRp;
            int sum = 1;
            while (q.link != null) {
                q = q.link;
                sum += 1;
            }

            return sum;
        } else {
            JOptionPane.showMessageDialog(null, "PILA VACIA", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    public static void inPila(int num) {
        Nodo q = new Nodo(num);
        q = new Nodo(num);
        q.link = PTRp;
        PTRp = q;

    }

    public static void sacarMeter(int pos1, int pos2) {

        int sum = 1;
        int datoS[] = new int[50];
        int dato = canPilaLista(); //retorna el primer valor 

        while (sum != pos1) {
            
            datoS[sum] = dato;
            dato = canPilaLista();
            sum += 1;
        }
        int temp1 = dato;
        JOptionPane.showMessageDialog(null, "El dato en la posición: "+ pos1 +
                " es: "+ temp1,"Intercambiar posición", JOptionPane.INFORMATION_MESSAGE);
        dato = canPilaLista();

        while (sum != pos2) {
            
            datoS[sum] = dato;
            dato = canPilaLista();
            sum += 1;
        }

        inPila(temp1);
        temp1 = dato;
        JOptionPane.showMessageDialog(null, "El dato en la posición: "+ pos2 +
                " es: "+ temp1,"Intercambiar posición", JOptionPane.INFORMATION_MESSAGE);
        System.out.println(temp1+ "");
        while (sum != 0) {
            
            dato = datoS[sum - 1];
            if (pos1 == sum) {
                inPila(temp1);
            }else{
                inPila(dato);
            }
            sum -= 1;
        }
    }

}
