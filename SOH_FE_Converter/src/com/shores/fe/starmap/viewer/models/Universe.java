package com.shores.fe.starmap.viewer.models;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Universe {
    public List<Galaxy> galaxies = new ArrayList<>();
    
    String name = "Unknown Universe";
    
    public Universe(Document document) {
        
        Element root = document.getDocumentElement();
        name = root.getNodeName();   //
        
        NodeList galaxyNodeList = root.getChildNodes();
        for (int i =0 ; i < galaxyNodeList.getLength(); i++){
            if(galaxyNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                galaxies.add(new Galaxy(galaxyNodeList.item(i)));
            }
        }
    }

    public String getName() {
        return name;
    }
}
