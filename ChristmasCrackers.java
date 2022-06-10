import java.util.ArrayList;

public class ChristmasCrackers {
    ArrayList<Integer> ans = new ArrayList<Integer>();
    int extra = 0;

    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        ChristmasCrackers cc = new ChristmasCrackers();
        int[] result = cc.crack(a, b);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public int[] crack(int N, int K) {
        int t = N * K;
        if (t % 2 == 1) t++;
        int[] r = new int[t];
        for (int i = 0; i < t; i++) {
            r[i] = i % N;
        }
        return r;
    }
    //结果相等　但上面更加简洁
    /*public int[] crack(int a,int b){
        int [] mid=new int[a];
        for(int i=0;i< mid.length;i++){
            mid[i]=b;
        }

        boolean jump=true;
        while(jump){
            update(mid);
            for(int i=0;i< mid.length;i++){
                if(mid[i]>0){
                    System.out.println(mid[i]+" (((((())))))))) "+i);
                    jump=true;
                    break;
                }
                else{
                    jump=false;
                }
            }

            for (int i=0;i< mid.length;i++){
                System.out.println(mid[i]+"++++++++");
            }
            System.out.println("=============");
        }
        int[] res=new int[ans.size()];
        for(int i=0;i<res.length;i++){
            res[i]=ans.get(i);
        }
        return res;
    }

    public void update(int[] mid){
        if(mid.length%2==0){
            int large=0;
            int index=0;
            for(int i=0;i< mid.length;i++){
                if(mid[i]> index && mid[i]>0){
                    index=mid[i];
                    large=i;
                }
            }
            ans.add(large);
            ans.add(large+1);
            mid[large]--;
            mid[large+1]--;
        }
        else{
            int large=0;
            int index=0;
            for(int i=0;i< mid.length;i++){
                if(mid[i] > index && mid[i] > 0){
                    index = mid[i];
                    large = i;
                }
            }
            if(large < mid.length-1) {
                ans.add(large);
                ans.add(large + 1);
                mid[large]--;
                mid[large + 1]--;
            }
            else{

                if(extra< mid.length && extra!=large){
                    ans.add(extra);
                    extra++;
                }else{
                    ans.add(0);
                }
                ans.add(large);
                mid[large]--;
            }
        }
    }*/
}