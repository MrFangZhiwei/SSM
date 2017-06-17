package com.keyone.dom4j.test;

import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.junit.Test;

import com.keyone.common.util.DOMUtils;


public class Dom4jTest
{
	@Test
	public void test() throws IOException{
		Document document = DOMUtils.getXMLByFilePath(this.getClass().getResource("/test/test.xml").getPath());
		Element rootElement = document.getRootElement();
		//填写mediumA匹配节点的名字
		
		Element childElement = DOMUtils.getChildElement(rootElement, "mediumA");
		Element childElement2 = DOMUtils.getChildElement(childElement, "stepA");
		//修改会写
		childElement2.setText("hhhh");
		DOMUtils.writeXMLToFile(document, this.getClass().getResource("/test/test.xml").getPath());
		
		List<Element> list = DOMUtils.getChildElements(childElement);
		for (Element element2 : list)
		{
			String name = element2.getName();
			System.out.println(name);
			String text = element2.getText();
			System.out.println(text);
		}
		
		DOMUtils.addChild(rootElement, "mediumw", "SAS");
		DOMUtils.writeXMLToFile(document, this.getClass().getResource("/test/test.xml").getPath());
	}
}
