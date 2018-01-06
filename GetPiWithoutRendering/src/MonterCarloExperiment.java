import java.awt.*;

public class MonterCarloExperiment {
    private int squareSide;
    private int N;
    private int outPutInterval = 100;

    public MonterCarloExperiment(int squareSide, int N){
        if(squareSide <= 0 || N <= 0)
            throw new IllegalArgumentException("squareSide and N must larger than 0");
        this.squareSide = squareSide;
        this.N = N;
    }

    public void setOutPutInterval(int interval){
        if(interval <= 0)
            throw new IllegalArgumentException("interval must be larget than zero!");
        this.outPutInterval = interval;
    }

    public void run(){
        Circle circle = new Circle(squareSide/2 , squareSide/2, squareSide/2);
        PiData data = new PiData(circle);
        for(int i = 0 ; i < N ; i++){
            if(i % outPutInterval == 0)
                System.out.println(data.estimatePi());
            int x = (int)(Math.random() * squareSide);
            int y = (int)(Math.random() * squareSide);
            data.addPoint(new Point(x, y));

        }
    }

    public static void main(String[] args){
        int squareSide = 800;
        int N = 1000000;
        MonterCarloExperiment exp = new MonterCarloExperiment(squareSide, N);
        exp.run();
    }
}
