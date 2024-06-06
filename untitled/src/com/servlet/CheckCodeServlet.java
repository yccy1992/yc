package com.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int width=100;
		int height=50;
		
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
		
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.pink);
		graphics.fillRect(0, 0, width, height);
		
		graphics.setColor(Color.blue);
		graphics.drawRect(0, 0, width-1, height-1);
		
		String str="ABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";
		Random ran = new Random();
		StringBuffer sbf = new StringBuffer();
		
		for(int i=1;i<=4;i++) {
			int index=ran.nextInt(str.length());//[0~str.length)
			char ch = str.charAt(index);//FK
			sbf.append(ch);//记录验证码上的字符内容FK1Q
			graphics.setFont(new Font(Font.SANS_SERIF,Font.BOLD+Font.ITALIC,20));
			graphics.drawString(String.valueOf(ch), width/5*i, height/2);	//F	K 1 Q		
			
		}
		session.setAttribute("verifyCode", sbf.toString());
		graphics.setColor(Color.green);
		for(int i=0;i<10;i++) {
			int x1 = ran.nextInt(width);
			int y1 = ran.nextInt(height);
			int x2 = ran.nextInt(width);
			int y2= ran.nextInt(height);
			graphics.drawLine(x1, y1, x2, y2);
		}
		
		
		ImageIO.write(image, "jpg", response.getOutputStream());
		
		
		

	}

}
