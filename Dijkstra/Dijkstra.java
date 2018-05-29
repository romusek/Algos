import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra {
    public static PriorityQueue<Edge> kolej = new PriorityQueue<>(new Komparator());
    public static int[] d = new int[10000];//10000 max wierzcholkow
    public static int MAX = 2000000000;
    public static int n, k;//liczba wierzcholkow i krawedzi
    public static ArrayList<ArrayList<Edge>> t = new ArrayList<>();
    public static void main(String[]asd) {
        czytanie("C://Users//rober//Documents//Algos//src//test.txt");
        System.out.println(GO(1,4));
    }

    public static int GO(int wej, int wyj) {
        Edge tmp;
        d[wej] = 0;
        Edge przydatneTMP;// = new Edge();
        while(!kolej.isEmpty()) {
            tmp = kolej.poll();
            for (int i=0; i<t.get(tmp.getCel()).size(); i++) {
                if (d[t.get(tmp.getCel()).get(i).getCel()] > d[tmp.getCel()] + t.get(tmp.getCel()).get(i).getKoszt()) {
                    d[t.get(tmp.getCel()).get(i).getCel()] = d[tmp.getCel()] + t.get(tmp.getCel()).get(i).getKoszt();
                    przydatneTMP = new Edge(t.get(tmp.getCel()).get(i).getCel(),
                            d[t.get(tmp.getCel()).get(i).getCel()]);
                    kolej.add(przydatneTMP);
                }
            }
        }
        return d[wyj];
    }

    public static void czytanie(String nazwa) {
        try {
            Scanner scanner = new Scanner(new File(nazwa));
            int wej, wyj, koszt;
            n = scanner.nextInt();
            k = scanner.nextInt();
            Edge tmp;
            for (int i=0; i<n; i++) {
                d[i] = MAX;
                t.add(new ArrayList<Edge>());
                tmp = new Edge(i, MAX);
                kolej.add(tmp);
            }
            for (int i=0; i<k; i++) {
                wej = scanner.nextInt();
                wyj = scanner.nextInt();
                koszt = scanner.nextInt();
                tmp = new Edge(wyj, koszt);
                t.get(wej).add(tmp);
            }
        }catch (FileNotFoundException e) {
            System.out.println("nie ma tu tego: " + e.getMessage());
        }
    }
}
