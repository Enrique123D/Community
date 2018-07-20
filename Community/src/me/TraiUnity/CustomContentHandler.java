package me.TraiUnity;

import org.bukkit.event.Listener;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class CustomContentHandler implements ContentHandler, Listener{

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
	}

	@Override
	public void endDocument() throws SAXException {
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		
	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		
	}

	@Override
	public void processingInstruction(String target, String Main) throws SAXException {
		
	}

	@Override
	public void setDocumentLocator(Locator locator) {
		
	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		
	}

	@Override
	public void startDocument() throws SAXException {
		
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		
		if(localName.equalsIgnoreCase("statistics")) {
			Main.subCount = Integer.parseInt(atts.getValue("subscriberCount"));
			Main.viewCount = Integer.parseInt(atts.getValue("totalUploadViews"));
		}	
	}

	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		
	}

}
