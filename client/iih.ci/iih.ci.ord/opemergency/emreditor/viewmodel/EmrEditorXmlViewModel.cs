
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml;
using xap.rui.control.exceptions;

namespace iih.ci.ord.opemergency.emreditor.viewmodel
{
    /// <summary>
    /// <para>描    述 : </para>
    /// <para>说    明 : </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.emreditor.viewmodel    </para>    
    /// <para>类 名 称 :  EmrEditorXmlViewModel					</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  hums</para> 
    /// <para>修 改 人 :  hums</para> 
    /// <para>创建时间 :  2016/8/8 16:26:56</para>
    /// <para>更新时间 :  2016/8/8 16:26:56</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public static class EmrEditorXmlViewModel
    {
        private const string ZDTX = "zdtx";

        /// <summary>
        /// digType节点
        /// </summary>
        private const string DIGTYPE_NODE = "digType";

        /// <summary>
        /// xml 中dig节点
        /// </summary>
        private const string DIG_NODE = "dig";

        /// <summary>
        /// xml中cdig节点
        /// </summary>
        private const string CDIG_NODE = "cdig";

        /// <summary>
        /// 配置文件中的诊断体系集合
        /// </summary>
        private static List<string> zdtxList;

        /// <summary>
        /// 返回的属性对象
        /// </summary>
        private static SortedDictionary<string, SortedDictionary<string, SortedDictionary<string, string>>> dic;


        /// <summary>
        ///  获取诊断XML属性对象
        /// </summary>
        /// <param name="xmlPath">诊断配置文件路径</param>
        /// <returns>返回数据结构说明 诊断体系：{节点分类：{节点属性，节点属性值}}
        /// <para>诊断体系：中医诊断、西医诊断</para>
        /// <para>中医诊断体系:CiDictCodeConst.ID_CI_DISYS_ZYZDTX : "0001AA10000000076SMM"</para>
        ///  <para>西医诊断体系:CiDictCodeConst.ID_CI_DISYS_XYZDTX : "0001AA10000000076SML"</para>
        ///  <para>节点分类：digType、dig、cdig</para>
        ///  <para>{节点属性，节点属性值}：各个分类对应的节点属性及属性值</para>
        /// </returns>
        public static SortedDictionary<string, SortedDictionary<string, SortedDictionary<string, string>>> getXmlDic(string xmlPath)
        {

            if (dic != null)
            {
                return dic;
            }

            dic = getXmlProperty(xmlPath);

            return dic;

        }

        public static List<string> getZdtxList(string xmlPath)
        {

            if (zdtxList == null)
            {
                getXmlDic(xmlPath);
            }
            return zdtxList;
        }

        /// <summary>
        ///  获取诊断XML属性对象
        /// </summary>
        /// <param name="xmlPath">诊断配置文件路径</param>
        /// <returns>返回数据结构说明 诊断体系：{节点分类：{节点属性，节点属性值}}
        /// <para>诊断体系：中医诊断、西医诊断</para>
        /// <para>中医诊断体系:CiDictCodeConst.ID_CI_DISYS_ZYZDTX : "0001AA10000000076SMM"</para>
        ///  <para>西医诊断体系:CiDictCodeConst.ID_CI_DISYS_XYZDTX : "0001AA10000000076SML"</para>
        ///  <para>节点分类：digType、dig、cdig</para>
        ///  <para>{节点属性，节点属性值}：各个分类对应的节点属性及属性值</para>
        /// </returns>
        private static SortedDictionary<string, SortedDictionary<string, SortedDictionary<string, string>>> getXmlProperty(string xmlPath)
        {

            SortedDictionary<string, SortedDictionary<string, SortedDictionary<string, string>>> propertyDic = null;
            XmlElement xmlElement = loadXml(xmlPath);
            if (xmlElement == null)
            {
                return propertyDic;
            }


            // 获取所有的digType节点
            XmlNodeList nodeList = xmlElement.SelectSingleNode(DIG_NODE).SelectNodes(DIGTYPE_NODE);
            if (nodeList != null && nodeList.Count > 0)
            {
                zdtxList = new List<string>();
                propertyDic = new SortedDictionary<string, SortedDictionary<string, SortedDictionary<string, string>>>();
                foreach (XmlNode digTypeNode in nodeList)
                {
                    //digType、 dig、cdig节点属性集合
                    SortedDictionary<string, SortedDictionary<string, string>> nodeProperty = new SortedDictionary<string, SortedDictionary<string, string>>();

                    // digType节点属性
                    SortedDictionary<string, string> digTypeNodeDic = getPropertyDic(digTypeNode);
                    nodeProperty.Add(DIGTYPE_NODE, digTypeNodeDic);
                    //获取诊断体系常量
                    zdtxList.Add(digTypeNode.Attributes[ZDTX].Value);

                    // dig节点
                    XmlNode digNode = digTypeNode.SelectSingleNode(DIG_NODE);
                    SortedDictionary<string, string> digNodePropertyDic = getPropertyDic(digNode);
                    nodeProperty.Add(DIG_NODE, digNodePropertyDic);

                    // cdig节点
                    XmlNode cdigNode = digNode.SelectSingleNode(CDIG_NODE);
                    SortedDictionary<string, string> cdigNodePropertyDic = getPropertyDic(cdigNode);
                    nodeProperty.Add(CDIG_NODE, cdigNodePropertyDic);

                    // digType节点与子节点属性集合
                    propertyDic.Add(digTypeNode.Attributes[ZDTX].Value, nodeProperty);
                }
            }

            return propertyDic;
        }

        /// <summary>
        /// 获取指定路径XmlElement对象
        /// </summary>
        /// <param name="xmlPath">xml文件路径</param>
        /// <returns></returns>
        public static XmlElement loadXml(string xmlPath)
        {
            XmlElement element = null;

            try
            {
                XmlDocument xmlDoc = new XmlDocument();

                // 加载xml文件
                xmlDoc.Load(xmlPath);
                element = xmlDoc.DocumentElement;
            }
            catch (Exception e)
            {
                throw new XapBizException("文件：[" + xmlPath + "]不存在！", e);
            }

            return element;
        }

        /// <summary>
        /// 创建xml文档
        /// </summary>
        /// <returns></returns>
        public static XmlDocument createXmlDoc()
        {

            XmlDocument xmlDoc = new XmlDocument();
            XmlNode node = xmlDoc.CreateXmlDeclaration("1.0", "utf-8", "");
            xmlDoc.AppendChild(node);

            XmlNode root = xmlDoc.CreateElement("root");
            xmlDoc.AppendChild(root);

            return xmlDoc;
        }

        /// <summary>  
        /// 创建节点  
        /// </summary>  
        /// <param name="xmldoc"></param>  xml文档
        /// <param name="parentnode"></param>父节点  
        /// <param name="name"></param>  节点名
        /// <param name="value"></param>  节点值
        /// 
        public static void CreateNode(XmlDocument xmlDoc, XmlNode parentNode, string name, string value)
        {
            XmlNode node = xmlDoc.CreateNode(XmlNodeType.Element, name, null);
            node.InnerText = value;
            parentNode.AppendChild(node);
        }


        /// <summary>
        /// 获取节点属性SortedDictionary集合
        /// </summary>
        /// <param name="node">XmlNode 对象</param>
        /// <returns></returns>
        private static SortedDictionary<string, string> getPropertyDic(XmlNode node)
        {

            SortedDictionary<string, string> nodeDic = new SortedDictionary<string, string>();

            XmlAttributeCollection xmlAttrCollection = node.Attributes;

            if (xmlAttrCollection != null && xmlAttrCollection.Count > 0)
            {
                foreach (XmlAttribute attr in xmlAttrCollection)
                {
                    nodeDic.Add(attr.Name, attr.Value);
                }
            }
            return nodeDic;
        }
    }
}
