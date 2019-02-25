package book.backOneOrZeor;

public class Product implements Comparable<Product>{
    private int w; //重量
    private int v; //价值

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    @Override
    public int compareTo(Product o) {
        if(this.v/this.w > o.v/o.w){
            return 1;
        }else if(this.v/this.w < o.v/o.w){
            return -1;
        }
        return 0;
    }
}
