package utils;


import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Supplier;

/**
 * 对象工具类
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2020-03-25 19:08
 */
public class ObjectsUtils {
    private ObjectsUtils() {
        throw new AssertionError("No java.util.Objects instances for you!");
    }

    public static boolean equals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }


//    public static boolean deepEquals(Object a,Object b){
//        if (a == b) {
//            return true;
//        } else if (a == null || b == null) {
//            return false;
//        }else {
//            return Arrays.deepEquals0(a, b);
//        }
//    }

    public static int hashCode(Object o) {
        return o != null ? o.hashCode() : 0;
    }

    public static int hash(Object... values) {
        return Arrays.hashCode(values);
    }

    public static String toString(Object o) {
        return String.valueOf(o);
    }

    public static String toString(Object o, String nullDefault) {
        return (o != null) ? o.toString() : nullDefault;
    }

    public static <T> int compare(T a, T b, Comparator<? super T> c) {
        return (a == b) ? 0 : c.compare(a, b);
    }

    public static <T> T requireNonNull(T obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        return obj;
    }

    public static <T> T requireNonNull(T obj,String message) {
        if (obj == null) {
            throw new NullPointerException(message);
        }
        return obj;
    }


    public static boolean isNull(Object object) {
        return object == null;
    }

    public static boolean nonNull(Object object) {
        return object != null;
    }

    public static <T> T requireNonNullElse(T obj, T defaultObj) {
        return (obj != null) ? obj : requireNonNull(defaultObj, "defaultObj");
    }

    public static <T> T requireNonNullElseGet(T obj, Supplier<? extends T> supplier) {
        return (obj != null) ? obj : requireNonNull(requireNonNull(supplier, "supplier").get(), "supplier.get()");
    }

    public static <T> T requireNonNull(T obj, Supplier<String> messageSupplier) {
        if (obj == null) {
            throw new NullPointerException(messageSupplier == null ? null : messageSupplier.get());
        }
        return obj;
    }

//    public static int checkIndex(int index, int length) {
//        return Preconditions.checkIndex(index, length, null);
//    }
//
//    public static int checkFromTOIndex(int fromIndex, int toIndex, int length) {
//        return Preconditions.checkFromto(fromIndex, toIndex, length);
//    }
//
//    public static int checkFromIndexSize(int fromIndex, int size, int length) {
//        return Preconditions.checkFromIndexSize(fromIndex, size, length, null);
//    }


}
