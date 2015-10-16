
package com.shores.fe.starmap.viewer.interfaces.observability;

import com.shores.fe.starmap.viewer.models.FeedbackCode;

public interface Observer {
    public void update(FeedbackCode code);
}
