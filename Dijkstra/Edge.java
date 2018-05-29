public class Edge {
    private int cel, koszt;

    public Edge(int cel, int koszt) {
        this.cel = cel;
        this.koszt = koszt;
    }
    public Edge() {
        cel = -1;
        koszt = 2000000000;
    }
    public void setCel(int cell) {
        cel = cell;
    }
    public int getCel() {
        return cel;
    }
    public void setKoszt(int kosztt) {
        koszt = kosztt;
    }
    public int getKoszt() {
        return koszt;
    }
}
