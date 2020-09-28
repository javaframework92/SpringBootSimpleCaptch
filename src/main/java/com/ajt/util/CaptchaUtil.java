package com.ajt.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Objects;

import javax.imageio.ImageIO;

import cn.apiclub.captcha.Captcha;

public class CaptchaUtil {

	private CaptchaUtil() {
	}

	public static Captcha createCaptcha(int width, int height) {
		return new Captcha.Builder(width, height)
				.addBackground()
				.addText()
				.addNoise().build();
	}

	public static void createImage(Captcha captcha, String imageFormat, String file)	throws IOException {
		ByteArrayOutputStream baos = null;
		if (Objects.nonNull(captcha)) {
			baos = new ByteArrayOutputStream();
			ImageIO.write(captcha.getImage(), imageFormat, baos);
			CaptchaUtil.writeFile(baos, file);
		}
	}

	public static void writeFile(ByteArrayOutputStream baos, String file) throws IOException {
		if (Objects.nonNull(baos)) {
			FileOutputStream fos = new FileOutputStream(new File(file));
			fos.write(baos.toByteArray());
			fos.flush();
			fos.close();
		}
	}
	
	public static String encodeCaptchaImageBase64(Captcha captcha, String imageFormat) throws IOException {
		ByteArrayOutputStream baos = null;
		String imgData = null;
		if (Objects.nonNull(captcha)) {
			baos = new ByteArrayOutputStream();
			ImageIO.write(captcha.getImage(), imageFormat, baos);
			imgData = new String(Base64.getEncoder().encode(baos.toByteArray()));
		}
		return imgData;
	}

}
