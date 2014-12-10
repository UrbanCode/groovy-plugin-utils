package com.urbancode.air;

public class AirPluginTool {

    //**************************************************************************
    // CLASS
    //**************************************************************************

    //**************************************************************************
    // INSTANCE
    //**************************************************************************
    
    final public def isWindows = (System.getProperty('os.name') =~ /(?i)windows/).find()

    def out = System.out;
    def err = System.err;

    private def inPropsFile;
    private def outPropsFile;

    def outProps;

    public AirPluginTool(def inFile, def outFile){
        inPropsFile = inFile;
        outPropsFile = outFile;
        outProps = new Properties();
    }

    public Properties getStepProperties() {
        def props = new Properties();
        final def inputPropsFile = this.inPropsFile;
        final def inputPropsStream = null;
        try {
            inputPropsStream = new FileInputStream(inputPropsFile);
            props.load(inputPropsStream);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            inputPropsStream.close();
        }
        return props;
    }

    public void setOutputProperty(String name, String value) {
        this.outProps.setProperty(name, value);
    }

    public void setOutputProperties() {
        final OutputStream outputPropsStream = null;
        try {
            outputPropsStream = new FileOutputStream(this.outPropsFile);
            outProps.store(outputPropsStream, "");
        }
        finally {
            if (outputPropsStream != null) {
                outputPropsStream.close();
            }   
        }
    }

    public String getAuthToken() {
        String authToken = System.getenv("AUTH_TOKEN");
        return "{\"token\" : \"" + authToken + "\"}";
    }

    public String getAuthTokenUsername() {
        return "PasswordIsAuthToken";
    }

    public void storeOutputProperties() {
        setOutputProperties();
    }
}
