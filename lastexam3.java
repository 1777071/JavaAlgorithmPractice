public class lastexam3 {
    static public int getfloor(String data) {
        int floor = 0;
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == '[') floor++;
        }
        return floor;
    }

    //find the inside []
    static public int[] getLocation(String s) {
        //get the inside [] location
        int[] location = new int[2];
        for (int i = 0; i < s.length(); i++) {
            // s.charAt(i)='[' the last [
            if (s.charAt(i) == '[') location[0] = i;
        }
        for (int i = location[0]; i < s.length(); i++) {
            // s.charAt(i)=']' the fist ]
            if (s.charAt(i) == ']') {
                location[1] = i;
                break;
            }
        }
        return location;
    }

    //open the inside one
    static public String open(String s, int location1, int location2) {

        String frontpart = s.substring(0, location1);
        int quantity = ((int) s.charAt(location1 + 1)) - 48;
        String context = s.substring(location1 + 2, location2);
        String centerpart = context;
        String behindpart = s.substring(location2 + 1, (int) s.length());
        for (int i = 1; i < quantity; i++) {
            centerpart = String.join("", centerpart, context);
        }
        String open = String.join("", frontpart, centerpart, behindpart);
        return open;
    }


    static public String unwind(String data) {
        //how many [] ---floor
        //locate [] location
        //from inside to outside  floor's [] to the first [] open the string
        int floor = getfloor(data);
        String unwind = data;
        for (int i = 0; i < floor; i++) {
            int[] location = getLocation(unwind);
            System.out.println(location[0] + "=========" + location[1] + "==========" + i);
            unwind = open(unwind, location[0], location[1]);
        }
        return unwind;
    }

    static public void main(String[] args) {
        String data = "[5[9CQKQYW][2[5QTYWYYND]]]";
        System.out.print(unwind(data));
        //System.out.print(getfloor(data));


    }
}