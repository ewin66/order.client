using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ems.d;
using iih.en.pv.dto.d;
using xap.mw.core.data;
  
namespace iih.ci.iih.ci.ord.ems.d
{    /// <summary>
       /// CiOrderTransMissionDTO 的摘要说明。
       /// </summary>
   public  class CiOrderTransMissionDTO : BaseDTO
    {

     
           public CiOrderTransMissionDTO()
           {

           }

           /// <summary>
           /// 主键
           /// </summary>
           public string Id
           {
               get { return getAttrVal<string>("Id", null); }
               set { setAttrVal<string>("Id", value); }
           }

           /// <summary>
           /// 提示信息
           /// </summary>
           public FMap2 Fmap2
           {
               get { return getAttrVal<FMap2>("Fmap2", null); }
               set { setAttrVal<FMap2>("Fmap2", value); }
           }

          

           /// <summary>
           /// 医嘱集合
           /// </summary>
           public FArrayList Ciorderaggdo
           {
               get { return getAttrVal<FArrayList>("Ciorderaggdo", null); }
               set { setAttrVal<FArrayList>("Ciorderaggdo", value); }
           }

           /// <summary>
           /// 临床上下文信息
           /// </summary>
           public CiEnContextDTO Ciencontextdto
           {
               get { return getAttrVal<CiEnContextDTO>("Ciencontextdto", null); }
               set { setAttrVal<CiEnContextDTO>("Ciencontextdto", value); }
           }

           /// <summary>
           /// 医疗单类型
           /// </summary>
           public int? Ciemstype
           {
               get { return getAttrVal<int?>("Ciemstype", null); }
               set { setAttrVal<int?>("Ciemstype", value); }
           }

           /// <summary>
           /// displaynam7
           /// </summary>
           public string Name7
           {
               get { return getAttrVal<string>("Name7", null); }
               set { setAttrVal<string>("Name7", value); }
           }

           /// <summary>
           /// displaynam8
           /// </summary>
           public string Name8
           {
               get { return getAttrVal<string>("Name8", null); }
               set { setAttrVal<string>("Name8", value); }
           }

           /// <summary>
           /// displaynam9
           /// </summary>
           public string Name9
           {
               get { return getAttrVal<string>("Name9", null); }
               set { setAttrVal<string>("Name9", value); }
           }

           /// <summary>
           /// displaynam10
           /// </summary>
           public string Name10
           {
               get { return getAttrVal<string>("Name10", null); }
               set { setAttrVal<string>("Name10", value); }
           }

           /// <summary>
           /// displaynam11
           /// </summary>
           public string Name11
           {
               get { return getAttrVal<string>("Name11", null); }
               set { setAttrVal<string>("Name11", value); }
           }
           /// <summary>
           /// 返回属性列表
           /// </summary>
           /// <returns></returns>
           public override string[] getAttrNames()
           {
               return new string[] { "Id", "Fmap2", "Errlist", "Ciorderaggdo", "Ciencontextdto", "Ciemstype", "Name7", "Name8", "Name9", "Name10", "Name11" };
           }

           /// <summary>
           /// 返回全路径DO类名
           /// </summary>
           /// <returns></returns>
           public override string getFullClassName()
           {
               return "iih.ci.ord.ems.ciordertransmissiondt.d.CiOrderTransMissionDTO";
           }
       }

    }

