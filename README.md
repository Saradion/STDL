Deux trois petites notes : tous les TP fonctionnent out of the box. Une fois le repo cloné, faire : 

```
cd TP0X 
make
```
et ça marche.

Sommaire des TP :


- TP01 : Interpretation MiniML sans effet de bord
- TP02 : Interpretation MiniML avec effet de bord (NB, ya pas le typage ici j'ai oublié de le terminer)
- TP03 : Intro à Egg avec GDouble
- TP04 : Construction de l'AST pour BLOC
- TP05 : Ajout de la TDS pour BLOC

- Soon (tm) : TP06, Typage de BLOC

Les makefiles ont été un peu tripatouillé vis-à-vis de ceux fournis.

NB : si, avec le fichier test du TP05, vous obtenez ceci 
```
Bloc Version 0.0.1
test.txt:6:Error(Semantics):Undefined identifier k.
java.lang.NullPointerException
```
lors de l'execution du make, alors pas de panique : c'est parfaitement "normal".
