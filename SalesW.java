public class SalesW {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 6, 10, 15, 21, 28, 36, 45, 55};
        int[] b = {-3, -5, 10, -2, -6, -7, 3, -2, 8, 5, -1};
        SalesW sw = new SalesW();
        int result = sw.minMoves(a, b);
        System.out.println(result);
    }

    public int minMoves(int[] a, int[] b) {

        int cur = 0;
        int lastMinus = -1;
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            if (cur < 0 && cur + b[i] >= 0) {
                ans += (a[i] - a[i - 1]);
                ans += 2 * (a[i] - lastMinus);
                cur += b[i];
                lastMinus = -1;
            } else {
                if (lastMinus < 0 && cur + b[i] < 0) {
                    lastMinus = a[i];
                }
                cur += b[i];
                if (i == 0) {
                    ans += (a[i] - 0);
                } else {
                    ans += (a[i] - a[i - 1]);
                }
            }
        }
        return ans;

        /*int productNum=0;
        int index=0;
        int result=0;
        boolean[] visit=new boolean[b.length];
        for(int i=0;i<b.length;i++){
            if(b[i]>0){
                index=i;
                productNum=b[i];
                result+=a[i];
                break;
            }
        }
        visit[index]=true;
        int count=0;
        while (count<10){
            count++;
            boolean jump=true;
            for(int i=0;i<visit.length;i++){
                if(!visit[i]){
                    jump=false;
                }
            }
            if(jump){
                if(index!=a.length){
                    result+=a[a.length-1]-a[index];
                }
                return result;
            }
            for(int i=0; i<visit.length;i++){
                System.out.print(visit[i]+" ");
            }
            System.out.println("==========");
            int index1=0;
            int index2=0;
            int min=10000000;
            int min1=10000000;
            for(int i=0;i<a.length;i++){
                if(b[i]>0 && !visit[i]){
                    int distance=a[index]-a[i];
                    if(distance<0){
                        distance=-1*distance;
                    }
                    if(distance<min){
                        min=distance;
                        index1=i;
                    }
                }
                if(b[i]<0 && !visit[i] ){
                    if(productNum+b[i]>=0) {
                        int distance1 = a[index] - a[i];
                        if (distance1 < 0) {
                            distance1 = -1 * distance1;
                        }
                        if (distance1 < min1) {
                            min1 = distance1;
                            index2 = i;
                        }
                    }
                }
            }

            int va=a[index]-a[index1];
            int va1=a[index]-a[index2];

            if(va<0){
                 va=va*-1;
            }
            if(va1<0){
                 va1=va1*-1;
            }

            if(va>va1){
                if(index==index2){
                    index2=index1;
                }
                index=index2;
                visit[index]=true;
                productNum+=b[index2];

                result+=va1;
            }
            else{
                    if(index==index1){
                        index1=index2;
                    }
                    index = index1;
                    visit[index1]=true;
                    productNum+=b[index1];
                    System.out.println(productNum+"=========="+b[index1]);
                    result+=va;

            }

        }
        return count;
    }*/
    }
}