package com.RNFetchBlob;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

class RNFetchBlobConfig {

    public Boolean fileCache;
    public String path;
    public String appendExt;
    public ReadableMap addAndroidDownloads;
    public Boolean trusty;
    public String key;
    public String mime;
    public Boolean auto;
    public Boolean overwrite = true;
    public Boolean increment = false;
    public Boolean followRedirect = true;
    public ReadableArray binaryContentTypes = null;

    public long connectTimeout = 60000;
    public long readTimeout = 60000;
    public long writeTimeout = 60000;

    RNFetchBlobConfig(ReadableMap options) {
        if(options == null)
            return;
        this.fileCache = options.hasKey("fileCache") ? options.getBoolean("fileCache") : false;
        this.path = options.hasKey("path") ? options.getString("path") : null;
        this.appendExt = options.hasKey("appendExt") ? options.getString("appendExt") : "";
        this.trusty = options.hasKey("trusty") ? options.getBoolean("trusty") : false;
        if(options.hasKey("addAndroidDownloads")) {
            this.addAndroidDownloads = options.getMap("addAndroidDownloads");
        }
        if(options.hasKey("binaryContentTypes"))
            this.binaryContentTypes = options.getArray("binaryContentTypes");
        if(this.path != null && path.toLowerCase().contains("?append=true")) {
            this.overwrite = false;
        }
        if(options.hasKey("overwrite"))
            this.overwrite = options.getBoolean("overwrite");
        if(options.hasKey("followRedirect")) {
            this.followRedirect = options.getBoolean("followRedirect");
        }
        this.key = options.hasKey("key") ? options.getString("key") : null;
        this.mime = options.hasKey("contentType") ? options.getString("contentType") : null;
        this.increment = options.hasKey("increment") ? options.getBoolean("increment") : false;
        this.auto = options.hasKey("auto") ? options.getBoolean("auto") : false;

        if (options.hasKey("timeout")) {
            this.connectTimeout = options.getInt("timeout");
            this.readTimeout = options.getInt("timeout");
            this.writeTimeout = options.getInt("timeout");
        }

        if (options.hasKey("connectTimeout")) {
            this.connectTimeout = options.getInt("connectTimeout");
        }

        if (options.hasKey("readTimeout")) {
            this.readTimeout = options.getInt("readTimeout");
        }

        if (options.hasKey("writeTimeout")) {
            this.writeTimeout = options.getInt("writeTimeout");
        }
    }

}
