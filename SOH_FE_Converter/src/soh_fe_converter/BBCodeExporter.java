/*
 * Copyright (C) 2015 Administrateur
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package soh_fe_converter;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class BBCodeExporter {
    
    private VBox bbCodeContainer;
    private GridPane bbCodeGrid;

    
    public BBCodeExporter() {
        bbCodeContainer = new VBox();
        bbCodeGrid = new GridPane();
        
        Button exportAll = new Button("Export all");
        GridPane.setConstraints(exportAll, 0, 0);
        bbCodeGrid.getChildren().add(exportAll);
        
        Button exportSelection = new Button("Export Selection");
        GridPane.setConstraints(exportSelection, 1, 0);
        bbCodeGrid.getChildren().add(exportSelection);
       
        Button exportFiltered = new Button("Export Filtered");
        GridPane.setConstraints(exportFiltered, 2, 0);
        bbCodeGrid.getChildren().add(exportFiltered);
        
        TextArea bbcodePreview = new TextArea();
        bbcodePreview.setPrefRowCount(10);
        bbcodePreview.setPrefColumnCount(100);
        bbcodePreview.setWrapText(true);
        bbcodePreview.setPrefWidth(150);
        GridPane.setHalignment(bbcodePreview, HPos.CENTER);
        
        bbCodeContainer.getChildren().addAll(bbCodeGrid, bbcodePreview);

        String bbCodeDefault = "Generated bbcode will appear here.";
        
        bbcodePreview.setText(bbCodeDefault);
    }
    
    

    VBox getBBCodeComponent() {
        return bbCodeContainer;
    }
    
}
