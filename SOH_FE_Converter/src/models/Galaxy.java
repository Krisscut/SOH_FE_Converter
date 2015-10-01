/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Galaxy {
    
    List<Sector> sectors = new ArrayList<>();
    String name = "Unknown Galaxy";

    public Galaxy(Node galaxyNode) {
        name = galaxyNode.getNodeName();   //
        NodeList sectorListNode = galaxyNode.getChildNodes();
        
        for (int i = 0; i< sectorListNode.getLength(); i++) {
             if(sectorListNode.item(i).getNodeType() == Node.ELEMENT_NODE) {  
                 
                 
             }           
        }
        

    }

    public String getName() {
        return name;
    }
    
}
