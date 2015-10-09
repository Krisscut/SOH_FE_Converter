package com.shores.fe.starmap.viewer.interfaces;

import com.shores.fe.starmap.viewer.core.SOH_FE_Converter;
import com.shores.fe.starmap.viewer.models.AbstractModel;

public interface IController {
    public void init(AbstractModel model, SOH_FE_Converter core);
}
