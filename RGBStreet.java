public class RGBStreet {
    public static void main(String[] args) {
        String[] a = {"26 40 83", "49 60 57", "13 89 99"};
        RGBStreet rs = new RGBStreet();
        int result = rs.estimateCost(a);
        System.out.println(result);
    }

    public int estimateCost(String[] a) {
        int[][] b = new int[3][3];
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            String mid = "";
            index = 0;
            for (int j = 0; j < a[i].length(); j++) {

                char mid1 = a[i].charAt(j);

                if (mid1 == ' ' || j == a[i].length() - 1) {
                    if (j == a[i].length() - 1) {
                        for (int k = j; k < a[i].length(); k++) {
                            mid += a[i].charAt(k);
                        }
                        b[i][index] = Integer.parseInt(mid);
                    } else {
                        b[i][index] = Integer.parseInt(mid);
                    }
                    mid = "";
                    index++;
                } else {
                    mid += mid1;
                }
            }
        }
        int res = cal(b);
        return res;
    }

    public int cal(int[][] b) {
        boolean[] grb = new boolean[3];
        for (int i = 0; i < grb.length; i++) {
            grb[i] = true;
        }
        int res = 1000000;
        int res1 = 0;
        int index = 0;
        for (int i = 0; i < b.length; i++) {
            int temp = 10000;
            index = 0;
            for (int j = 0; j < b[i].length; j++) {
                if (b[i][j] < temp && grb[j]) {
                    index = j;
                    temp = b[i][j];
                }
            }

            res1 += temp;
            System.out.println(res1);
            for (int j = 0; j < grb.length; j++) {
                grb[j] = true;
            }
            grb[index] = false;

        }
        return res1;
    }
}


/*int res=Integer.MAX_VALUE;
  int size=0;
  int color[][];
  public int estimateCost(String[] houses){
    size=houses.length;
    color=new int[3][size];

    for(int i=0;i<houses.length;i++){
      String t[]=houses[i].split(" ");
      for(int j=0;j<3;j++)
        color[j][i]=Integer.parseInt(t[j]);
    }

    search(1,0,color[0][0]);
    search(1,1,color[1][0]);
    search(1,2,color[2][0]);
    return res;
  }

  void search(int i,int c,int r){
    if(r>res)
      return;
    if(i==size){
      if(r<res)
        res=r;
      return;
    }

    switch(c){
    case 0:
      search(i+1,1,r+color[1][i]);
      search(i+1,2,r+color[2][i]);
      return;
    case 1:
      search(i+1,0,r+color[0][i]);
      search(i+1,2,r+color[2][i]);
      return;
    case 2:
      search(i+1,0,r+color[0][i]);
      search(i+1,1,r+color[1][i]);
      return;
    }
  }*/