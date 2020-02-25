import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;

import java.lang.reflect.Method;

public class ReflectUtils {

    /**
     * 通过springframework.core 包中相关的类获取指定类中指定方法名的所有参数名
     *
     * @param clazz      要获取参数的类名
     * @param methodName 要获取参数的方法
     * @return 获取到的参数
     */
    public static String[] getArgsNamesBySpring(Class<?> clazz, String methodName) {
        ParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                return parameterNameDiscoverer.getParameterNames(method);
            }
        }
        return null;
    }

}
