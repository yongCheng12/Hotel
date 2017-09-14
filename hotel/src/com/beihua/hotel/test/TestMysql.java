package com.beihua.hotel.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
public class TestMysql {
 
 public static void main(String[] args) {
  System.out.println("��ʼ����...");
  backup();
  System.out.println("���ݳɹ�...");
  
  System.out.println("��ʼ��ԭ...");
  load1();
  System.out.println("��ԭ�ɹ�...");
 }
 
 public static void backup() {
  try {
   Runtime rt = Runtime.getRuntime();
   // ���� ����mysql�İ�װĿ¼������
   Process child = rt
     .exec("D://mysql5//bin//mysqldump -h localhost -uroot -pmysql  webshop");
   // ���õ�������Ϊutf-8�����������utf-8
   // �ѽ���ִ���еĿ���̨�����Ϣд��.sql�ļ����������˱����ļ���ע��������Կ���̨��Ϣ���ж�������ᵼ�½��̶����޷�����
   InputStream in = child.getInputStream();// ����̨�������Ϣ��Ϊ������
   InputStreamReader xx = new InputStreamReader(in, "utf-8");
   // �������������Ϊutf-8�����������utf-8����������ж����������
   String inStr;
   StringBuffer sb = new StringBuffer("");
   String outStr;
   // ��Ͽ���̨�����Ϣ�ַ���
   BufferedReader br = new BufferedReader(xx);
   while ((inStr = br.readLine()) != null) {
    sb.append(inStr + "\r\n");
   }
   outStr = sb.toString();
   // Ҫ�����������õ�sqlĿ���ļ���
   FileOutputStream fout = new FileOutputStream(
     "e:/test.sql");
   OutputStreamWriter writer = new OutputStreamWriter(fout, "utf-8");
   writer.write(outStr);
   writer.flush();
   in.close();
   xx.close();
   br.close();
   writer.close();
   fout.close();
   System.out.println("");
  } catch (Exception e) {
   e.printStackTrace();
  }
 }
 
 public static void load() {
  try {
   String fPath = "c:/test.sql";
   Runtime rt = Runtime.getRuntime();
   // ���� mysql ��װĿ¼������
   Process child = rt.exec("C://Program Files//MySQL//MySQL Server 5.1//bin//mysql -u root -p root dlgs_test");
  
   OutputStream out = child.getOutputStream();// ����̨��������Ϣ��Ϊ�����
   String inStr;
   StringBuffer sb = new StringBuffer("");
   String outStr;
   BufferedReader br = new BufferedReader(new InputStreamReader(
     new FileInputStream(fPath), "utf-8"));
   while ((inStr = br.readLine()) != null) {
    sb.append(inStr + "\r\n");
   }
   outStr = sb.toString();
   System.out.println(outStr);
   OutputStreamWriter writer = new OutputStreamWriter(out, "utf-8");
   System.out.println("7777777777777777777777777777777777777");
   writer.write(outStr);
   System.out.println("888888888888888888888888888888888888888");
   writer.flush();
   out.close();
   br.close();
   writer.close();
   System.out.println("");
  } catch (Exception e) {
   e.printStackTrace();
  }
 }
 
 public static void load1() {      
        try {      
            String fPath = "e:/test.sql";    
            Runtime rt = Runtime.getRuntime();      
     
            // ���� mysql �� cmd:      
            Process child = rt.exec("D://mysql5//bin//mysql.exe -uroot -pmysql test ");      
            OutputStream out = child.getOutputStream();//����̨��������Ϣ��Ϊ�����      
            String inStr;      
            StringBuffer sb = new StringBuffer("");      
            String outStr;      
            BufferedReader br = new BufferedReader(new InputStreamReader(      
                    new FileInputStream(fPath), "utf8"));      
            while ((inStr = br.readLine()) != null) {      
                sb.append(inStr + "\r\n");      
            }      
            outStr = sb.toString();      
     
            OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");      
            writer.write(outStr);      
            // ע����������û��巽ʽд���ļ��Ļ����ᵼ���������룬��flush()��������Ա���      
            writer.flush();      
            // �����ǹر����������      
            out.close();      
            br.close();      
            writer.close();      
     
            System.out.println("");      
     
        } catch (Exception e) {      
            e.printStackTrace();      
        }      
     
    } 
 
}
