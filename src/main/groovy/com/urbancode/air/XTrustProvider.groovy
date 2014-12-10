package com.urbancode.air

import java.security.Provider
import java.security.Security

public class XTrustProvider extends Provider {

    //**********************************************************************************************
    // CLASS
    //**********************************************************************************************
    final static private long serialVersionUID = 1L;

    //----------------------------------------------------------------------------------------------
    static public void install() {
        if (Security.getProvider(XTrustProvider.class.getSimpleName()) == null) {
            Security.insertProviderAt(new XTrustProvider(), 2);
            Security.setProperty("ssl.TrustManagerFactory.algorithm", "XTrust509");
        }
    }

    //**********************************************************************************************
    // INSTANCE
    //**********************************************************************************************

    //----------------------------------------------------------------------------------------------
    public XTrustProvider() {
        super(XTrustProvider.class.getSimpleName(), 1D,
                "Basic XTrustProvider ignoring invalid certificates");

        put("TrustManagerFactory.XTrust509", XTrustManagerFactory.class.getName());
    }
}
