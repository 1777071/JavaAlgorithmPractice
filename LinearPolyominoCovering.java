public class LinearPolyominoCovering {
    public String findCovering(String region) {
        region = region.replace("XX", "BB");
        region = region.replace("BBBB", "AAAA");
        if (region.contains("X")) {
            return "impossible";
        } else {
            return region;
        }
    }
}