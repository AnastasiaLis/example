package com.xxx.yyy.util;

import java.io.IOException;
import java.net.InetSocketAddress;
import javax.servlet.http.HttpSession;
import net.rubyeye.xmemcached.XMemcachedClient;

public class XXXUtil {
    public static String getMemcached(String item){
        String itemval="";
        XMemcachedClient mcc = null;
        try{
           mcc = new XMemcachedClient(new InetSocketAddress("xxx.xxx.xxx.xxx", portnumber));
           itemval = (String)mcc.get(item);
        }catch(IOException ee){
            ee.printStackTrace();
        }catch(Exception eeee){
            eeee.printStackTrace();
        } 
        finally {
            if (mcc != null)
                try{mcc.shutdown();}catch(Exception e) {}
        }
        return itemval;
    }
    public static void setMemcached(String item, String value){
       XMemcachedClient mcc = null;
       try{
           mcc = new XMemcachedClient(new InetSocketAddress("xxx.xxx.xxx.xxx", portnumber));    
           mcc.set(item, 14400, value);
       }catch(Exception ee){
           ee.printStackTrace();
       }
       finally {
            if (mcc != null)
                try{mcc.shutdown();}catch(Exception e) {}
        }
    }
}