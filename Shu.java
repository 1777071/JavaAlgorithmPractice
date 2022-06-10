class DVDPlayer {
    boolean canRecord = false;

    void recordDVD() {
        System.out.println("“DVD recording”");
    }
}

class Shu {
    public static void main(String[] args) {
        DVDPlayer d = new DVDPlayer();
        d.canRecord = true;
        d.recordDVD();
        if (d.canRecord == true) {
            d.recordDVD();
        }
    }
}