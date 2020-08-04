package test;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 支付单号生成工具里
 *
 * @author ljj
 */
public class PaymentIdGenerateUtils {

    private PaymentIdGenerateUtils() {

    }

    private static final String START = "zf";

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyMMdd");


    /**
     * 生成支付id
     * @param maxPaymentId
     * @return
     */
    public static String generatePaymentId(String maxPaymentId) {
        LocalDate now = LocalDate.now();
        String format = DATE_TIME_FORMATTER.format(now);

        String sequenceCode = "";

        sequenceCode = getSequenceCode(maxPaymentId);


        return START + format + sequenceCode;


    }

    private static String getSequenceCode(String maxPaymentId) {
        String sequenceCode;
        if (maxPaymentId==null||maxPaymentId.equals("")) {
            sequenceCode = "001";
        }else{
            String substring = maxPaymentId.substring(8);
            Integer integer = Integer.valueOf(substring);
            sequenceCode = String.valueOf(integer + 1);
            if (sequenceCode.length() == 1) {
                sequenceCode = "00" + sequenceCode;
            } else if (sequenceCode.length() == 2) {
                sequenceCode = "0" + sequenceCode;
            }
        }
        return sequenceCode;
    }
}
