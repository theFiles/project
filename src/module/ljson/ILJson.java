package module.ljson;

import java.lang.reflect.*;
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

    /**
     * 通过set方法修改对象属性
     */
    default boolean set(String fieldName, String value){
        // 当前的类的反射对象
        Class thisClass = this.getClass();
        // 取属性值
        try {
            Class<?> type = thisClass.getDeclaredField(fieldName).getType();

            // 拼接方法名
            String methodName = "set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
            thisClass.getMethod(methodName,type).invoke(this,format(type,value));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 根据规定类型转换值的类型
     */
    default Object format(Class<?> type, String value){
        try {
            String typeName = type.getName();
            // 字符串
            if ("java.lang.String".equals(typeName)) {
                return value;
            }
            // 整数
            else if ("int".equals(typeName) || type.equals("java.lang.Integer")) {
                return Integer.parseInt(value);
            }
            // 长整数
            else if ("long".equals(typeName) || type.equals("java.lang.Long")) {
                return Long.parseLong(value);
            }
            // 双浮点数
            else if ("double".equals(typeName) || type.equals("java.lang.Double")) {
                return Double.parseDouble(value);
            }
            // 字节型
            else if ("short".equals(typeName) || type.equals("java.lang.Short")) {
                return Short.parseShort(value);
            }
            // 字节型
            else if ("byte".equals(typeName) || type.equals("java.lang.Byte")) {
                return Byte.parseByte(value);
            }
            // 单浮点数
            else if ("float".equals(typeName) || type.equals("java.lang.Float")) {
                return Float.parseFloat(value);
            }
        }catch (Exception e){

        }

        return null;
    }
}
