import java.util.Scanner;

class Nodo {
    int valor;
    Nodo izq, der;
    Nodo(int v) { valor = v; }
}

public class Main {
    static Nodo raiz = null;

    // Insertar número
    static Nodo insertar(Nodo n, int v) {
        if (n == null) return new Nodo(v);
        if (v < n.valor) n.izq = insertar(n.izq, v);
        else if (v > n.valor) n.der = insertar(n.der, v);
        return n;
    }

    // Recorrido inorden
    static void inorden(Nodo n) {
        if (n != null) {
            inorden(n.izq);
            System.out.print(n.valor + " ");
            inorden(n.der);
        }
    }

    // Buscar número
    static boolean buscar(Nodo n, int v) {
        if (n == null) return false;
        if (n.valor == v) return true;
        return v < n.valor ? buscar(n.izq, v) : buscar(n.der, v);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op, num;

        do {
            System.out.println("\n1. Insertar");
            System.out.println("2. Mostrar inorden");
            System.out.println("3. Buscar");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            op = sc.nextInt();

            if (op == 1) {
                System.out.print("Número: ");
                num = sc.nextInt();
                raiz = insertar(raiz, num);
            } else if (op == 2) {
                inorden(raiz);
                System.out.println();
            } else if (op == 3) {
                System.out.print("Buscar número: ");
                num = sc.nextInt();
                System.out.println(buscar(raiz, num) ? "Existe" : "No existe");
            }
        } while (op != 4);
    }
}
