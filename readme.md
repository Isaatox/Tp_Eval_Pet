# TP Eval Pet : Hugo JENOUVRIER

SDV 2023


## BDD

> Identifiant base de données 
>
Afin d'initialiser sa connection à sa Base de données :

1. Créez une base de donnée appelez **petstore**
2. Dans ressources/META-INF/ renomez le fichier **persistence.exemple.xml** en **persistence.xml**
3. Ainsi dans ce fichier vous trouverez **DB_HOST** / **DB_NAME** / **DB_USER** / **DB_PASS** et rentrez vos informations de connection
4. Actuellement le driver mariaDB est utilisé, vous pouvez le modifier par exemple avec postgresqlsi vous le souhaitez.

## Utilisez l'application

Pour utiliser l'application vous trouverez le fichier _Main_ dans **fr.sdv2023**.
Ainsi dedans vous pourrez lancez le programme et cela créera les tables automatiquement ainsi que des données d'exemple directement.

> _Si vous relancez l'application cela réinitialisera votre base et réajoutera les nouvelles donnée que vous avez potentiellement rajoutez._