package com.dlz.scheme.bimface;

import com.bimface.exception.BimfaceException;
import com.bimface.sdk.BimfaceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BimfaceComponent {
    @Autowired
    private BimfaceClient bimfaceClient;

    public String getViewtoken(Long fileId) throws BimfaceException {
        return bimfaceClient.getViewTokenByFileId(fileId);
    }

}
