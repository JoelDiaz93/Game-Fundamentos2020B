package sample.animation;

import com.sun.javafx.collections.MappingChange;
import javafx.scene.image.Image;

public class LoadImage {

    private static final Image Charizard = new Image("file:IMG/Fire/icon006.png", 300, 150, true, true);
    private static final Image Typhlosion = new Image("file:IMG/Fire/icon157.png", 300, 150, true, true);
    private static final Image Monferno = new Image("file:IMG/Fire/icon391.png", 300, 150, true, true);
    private static final Image Combusken = new Image("file:IMG/Fire/icon256.png", 300, 150, true, true);

    private static final Image Onyx = new Image("file:IMG/Ground/icon095.png", 300, 150, true, true);
    private static final Image Marowak = new Image("file:IMG/Ground/icon105.png", 300, 150, true, true);
    private static final Image Graveler = new Image("file:IMG/Ground/icon075.png", 300, 150, true, true);
    private static final Image Donphan = new Image("file:IMG/Ground/icon232.png", 300, 150, true, true);

    private static final Image Gyarados = new Image("file:IMG/Water/icon130.png", 300, 150, true, true);
    private static final Image Feraligatr = new Image("file:IMG/Water/icon160.png", 300, 150, true, true);
    private static final Image Piplup = new Image("file:IMG/Water/icon393.png", 300, 150, true, true);
    private static final Image Blastoise = new Image("file:IMG/Water/icon009.png", 300, 150, true, true);

    private static final Image Pidgeot = new Image("file:IMG/Air/icon018.png", 300, 150, true, true);
    private static final Image Hoothoot = new Image("file:IMG/Air/icon163.png", 300, 150, true, true);
    private static final Image Lugia = new Image("file:IMG/Air/icon249.png", 300, 150, true, true);
    private static final Image Staravia = new Image("file:IMG/Air/icon397.png", 300, 150, true, true);

    private static final Image Pokeball = new Image("file:IMG/ball_00.png", 300, 150, true, true);

    public Image getImage(String name) {
        switch (name) {
            //fire
            case "Charizard": {
                return Charizard;
            }
            case "Typhlosion": {
                return Typhlosion;
            }
            case "Monferno": {
                return Monferno;
            }
            case "Combusken": {
                return Combusken;
            }
            //ground
            case "Onyx": {
                return Onyx;
            }
            case "Marowak": {
                return Marowak;
            }
            case "Graveler": {
                return Graveler;
            }
            case "Donphan": {
                return Donphan;
            }
            //water
            case "Gyarados": {
                return Gyarados;
            }
            case "Feraligatr": {
                return Feraligatr;
            }
            case "Piplup": {
                return Piplup;
            }
            case "Blastoise":{
                return Blastoise;
            }
            //Air
            case "Pidgeot":{
                return Pidgeot;
            }
            case "Hoothoot":{
                return Hoothoot;
            }
            case "Lugia":{
                return Lugia;
            }
            case"Staravia":{
                return Staravia;
            }
            default: {
                return Pokeball;
            }
        }
    }
}
