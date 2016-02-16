package com.manager.common;
import java.io.IOException;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
public class MD5
{


  public static final byte[] encodeToBytes(String origin)
  {
    try
    {
      MessageDigest md = MessageDigest.getInstance("MD5");
      return md.digest(new String(origin).getBytes());
    } catch (Exception e) {
      System.out.println("无法获得MD5实例");
    }
    return null;
  }

  public static final String encode(String origin)
  {
    try
    {
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] bytes = md.digest(
    	        new String(origin).getBytes());
      StringBuffer strb = new StringBuffer();
      for(int i=0;i<bytes.length;i++){
    	  //bytes[i] =   (byte)(bytes[i] & Integer.parseInt("000000000000000000000000011111111", 2));
    	 int n = bytes[i];
    	  if(n<0){
    		  n = 256 + n;
    	  }
    	  if(Integer.toHexString(n).length()==1){
    		  strb.append("0"+Integer.toHexString(n));
    	  }else{
    		  strb.append(Integer.toHexString(n));
    	  }
    	  
      }
     
      return strb.toString();

    } catch (Exception e) {
      System.out.println("无法获得MD5实例");
    }return "";
  }
  public static final Set<String> encodeInBatch(Set<String> origins)
  {
	  Set<String> set = new HashSet<String>();
    try
    {
      MessageDigest md = MessageDigest.getInstance("MD5");
      for(String origin:origins){
      byte[] bytes = md.digest(
    	        new String(origin).getBytes());
      StringBuffer strb = new StringBuffer();
      for(int i=0;i<bytes.length;i++){
    	  //bytes[i] =   (byte)(bytes[i] & Integer.parseInt("000000000000000000000000011111111", 2));
    	 int n = bytes[i];
    	  if(n<0){
    		  n = 256 + n;
    	  }
    	  if(Integer.toHexString(n).length()==1){
    		  strb.append("0"+Integer.toHexString(n));
    	  }else{
    		  strb.append(Integer.toHexString(n));
    	  }
    	  
      }
     
      set.add(strb.toString());
      }

    } catch (Exception e) {
      System.out.println("无法获得MD5实例");
    }
    return set;
  }
  
  public static final Set<String> encodeInBatch(Set<String> origins,String confuse)
  {
	  Set<String> set = new HashSet<String>();
	  confuse = confuse==null?"":confuse.trim();
    try
    {
      MessageDigest md = MessageDigest.getInstance("MD5");
      for(String origin:origins){
      byte[] bytes = md.digest(
    	        new String(origin+confuse).getBytes());
      StringBuffer strb = new StringBuffer();
      for(int i=0;i<bytes.length;i++){
    	  //bytes[i] =   (byte)(bytes[i] & Integer.parseInt("000000000000000000000000011111111", 2));
    	 int n = bytes[i];
    	  if(n<0){
    		  n = 256 + n;
    	  }
    	  if(Integer.toHexString(n).length()==1){
    		  strb.append("0"+Integer.toHexString(n));
    	  }else{
    		  strb.append(Integer.toHexString(n));
    	  }
    	  
      }
     
      set.add(strb.toString());
      }

    } catch (Exception e) {
      System.out.println("无法获得MD5实例");
    }
    return set;
  }

  public static final byte[] encode(byte[] origin)
  {
    try
    {
      MessageDigest md = MessageDigest.getInstance("MD5");
      return md.digest(origin);
    } catch (Exception e) {
      System.out.println("无法获得MD5实例");
    }return new byte[0];
  }

  public static void main(String[] args) throws IOException
  {
	   
	  BASE64Encoder base64en = new BASE64Encoder();
	  System.out.println(base64en.encode("htgladmin".getBytes("UTF-8")));
	//18913929522 js_kscgj  js_tcsb
	  System.out.println(MD5.encode("js_tcsb"));
	 System.out.println(" 第一次base64 "+base64en.encode(MD5.encodeToBytes("js_tcsb")));
	 System.out.println(" 第二次base64 "+ base64en.encode(base64en.encode(MD5.encodeToBytes("js_tcsb")).getBytes()));
	 System.out.println(MD5.encode("18913929522"));
	
	 BASE64Decoder dec = new BASE64Decoder();
	 byte[] b = dec.decodeBuffer("YTg4ODg4ODg4");
     System.out.println(new String(b,"UTF-8"));
    }
}
