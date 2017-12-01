package iih.ci.ord.s.tag;

import java.lang.reflect.Field;

public class FieldTagVUtils {
	public static void getTagContent(String clazz){
        Class targetClass = null;
        
        try {
            targetClass = Class.forName(clazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        for (Field m : targetClass.getFields()) {
            if (m.isAnnotationPresent(DmEnumDesc.class)) {
            	DmEnumDesc tag = m.getAnnotation(DmEnumDesc.class);
            	System.out.println("字段" + m.getName() + "的DmEnumDesc注解内容为：" + tag.name() + "，" + tag.description());
            } else {
                System.out.println("没被DmEnumDesc注解修饰的字段名：" + m.getName());
            }
        }
	}
}
