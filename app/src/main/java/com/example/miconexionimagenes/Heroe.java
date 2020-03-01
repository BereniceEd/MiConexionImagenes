package com.example.miconexionimagenes;

import java.util.List;

public class Heroe {
//Objeto Heroe
        public String image_url;
        public String name;

        public Heroe(String image_url, String name) {
            this.image_url = image_url;
            this.name = name;

        }
private List<Heroe> heroes;
        public  List<Heroe> agregar(Heroe h){
            heroes.add(h);

return heroes;
        }

        public List<Heroe> getHeroes() {
                return heroes;
        }

        public void setHeroes(List<Heroe> heroes) {
                this.heroes = heroes;
        }

        public Heroe() {
        }

        public String getImage_url() { return image_url;}

        public void setImage_url(String image_url) {this.image_url = image_url;}

        public String getName() {return name;}

        public void setName(String name) {this.name = name;}


}
