using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.dto.d;
using iih.en.pv.dto.d;
using xap.rui.engine;

namespace iih.ci.ord.medicaresharing
{
    interface IMedicalSharingDateRule
    {
        List<MedicalSharingDTO> MedicalSharingValidate(BaseContext context, MedicalSharingDTO[] medicalSharingDto, Ent4BannerDTO ent4BannerDto);
    }
}
