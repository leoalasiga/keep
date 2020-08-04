package jvminfo;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;

/**
 * @ClassName JvmInfoDemo
 * @Description 利用ManagementFactory获取jvm信息
 * @Author 刘嘉杰
 * @Date 2019/11/21 16:28
 * @Version 1.0
 */
public class JvmInfoDemo {
    public static void main(String[] args) {
        /**
         * Returns the managed bean for the class loading system of
         * the Java virtual machine
         */
        ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
        System.out.println("LoadedClassCount:" + classLoadingMXBean.getLoadedClassCount());
        System.out.println("TotalLoadedClassCount:"+classLoadingMXBean.getTotalLoadedClassCount());
        System.out.println("UnloadedClassCount"+classLoadingMXBean.getUnloadedClassCount());



    }
}
