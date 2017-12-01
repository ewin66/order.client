
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Reflection;
using xap.mw.log;
using xap.rui.control.exceptions;

namespace iih.ci.ord.common.utils
{
    /// <summary>
    /// <para>描    述 : 操作对象间属性类</para>
    /// <para>说    明 : 对象属性间值拷贝，获取、设置对象的属性值</para>
    /// <para>项目名称 :  iih.ci.ord.common.utils    </para>    
    /// <para>类 名 称 :  BeanUtils					</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  hums</para> 
    /// <para>修 改 人 :  hums</para> 
    /// <para>创建时间 :  2016/8/22 17:56:13</para>
    /// <para>更新时间 :  2016/8/22 17:56:13</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class BeanUtils
    {
        // 忽略控制状态属性
        private static List<string> ignores = new List<string>() { "Dirty", "IsDELETED", "IsNEW", "IsUNCHANGED", "IsUPDATED", "Status", "BdDataInfoNameMap", "IsFakeDeleted" };
        /// <summary>
        /// 源对象与目标对象间属性拷贝
        /// </summary>
        /// <param name="source">源对象</param>
        /// <param name="target">目标对象</param>
        public static void CopyProerties(Object source, Object target)
        {
            CopyProerties(source, target, null);
        }

        /// <summary>
        /// 源对象与目标对象间属性拷贝
        /// </summary>
        /// <param name="source">源对象</param>
        /// <param name="target">目标对象</param>
        /// <param name="ignoreProperties">拷贝时忽略的属性</param>
        public static void CopyProerties(Object source, Object target, string[] ignoreProperties)
        {
            List<string> ignoreList = new List<string>();
            ignoreList.AddRange(ignores);
            if (ignoreProperties != null)
            {
                ignoreList.AddRange(ignoreProperties);
            }

            // 属性类型
            BindingFlags flag = BindingFlags.Public | BindingFlags.IgnoreCase | BindingFlags.Instance;

            // 源对象
            Type sourceType = source.GetType();

            // 目标对象
            Type targetType = target.GetType();
            PropertyInfo[] targetInfos = targetType.GetProperties();

            // 遍历目标对象的属性，将源对象对应的属性值赋值给目标对象
            foreach (PropertyInfo tagertInfo in targetInfos)
            {
                try
                {
                    PropertyInfo propertyInfo = sourceType.GetProperty(tagertInfo.Name, flag);

                    if (propertyInfo == null)
                    {
                        continue;
                    }

                    if (ignoreList.Contains<string>(tagertInfo.Name))
                    {
                        continue;
                    }

                    // 获取源对象属性值
                    Object valObj = propertyInfo.GetValue(source, null);

                    tagertInfo.SetValue(target, valObj, null);
                }
                catch (Exception ex)
                {
                    LogManager.GetLogger().ErrorEx("源对象[" + sourceType.FullName + "]向目标对象[" + targetType.FullName + "]进行属性[" + tagertInfo.Name + "]拷贝出现错误！", ex);
                    throw new XapBizException("源对象[" + sourceType.FullName + "]向目标对象[" + targetType.FullName + "]进行属性[" + tagertInfo.Name + "]拷贝出现错误！", ex); ;
                }
            }
        }

        /// <summary>
        /// 源对象与目标对象间拷贝指定属性
        /// </summary>
        /// <param name="source">源对象</param>
        /// <param name="target">目标对象</param>
        /// <param name="properties">需要拷贝的属性</param>
        public static void SetProerties(Object source, Object target, string[] properties)
        {
            // 属性类型
            BindingFlags flag = BindingFlags.Public | BindingFlags.IgnoreCase | BindingFlags.Instance;

            // 源对象
            Type sourceType = source.GetType();

            // 目标对象
            Type targetType = target.GetType();

            foreach (string propretyName in properties)
            {
                try
                {
                    PropertyInfo sourceProperty = sourceType.GetProperty(propretyName, flag);
                    if (sourceProperty == null)
                    {
                        LogManager.GetLogger().ErrorEx("源对象[" + sourceType.FullName + "]向目标对象[" + targetType.FullName + "]进行属性拷贝时出错，源对象中未找到属性[" + propretyName + "]");
                        continue;
                    }

                    PropertyInfo targetProperty = targetType.GetProperty(propretyName, flag);
                    if (targetProperty == null)
                    {
                        LogManager.GetLogger().ErrorEx("源对象[" + sourceType.FullName + "]向目标对象[" + targetType.FullName + "]进行属性拷贝时出错，目标对象中未找到属性[" + propretyName + "]");
                        continue;
                    }

                    // 获取源对象属性值
                    Object valObj = sourceProperty.GetValue(source, null);
                    targetProperty.SetValue(target, valObj, null);
                }
                catch (Exception ex)
                {
                    LogManager.GetLogger().ErrorEx("源对象[" + sourceType.FullName + "]向目标对象[" + targetType.FullName + "]进行属性[" + propretyName + "]拷贝出现错误！", ex);
                    throw new XapBizException("源对象[" + sourceType.FullName + "]向目标对象[" + targetType.FullName + "]进行属性[" + propretyName + "]拷贝出现错误！", ex); ;
                }
            }


        }

        /// <summary>
        /// 获取属性值
        /// </summary>
        /// <param name="beanObj">获取属性值得对象</param>
        /// <param name="name">对象的属性名称</param>
        /// <returns>指定属性的值</returns>
        public static Object GetValue(object beanObj, string name)
        {
            if (beanObj == null)
            {
                LogManager.GetLogger().ErrorEx("获取属性值得对象不能为空！");
            }

            Type type = beanObj.GetType();
            try
            {
                PropertyInfo property = type.GetProperty(name);
                object valObj = property.GetValue(beanObj, null);
                return Convert.ChangeType(valObj, property.PropertyType);
            }
            catch (Exception ex)
            {
                LogManager.GetLogger().ErrorEx("获取对象[" + type.FullName + "]属性[" + name + "]的值失败！", ex);
                return null;
            }
        }

        /// <summary>
        /// 获取属性值
        /// </summary>
        /// <param name="beanObj">获取属性值得对象</param>
        /// <param name="name">对象的属性名称</param>
        /// <returns>指定属性的值</returns>
        public static Object GetObjValue(object beanObj, string name)
        {
            if (beanObj == null)
            {
                LogManager.GetLogger().ErrorEx("获取属性值得对象不能为空！");
            }

            Type type = beanObj.GetType();
            try
            {
                PropertyInfo property = type.GetProperty(name);
                object valObj = property.GetValue(beanObj, null);
                return valObj;
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

                object valObj = Convert.ChangeType(val, propertyInfo.PropertyType);
                propertyInfo.SetValue(beanObj, valObj, null);
                return true;
            }
            catch (Exception ex)
            {
                LogManager.GetLogger().ErrorEx("对象属性[" + propertyName + "]赋值[" + val + "]失败！", ex);
                return false;

            }
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
