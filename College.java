public class College {
    private String name;
    private String location;
    private String setting;
    private String size;
    private String major;
    private String range;
    private int acceptRate;

    public College(String n, String l, String se, String si, String m, String r, int ar) {
        this.name = n;
        this.location = l;
        this.setting = se;
        this.size = si;
        this.major = m;
        this.range = r;
        this.acceptRate = ar;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getSetting() {
        return setting;
    }

    public String getSize() {
        return size;
    }

    public String getMajor() {
        return major;
    }

    public String getRange() {
        return range;
    }

    public int getRate() {
        return acceptRate;
    }
}
