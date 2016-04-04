/**
 * 
 */
package com.manager.common.sms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author baiyp
 *
 */
public class MessageSender {
	
	
	private static final String url= "http://dx.ipyy.net/sms.aspx";
	
	private static final String userName ="AA00117";
	//帐号密码
	private static final String password = "AA0011714";
	
	
	public static int sendMessage(String content,String mobiles){ 
		try {
			
			String returnString = MessageSender.sendSms(url,"",userName,password,mobiles,content,"","");
			//System.out.println(returnString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
 
	/**
	 * @param userid
	 * @param account
	 * @param password
	 * @param mobile
	 * @param content
	 * @param sendTime
	 * @param extno
	 * @return
	 */
    public static String sendSms(String qUrl,String userid, String account,
			String password, String mobile, String content,
			String sendTime, String extno) {
    	StringBuffer sub = new StringBuffer();
		try {
			String parameter="action=send&userid="+ userid + "&account=" + account + "&password="
				+ password + "&mobile=" + mobile + "&content=" + content + "&sendTime="
				+ sendTime + "&extno=" + extno + "";
			URL url = new URL(qUrl);
			URLConnection con=url.openConnection();
			con.setDoOutput(true);
			OutputStreamWriter out=new OutputStreamWriter(con.getOutputStream(),"utf-8");
			out.write(parameter);
			out.flush();
			out.close();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String line;
			while ((line = br.readLine()) != null) {
				sub.append(line + "");
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return sub.toString();
		}
    }
    
    public static void main(String [] args) throws Exception{
    	 
    	
    	//MessageSender.sendMessage("加加物联网提示：您的VIP会员申请已通过，可以正常使用【加加物联网】","18602427087");
    }

}
