DMS 
===

Das Projekt wurde mit Hilfe des Play Frameworks geschrieben.

Zum Ausführen des Programms, einfach `play run` ausführen.

Die folgenden Befehle sollten in der Datenbank durchgeführt werden.

```
mysql> CREATE DATABASE dms;
mysql> GRANT ALL PRIVILEGES ON dms.* TO 'dmsuser'@'%' IDENTIFIED BY 'dmspassword';
mysql> FLUSH PRIVILEGES;
```

Es wurde leider keine grafische Oberfläche implementiert, daher finden Sie Testcases im test/ Verzeichnis.
