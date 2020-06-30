package refelectdemo;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * TODO
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2020-06-06 14:28
 */
public class ObjectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<>();

    /**
     * convert an object to a string representation that list all fields
     *
     * @param obj
     * @return
     */
    public String toString(Object obj) {
        if (obj == null) {
            return "null";
        }

        if (visited.contains(obj)) {
            return "...";
        }

        visited.add(obj);
        Class<?> cl = obj.getClass();
        if (cl == String.class) {
            return (String) obj;
        }

        if (cl.isArray()) {
            String r = cl.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) {
                    r += ",";
                }

                Object val = Array.get(obj, i);
                if (cl.getComponentType().isPrimitive()) {
                    r += val;
                } else {
                    r += toString(val);
                }
            }
            return r + "}";

        }

        String r = cl.getName();
        //inspect the field of this class and superclass
        do {
            r += "[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            //get the name and value of all fields
            for (Field field : fields) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    if (!r.endsWith("[")) {
                        r += ",";
                    }
                    r += field.getName() + "=";

                    try {
                        Class<?> type = field.getType();
                        Object val = field.get(obj);
                        if (type.isPrimitive()) {
                            r += val;
                        } else {
                            r += toString(val);

                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
            }

            r += "]";
            cl = cl.getSuperclass();

        } while (cl != null);

        return r;
    }
}
