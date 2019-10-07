/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

module Mavenproject1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    
    opens tp1 to javafx.fxml;
    exports tp1;
}
