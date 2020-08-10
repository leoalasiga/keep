package basic.demo5.demo5_12;

/**
 * @author ljj
 * @description
 * @date 2020-08-10
 */
public enum Size {
    /**
     * size
     */
    SMALL("S"),MEDIUM("M"),LARGE("L"), EXTRA_LARGE("XL");

    private String abbreviation;

    Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
