package com.honsin.portal.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class ImageConvertUtil {
	
	private static final Logger logSy = LoggerFactory.getLogger(ImageConvertUtil.class);

	/**
	 * 将文件转换为base64字符串
	 * @param path
	 * @return
	 */
	public static String getStringFromFile(String path) {
		byte[] rs = null;
		InputStream in = null;
		ByteArrayOutputStream out =null;
		try {
			in = new FileInputStream(path);
			out = new ByteArrayOutputStream(1024);
			byte[] buffer = new byte[1024];
			int n;
			while( (n = in.read(buffer)) != -1) {
				out.write(buffer, 0, n);
			}
			in.close();
			out.close();
			rs = out.toByteArray();
		} catch(IOException e) {
			e.printStackTrace();
		}
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(rs);
	}
	
	/**
	 * 将base64字符串转换为文件
	 * @param b
	 * @param filePath
	 * @param fileName
	 */
	public static void getFileFromString(String imgStr, String filePath, String fileName){
		FileOutputStream fos = null;
		try {
			File dir = new File(filePath);
			if(!dir.exists() || !dir.isDirectory()) {
				dir.mkdirs();
			}
			//Base64 解码
			BASE64Decoder decoder = new BASE64Decoder(); 
			byte[] b = decoder.decodeBuffer(imgStr);  
            for(int i=0;i<b.length;++i)  
            {  
                if(b[i]<0)  
                {//调整异常数据  
                    b[i]+=256;  
                }  
            }  
            //生成图片
            String location = filePath + File.separator + fileName;
            logSy.info("\n买家头像路径 ==> " + location);
            fos = new FileOutputStream(location);
            fos.write(b);
            fos.flush();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
