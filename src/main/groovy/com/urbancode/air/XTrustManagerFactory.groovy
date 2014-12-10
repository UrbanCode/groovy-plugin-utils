package com.urbancode.air

import javax.net.ssl.ManagerFactoryParameters
import javax.net.ssl.TrustManager
import javax.net.ssl.TrustManagerFactorySpi
import java.security.InvalidAlgorithmParameterException
import java.security.KeyStore

public class XTrustManagerFactory extends TrustManagerFactorySpi {

    //**********************************************************************************************
    // CLASS
    //**********************************************************************************************

    //**********************************************************************************************
    // INSTANCE
    //**********************************************************************************************

    //------------------------------------------------------------------------------------------
    public XTrustManagerFactory() {
    }

    //------------------------------------------------------------------------------------------
    @Override
    protected void engineInit(KeyStore keystore) {
    }

    //------------------------------------------------------------------------------------------
    @Override
    protected void engineInit(ManagerFactoryParameters managerParams)
    throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException(
                "XTrustManagerFactory cannot be initialized using ManagerFactoryParameters");
    }

    //------------------------------------------------------------------------------------------
    @Override
    protected TrustManager[] engineGetTrustManagers() {
        List<TrustManager> managerList = new ArrayList<TrustManager>();
        managerList.add(new OpenX509TrustManager());

        return managerList.toArray(new TrustManager[managerList.size()]);
    }
}
