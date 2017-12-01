
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciorder.d;
using System.Windows.Forms;
using System.Xml;
using iih.ci.diag.dto.d;
using xap.mw.coreitf.d;
using xap.rui.control.exceptions;
using System.Reflection;
using iih.ci.ord.dto.ordermr.d;
using xap.mw.core.data;
using iih.bd.bc.udi;

namespace iih.ci.ord.opemergency.emreditor.viewmodel
{
    /// <summary>
    /// <para>描    述 : 诊断、处置数据转换类</para>
    /// <para>说    明 : 根据xml中的配置将诊断、处置的数据转为病历中需要的数据</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.emreditor.viewmodel    </para>    
    /// <para>类 名 称 :  EmrEditorCiViewModel					</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  hums</para> 
    /// <para>修 改 人 :  hums</para> 
    /// <para>创建时间 :  2016/8/8 17:47:39</para>
    /// <para>更新时间 :  2016/8/8 17:47:39</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class EmrEditorCiViewModel
    {

        #region 公共属性

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
        /// 空格
        /// </summary>
        private const string SPACE_STR = " ";

        /// <summary>
        /// 诊断配置文件路径
        /// </summary>
        private string configPathCiDiag;

        /// <summary>
        /// 处置配置文件路径
        /// </summary>
        private string configPathCiOrder;

        public string ConfigPathCiDiag
        {
            get { return configPathCiDiag; }
            set { configPathCiDiag = value; }
        }

        public string ConfigPathCiOrder
        {
            get { return configPathCiOrder; }
            set { configPathCiOrder = value; }
        }

        #endregion

        /// <summary>
        /// 构造处置xml格式数据
        /// </summary>
        /// <param name="ciOrderList"></param>
        /// <returns></returns>
        public string convertCZToXmlStr(CiOrderDO[] ciOrders, string xmlCfgPath)
        {
            string xmlPath = Application.StartupPath + xmlCfgPath;

            StringBuilder builder = new StringBuilder();
            if (ciOrders != null && ciOrders.Length > 0)
            {
                XmlElement element = EmrEditorXmlViewModel.loadXml(xmlPath);

                builder.Append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
                builder.Append("<table>");

                // 获取处置列
                List<string> colNameList = this.getCzColumn(element);

                //追加Column部分
                this.appendColumnStr(builder, colNameList);

                // 追加body部分
                this.appendBodyStr(element, colNameList, builder, ciOrders);

                builder.Append("</table>");
            }

            return builder.ToString();
        }

        /// <summary>
        /// 构造处置xml格式数据  yjb
        /// </summary>
        /// <param name="mrDtos"></param>
        /// <param name="xmlCfgPath"></param>
        /// <returns></returns>
        public string convertCZToXmlStr(OrderMrDto[] mrDtos, string xmlCfgPath)
        {
            string xmlPath = Application.StartupPath + xmlCfgPath;

            StringBuilder builder = new StringBuilder();
            if (mrDtos != null && mrDtos.Length > 0)
            {
                XmlElement element = EmrEditorXmlViewModel.loadXml(xmlPath);

                builder.Append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
                builder.Append("<table>");

                // 获取处置列
                List<string> colNameList = this.getCzColumn(element);

                //追加Column部分
                this.appendColumnStr(builder, colNameList);

                // 追加body部分
                this.appendBodyStr(element, colNameList, builder, mrDtos);

                builder.Append("</table>");
            }
            if (mrDtos != null && mrDtos.Length == 0)
            {
                XmlElement element = EmrEditorXmlViewModel.loadXml(xmlPath);

                builder.Append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
                builder.Append("<table>");
                builder.Append("</table>");
            }

            return builder.ToString();
        }

        /// <summary>
        /// 获取处置的列名
        /// </summary>
        /// <param name="element">处置配置的文档对象</param>
        /// <returns></returns>
        private List<string> getCzColumn(XmlElement element)
        {
            List<string> colNameList = new List<string>();
            XmlNode colsNode = element.SelectSingleNode("columns");
            // 取全部的column节点
            XmlNodeList colNodeList = colsNode.SelectNodes("column");
            foreach (XmlNode node in colNodeList)
            {
                colNameList.Add(node.Attributes["colname"].Value);
            }
            return colNameList;
        }

        /// <summary>
        /// 诊断转xml格式
        /// </summary>
        /// <param name="diDTOs">诊断数据集合</param>
        /// <param name="xmlCfgPath">解析诊断的xml配置文件</param>
        /// <returns></returns>
        public string convertZdToXmlStr(DIDTO[] diDTOs, string xmlCfgPath)
        {
            bool showDigTypeName = false;

            string xmlPath = Application.StartupPath + xmlCfgPath;
            StringBuilder builder = new StringBuilder();
            builder.Append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
            builder.Append("<root>");
            builder.Append("<dig signName=\"\" signTime=\"\">");
            if (diDTOs != null && diDTOs.Length > 0)
            {
                // 获取诊断体系常量
                List<string> zdtxList = EmrEditorXmlViewModel.getZdtxList(xmlPath);
                SortedDictionary<string, SortedDictionary<string, SortedDictionary<string, string>>> propertyDic = EmrEditorXmlViewModel.getXmlDic(xmlPath);

                SortedDictionary<string, List<DIDTO>> diDTODic = this.reOrderDIDTO(diDTOs, zdtxList);
                if (diDTODic != null)
                {
                    //if (diDTODic.Count > 1)
                    //{
                        showDigTypeName = true;
                    //}

                    foreach (string zdtx in zdtxList)
                    {
                        if (!diDTODic.ContainsKey(zdtx))
                        {
                            continue;
                        }

                        SortedDictionary<string, SortedDictionary<string, string>> dic = propertyDic[zdtx];
                        SortedDictionary<string, string> digTypeProeprty = dic[DIGTYPE_NODE];
                        // 追加digType节点
                        this.appendDigTypeProperty(builder, digTypeProeprty, showDigTypeName);

                        // 追加dig、cdig节点
                        this.appendDigProperty(builder, dic, diDTODic[zdtx]);

                        builder.Append("</digType>");
                    }
                }
            }
            builder.Append("</dig>");
            builder.Append("</root>");
            return builder.ToString();
        }

        /// <summary>
        /// 追加digType节点
        /// </summary>
        /// <param name="builder"></param>
        /// <param name="digTypeProeprty"></param>
        /// <param name="dispalyName"></param>
        private void appendDigTypeProperty(StringBuilder builder, SortedDictionary<string, string> digTypeProeprty, bool dispalyName)
        {

            builder.Append("<" + DIGTYPE_NODE);

            foreach (string key in digTypeProeprty.Keys)
            {
                builder.Append(SPACE_STR);
                if (key == "name")
                {
                    if (dispalyName)
                    {
                        builder.Append(key + "=\"" + digTypeProeprty[key] + "\"");
                    }
                    else
                    {
                        builder.Append(key + "=\"\"");
                    }
                }
                else { builder.Append(key + "=\"" + digTypeProeprty[key] + "\""); }

            }
            builder.Append(">");
        }

        /// <summary>
        /// 追加dig节点
        /// </summary>
        /// <param name="builder"></param>
        /// <param name="digTypeProeprty"></param>
        /// <param name="diDTOList"></param>
        private void appendDigProperty(StringBuilder builder, SortedDictionary<string, SortedDictionary<string, string>> proeprtyDic, List<DIDTO> diDTOList)
        {
            Type type = null;

            // dig节点属性
            SortedDictionary<string, string> digProperty = proeprtyDic["dig"];
            // cdig节点属性
            SortedDictionary<string, string> cdigProperty = proeprtyDic["cdig"];

            foreach (DIDTO diDTO in diDTOList)
            {
                if (type == null)
                {
                    type = diDTO.GetType();
                }

                builder.Append("<" + DIG_NODE).Append(SPACE_STR);
                //this.appendNameStr(builder, type, diDTO, digProperty["name"], digProperty["displayColumn"]);
                this.appendNameStrNew(builder, type, diDTO, digProperty, digProperty["displayColumn"]);
                builder.Append(">");

                // 追加cdig节点内容
                this.appendCDigProperty(builder, type, cdigProperty, diDTO);

                builder.Append("</" + DIG_NODE + ">");
            }
        }

        /// <summary>
        /// 追加cdig节点属性
        /// </summary>
        /// <param name="builder"></param>
        /// <param name="cdigProperty"></param>
        /// <param name="diDTO"></param>
        private void appendCDigProperty(StringBuilder builder, Type type, SortedDictionary<string, string> cdigProperty, DIDTO diDTO)
        {
            builder.Append("<" + CDIG_NODE).Append(SPACE_STR); ;
            //this.appendNameStr(builder, type, diDTO, cdigProperty["name"], cdigProperty["displayColumn"]);
            this.appendNameStrNew(builder, type, diDTO, cdigProperty, cdigProperty["displayColumn"]);
            builder.Append("></" + CDIG_NODE + ">");
        }

        private void appendNameStr(StringBuilder builder, Type type, DIDTO diDTO, string nameStr, string displayColumn)
        {
            string tempColName = null;
            string tempVal = null;


            if (string.IsNullOrEmpty(nameStr) || string.IsNullOrEmpty(displayColumn))
            {
                return;
            }

            // 属性分组 displayColumn="Id_disys_name;Fg_suspdi|Y:?,N:'',default:''"
            string[] columnArr = displayColumn.Split(';');

            // 遍历所有displayColumn中配置的属性，并将属性值赋值给name中匹配的属性
            foreach (string colName in columnArr)
            {
                tempColName = colName;
                // 用于判断属性中是否有需要将值进行转译
                string[] colValOptional = colName.Split('|');

                if (colValOptional.Length > 1)
                {
                    tempColName = colValOptional[0];
                }
                tempVal = this.getPropertyVal(diDTO, type, tempColName);
                // 把结果替换成配置中对应的符号 displayColumn="Id_disys_name;Fg_suspdi|Y:?,N:'',default:''"
                if (!string.IsNullOrEmpty(tempVal) && colValOptional.Length > 1)
                {
                    string[] colValOptionalArr = colValOptional[1].Split(',');
                    foreach (string valOptional in colValOptionalArr)
                    {
                        string[] valDic = valOptional.Split(':');
                        if (valDic[0].Equals(tempVal))
                        {
                            if (valDic[1].Equals("''"))
                            {
                                tempVal = "";
                            }
                            else
                            {
                                tempVal = valDic[1];
                            }

                            break;
                        }
                    }
                }


                // 将name字符串中指定的属性替换成对应的值
                nameStr = nameStr.Replace("{" + tempColName + "}", tempVal);
            }
            builder.Append("name=\"" + nameStr + "\"");
        }
        private void appendNameStrNew(StringBuilder builder, Type type, DIDTO diDTO, SortedDictionary<string, string> digProperty, string displayColumn)
        {
            string tempColName = null;
            string nameStr = digProperty["name"];

            if (digProperty == null || string.IsNullOrEmpty(displayColumn))
            {
                return;
            }

            // 属性分组 displayColumn="Id_disys_name;Fg_suspdi;Supplement"
            string[] columnArr = displayColumn.Split(';');
            foreach (string key in digProperty.Keys)
            {
                if (!key.Equals("displayColumn"))
                {
                    bool isMatch = false;

                    foreach (string colName in columnArr)
                    {
                        string tempColname = "{" + colName + "}";
                        if (digProperty[key] == ("{" + colName + "}"))
                        {
                            isMatch = true;
                            tempColName = colName;
                        }
                    }
                    if (isMatch)
                    {
                        builder.Append(key + "=\"" + this.getPropertyVal(diDTO, type, tempColName) + "\" ");
                    }
                    else
                    {
                        builder.Append(key + "=\"" + digProperty[key] + "\" ");
                    }
                }
            }

        }
        /// <summary>
        /// 将诊断数据按诊断体系进行分组
        /// </summary>
        /// <param name="diDTOs">诊断数据集合</param>
        /// <param name="zdtxList">诊断体系集合</param>
        /// <returns></returns>
        private SortedDictionary<string, List<DIDTO>> reOrderDIDTO(DIDTO[] diDTOs, List<string> zdtxList)
        {

            SortedDictionary<string, List<DIDTO>> didtoList = null;

            if (zdtxList != null && zdtxList.Count > 0 && diDTOs != null && diDTOs.Length > 0)
            {

                didtoList = new SortedDictionary<string, List<DIDTO>>();

                Dictionary<string, List<DIDTO>> diDTODic = new Dictionary<string, List<DIDTO>>();

                if (!String.IsNullOrEmpty(diDTOs[0].Id_didef))
                {
                    foreach (DIDTO diDTO in diDTOs)
                    {
                        // 排除未在配置文件中指定的诊断体系
                        if (!diDTODic.ContainsKey(diDTO.Id_disys))
                        {
                            diDTODic.Add(diDTO.Id_disys, new List<DIDTO>());
                        }
                        // 是否为主诊断，主诊断放第一位
                        if (diDTO.Fg_majdi == FBoolean.True)
                        {
                            diDTODic[diDTO.Id_disys].Insert(0, diDTO);
                        }
                        else
                        {
                            diDTODic[diDTO.Id_disys].Add(diDTO);
                        }
                    }
                }
                else
                {
                    diDTODic.Add(CiDictCodeConst.ID_CI_DISYS_XYZDTX, new List<DIDTO>());
                }

                foreach (string zdtx in zdtxList)
                {
                    if (diDTODic.ContainsKey(zdtx))
                    {
                        didtoList.Add(zdtx, diDTODic[zdtx]);
                    }
                }
            }
            return didtoList;
        }

        /// <summary>
        /// 处置追加Column部分
        /// </summary>
        /// <param name="builder"></param>
        /// <param name="colNameList"> 列名集合</param>
        private void appendColumnStr(StringBuilder builder, List<string> colNameList)
        {
            builder.Append("<column>");
            foreach (string colName in colNameList)
            {
                builder.Append("<node>");
                builder.Append(colName);
                builder.Append("</node>");
            }

            builder.Append("</column>");

        }

        /// <summary>
        /// 追加body部分的str
        /// </summary>
        /// <param name="element"></param>
        /// <param name="colNameList"></param>
        /// <param name="builder"></param>
        /// <param name="ciOrderList"></param>
        private void appendBodyStr(XmlElement element, List<string> colNameList, StringBuilder builder, CiOrderDO[] ciOrders)
        {
            // 结构说明：sd_srvtp code: [format colName: format节点]
            Dictionary<string, Dictionary<string, XmlNode>> dic = this.getSdSrvtpNodeDic(element);

            // 遍历ciorder数据集合，根据规则解析 ciOrder.Content_or字段内容
            // 每条医嘱作为一个分组
            foreach (CiOrderDO ciOrder in ciOrders)
            {
                //根据服务分类获取配置中对应配置节点信息
                Dictionary<string, XmlNode> formatNodeDic = this.getXmlNodeListBySdSrvtp(ciOrder.Sd_srvtp, dic);

                if (formatNodeDic == null)
                {
                    continue;
                }

                builder.Append("<group>");

                // 获取Content_or字段信息
                string contentOr = ciOrder.Content_or;
                string[] contentArr = contentOr.Split('|');

                // 服务名1&用量1&单位1&煎法1^服务名2&用量2&单位2&煎法2
                string[] content2Arr = contentArr[2].Split('^');
                for (int l = 0; l < content2Arr.Length; l++)
                {
                    builder.Append("<row>");
                    // 遍历列，获取对应列的值
                    foreach (string colName in colNameList)
                    {
                        // 不含表头的列需要添加空节点占位
                        if (!formatNodeDic.ContainsKey(colName))
                        {
                            builder.Append("<node></node>");
                            continue;
                        }
                        builder.Append("<node>");

                        // 获取配置文件中格式化数据节点
                        XmlNode formatNode = formatNodeDic[colName];
                        // 节点对应内容中的索引（存在多对情况 如format content="2.1,2.2" colName="Dosage"/>）
                        // 对应显示的内容为 用量、单位合并显示到一个单元格
                        string[] contentIndexArr = formatNode.Attributes["content"].Value.Split(',');
                        string tempVal = "";
                        for (int i = 0; i < contentIndexArr.Length; i++)
                        {
                            // 配置文件中对应内容的索引
                            string[] indexArr = contentIndexArr[i].Split('.');
                            int contentIndex = int.Parse(indexArr[0]);
                            int valIndex = int.Parse(indexArr[1]);

                            // contentIndex ==2 存在多组数据情况，服务名1&用量1&单位1&煎法1^服务名2&用量2&单位2&煎法2 其数据按“^”分割
                            if (contentIndex == 2)
                            {
                                if (content2Arr[l].IndexOf("null") >= 0)
                                {
                                    tempVal += "";
                                }
                                if (content2Arr.Length > l && content2Arr[l].Split('&').Length > valIndex)
                                {
                                    tempVal += content2Arr[l].Split('&')[valIndex] + " ";
                                }
                                else
                                {
                                    throw new XapBizException("医嘱中物品[" + ciOrder.Sd_srvtp + ":" + ciOrder.Content_or + "]格式错误，");
                                }
                            }
                            else
                            {
                                if (contentArr[contentIndex].IndexOf("null") == 0)
                                {
                                    tempVal += "";
                                }
                                else if (contentArr.Length > contentIndex && contentArr[contentIndex].Split('&').Length > valIndex)
                                {
                                    tempVal += contentArr[contentIndex].Split('&')[valIndex] + " ";
                                }
                                else
                                {
                                    throw new XapBizException("医嘱中物品[" + ciOrder.Sd_srvtp + ":" + ciOrder.Content_or + "]格式错误，");
                                }

                            }

                            if (tempVal == null || tempVal.IndexOf("null") >= 0)
                            {
                                tempVal = "";
                            }
                        }
                        builder.Append(tempVal + "</node>");
                    }

                    builder.Append("</row>");
                }
                builder.Append("</group>");
            }
        }

        /// <summary>
        /// 追加body部分的str  yjb
        /// </summary>
        /// <param name="element"></param>
        /// <param name="colNameList"></param>
        /// <param name="builder"></param>
        /// <param name="mrDtos"></param>
        private void appendBodyStr(XmlElement element, List<string> colNameList, StringBuilder builder, OrderMrDto[] mrDtos)
        {
            // 结构说明：sd_srvtp code: [format colName: format节点]
            Dictionary<string, Dictionary<string, XmlNode>> dic = this.getSdSrvtpNodeDic(element);
            string id_or = "";
            int i = 0;

            // 遍历OrderMrDto数据集合
            // 每条医嘱作为一个分组
            foreach (OrderMrDto mrDto in mrDtos)
            {
                if (string.IsNullOrWhiteSpace(mrDto.Sd_srvtp))
                    continue;
                //根据服务分类获取配置中对应配置节点信息
                Dictionary<string, XmlNode> formatNodeDic = this.getXmlNodeListBySdSrvtp(mrDto.Sd_srvtp, dic);

                if (formatNodeDic == null)
                {
                    continue;
                }

                if (!id_or.Equals(mrDto.Id_or))
                {
                    if(i>0)
                        builder.Append("</group>");
                    builder.Append("<group>");
                }

                builder.Append("<row>");

                foreach (string colName in colNameList)
                {
                    // 不含表头的列需要添加空节点占位
                    if (!formatNodeDic.ContainsKey(colName))
                    {
                        builder.Append("<node></node>");
                        continue;
                    }
                    builder.Append("<node>");

                    // 获取配置文件中格式化数据节点
                    XmlNode formatNode = formatNodeDic[colName];

                    //数据源DTO的字段名
                    string colNameCont = formatNode.Attributes["content"].Value;

                    string[] colNameConts = colNameCont.Split(',');

                    if (colNameConts != null && colNameConts.Length > 1)
                    {
                        for (int j = 0; j < colNameConts.Length; j++)
                        {
                            if (mrDto.getAttrVal(colNameConts[j]) != null)
                                builder.Append(mrDto.getAttrVal(colNameConts[j]).ToString());
                        }
                    }
                    else
                    {
                        if (mrDto.getAttrVal(colNameCont) != null)
                            builder.Append(mrDto.getAttrVal(colNameCont).ToString());
                    }

                    builder.Append("</node>");
                }

                builder.Append("</row>");

                if (mrDtos.Length-1 == i)
                {
                    builder.Append("</group>");
                }

                id_or = mrDto.Id_or;
                i++;
            }
        }

        /// <summary>
        /// 根据分类找到xml中对应的节点
        /// </summary>
        /// <param name="sdSrvtp"></param>
        /// <param name="dic"></param>
        /// <returns></returns>
        private Dictionary<string, XmlNode> getXmlNodeListBySdSrvtp(string sdSrvtp, Dictionary<string, Dictionary<string, XmlNode>> dic)
        {
            string tempSdSrvtp = sdSrvtp;
            int l = sdSrvtp.Length / 2;
            for (int i = 0; i < l; i++)
            {
                tempSdSrvtp = tempSdSrvtp.Substring(0, tempSdSrvtp.Length - i * 2);
                if (dic.ContainsKey(tempSdSrvtp))
                {
                    return dic[tempSdSrvtp];
                }
            }
            // 没有找到匹配的配置查找默认配置
            if (dic.ContainsKey("OTH"))
            {
                return dic["OTH"];
            }

            //TODO 在配置文件EmrEditorCiOrder.xml中没找到对应分类的编码的配置时抛出异常
            throw new XapBizException("医嘱病历配置文件中未找到物品分类为[" + sdSrvtp + "]相关配置");
        }

        /// <summary>
        /// 获取body部分的sd_srvtp 节点
        /// </summary>
        /// <param name="element"></param>
        /// <returns>Dictionary对象，其中key值为sd_srvtp code vlaue为format节点，
        /// <para>结构说明：sd_srvtp code: [format colName: format节点]</para>
        /// </returns>
        private Dictionary<string, Dictionary<string, XmlNode>> getSdSrvtpNodeDic(XmlElement element)
        {
            XmlNode bodyNode = element.SelectSingleNode("body");
            XmlNodeList nodeList = bodyNode.SelectNodes("sd_srvtp");

            Dictionary<string, Dictionary<string, XmlNode>> xmlNodeDic = new Dictionary<string, Dictionary<string, XmlNode>>();

            Dictionary<string, XmlNode> sdSrvtpNodeDic = new Dictionary<string, XmlNode>();

            // 先将节点换成Dictionary对象，当节点存在引用情况是需要使用sdSrvtpNodeDic
            foreach (XmlNode node in nodeList)
            {
                sdSrvtpNodeDic.Add(node.Attributes["code"].Value, node);
            }

            foreach (XmlNode node in nodeList)
            {

                Dictionary<string, XmlNode> formatNodeDic = new Dictionary<string, XmlNode>();

                XmlNode tempNode = node;
                // 判断xml中是否为参考其他节点，如果是参考其他节点，获取参考节点信息
                XmlNode refNode = tempNode.SelectSingleNode("ref");
                if (refNode != null)
                {
                    string refCode = refNode.Attributes["code"].Value;
                    if (sdSrvtpNodeDic.ContainsKey(refCode))
                    {
                        tempNode = sdSrvtpNodeDic[refCode];
                    }
                }

                // 获取节点中的format节点
                XmlNodeList formNodeList = tempNode.SelectNodes("format");
                foreach (XmlNode formatNode in formNodeList)
                {
                    formatNodeDic.Add(formatNode.Attributes["colName"].Value, formatNode);
                }
                xmlNodeDic.Add(node.Attributes["code"].Value, formatNodeDic);
            }

            return xmlNodeDic;
        }

        /// <summary>
        /// 根据属性名称获取属性值
        /// </summary>
        /// <param name="obj">获取值得数据对象</param>
        /// <param name="type">对象的Type属性</param>
        /// <param name="propertyName">属性名称</param>
        /// <returns></returns>
        private string getPropertyVal(object obj, Type type, string propertyName)
        {

            PropertyInfo propertyInfo = type.GetProperty(propertyName);

            if (propertyInfo == null)
            {
                throw new XapBizException("对象中不包含属性[" + propertyName + "]");
            }

            object valueObj = propertyInfo.GetValue(obj, null);

            string valStr = null;
            if (valueObj is string || valueObj is DateTime || valueObj is int)
            {// 字符串类型
                valStr = valueObj.ToString();
            }
            else if (valueObj is bool)
            {
                valStr = ((bool)valueObj) == true ? "Y" : "N";
            }
            else
            {
                valStr = "";
            }

            return valStr;
        }


    }
}
