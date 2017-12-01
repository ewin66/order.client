using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Reflection;
using System.Drawing;
using xap.mw.log;

namespace iih.ci.ord.orsrvref.util
{
    class BeanPropertyUtil
    {

        /// <summary>
        /// 对齐方式
        /// </summary>
        private const string ALIGNMENT = "ALIGNMENT";

        /// <summary>
        /// 对齐方式 NEAR 居左， CENTER 居中， FAR居右
        /// </summary>
        private static Dictionary<string, StringAlignment> ALIGNMENT_DIC = new Dictionary<string, StringAlignment> { 
        { "NEAR", StringAlignment.Near } ,{ "CENTER", StringAlignment.Center } ,{ "FAR", StringAlignment.Far } 
        };

        /// <summary>
        /// 获取属性值
        /// </summary>
        /// <param name="beanObj">获取属性值得对象</param>
        /// <param name="name">对象的属性名称</param>
        /// <returns>指定属性的值</returns>
        public static string GetValue(object beanObj, string name)
        {
            if (beanObj == null)
            {
                LogManager.GetLogger().ErrorEx("获取属性值得对象不能为空！");
            }

            Type type = beanObj.GetType();
            try
            {

                object valObj = type.GetProperty(name).GetValue(beanObj, null);
                string val = Convert.ToString(valObj);
                if (string.IsNullOrEmpty(val)) return null;
                return val;
            }
            catch (Exception ex)
            {
                LogManager.GetLogger().ErrorEx("获取对象[" + type.FullName + "]属性[" + name + "]的值失败！", ex);
                return null;
            }
        }

        /// <summary>
        /// 给对象属性赋值
        /// </summary>
        /// <param name="beanObj">待赋值的对象</param>
        /// <param name="propertyName">赋值的属性名称</param>
        /// <param name="val">属性值</param>
        /// <returns>是否成功赋值，true：成功，false：失败</returns>
        private static bool SetPropertyVal(object beanObj, string propertyName, object val)
        {
            try
            {
                Type type = beanObj.GetType();
                BindingFlags flag = BindingFlags.Public | BindingFlags.IgnoreCase | BindingFlags.Instance;
                PropertyInfo propertyInfo = type.GetProperty(propertyName, flag);
                if (propertyInfo == null)
                {
                    return false;
                }
                propertyInfo.SetValue(beanObj, val, null);
                return true;
            }
            catch (Exception ex)
            {
                LogManager.GetLogger().ErrorEx("对象属性[" + propertyName + "]赋值[" + val + "]失败！", ex);
                return false;

            }
        }

        /// <summary>
        /// 给对象属性或成员变量赋值
        /// </summary>
        /// <param name="beanObj">待赋值的对象</param>
        /// <param name="name">属性或成员变量名称</param>
        /// <param name="val">属性或成员变量对应的值</param>
        /// <returns>是否成功赋值，true：成功，false：失败</returns>
        public static bool SetValue(object beanObj, string name, object val)
        {

            bool isSetValSucc = SetPropertyVal(beanObj, name, val);
            if (!isSetValSucc)
            {
                isSetValSucc = SetFieldVal(beanObj, name, val);
            }
            return isSetValSucc;
        }



        /// <summary>
        /// 给对象可访问变量赋值
        /// </summary>
        /// <param name="beanObj">待赋值的对象</param>
        /// <param name="fieldName">赋值的变量名称</param>
        /// <param name="val">属性值</param>
        /// <returns>是否成功赋值，true：成功，false：失败</returns>
        private static bool SetFieldVal(object beanObj, string fieldName, object val)
        {

            try
            {
                Type type = beanObj.GetType();
                BindingFlags flag = BindingFlags.Public | BindingFlags.IgnoreCase | BindingFlags.Instance;

                FieldInfo fieldInfo = type.GetField(fieldName, flag);
                if (fieldInfo == null)
                {
                    return false;
                }
                object valObj = Convert.ChangeType(val, fieldInfo.FieldType);
                fieldInfo.SetValue(beanObj, valObj);
                return true;
            }
            catch (Exception ex)
            {
                LogManager.GetLogger().ErrorEx("对象变量[" + fieldName + "]赋值[" + val + "]失败！", ex);
                return false;
            }
        }

    }
}
