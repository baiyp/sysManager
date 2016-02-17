package com.manager.common;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Map.Entry;
/**
 * �������ļ������Ĺ�����
 * ��ȡ���������޸�
 * ע�⣺	���·�����ȡ�����ļ��Ỻ������,���޸������ļ�ʱ���������ã�
 *��InputStream in = PropertiesUtils.class.getResourceAsStream("/config.properties");
 *������취��
 *��String savePath = PropertiesUtils.class.getResource("/config.properties").getPath();
 */
public class PropertiesUtils {
	/**
	 * ��ȡ�����ļ������� ����key��ȡֵ
	 * @param fileName �ļ�����(ע�⣺���ص���src�µ��ļ�,�����ĳ�����£���Ѱ�������)
	 * @param key
	 * @return
	 */
	public static String findPropertiesKey(String key) {
		
		try {
			Properties prop = getProperties();
			return prop.getProperty(key);
		} catch (Exception e) {
			return "";
		}
		
	}

	public static void main(String[] args) {
		Properties prop = new Properties();
		InputStream in = PropertiesUtils.class
				.getResourceAsStream("/config.properties");
		try {
			prop.load(in);
			Iterator<Entry<Object, Object>> itr = prop.entrySet().iterator();
			while (itr.hasNext()) {
				Entry<Object, Object> e = (Entry<Object, Object>) itr.next();
				System.err.println((e.getKey().toString() + "" + e.getValue()
						.toString()));
			}
		} catch (Exception e) {
			
		}
	}

	/**
	 * ���ء�Properties
	 * @param fileName �ļ�����(ע�⣺���ص���src�µ��ļ�,�����ĳ�����£���Ѱ�������)
	 * @param 
	 * @return
	 */
	public static Properties getProperties(){
		Properties prop = new Properties();
		String savePath = PropertiesUtils.class.getResource("/config.properties").getPath();
		//���·�����ȡ�����ļ��Ỻ������
//		InputStream in = PropertiesUtils.class
//				.getResourceAsStream("/config.properties");
		try {
			InputStream in =new BufferedInputStream(new FileInputStream(savePath));  
			prop.load(in);
		} catch (Exception e) {
			return null;
		}
		return prop;
	}
	/**
	 * д��properties��Ϣ
	 * 
	 * @param key
	 *            ����
	 * @param value
	 *            ֵ
	 */
	public static void modifyProperties(String key, String value) {
		try {
			// ���������ж�ȡ�����б�����Ԫ�ضԣ�
			Properties prop = getProperties();
			prop.setProperty(key, value);
			String path = PropertiesUtils.class.getResource("/config.properties").getPath();
			FileOutputStream outputFile = new FileOutputStream(path);
			prop.store(outputFile, "modify");
			outputFile.close();
			outputFile.flush();
		} catch (Exception e) {
		}
	}
}

