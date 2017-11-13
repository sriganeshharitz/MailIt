package com.uttarainfo.test.MailIt.Model;

import java.util.*;
import java.io.*;
class testpgm
{
    public static double hex2dec(String s)
    {
        String digits = "0123456789ABCDEF";
        s = s.toUpperCase();
        double val = 0;
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            double d = digits.indexOf(c);
            val = 16*val + d;
        }
        return val;
    }
    public static String dec2bin(double dec){
        double decnum=dec;
        String binD="";
        while(decnum != 0)
        {
            binD = ((int)(decnum%2))+binD;
            decnum = decnum/2;
        }
        return binD.replaceAll("^[0]+","");
    }

    public static void main(String args[]) throws Exception
    {
// Open the file
        FileInputStream fstream = new FileInputStream("RAMerrors");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        double maxRam=Math.pow(1024,3);
        double ramRange[] = {0,maxRam, maxRam*2, maxRam*3, (maxRam*4)-1};

        String strLine;
        //Read File Line By Line
        while ((strLine = br.readLine()) != null ) {
            strLine=strLine.trim();
            double decimal = hex2dec(strLine);
            String bin = dec2bin(decimal);
            boolean notfound=true;
            for (int i=0;i<ramRange.length-1;i++){
                if ((decimal>=ramRange[i]) && (decimal<ramRange[i+1])) {
                    System.out.printf("%s = %.0f = %s = decimal number located at %d RAM chip\n",strLine,decimal,bin,i);
                    notfound=false;
                    break;
                }
            }
            if (notfound) System.out.printf("%s = %.0f = %s = decimal number not located in RAM chip\n",strLine,decimal,bin);
        }

        br.close();
    }
}