import java.util.Random;

public class Main {

    static int randInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    static void OutWP(int size) throws Exception
    {
        final int maxRand = 30000;
        double startTime, stopTime;


        HashMap map = new HashMap((int)(1.5 * size));
        
        //first 1000
            startTime = System.nanoTime();
        int i = 0;
        for (; i < 1000; i++) {
            map.add(randInt(0,maxRand), randInt(0,maxRand));
        }
            stopTime = System.nanoTime();
        double timeAddFirst = (stopTime - startTime)/1000000;

        
        //доп
        int end = size - 2000;
        for (; i < end; i++)
        {
            if (i == size / 2) map.add(size / 2, size / 2);
            map.add(i, i);
        }

        
        //last 1000
            startTime = System.nanoTime();
        for (; i < size; i++) {
            map.add(randInt(0,maxRand), randInt(0,maxRand));
        }
            stopTime = System.nanoTime();
        double timeAddLast = (stopTime - startTime)/1000000;


            startTime = System.nanoTime();
        map.get(size / 2);
            stopTime = System.nanoTime();
        double timeSearch = (stopTime - startTime)/1000000;

        System.out.printf("Кол. эл: %10d\t\tвремя(мс)->\t\tдоб. первых 1000: %.3f\t\tдоб. последних 1000: %.3f\t\tпоиска: %.3f\n", size, timeAddFirst, timeAddLast, timeSearch);

    }



    public static void main(String[] args) {
        try {
            OutWP(10000);
            OutWP(100000);
            OutWP(1000000);

        }
        catch (Exception e)
        {
            System.out.print("\n\tОШИБКА: ");
            System.out.println(e);
        }
    }
}