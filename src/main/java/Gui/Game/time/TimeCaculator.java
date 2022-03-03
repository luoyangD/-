package Gui.Game.time;

public class TimeCaculator {
    public long start=System.currentTimeMillis();
    public TimeCaculator(){}
    public long caculate(){
        long now=System.currentTimeMillis();
        return now-start;
    }

    /*
    public static void main(String[] args) {
        TimeCaculator tc = new TimeCaculator();
        int i = 0;
        long record = 0;
        while (true){
            if (tc.caculate()%1000==0){
                if (record!=tc.caculate()){
                    record=tc.caculate();
                    i++;
                    System.out.println(i);
                    if (i>=20){
                        break;
                    }
                }
            }
        }

    }

     */
}
