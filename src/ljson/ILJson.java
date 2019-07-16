package ljson;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public interface ILJson {

    /**
     * 取所有属性的键值
     * @return      所有属性的键值集合
     */
    default Map getParam(){
        // 返回的Map
        Map map = new HashMap();
        // 当前的类的反射对象
        Class thisClass = this.getClass();
        // 取当前类中所有的属性
        Field[] declaredFields = thisClass.getDeclaredFields();


        for (Field f:declaredFields){
            String key = f.getName(); // 属性名

            // 通过属性名取get方法名
            String methodName = "get"
                    +key.substring(0,1).toUpperCase()
                    +key.substring(1);

            // 属性值
            Object value;
            try {
                // 调用get方法取值
                value = thisClass.getMethod(methodName).invoke(this);
            }

            catch (Exception e) {
                value = "error value!";
            }

            map.put(key,value);
        }

        return map;
    }
}
