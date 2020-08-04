package test;


/**
 * 转换金额为大写金额
 *
 * @author ljj
 */
public class ConvertMoneyUtils {


    private ConvertMoneyUtils() {
    }

    /**
     * 大写数字
     */
    private static final String[] NUMBERS = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

    /**
     * 整数部分
     */
    private static final String[] INTUNIT = {"元", "拾", "佰", "仟", "万", "亿"};

    /**
     * 小数部分
     */
    private static final String[] DOTUNIT = {"角", "分", "厘"};

    /**
     * 数字的正则表达式
     */
    private static final String NUMBER_FORMAT = "^\\d+(\\.\\d+)?$";


    /**
     * 转换数字成大写的中文金额
     *
     * @param money
     * @return
     */
    public static String toUpperChinese(String money) {

        money = money.trim();

        if (money == "" || money == null) {
            return "";
        }

        if (!money.matches(NUMBER_FORMAT)) {
            throw new RuntimeException("非数字,无法转换");
        }

        if (Double.valueOf(money).toString().equals("0.0")) {
            return "零元";
        }


        if (money.contains(".")) {
            String[] split = money.split("\\.");
            String intPart = getIntPart(split[0]);
            String dotPart = getDotPart(split[1]);
            return intPart + dotPart;
        } else {
            return getIntPart(money);
        }

    }

    private static String getDotPart(String dotPart) {
        if (dotPart.length() > 3) {
            dotPart = dotPart.substring(0, 3);
        }

        if (Double.valueOf(dotPart).equals(0.0D)) {
            return "";
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < dotPart.length(); i++) {
            Integer c = Integer.valueOf(String.valueOf(dotPart.charAt(i)));
            if (i % 3 == 0) {
                str.append(NUMBERS[c]).append(DOTUNIT[0]);
                continue;
            }

            if (i % 3 == 1) {
                str.append(NUMBERS[c]).append(DOTUNIT[1]);
                continue;
            }

            str.append(NUMBERS[c]).append(DOTUNIT[2]);
        }

        return str.toString();

    }

    private static String getIntPart(String intPart) {
        StringBuilder str = new StringBuilder();
        int length = intPart.length();
        int zeroCount = 0;
        for (int i = 0; i < length; i++) {
            int j = i + 1;
            Integer c = Integer.valueOf(String.valueOf(intPart.charAt(length - j)));
            if (c == 0) {
                zeroCount++;
                continue;
            }

            if (zeroCount > 0) {
                str.insert(0, NUMBERS[c] + INTUNIT[0]);
            }

            zeroCount = 0;

            //个
            if (i == 0) {
                str.append(NUMBERS[c] + INTUNIT[0]);
                continue;
            }

            //亿
            if (i % 8 == 0) {
                str.insert(0, NUMBERS[c] + INTUNIT[5]);
                continue;
            }

            //万
            if (i % 4 == 0) {
                str.insert(0, NUMBERS[c] + INTUNIT[4]);
                continue;
            }
            //拾
            if (i % 4 == 1) {
                str.insert(0, NUMBERS[c] + INTUNIT[1]);
                continue;
            }
            //佰
            if (i % 4 == 2) {
                str.insert(0, NUMBERS[c] + INTUNIT[2]);
                continue;
            }

            //仟
            if (i % 4 == 3) {
                str.insert(0, NUMBERS[c] + INTUNIT[3]);
                continue;
            }
        }
        return str.toString();
    }


    public static void main(String[] args) {
        System.out.println(toUpperChinese("10101010101010"));
    }
}
